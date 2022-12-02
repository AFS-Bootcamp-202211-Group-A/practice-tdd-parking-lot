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
        if (isFull()) {
            throw new NoAvailablePositionException();
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket)  {
        if(isWrongTicket(ticket)) {
            throw new UnrecognizedTicketException();
        }
        Car returnCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return returnCar;
    }

    public boolean isWrongTicket(Ticket ticket) {
        return !parkedPosition.containsKey(ticket);
    }

    public boolean isFull() {
        return parkedPosition.size() == maxPosition;
    }

}
