package com.parkinglot;


public class StandardParkingBoy {
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;

    public StandardParkingBoy(ParkingLot firstParkingLot){
        this.firstParkingLot = firstParkingLot;
    }
    public StandardParkingBoy(ParkingLot firstParkingLot,ParkingLot secondParkingLot){
        this.firstParkingLot = firstParkingLot;
        this.secondParkingLot = secondParkingLot;
    }
    public Ticket park(Car car) {
        return this.firstParkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        return this.firstParkingLot.fetch(ticket);
    }
}
