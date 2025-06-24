package uz.dev.aerobook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 14:05
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfirmBookingRespDTO {

    private String bookingReference;
    private LocalDateTime bookingTime;
    private BigDecimal totalPrice;

}
