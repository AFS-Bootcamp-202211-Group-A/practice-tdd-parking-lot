package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLotList;

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        try {
            ParkingLot firstNotFullParkingLot = parkingLotList.stream()
                    .reduce(((parkingLot, parkingLot2) -> parkingLot.getFreePositions()>=parkingLot2.getFreePositions()? parkingLot:parkingLot2))
                    .get();
            return firstNotFullParkingLot.park(car);
        } catch (Exception e) {
            throw new NoAvailablePositionException();
        }

    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLotOfTicket = ticket.getSelectedParkingLot();
        if (parkingLotOfTicket == null){
            throw new UnrecognizedTicketException();
        }
        return parkingLotOfTicket.fetch(ticket);
    }
}
