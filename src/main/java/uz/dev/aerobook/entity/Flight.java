package uz.dev.aerobook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import uz.dev.aerobook.entity.template.AbsLongEntity;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:13
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class Flight extends AbsLongEntity {

    @Column(nullable = false)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Airport arrivalAirport;
}
