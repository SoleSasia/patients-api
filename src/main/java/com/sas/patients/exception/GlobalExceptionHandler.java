package com.sas.patients.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(DuplicatedPatientException.class)
    ResponseEntity<String> handleDuplicatePatientException(DuplicatedPatientException ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(500).body("Un error inesperado a ocurrido: " + ex.getMessage());
    }

}
