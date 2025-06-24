package uz.dev.aerobook.service.template;

import uz.dev.aerobook.dto.response.PageableDTO;

import java.time.LocalDate;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 11:40
 **/

public interface FlightService {

    PageableDTO searchFlights(String fromIata, String toIata, LocalDate date, Integer page);


}
