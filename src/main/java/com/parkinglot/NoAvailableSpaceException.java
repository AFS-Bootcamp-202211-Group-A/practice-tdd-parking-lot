package com.parkinglot;

public class NoAvailableSpaceException extends RuntimeException {
    public NoAvailableSpaceException() {
        super("No available position.");
    }
}
