package com.rahand.rip.government.domain.exception;


import com.rahand.rip.government.domain.exception.InvalidNationalIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidNationalIdException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidNationalId(InvalidNationalIdException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", 400);
        body.put("error", "INVALID_NATIONAL_ID");
        body.put("message", ex.getMessage());
        body.put("path", "/api/v1/identity/check");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
