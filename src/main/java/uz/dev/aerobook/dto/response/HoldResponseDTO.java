package uz.dev.aerobook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:34
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoldResponseDTO {

    private String holdId;

    private LocalDateTime heldUntil;

}
