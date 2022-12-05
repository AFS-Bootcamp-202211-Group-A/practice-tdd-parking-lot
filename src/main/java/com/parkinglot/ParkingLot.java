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
    protected Ticket park(Car car) {
        if (isFull()) {
            throw new NoAvailablePositionException();
        }
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    protected Car fetch(Ticket ticket)  {
        if(isWrongTicket(ticket)) {
            throw new UnrecognizedTicketException();
        }
        Car returnCar = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return returnCar;
    }

    protected boolean isWrongTicket(Ticket ticket) {
        return !parkedPosition.containsKey(ticket);
    }

    protected boolean isFull() {
        return parkedPosition.size() == maxPosition;
    }

    protected int getEmptyPosition() {
        return maxPosition - parkedPosition.size();
    }

}
