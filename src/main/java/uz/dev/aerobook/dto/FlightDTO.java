package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dev.aerobook.entity.Flight;

import java.io.Serializable;

/**
 * DTO for {@link Flight}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO implements Serializable {
    private Long id;
    private String flightNumber;
    private Long departureAirportId;
    private Long arrivalAirportId;
}