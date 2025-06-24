package uz.dev.aerobook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.dev.aerobook.entity.ScheduledFlight;
import uz.dev.aerobook.projection.FlightSearchProjection;

import java.time.LocalDate;

@Repository
public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {

    @Query(value = """
                     SELECT sf.id                 AS scheduledFlightId,
                   f.flightNumber       AS flightNumber,
                   aFrom.iataCode       AS fromAirportIata,
                   aFrom.name           AS fromAirportName,
                   aTo.iataCode         AS toAirportIata,
                   aTo.name             AS toAirportName,
                   sf.departureTime     AS departureTime,
                   sf.arrivalTime       AS arrivalTime,
                   COUNT(fs)            AS availableSeats,
                   MIN(fs.price)        AS minimumPrice
            FROM ScheduledFlight sf
              JOIN sf.flight f
              JOIN f.departureAirport aFrom
              JOIN f.arrivalAirport aTo
              JOIN FlightSeat fs ON fs.scheduledFlight = sf AND fs.status = 'AVAILABLE'
            WHERE aFrom.iataCode = :fromIata
              AND aTo.iataCode   = :toIata
              AND DATE(sf.departureTime) = :date
              AND sf.status      = 'SCHEDULED'
            GROUP BY sf.id, f.flightNumber, aFrom.iataCode, aFrom.name,
                     aTo.iataCode, aTo.name, sf.departureTime, sf.arrivalTime
            """,
            countQuery = """
                    SELECT COUNT(DISTINCT sf.id)
                    FROM ScheduledFlight sf
                    JOIN sf.flight f
                    JOIN f.departureAirport aFrom
                    JOIN f.arrivalAirport aTo
                    WHERE aFrom.iataCode = :fromIata
                      AND aTo.iataCode = :toIata
                      AND DATE(sf.departureTime) = :date
                      AND sf.status = 'SCHEDULED'
                    """)
    Page<FlightSearchProjection> searchFlights(@Param("fromIata") String fromIata,
                                               @Param("toIata") String toIata,
                                               @Param("date") LocalDate date,
                                               Pageable pageable);

}