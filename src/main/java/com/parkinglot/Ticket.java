package com.parkinglot;

public class Ticket {
    ParkingLot selectedParkingLot;
    public Ticket(){

    }
    public Ticket(ParkingLot parkingLot){
        this.selectedParkingLot = parkingLot;
    }

    public ParkingLot getSelectedParkingLot() {
        return selectedParkingLot;
    }
}
