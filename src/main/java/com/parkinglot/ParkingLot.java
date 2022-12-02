package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkedPosition = new HashMap<>();
    private final int maxPosition;

    public ParkingLot(){
        this.maxPosition = 10;
    }

    public ParkingLot(int maxPosition){
        this.maxPosition = maxPosition;
    }
    public Ticket park(Car car) {
        if (parkedPosition.size() == maxPosition) {
            return null;
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car returnCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return returnCar;
    }
}
