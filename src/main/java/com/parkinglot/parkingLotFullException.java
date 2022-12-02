package com.parkinglot;

public class parkingLotFullException extends RuntimeException{
    public parkingLotFullException(String message) {
        super("No available position.");
    }
}
