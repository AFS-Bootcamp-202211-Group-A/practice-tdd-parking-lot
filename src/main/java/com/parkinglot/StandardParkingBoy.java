package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car){
        ParkingLot availableParkingLot = parkingLots
                .stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElse(null);
        if(availableParkingLot == null){
            throw new NoAvailablePositionException();
        }
        return availableParkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLots.get(0).fetch(ticket);
    }
}
