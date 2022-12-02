package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void should_park_to_second_parking_lot_when_car_park_given_2nd_lots_with_more_space() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        parkingLots.add(new ParkingLot(2));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertTrue(parkingLots.get(1).hasCar(ticket));
    }

}
