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
        NoAvailableSpaceException exception = null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.park(car);
            } catch (NoAvailableSpaceException noAvailableSpaceException) {
                exception = noAvailableSpaceException;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return null;
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
