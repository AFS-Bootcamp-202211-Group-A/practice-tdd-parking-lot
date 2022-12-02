package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final static int CAPACITY = 10;
    private Map<Ticket, Car> parkedPosition = new HashMap<>();

    public Ticket park(Car car) {
        if (parkedPosition.size() < CAPACITY) {
            Ticket ticket = new Ticket();
            parkedPosition.put(ticket, car);
            return ticket;
        }
        return null;

    }

    public Car fetch(Ticket ticket) {
        Car foundCar = parkedPosition.get(ticket);
        if (foundCar != null) {
            parkedPosition.remove(ticket);
        }
        return foundCar;
    }
}
