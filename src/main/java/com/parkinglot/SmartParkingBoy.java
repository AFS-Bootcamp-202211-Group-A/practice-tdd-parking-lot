package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends StandardParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot availableParkingLot = parkingLots
                .stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparingInt(ParkingLot::getEmptyPosition))
                .orElseThrow(NoAvailablePositionException::new);
        return availableParkingLot.park(car);
    }
}
