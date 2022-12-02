package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> cars = new ArrayList<>(10);
    public Ticket park(Car car) {
        cars.add(car);
        return new Ticket(car);
    }

    public Car fetch(Ticket ticket) {
        if(cars.contains(ticket.getCar())){
            cars.remove(ticket.getCar());
        }
        return ticket.getCar();
    }
}
