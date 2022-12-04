package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkinglotTest {

    @Test
    void should_return_ticket_when_park_given_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Car car = new Car();

        //when
        Ticket ticket = parkinglot.park(car);

        //then
        assertNotNull(ticket);
    }
    
    @Test
    void should_return_car_when_fetch_given_a_ticket_and_a_parkedCar() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
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
        ParkingLot parkinglot = new ParkingLot(2);
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
    void should_return_exception_with_error_message_when_fetch_given_a_parkinglot_and_a_used_ticket() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Car car1 = new Car();
        Ticket ticket1 = parkinglot.park(car1);
        Car fetchedCar1 = parkinglot.fetch(ticket1);
        Ticket usedTicket = ticket1;

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkinglot.fetch(usedTicket));
        assertEquals( "Unrecognized parking ticket.", exception.getMessage()) ;
    }

    @Test
    void should_return_exception_with_error_message_when_park_given_a_parkinglot_without_position_and_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Car car1 = new Car();
        Ticket ticket1 = parkinglot.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkinglot.park(car2);
        Car car3 = new Car();

        //when

        //then
        Exception exception = assertThrows(NoParkPositionException.class, () -> parkinglot.park(car3));
        assertEquals( "No available position.", exception.getMessage()) ;
    }
    
    @Test
    void should_return_exception_with_error_message_when_fetch_given_a_parkinglot_and_a_unrecognizedTicket() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Ticket UnrecognizedTicket = new Ticket();


        //when
        
        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkinglot.fetch(UnrecognizedTicket));
        assertEquals( "Unrecognized parking ticket.", exception.getMessage()) ;
    }

}
