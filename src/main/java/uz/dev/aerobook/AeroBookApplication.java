package uz.dev.aerobook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AeroBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AeroBookApplication.class, args);
    }

}
