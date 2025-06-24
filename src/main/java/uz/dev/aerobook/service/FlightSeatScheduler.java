package uz.dev.aerobook.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.dev.aerobook.repository.FlightSeatRepository;

@Service
@RequiredArgsConstructor
public class FlightSeatScheduler {

    private final FlightSeatRepository flightSeatRepository;

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void releaseExpiredSeats() {
        int releasedSeats = flightSeatRepository.releaseExpiredHolds();

        if (releasedSeats > 0) {

            System.out.println("Released " + releasedSeats + " expired held seats.");

        }
    }
}
