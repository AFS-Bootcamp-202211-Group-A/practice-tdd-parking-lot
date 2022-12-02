package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Map<Ticket, Car> parkedCars = new HashMap();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        this.parkedCars.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car carparked = parkedCars.get(ticket);
        parkedCars.remove(ticket);
        return carparked;
    }
}
