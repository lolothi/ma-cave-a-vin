package macaveavin.app.api.controller;

import macaveavin.app.api.repository.CellarPlaceNotEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CellarPlaceNotEmptyException.class)
    public ResponseEntity<String> handleCellarPlaceNotEmptyException(CellarPlaceNotEmptyException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
