package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_park_given_a_car_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_pass_a_valid_ticket_given_a_valid_ticket_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }


}