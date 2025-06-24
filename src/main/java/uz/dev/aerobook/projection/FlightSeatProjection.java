package uz.dev.aerobook.projection;

import java.math.BigDecimal;

public interface FlightSeatProjection {

    Long getSeatId();        // FlightSeat ID

    String getSeatNumber();  // Seat raqami

    String getSeatClass();   // Seat klassi (ECONOMY, BUSINESS, FIRST)

    BigDecimal getPrice();   // Narxi

    String getStatus();      // AVAILABLE, HELD, BOOKED
}
