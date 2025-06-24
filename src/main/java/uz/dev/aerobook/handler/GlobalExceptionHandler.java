package uz.dev.aerobook.handler;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.dev.aerobook.dto.response.ErrorDTO;
import uz.dev.aerobook.dto.response.FieldErrorDTO;
import uz.dev.aerobook.exceptions.EntityNotFoundException;
import uz.dev.aerobook.exceptions.HoldExpiredException;
import uz.dev.aerobook.exceptions.SeatNotAvailableException;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice(basePackages = "uz.dev.aerobook")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handle(EntityNotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO(
                e.getStatus().value(),
                e.getMessage()
        );
        return new ResponseEntity<>(errorDTO, e.getStatus());
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        List<FieldErrorDTO> fieldErrors = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String fieldName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            fieldErrors.add(new FieldErrorDTO(fieldName, message));
        }

        ErrorDTO error = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Field not valid",
                fieldErrors
        );

        return ResponseEntity
                .status(400)
                .body(error);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> handle(RuntimeException e) {

        ErrorDTO error = new ErrorDTO(
                500,
                "Internal Server Error: " + e.getMessage()
        );

        return ResponseEntity
                .status(500)
                .body(error);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handle(IllegalArgumentException e) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(value = OptimisticLockingFailureException.class)
    public ResponseEntity<ErrorDTO> handle(OptimisticLockingFailureException e) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.CONFLICT.value(),
                "Kechirasiz, bu o'rindiqlar hozirgina band qilindi, iltimos boshqasini tanlang"
        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(value = HoldExpiredException.class)
    public ResponseEntity<ErrorDTO> handle(HoldExpiredException e) {
        ErrorDTO error = new ErrorDTO(
                e.getStatus().value(),
                e.getMessage()
        );
        return ResponseEntity
                .status(e.getStatus())
                .body(error);
    }

    @ExceptionHandler(value = SeatNotAvailableException.class)
    public ResponseEntity<ErrorDTO> handle(SeatNotAvailableException e) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }
}
