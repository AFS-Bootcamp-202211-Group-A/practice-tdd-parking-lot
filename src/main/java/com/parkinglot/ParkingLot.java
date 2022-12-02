package com.parkinglot;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class ParkingLot {

    HashMap<Ticket, Car> ticketCarMap = new HashMap<>();
    private static final int CAPACITY = 10;

    public Ticket park(Car car) {
        if (ticketCarMap.size() >= CAPACITY) {
            return null;
        } else {
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }
    }

    public Car fetch(Ticket ticket) {

        Car fetchedCar = ticketCarMap.getOrDefault(ticket, null);
        if (!isNull(fetchedCar)) {
            ticketCarMap.remove(ticket);
        }
        return fetchedCar;
    }


}
