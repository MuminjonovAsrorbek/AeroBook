package uz.dev.aerobook.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 14:04
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfirmBookingReqDTO {

    private String holdId;

    private Long userId;

}
