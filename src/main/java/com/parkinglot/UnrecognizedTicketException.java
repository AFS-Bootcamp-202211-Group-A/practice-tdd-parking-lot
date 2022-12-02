package com.parkinglot;

public class UnrecognizedTicketException extends RuntimeException{
    public UnrecognizedTicketException(String message) {
        super("Unrecognized parking ticket.");
    }
}
