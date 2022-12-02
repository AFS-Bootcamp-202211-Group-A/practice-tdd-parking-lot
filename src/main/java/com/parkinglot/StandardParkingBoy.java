package com.parkinglot;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class StandardParkingBoy {
    private ParkingLot parkingLot;
    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public Ticket park(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot.fetch(ticket);
    }
}
