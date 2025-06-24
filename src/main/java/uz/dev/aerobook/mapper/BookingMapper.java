package uz.dev.aerobook.mapper;

import org.springframework.stereotype.Component;
import uz.dev.aerobook.dto.BookingDTO;
import uz.dev.aerobook.entity.Booking;
import uz.dev.aerobook.mapper.template.BaseMapper;

import java.util.List;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 16:09
 **/

@Component
public class BookingMapper implements BaseMapper<Booking, BookingDTO> {
    @Override
    public Booking toEntity(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public BookingDTO toDto(Booking booking) {

        return new BookingDTO(
                booking.getId(),
                booking.getBookingReference(),
                booking.getStatus(),
                booking.getTotalPrice(),
                booking.getCreatedAt().toLocalDateTime(),
                booking.getUser().getId()
        );

    }

    @Override
    public List<BookingDTO> toDto(List<Booking> bookings) {

        return bookings.stream().map(this::toDto).toList();

    }
}
