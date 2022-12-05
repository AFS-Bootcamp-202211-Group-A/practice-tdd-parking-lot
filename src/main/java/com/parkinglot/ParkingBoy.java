package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    public Ticket park(Car car) {
        try{
            ParkingLot theParkingLot = this.parkingLots
                    .stream()
                    .filter(parkingLot -> !parkingLot.isFull())
                    .findFirst()
                    .get();
            return theParkingLot.park(car);
        }
        catch (Exception e){
            throw new parkingLotFullException();
        }
    }

    public Car fetch(Ticket ticket) {
        try{
            return ticket.getParkingLotOfTheTicket().fetch(ticket);
        }
        catch (Exception e){
            throw new UnrecognizedTicketException();
        }
    }
}
