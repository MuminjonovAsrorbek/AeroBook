package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dev.aerobook.entity.FlightSeat;
import uz.dev.aerobook.enums.FlightSeatStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link FlightSeat}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSeatDTO implements Serializable {
    private Long id;
    private Long scheduledFlightId;
    private Long seatId;
    private BigDecimal price;
    private FlightSeatStatus status;
    private LocalDateTime heldUntil;
    private Long bookingId;
    private Long version;
}