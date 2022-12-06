package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkedPosition = new HashMap<>();
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (isFull()){
            throw new NoParkPositionException();
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    public boolean isFull() {
        return parkedPosition.size() == capacity;
    }

    public int getRemainingCapacity() {
        return capacity-parkedPosition.size() ;
    }

    public boolean isAssociateWithTicket(Ticket ticket) {
        return parkedPosition.containsKey(ticket);
    }

    public Car fetch(Ticket ticket) {
        if (unrecognizedTicket(ticket)){
            throw new UnrecognizedTicketException();
        }
        Car fetchedCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return fetchedCar;
    }

    private boolean unrecognizedTicket(Ticket ticket) {
        return !parkedPosition.containsKey(ticket);
    }

}
