package com.parkinglot;


import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public StandardParkingBoy(ParkingLot firstParkingLot) {
        parkingLotList.add(firstParkingLot);
    }

    public StandardParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        try {
            ParkingLot firstNotFullParkingLot = parkingLotList.stream()
                    .filter(parkingLot -> !parkingLot.isFull())
                    .findFirst().get();
            return firstNotFullParkingLot.park(car);
        } catch (Exception e) {
            throw new NoAvailablePositionException();
        }

    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLotOfTicket = ticket.getSelectedParkingLot();
        if (parkingLotOfTicket == null) {
            throw new UnrecognizedTicketException();
        }
        return parkingLotOfTicket.fetch(ticket);
    }
}
