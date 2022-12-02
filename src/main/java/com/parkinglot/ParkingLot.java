package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    public static int capacity=10;
    private Map<Ticket, Car> parkedPostion = new HashMap<>();
    public ParkingLot(){}
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }
    public Ticket park(Car car) {
        if(parkedPostion.size() < capacity){
            Ticket ticket = new Ticket(car);
            parkedPostion.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkedPostion.get(ticket);
        parkedPostion.remove(ticket);
        return car;
    }
}
