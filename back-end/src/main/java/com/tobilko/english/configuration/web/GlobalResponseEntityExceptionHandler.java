package com.tobilko.english.configuration.web;

import com.tobilko.english.configuration.web.exception.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

/**
 * Created by Andrew Tobilko on 9/2/17.
 */
// TODO: 9/3/17 rewrite
@ControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            RollbackException.class
    })
    public ResponseEntity<ExceptionResponse> handleRollbackException(
            RollbackException exception
    ) {

        Throwable cause = exception.getCause();

        if (cause instanceof ConstraintViolationException) {
            // validation error
            return new ResponseEntity<>(ExceptionResponse.of(cause.getMessage(), LocalDateTime.now()), HttpStatus.PARTIAL_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}