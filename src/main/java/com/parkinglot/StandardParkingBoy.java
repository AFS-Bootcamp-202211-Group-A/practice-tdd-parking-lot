package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
        this.parkingLots = null;
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
        this.parkingLot = null;
    }

    public Ticket park(Car car){
        if(this.parkingLot != null) {
            return this.parkingLot.park(car);
        }else{
            return parkingLots.stream()
                    .filter(parkingLot -> !parkingLot.isFull())
                    .findFirst()
                    .orElseThrow(NoParkPositionException::new)
                    .park(car);
        }

    }

    public Car fetch(Ticket ticket){
        if(this.parkingLot != null) {
            return this.parkingLot.fetch(ticket);
        }else{
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.isAssociateWithTicket(ticket))
                    .findFirst()
                    .orElseThrow(UnrecognizedTicketException::new)
                    .fetch(ticket);
        }

    }


}
