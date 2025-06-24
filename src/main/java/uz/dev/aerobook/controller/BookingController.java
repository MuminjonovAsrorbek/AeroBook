package uz.dev.aerobook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.dev.aerobook.dto.request.BookingSeatDTO;
import uz.dev.aerobook.dto.request.ConfirmBookingReqDTO;
import uz.dev.aerobook.dto.response.ConfirmBookingRespDTO;
import uz.dev.aerobook.dto.response.HoldResponseDTO;
import uz.dev.aerobook.service.template.BookingService;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:31
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/hold")
    public HoldResponseDTO holdSeat(@RequestBody BookingSeatDTO bookingSeatDTO) {

        return bookingService.holdSeat(bookingSeatDTO);

    }

    @PostMapping("/confirm")
    public ConfirmBookingRespDTO confirmBooking(@RequestBody ConfirmBookingReqDTO confirmBookingReqDTO) {

        return bookingService.confirmBooking(confirmBookingReqDTO);

    }

}
