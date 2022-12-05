package com.parkinglot;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class ParkingLot {

    private HashMap<Ticket, Car> ticketCarMap = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public Ticket park(Car car) throws UnavailableSlotException {
        if (isFull()) {
            throw new UnavailableSlotException();
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;

    }

    private boolean isFull() {
        return ticketCarMap.size() >= capacity;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedTicketException {

        Car fetchedCar = ticketCarMap.remove(ticket);
        if (isNull(fetchedCar)) {
            throw new UnrecognizedTicketException();

        }
        return fetchedCar;
    }

    public HashMap<Ticket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public int getCapacity() {
        return capacity;
    }
}
