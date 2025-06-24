package uz.dev.aerobook.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface FlightSearchProjection {

    Long getScheduledFlightId();

    String getFlightNumber();

    String getFromAirportIata();

    String getFromAirportName();

    String getToAirportIata();

    String getToAirportName();

    LocalDateTime getDepartureTime();

    LocalDateTime getArrivalTime();

    Integer getAvailableSeats();

    BigDecimal getMinimumPrice();


}

