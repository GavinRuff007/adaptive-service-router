package com.rahand.rip.government.infrastructure.api.exception;

import com.rahand.rip.government.domain.exception.InvalidBirthDateException;
import com.rahand.rip.government.domain.exception.InvalidNationalIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidNationalIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNationalId(InvalidNationalIdException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidBirthDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBirthDate(InvalidBirthDateException ex) {
        return ex.getMessage();
    }
}
