package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_a_parking_car_when_fetch_given_a_parkinglot_a_standard_parkingBoy_and_a_ticket() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkinglot);
        Ticket ticket = standardParkingBoy.park(car);

        //when
        Car fetchedCar = parkinglot.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_rightCars_when_fetchTwice_given_a_standard_parking_boy_TwoParkedCar_and_tickets() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkinglot);
        Car car1 = new Car();
        Ticket ticket1 = standardParkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = standardParkingBoy.park(car2);

        //when
        Car fetchedCar1 = standardParkingBoy.fetch(ticket1);
        Car fetchedCar2 = standardParkingBoy.fetch(ticket2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_a_standard_parking_boy_a_parkinglot_and_a_used_ticket() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkinglot);
        Car car1 = new Car();
        Ticket ticket1 = standardParkingBoy.park(car1);
        Car fetchedCar1 = standardParkingBoy.fetch(ticket1);
        Ticket usedTicket = ticket1;

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> standardParkingBoy.fetch(usedTicket));
        assertEquals( "Unrecognized parking ticket.", exception.getMessage()) ;
    }

    @Test
    void should_return_exception_with_error_message_when_park_given_a_standard_parking_boy_a_parkinglot_without_position_and_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkinglot);
        Car car1 = new Car();
        Ticket ticket1 = standardParkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = standardParkingBoy.park(car2);
        Car car3 = new Car();

        //when

        //then
        Exception exception = assertThrows(NoParkPositionException.class, () -> standardParkingBoy.park(car3));
        assertEquals( "No available position.", exception.getMessage()) ;
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_a_standard_parking_boy_a_parkinglot_and_a_unrecognizedTicket() {
        //given
        ParkingLot parkinglot = new ParkingLot(2);
        Ticket UnrecognizedTicket = new Ticket();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkinglot);


        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> standardParkingBoy.fetch(UnrecognizedTicket));
        assertEquals( "Unrecognized parking ticket.", exception.getMessage()) ;
    }
}
