package es.urjc.cloudapps.insurancecompany.shared.infrastructure;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<String> handleConflictIllegalArguments(IllegalArgumentException ex) {

        String bodyOfResponse = "Bad request - Domain conflict: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    protected ResponseEntity<String> handleConflictIllegalState(IllegalStateException ex) {

        String bodyOfResponse = "Bad request - Domain conflict: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<String> handleConflictNullPointer(NullPointerException ex) {

        String bodyOfResponse = "Internal server error: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class, ConstraintViolationException.class})
    protected ResponseEntity<String> handleConflictDataIntegrity(RuntimeException ex) {

        String bodyOfResponse = "Internal server error: Database exception";
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
