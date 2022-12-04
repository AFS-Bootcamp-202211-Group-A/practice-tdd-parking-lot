package com.parkinglot;

import java.util.ArrayList;

public class StandardParkingBoy {

    private ArrayList<ParkingLot> parkingLots = new ArrayList<>();

    protected ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLots.add(parkingLot);
    }

    public StandardParkingBoy(ArrayList<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }

    private ParkingLot findEmptyLot(){
        return parkingLots
                .stream()
                .filter(ParkingLot::isNotFull)
                .findFirst()
                .orElseThrow(ParkingLotFullException::new);
    }

    private ParkingLot findParkedCar(Ticket ticket){
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasCar(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedTicketException::new);
    }

    public Ticket park(Car car){
        return findEmptyLot().park(car);
    }

    public Car fetch(Ticket ticket) {
        return findParkedCar(ticket).fetch(ticket);
    }
}
