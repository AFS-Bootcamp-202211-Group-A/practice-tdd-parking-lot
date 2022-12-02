package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    public Ticket park(Car car) {
        try{
            return parkingLots.stream()
                    .filter(parkingLot -> !parkingLot.isFull())
                    .reduce((lot1,lot2) -> lot2.getFreeSize() > lot1.getFreeSize()?lot2:lot1)
                    .get()
                    .park(car);
        }
        catch (Exception e){
            throw new parkingLotFullException();
        }
    }

    public Car fetch(Ticket ticket) {
        try{
            return ticket.getParkingLotOfTheTicket().fetch(ticket);
        }
        catch (Exception e){
            throw new UnrecognizedTicketException();
        }
    }
}
