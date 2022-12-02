package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Map<Ticket, Car> parkedCars = new HashMap();
    private static int parkingSpaces = 10;

    public Ticket park(Car car) {
        if (parkingSpaces == 0){
            return null;
        }
        parkingSpaces--;
        Ticket ticket = new Ticket();
        this.parkedCars.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car carparked = parkedCars.get(ticket);
        if (carparked != null){
            parkingSpaces++;
            parkedCars.remove(ticket);
        }
        return carparked;
    }
}
