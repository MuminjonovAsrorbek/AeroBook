package uz.dev.aerobook.entity.template;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldNameConstants;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:10
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
@FieldNameConstants
public abstract class AbsLongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
