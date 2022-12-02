package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkinglot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket_and_a_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }
}
