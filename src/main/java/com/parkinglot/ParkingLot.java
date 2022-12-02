package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkedPosition = new HashMap<>();
    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car foundCar = parkedPosition.get(ticket);
        if (foundCar!= null){
            parkedPosition.remove(ticket);
        }
        return foundCar;
    }
}
