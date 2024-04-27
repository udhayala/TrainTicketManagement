package com.cloudbees.service.exception;

public class TicketNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public TicketNotFoundException(final String message) {
        super(message);
    }
}
