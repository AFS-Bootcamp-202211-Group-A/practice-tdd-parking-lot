package com.parkinglot;

public class Ticket {
    private ParkingLot parkingLotOfTheTicket;
    public Ticket(){}
    public Ticket(ParkingLot parkingLotOfTheTicket){
        this.parkingLotOfTheTicket=parkingLotOfTheTicket;
    }
    public ParkingLot getParkingLotOfTheTicket() {
        return parkingLotOfTheTicket;
    }
}
