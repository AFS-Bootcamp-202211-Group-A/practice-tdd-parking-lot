package com.parkinglot;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class ParkingLot {

    private HashMap<Ticket, Car> ticketCarMap = new HashMap<>();
    private static int capacity = 10;

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }
    public Ticket park(Car car) {
        if (ticketCarMap.size() >= capacity) {
            return null;
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;

    }

    public Car fetch(Ticket ticket) {

        return ticketCarMap.remove(ticket);
    }


}
