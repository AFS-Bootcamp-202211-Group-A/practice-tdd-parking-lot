package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private final HashMap<Ticket, Car> parkedPosition = new HashMap<>();
    private int capacity = 10;

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (parkedPosition.size() >= capacity) {
            throw new NoAvailableSpaceException();
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (!isRecognizedTicket(ticket)) {
            throw new UnrecognizedTicketException();
        }
        final Car fetchedCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return fetchedCar;
    }

    private boolean isRecognizedTicket(Ticket ticket) {
        return parkedPosition.containsKey(ticket);
    }
}