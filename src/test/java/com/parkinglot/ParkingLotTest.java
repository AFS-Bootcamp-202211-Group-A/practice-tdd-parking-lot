package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        // when
        Ticket ticket = parkingLot.park(car);
        // then
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_given_a_parked_car_and_a_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        // when
        Car fetchedCar = parkingLot.fetch(ticket);
        // then
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_right_car_when_fetch_twice_given_two_parked_car_and_two_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Ticket aliceTicket = parkingLot.park(aliceCar);
        Ticket bobTicket = parkingLot.park(bobCar);
        // when
        Car aliceFetchedCar = parkingLot.fetch(aliceTicket);
        Car bobFetchedCar = parkingLot.fetch(bobTicket);
        // then
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }
    @Test
    void should_return_nothing_when_fetch_given_wrong_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Ticket aliceTicket = parkingLot.park(aliceCar);
        Ticket bobTicket = new Ticket();
        // when
        Car fetchedCar = parkingLot.fetch(bobTicket);
        // then
        assertNull(fetchedCar);
    }
    @Test
    void should_return_nothing_when_fetch_given_used_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        // when
        Car fetchedCar = parkingLot.fetch(ticket);
        Car newFetchedCar = parkingLot.fetch(ticket);
        // then
        assertNull(newFetchedCar);
    }
}
