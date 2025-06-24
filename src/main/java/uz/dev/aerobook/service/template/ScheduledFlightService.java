package uz.dev.aerobook.service.template;

import uz.dev.aerobook.dto.response.PageableDTO;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:26
 **/

public interface ScheduledFlightService {

    PageableDTO getScheduledFlightSeats(Long flightId, Integer page);

}
