package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    public StandardParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots
                .stream()
                .filter(ParkingLot::isNotFull)
                .findFirst()
                .orElseThrow(NoAvailableSpaceException::new)
                .park(car);
    }
    public Car fetch(Ticket ticket) {
        return parkingLots
                .stream()
                .filter(parkingLot -> parkingLot.isRecognizedTicket(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedTicketException::new)
                .fetch(ticket);
    }
}
