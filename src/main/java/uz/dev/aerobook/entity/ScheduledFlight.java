package uz.dev.aerobook.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.enums.ScheduledFlightStatus;

import java.time.LocalDateTime;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:15
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class ScheduledFlight extends AbsLongEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Flight flight;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduledFlightStatus status;
}
