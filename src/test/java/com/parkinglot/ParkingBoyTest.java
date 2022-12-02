package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_park_given_a_car_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //
        assertNotNull(ticket);
    }
}