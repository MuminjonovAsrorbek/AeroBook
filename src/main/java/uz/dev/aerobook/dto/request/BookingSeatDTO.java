package uz.dev.aerobook.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:30
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingSeatDTO {

    private List<Long> flightSeatIds;

    private Long userId;

}
