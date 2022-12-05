package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots){
        super(parkingLots);

    }

    @Override
    public Ticket park(Car car) throws UnavailableSlotException {
        Optional<ParkingLot> bestParkingLot = parkingLots
                .stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getCapacity() - parkingLot.getTicketCarMap().size()));
        if(!bestParkingLot.isPresent()){
            throw new UnavailableSlotException();
        }
        return bestParkingLot.get().park(car);
    }



}