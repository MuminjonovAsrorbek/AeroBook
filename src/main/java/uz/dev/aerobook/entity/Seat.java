package uz.dev.aerobook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.enums.SeatType;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:17
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class Seat extends AbsLongEntity {

    @Column(nullable = false, unique = true)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType type;

}
