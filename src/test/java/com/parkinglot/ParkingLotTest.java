package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {

    @Test
    void should_return_a_parking_ticket_when_park_given_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_pass_a_valid_ticket_given_a_valid_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
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
        ParkingLot parkingLot = new ParkingLot();
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
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket dummyTicket = new Ticket();

        //when
        Car fetchedCar = parkingLot.fetch(dummyTicket);

        //then
        assertEquals(null, fetchedCar);

    }


}