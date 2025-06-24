package uz.dev.aerobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dev.aerobook.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}