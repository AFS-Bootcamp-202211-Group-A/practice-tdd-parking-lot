package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket, Car> parkedPosition = new HashMap<>();
    int capacity = 10;
    public Ticket park(Car car) {
        if (parkedPosition.size() >= capacity) {
            return null;
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        final Car fetchedCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return fetchedCar;
    }
}