package uz.dev.aerobook.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 12:36
 **/

@Getter
public class SeatNotAvailableException extends RuntimeException {

    private final HttpStatus status;

    public SeatNotAvailableException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
