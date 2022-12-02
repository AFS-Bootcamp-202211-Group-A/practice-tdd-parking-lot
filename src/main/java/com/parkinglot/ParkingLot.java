package com.parkinglot;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class ParkingLot {

    private HashMap<Ticket, Car> ticketCarMap = new HashMap<>();
    private static int capacity = 10;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (isFull()) {
            return null;
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;

    }

    private boolean isFull() {
        return ticketCarMap.size() >= capacity;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedTicketException{

        Car fetchedCar = ticketCarMap.remove(ticket);
        if(isNull(fetchedCar)){
            throw new UnrecognizedTicketException();

        }
        return fetchedCar;
    }


}
