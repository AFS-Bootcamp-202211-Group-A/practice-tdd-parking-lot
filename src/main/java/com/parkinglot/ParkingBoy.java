package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private final Map<Ticket, ParkingLot> ticketParkingLotPosition = new HashMap<>();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot1 = parkingLot;
    }

    public ParkingBoy(ParkingLot parkingLot1, ParkingLot parkingLot2) {
        this.parkingLot1 = parkingLot1;
        this.parkingLot2 = parkingLot2;
    }

    public Ticket park(Car car) {
        Ticket ticket;
        if(this.parkingLot1.isFull() && parkingLot2!=null){
            ticket = this.parkingLot2.park(car);
            ticketParkingLotPosition.put(ticket,parkingLot2);
        }
        else {
            ticket = this.parkingLot1.park(car);
            ticketParkingLotPosition.put(ticket,parkingLot1);
        }
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot1.fetch(ticket);
    }

    public ParkingLot getParkingLotPosition(Ticket ticket) {
        return this.ticketParkingLotPosition.get(ticket);
    }
}
