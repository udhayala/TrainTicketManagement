package com.cloudbees.service.exception;

public class NoSeatAvailableException  extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public NoSeatAvailableException(final String message) {
        super(message);
    }
}
