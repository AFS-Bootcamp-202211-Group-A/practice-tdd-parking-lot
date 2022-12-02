package com.parkinglot;

public class ParkingBoy {
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot1 = parkingLot;
    }

    public ParkingBoy(ParkingLot parkingLot1, ParkingLot parkingLot2) {
        this.parkingLot1 = parkingLot1;
        this.parkingLot2 = parkingLot2;
    }

    public Ticket park(Car car) {
        return this.parkingLot1.park(car);
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot1.fetch(ticket);
    }
}
