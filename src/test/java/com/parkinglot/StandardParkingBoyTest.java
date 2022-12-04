package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {

    @Test
    void should_return_a_parking_ticket_when_park_given_a_parkinglot_a_standard_parkingBoy_and_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Car car1 = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkinglot);
        Ticket ticket = standardParkingBoy.park(car1);
        //when

        //then
        assertNotNull(ticket);
    }
}
