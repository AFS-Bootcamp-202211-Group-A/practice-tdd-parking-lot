package com.parkinglot;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {

    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    public ParkingBoy(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot: parkingLots){
            if(parkingLot.getTicketCarMap().size() < parkingLot.getCapacity()){
                return parkingLot.park(car);
            }
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        return null;
    }
}
