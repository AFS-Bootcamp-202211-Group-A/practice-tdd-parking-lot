package com.parkinglot;

public class NoParkPositionException extends RuntimeException{

    public NoParkPositionException(){
        super("No available position.");
    }
}
