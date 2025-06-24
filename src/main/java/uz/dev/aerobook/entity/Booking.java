package uz.dev.aerobook.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.enums.BookingStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 16:23
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
public class Booking extends AbsLongEntity {

    @Column(nullable = false, unique = true)
    private String bookingReference;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    private User user;

    @OneToOne
    private FlightSeat flightSeat;
}
