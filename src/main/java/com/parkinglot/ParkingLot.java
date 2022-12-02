package com.parkinglot;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.Objects.isNull;

public class ParkingLot {

    HashMap<Ticket, Car> ticketCarMap = new HashMap<Ticket, Car>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {

        Car fetchedCar = ticketCarMap.getOrDefault(ticket, null);
        if(!isNull(fetchedCar)){
            ticketCarMap.remove(ticket);
        }
        return fetchedCar;
    }


}
