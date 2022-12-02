package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;

    public ParkingLot(int capacity){
        this.capacity = capacity;

    }
    private Map<Ticket, Car> parkedPosition = new HashMap<>();

    public Ticket park(Car car) {
        if (isNotFull()) {
            Ticket ticket = new Ticket();
            parkedPosition.put(ticket, car);
            return ticket;
        }
        return null;

    }

    private boolean isNotFull() {
        return parkedPosition.size() < capacity;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedTicketException {
        if (isUnrecognizedTicket(ticket)){
            throw new UnrecognizedTicketException();
        }

        Car foundCar = parkedPosition.get(ticket);
        if (foundCar != null) {
            parkedPosition.remove(ticket);
        }
        return foundCar;
    }

    private boolean isUnrecognizedTicket(Ticket ticket) {
        return !parkedPosition.containsKey(ticket);
    }
}
