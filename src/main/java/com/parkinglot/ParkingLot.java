package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> parkedPostion = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket(car);
        parkedPostion.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkedPostion.get(ticket);
        parkedPostion.remove(ticket);
        return car;
    }
}
