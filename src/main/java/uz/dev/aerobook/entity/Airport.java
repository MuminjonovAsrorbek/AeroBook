package uz.dev.aerobook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import uz.dev.aerobook.entity.template.AbsLongEntity;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:08
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class Airport extends AbsLongEntity {

    @Column(nullable = false)
    private String name;

    @Column(length = 3, nullable = false, unique = true)
    private String iataCode;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

}
