package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {

    @Test
    void should_return_a_parking_ticket_when_park_given_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_pass_a_valid_ticket_given_a_valid_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_return_the_corresponding_car_when_pass_the_corresponding_valid_ticket_given_a_valid_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //when
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }

    @Test
    public void should_return_null_when_pass_the_wrong_ticket_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket dummyTicket = new Ticket();

        //when
        Car fetchedCar = parkingLot.fetch(dummyTicket);

        //then
        assertNull(fetchedCar);

    }
    
    @Test
    public void should_return_null_when_pass_no_ticket_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(null);

        //then
        assertNull(fetchedCar);
    }

    @Test
    public void should_return_null_when_pass_used_ticket_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);

        //when
        Car fetchFetchedCar = parkingLot.fetch(ticket);

        //then
        assertNull(fetchFetchedCar);

    }

    @Test
    public void should_return_null_when_park_the_car_given_the_parking_lot_is_full(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();
        Car car11 = new Car();
        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.park(car3);
        parkingLot.park(car4);
        parkingLot.park(car5);
        parkingLot.park(car6);
        parkingLot.park(car7);
        parkingLot.park(car8);
        parkingLot.park(car9);
        parkingLot.park(car10);

        //when
        Ticket ticket11 = parkingLot.park(car11);

        //then
        assertNull(ticket11);
    }


}