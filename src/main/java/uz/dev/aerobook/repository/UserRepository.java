package uz.dev.aerobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dev.aerobook.entity.Booking;
import uz.dev.aerobook.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);


}