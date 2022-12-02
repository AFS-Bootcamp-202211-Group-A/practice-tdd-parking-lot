package com.parkinglot;

public class UnrecognizedTicketExceptioin extends RuntimeException {

    public UnrecognizedTicketExceptioin(){
        super("Unrecognized parking ticket.");
    }
}
