package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkinglotTest {

    @Test
    void should_return_ticket_when_park_given_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        parkinglot.setCapacity(2);
        Car car = new Car();

        //when
        Ticket ticket = parkinglot.park(car);

        //then
        assertNotNull(ticket);
    }
    
    @Test
    void should_return_car_when_fetch_given_a_ticket_and_a_parkedCar() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        parkinglot.setCapacity(2);
        Car car = new Car();
        Ticket ticket = parkinglot.park(car);

        //when
        Car fetchedCar = parkinglot.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }
    
    @Test
    void should_return_rightCars_when_fetchTwice_given_TwoParkedCar_and_tickets() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        parkinglot.setCapacity(2);
        Car car1 = new Car();
        Ticket ticket1 = parkinglot.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkinglot.park(car2);

        //when
        Car fetchedCar1 = parkinglot.fetch(ticket1);
        Car fetchedCar2 = parkinglot.fetch(ticket2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_nothing_when_fetch_given_a_parkinglot_and_a_wrong_parking_ticket() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        parkinglot.setCapacity(2);
        Ticket wrongTicket = new Ticket();

        //when
        Car fetchedCar = parkinglot.fetch(wrongTicket);

        //then
        assertNull(fetchedCar);
    }
    
    @Test
    void should_return_nothing_when_fetch_given_a_parkinglot_and_a_used_ticket() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        parkinglot.setCapacity(2);
        Car car1 = new Car();
        Ticket ticket1 = parkinglot.park(car1);
        Car fetchedCar1 = parkinglot.fetch(ticket1);
        Ticket usedTicket = ticket1;

        //when
        Car fetchedCarByUsedTicket = parkinglot.fetch(usedTicket);

        //then
        assertNull(fetchedCarByUsedTicket);
    }

    @Test
    void should_return_nothing_when_park_given_a_parkinglot_without_position_and_a_car() {
        //given
        int capacity = 2;
        ParkingLot parkinglot = new ParkingLot();
        parkinglot.setCapacity(capacity);
        Car car1 = new Car();
        Ticket ticket1 = parkinglot.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkinglot.park(car2);
        Car car3 = new Car();

        //when
        Ticket ticket3 = parkinglot.park(car3);

        //then
        assertNull(ticket3);
    }

}
