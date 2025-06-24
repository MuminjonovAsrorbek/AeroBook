package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dev.aerobook.enums.BookingStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.dev.aerobook.entity.Booking}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO implements Serializable {

    private Long id;

    private String bookingReference;

    private BookingStatus status;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private Long userId;
}