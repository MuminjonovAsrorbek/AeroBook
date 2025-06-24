package uz.dev.aerobook.service.template;

import uz.dev.aerobook.dto.request.BookingSeatDTO;
import uz.dev.aerobook.dto.request.ConfirmBookingReqDTO;
import uz.dev.aerobook.dto.response.ConfirmBookingRespDTO;
import uz.dev.aerobook.dto.response.HoldResponseDTO;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:33
 **/

public interface BookingService {
    HoldResponseDTO holdSeat(BookingSeatDTO bookingSeatDTO);

    ConfirmBookingRespDTO confirmBooking(ConfirmBookingReqDTO confirmBookingReqDTO);

}
