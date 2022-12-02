package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public int capacity=10;
    private final Map<Ticket, Car> parkedPosition = new HashMap<>();
    public ParkingLot(){}
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }
    public Ticket park(Car car) {
        if(parkedPosition.size() < capacity){
            Ticket ticket = new Ticket();
            parkedPosition.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return car;
    }
}
