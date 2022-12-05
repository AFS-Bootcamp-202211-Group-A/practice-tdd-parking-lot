package com.parkinglot;

public class UnavailableSlotException extends RuntimeException{
    public UnavailableSlotException(){
        super("No available position");
    }

}
