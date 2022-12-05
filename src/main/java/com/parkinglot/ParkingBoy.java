package com.parkinglot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ParkingBoy {

    public ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    public ParkingBoy(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots.addAll(parkingLots);
    }

    public Ticket park(Car car) throws UnavailableSlotException{
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().filter(parkingLot ->
                parkingLot.getTicketCarMap().size() < parkingLot.getCapacity()
        ).findFirst();
        if(!optionalParkingLot.isPresent()){
            throw new UnavailableSlotException();
        }
        return optionalParkingLot.get().park(car);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedTicketException {
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().filter(parkingLot ->
                parkingLot.getTicketCarMap().containsKey(ticket)).findFirst();
        if(!optionalParkingLot.isPresent()){
            throw new UnrecognizedTicketException();
        }
        return optionalParkingLot.get().fetch(ticket);
    }
}
