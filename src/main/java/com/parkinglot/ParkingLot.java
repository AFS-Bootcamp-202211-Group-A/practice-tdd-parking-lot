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
        throw new parkingLotFullException("No available position.");
    }

    public Car fetch(Ticket ticket) {
        if(!parkedPosition.containsKey(ticket)){
            throw new UnrecognizedTicketException("Unrecognized parking ticket.");
        }
        Car car = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return car;
    }
}
