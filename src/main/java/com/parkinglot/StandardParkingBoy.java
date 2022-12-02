package com.parkinglot;


public class StandardParkingBoy {
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;

    public StandardParkingBoy(ParkingLot firstParkingLot){
        this.firstParkingLot = firstParkingLot;
    }
    public StandardParkingBoy(ParkingLot firstParkingLot,ParkingLot secondParkingLot){
        this.firstParkingLot = firstParkingLot;
        this.secondParkingLot = secondParkingLot;
    }
    public Ticket park(Car car) {
        if (firstParkingLot.isFull()&& secondParkingLot!= null) {
            return this.secondParkingLot.park(car);
        }
        return this.firstParkingLot.park(car);

    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLotOfTicket = ticket.getSelectedParkingLot();
        if (parkingLotOfTicket == null){
            throw new UnrecognizedTicketException();
        }
        return parkingLotOfTicket.fetch(ticket);
    }
}
