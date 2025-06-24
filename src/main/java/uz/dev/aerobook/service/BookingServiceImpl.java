package uz.dev.aerobook.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.dev.aerobook.dto.request.BookingSeatDTO;
import uz.dev.aerobook.dto.request.ConfirmBookingReqDTO;
import uz.dev.aerobook.dto.response.ConfirmBookingRespDTO;
import uz.dev.aerobook.dto.response.HoldResponseDTO;
import uz.dev.aerobook.entity.Booking;
import uz.dev.aerobook.entity.FlightSeat;
import uz.dev.aerobook.enums.BookingStatus;
import uz.dev.aerobook.enums.FlightSeatStatus;
import uz.dev.aerobook.exceptions.EntityNotFoundException;
import uz.dev.aerobook.exceptions.HoldExpiredException;
import uz.dev.aerobook.exceptions.SeatNotAvailableException;
import uz.dev.aerobook.repository.BookingRepository;
import uz.dev.aerobook.repository.FlightSeatRepository;
import uz.dev.aerobook.repository.UserRepository;
import uz.dev.aerobook.service.template.BookingService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:33
 **/

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final FlightSeatRepository flightSeatRepository;

    private final UserRepository userRepository;

    private final BookingRepository bookingRepository;

    @Override
    @Transactional
    public HoldResponseDTO holdSeat(BookingSeatDTO bookingSeatDTO) {

        List<FlightSeat> seats = flightSeatRepository.findAllById(bookingSeatDTO.getFlightSeatIds());

        if (seats.size() != bookingSeatDTO.getFlightSeatIds().size()) {

            throw new EntityNotFoundException("Some seats not found", HttpStatus.NOT_FOUND);

        }

        for (FlightSeat seat : seats) {

            if (!seat.getStatus().equals(FlightSeatStatus.AVAILABLE)) {

                throw new SeatNotAvailableException("Seat " + seat.getSeat().getSeatNumber() + " is not available : " + seat.getId(), HttpStatus.BAD_REQUEST);

            }

        }

        String holdId = UUID.randomUUID().toString();

        LocalDateTime holdUntil = LocalDateTime.now().plusMinutes(10);

        for (FlightSeat seat : seats) {
            seat.setStatus(FlightSeatStatus.HELD);
            seat.setHeldUntil(holdUntil);
            seat.setHoldId(holdId);
        }

        flightSeatRepository.saveAll(seats);

        return new HoldResponseDTO(holdId, holdUntil);
    }

    @Override
    public ConfirmBookingRespDTO confirmBooking(ConfirmBookingReqDTO request) {

        List<FlightSeat> seats = flightSeatRepository.findAllByHoldIdAndHeldUntilAfterAndStatus(
                request.getHoldId(), LocalDateTime.now(), FlightSeatStatus.HELD
        );

        if (seats.isEmpty()) {
            throw new HoldExpiredException("Hold time expired or invalid holdId.", HttpStatus.BAD_REQUEST);
        }

        BigDecimal totalPrice = seats.stream()
                .map(FlightSeat::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Booking booking = null;

        for (FlightSeat seat : seats) {

            booking = new Booking();

            booking.setBookingReference(UUID.randomUUID().toString());
            booking.setStatus(BookingStatus.CONFIRMED);
            booking.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            booking.setTotalPrice(totalPrice);
            booking.setUser(userRepository.findById(request.getUserId()).orElseThrow());
            booking.setFlightSeat(seat);

            bookingRepository.save(booking);

        }


        for (FlightSeat seat : seats) {
            seat.setStatus(FlightSeatStatus.BOOKED);
            seat.setBooking(booking);
            seat.setHeldUntil(null);
            seat.setHoldId(null);
        }

        flightSeatRepository.saveAll(seats);

        return new ConfirmBookingRespDTO(
                booking.getBookingReference(),
                booking.getCreatedAt().toLocalDateTime(),
                booking.getTotalPrice()
        );

    }
}