package com.sas.patients.exception;

public class DuplicatedPatientException extends RuntimeException {
    public DuplicatedPatientException(String message) {
        super(message);
    }
}
