package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_park_given_a_car_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_pass_a_valid_ticket_given_a_valid_ticket_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_return_the_corresponding_car_when_pass_the_corresponding_valid_ticket_given_a_valid_ticket_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);

        //when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_the_wrong_ticket_given_wrong_ticket_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);
        Ticket dummyTicket = new Ticket();

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(dummyTicket));
        assertEquals("Unrecognized packing ticket", exception.getMessage());

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_used_ticket_given_used_ticket_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized packing ticket", exception.getMessage());

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_no_ticket_given_no_ticket_and_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(null));
        assertEquals("Unrecognized packing ticket", exception.getMessage());
    }

    @Test
    public void should_return_exception_with_error_message_when_park_the_car_given_the_parking_lot_is_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            parkingBoy.park(car);
        }
        Car extraCar = new Car();

        //when

        //then
        Exception exception = assertThrows(UnavailableSlotException.class, () -> parkingBoy.park(extraCar));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    public void should_return_two_tickets_when_park_the_car_given_two_parking_lot_two_cars_one_parking_boy() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);


        //when
        Ticket ticket1 = parkingBoy.park(new Car());
        Ticket ticket2 = parkingBoy.park(new Car());

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);


    }

//    @Test
//    public void should_return_two_tickets_when_park_the_car_given_two_parking_lot_two_cars_one_parking_boy() {
//        //given
//        ParkingLot parkingLot1 = new ParkingLot(1);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
//
//
//        //when
//        Ticket ticket1 = parkingBoy.park(new Car());
//        Ticket ticket2 = parkingBoy.park(new Car());
//
//        //then
//        assertEquals(car1, fetchedCar1);
//        assertEquals(car2, fetchedCar2);
//
//
//    }


}