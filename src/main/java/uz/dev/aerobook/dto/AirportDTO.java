package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link uz.dev.aerobook.entity.Airport}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO implements Serializable {
    private Long id;
    private String name;
    private String iataCode;
    private String country;
    private String city;
}