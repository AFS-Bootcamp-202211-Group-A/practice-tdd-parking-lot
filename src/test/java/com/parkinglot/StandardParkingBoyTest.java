package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);

    }

    @Test
    public void should_return_parked_car_when_car_parked_given_parking_lot_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);
        Car parkedCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, parkedCar);

    }



}
