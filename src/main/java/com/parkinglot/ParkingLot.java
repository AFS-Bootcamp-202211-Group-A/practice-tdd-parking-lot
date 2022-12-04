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
            throw new ParkingLotFullException();
        }
        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        return ticket;

    }

    protected Car fetch(Ticket ticket) {
        if (!parkedCars.containsKey(ticket)){
            throw new UnrecognizedTicketException();
        }
        return parkedCars.remove(ticket);
    }

    protected boolean isNotFull(){
        return parkedCars.size()<parkingSpaces;
    }

    protected boolean hasCar(Ticket ticket){
        return parkedCars.containsKey(ticket);
    }

    protected int getRemainingSpace() {
        return parkingSpaces -parkedCars.size();
    }
}
