package com.parkinglot;

public class UnrecognizedTicketException extends RuntimeException{
    public UnrecognizedTicketException(){
        super("Unrecognised Parking Ticket");
    }

}
