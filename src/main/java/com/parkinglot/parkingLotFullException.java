package com.parkinglot;

public class parkingLotFullException extends RuntimeException{
    public parkingLotFullException() {
        super("No available position.");
    }
}
