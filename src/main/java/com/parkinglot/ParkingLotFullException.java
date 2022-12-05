package com.parkinglot;

public class ParkingLotFullException extends RuntimeException {
    public ParkingLotFullException(){
        super("No available position.");
    }
}
