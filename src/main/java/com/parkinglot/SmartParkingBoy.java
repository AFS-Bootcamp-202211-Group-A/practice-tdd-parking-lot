package com.parkinglot;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws UnavailableSlotException {
        return super.park(car);
    }


}