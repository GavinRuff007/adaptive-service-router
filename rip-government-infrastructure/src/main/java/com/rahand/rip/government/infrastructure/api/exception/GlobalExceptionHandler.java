package com.rahand.rip.government.infrastructure.api.exception;

import com.rahand.rip.government.domain.exception.InvalidBirthDateException;
import com.rahand.rip.government.domain.exception.InvalidNationalIdException;
import com.rahand.rip.government.infrastructure.api.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidNationalIdException.class)
    public ResponseEntity<ApiResponse<?>> handleInvalidNationalId(InvalidNationalIdException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail("INVALID_NATIONAL_ID", ex.getMessage()));
    }

    @ExceptionHandler(InvalidBirthDateException.class)
    public ResponseEntity<ApiResponse<?>> handleInvalidBirthDateId(InvalidBirthDateException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail("INVALID_BIRTHDATE_ID", ex.getMessage()));
    }
}
