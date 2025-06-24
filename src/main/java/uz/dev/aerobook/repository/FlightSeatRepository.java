package uz.dev.aerobook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.dev.aerobook.entity.FlightSeat;
import uz.dev.aerobook.enums.FlightSeatStatus;
import uz.dev.aerobook.projection.FlightSeatProjection;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightSeatRepository extends JpaRepository<FlightSeat, Long> {

    @Query("""
                SELECT fs.id AS seatId,
                       s.seatNumber AS seatNumber,
                       s.type AS seatClass,
                       fs.price AS price,
                       fs.status AS status
                FROM FlightSeat fs
                JOIN fs.seat s
                WHERE fs.scheduledFlight.id = :flightId
            """)
    Page<FlightSeatProjection> findSeatsByScheduledFlightId(@Param("flightId") Long flightId, Pageable pageable);


    List<FlightSeat> findAllByHoldIdAndHeldUntilAfterAndStatus(String holdId, LocalDateTime now, FlightSeatStatus flightSeatStatus);

    @Modifying
    @Query("""
                UPDATE FlightSeat fs
                SET fs.status = 'AVAILABLE',
                    fs.heldUntil = null
                WHERE fs.status = 'HELD'
                  AND fs.heldUntil < CURRENT_TIMESTAMP
            """)
    int releaseExpiredHolds();

}