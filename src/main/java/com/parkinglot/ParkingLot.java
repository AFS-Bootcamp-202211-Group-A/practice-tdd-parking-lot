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
            return null;
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    private boolean isFull() {
        return parkedPosition.size() == capacity;
    }

    public Car fetch(Ticket ticket) {
        Car fetchedCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return fetchedCar;
    }

}
