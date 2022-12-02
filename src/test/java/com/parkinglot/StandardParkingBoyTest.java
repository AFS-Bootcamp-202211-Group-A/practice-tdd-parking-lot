package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_a_parking_lot_and_a_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        // when
        Ticket ticket = standardParkingBoy.park(car);
        // then
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_given_a_parking_lot_a_parked_car_and_a_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Ticket ticket = standardParkingBoy.park(car);
        // when
        Car fetchedCar = standardParkingBoy.fetch(ticket);
        // then
        assertEquals(car, fetchedCar);
    }
}
