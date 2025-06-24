package uz.dev.aerobook.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.enums.FlightSeatStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:19
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class FlightSeat extends AbsLongEntity {

    @ManyToOne
    private ScheduledFlight scheduledFlight;

    @ManyToOne
    private Seat seat;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private FlightSeatStatus status;

    private LocalDateTime heldUntil;

    private String holdId;

    @OneToOne(mappedBy = "flightSeat")
    private Booking booking;

    @Version
    private Long version;
}
