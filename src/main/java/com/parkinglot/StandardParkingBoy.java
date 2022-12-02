package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public Ticket park(Car car) {
        return this.parkingLots.get(0).park(car);
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLots.get(0).fetch(ticket);
    }
}
