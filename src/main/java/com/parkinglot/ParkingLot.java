package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final Map<Ticket, Car> parkedCars = new HashMap<>();
    private final int parkingSpaces;

    public ParkingLot() {
       this.parkingSpaces = 10;
    }
    public ParkingLot(int capacity) {
        this.parkingSpaces = capacity;
    }

    public Ticket park(Car car) {

        if (parkedCars.size() >= parkingSpaces){
            return null;
        }
        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        return ticket;

    }

    public Car fetch(Ticket ticket) {
        return parkedCars.remove(ticket);
    }

}
