package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    public SmartParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparingInt(ParkingLot::getVacancy))
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
