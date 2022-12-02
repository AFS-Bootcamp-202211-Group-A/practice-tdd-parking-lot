package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
            Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parked_car_and_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car,fetchedCar);
    }
    @Test
    void should_return_right_car_when_fetch_twice_given_two_parked_cars_and_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Ticket aliceTicket = parkingLot.park(aliceCar);
        Ticket bobTicket = parkingLot.park(bobCar);
        //when
        Car aliceFetchedCar = parkingLot.fetch(aliceTicket);
        Car bobFetchedCar = parkingLot.fetch(bobTicket);
        //then
        assertEquals(aliceCar,aliceFetchedCar);
        assertEquals(bobCar,bobFetchedCar);
    }
    @Test
    void should_return_null_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        parkingLot.park(aliceCar);
        //when
        Car aliceFetchedCar = parkingLot.fetch(new Ticket());
        //then
        assertNull(aliceFetchedCar);
    }
    @Test
    void should_return_null_when_fetch_car_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        parkingLot.fetch(ticket);
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertNull(fetchedCar);
    }
    @Test
    void should_return_nothing_when_park_given_fulled_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        final int CAPACITY = 10;
        for (int i=0;i<CAPACITY;i++){
            Car dummyCar = new Car();
            parkingLot.park(car);
        }
        //when

        Ticket ticket = parkingLot.park(car);
        //then
        assertNull(ticket);
    }




}
