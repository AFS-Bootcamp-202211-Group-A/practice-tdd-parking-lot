package com.parkinglot;

public class ParkingLot {
    private Car parkedCar ;
    public Ticket park(Car car) {
        parkedCar = car;
        return new Ticket();
    }

    public Car fetch(Ticket ticket) {
        return parkedCar;
    }
}
