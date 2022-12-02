package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parkingboy_and_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parkingboy_parked_car_and_a_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_parkingboy_two_parked_cars_and_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Ticket aliceTicket = parkingBoy.park(aliceCar);
        Ticket bobTicket = parkingBoy.park(bobCar);
        //when
        Car aliceFetchedCar = parkingBoy.fetch(aliceTicket);
        Car bobFetchedCar = parkingBoy.fetch(bobTicket);
        //then
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }
}
