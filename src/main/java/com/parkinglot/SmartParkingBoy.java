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
        Optional<ParkingLot> parkingLot = parkingLots.stream().max(Comparator.comparingInt(ParkingLot::getVacancy));
        return parkingLot.map(lot -> lot.park(car)).orElse(null);
    }

    public Car fetch(Ticket ticket) {
        UnrecognizedTicketException exception = null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetch(ticket);
            } catch (UnrecognizedTicketException unrecognizedTicketException) {
                exception = unrecognizedTicketException;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return null;
    }
}
