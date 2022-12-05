package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends StandardParkingBoy{
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    private ParkingLot findEmptyLot(){
        return getParkingLots()
                .stream()
                .max(Comparator.comparingInt(ParkingLot::getRemainingSpace))
                .orElseThrow(ParkingLotFullException::new);
    }

    @Override
    public Ticket park(Car car){
        return this.findEmptyLot().park(car);
    }
}
