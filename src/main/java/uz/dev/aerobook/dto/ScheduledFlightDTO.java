package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dev.aerobook.enums.ScheduledFlightStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.dev.aerobook.entity.ScheduledFlight}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduledFlightDTO implements Serializable {
    private Long id;
    private FlightDTO flight;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private ScheduledFlightStatus status;
}