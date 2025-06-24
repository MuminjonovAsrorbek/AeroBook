package uz.dev.aerobook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.dev.aerobook.dto.response.PageableDTO;
import uz.dev.aerobook.service.template.ScheduledFlightService;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:25
 **/

@RestController
@RequestMapping("/api/v1/scheduled-flights")
@RequiredArgsConstructor
public class SchedulerFlightController {

    private final ScheduledFlightService scheduledFlightService;

    @GetMapping("/{flightId}/seats")
    public PageableDTO getScheduledFlightSeats(@PathVariable Long flightId,
                                               @RequestParam(required = false, defaultValue = "0", name = "page") Integer page) {

        return scheduledFlightService.getScheduledFlightSeats(flightId, page);

    }

}
