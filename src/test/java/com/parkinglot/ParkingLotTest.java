package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {

    @Test
    void should_return_a_parking_ticket_when_park_given_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_pass_a_valid_ticket_given_a_valid_ticket() {
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
    public void should_return_exception_with_error_message_when_pass_the_wrong_ticket_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Ticket dummyTicket = new Ticket();

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingLot.fetch(dummyTicket));
        assertEquals("Unrecognized packing ticket", exception.getMessage());

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_used_ticket_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingLot.fetch(ticket));
        assertEquals("Unrecognized packing ticket", exception.getMessage());

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_no_ticket_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingLot.fetch(null));
        assertEquals("Unrecognized packing ticket", exception.getMessage());
    }

    @Test
    public void should_return_exception_with_error_message_when_park_the_car_given_the_parking_lot_is_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        Car extraCar = new Car();

        //when

        //then
        Exception exception = assertThrows(UnavailableSlotException.class, () -> parkingLot.park(extraCar));
        assertEquals("No available position", exception.getMessage());
    }



}