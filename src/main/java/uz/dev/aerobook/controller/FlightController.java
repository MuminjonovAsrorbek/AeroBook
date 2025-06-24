package uz.dev.aerobook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.dev.aerobook.dto.response.PageableDTO;
import uz.dev.aerobook.service.template.FlightService;

import java.time.LocalDate;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 11:34
 **/

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/search")
    public PageableDTO searchFlights(@RequestParam String fromIata,
                                     @RequestParam String toIata,
                                     @RequestParam LocalDate date,
                                     @RequestParam(required = false, defaultValue = "0", name = "page") Integer page) {

        return flightService.searchFlights(fromIata, toIata, date, page);

    }


}
