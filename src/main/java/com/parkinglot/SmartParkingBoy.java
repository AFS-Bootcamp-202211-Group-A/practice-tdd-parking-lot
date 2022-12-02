package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot availableParkingLot = parkingLots
                .stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .sorted(Comparator.comparing(ParkingLot::getEmptyPosition).reversed())
                .findFirst()
                .orElse(null);
        if(availableParkingLot == null) {
            throw new NoAvailablePositionException();
        }
        return availableParkingLot.park(car);
    }
}
