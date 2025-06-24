package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dev.aerobook.enums.SeatType;

import java.io.Serializable;

/**
 * DTO for {@link uz.dev.aerobook.entity.Seat}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO implements Serializable {
    private Long id;
    private String seatNumber;
    private SeatType type;
}