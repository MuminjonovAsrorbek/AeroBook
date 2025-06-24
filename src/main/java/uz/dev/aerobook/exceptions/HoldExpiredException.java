package uz.dev.aerobook.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 14:07
 **/

@Getter
public class HoldExpiredException extends RuntimeException {

    private final HttpStatus status;

    public HoldExpiredException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
