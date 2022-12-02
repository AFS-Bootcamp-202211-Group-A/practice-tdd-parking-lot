package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity=10;
    private final Map<Ticket, Car> parkedPosition = new HashMap<>();
    public ParkingLot(){}
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }
    public Ticket park(Car car) {
        if(isFull()){
            throw new parkingLotFullException();
        }
        Ticket ticket = new Ticket(this);
        parkedPosition.put(ticket, car);
        return ticket;
    }
    public boolean isFull() {
        return parkedPosition.size() >= capacity;
    }

    public Car fetch(Ticket ticket) {
        if(!parkedPosition.containsKey(ticket)){
            throw new UnrecognizedTicketException();
        }
        Car car = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return car;
    }

    public int getSize() {
        return parkedPosition.size();
    }

    public int getFreeSize() {
        return capacity - parkedPosition.size();
    }
}
