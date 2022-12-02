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
        RuntimeException runtimeException = null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.park(car);
            } catch (RuntimeException e) {
                runtimeException = e;
            }
        }
        if (runtimeException != null) {
            throw runtimeException;
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
