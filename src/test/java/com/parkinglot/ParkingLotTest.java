package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_a_car() {
        //given
        ParkingLot parkinglot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkinglot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket_and_a_parked_car() {
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
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }

//    @Test
//    void should_return_null_when_fetch_a_car_given_wrong_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Ticket ticket = new Ticket();
//
//        //when
//        Car fetchedCar = parkingLot.fetch(ticket);
//
//        //then
//        assertNull(fetchedCar);
//    }

    @Test
    void should_return_exception_with_error_message_when_fetch_a_car_given_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket unrecognizedTicket = new Ticket();

        //when
//        Car fetchedCar = parkingLot.fetch(unrecognizedTicket);

        //then
        Exception exception = assertThrows(UnrecognizedTicketExceptioin.class,
                () -> parkingLot.fetch(unrecognizedTicket)
        );
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

//    @Test
//    void should_return_null_when_fetch_a_car_given_used_parking_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        Ticket ticket = parkingLot.park(car);
//        parkingLot.fetch(ticket);
//
//        //when
//        Car fetchedCar = parkingLot.fetch(ticket);
//
//        //then
//        assertNull(fetchedCar);
//    }

    @Test
    void should_return_exception_with_error_message_when_fetch_a_car_given_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketExceptioin.class,
                () -> parkingLot.fetch(ticket)
        );
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

//    @Test
//    void should_return_null_when_park_a_car_given_parking_lot_without_position() {
//        //given
//        ParkingLot parkingLot = new ParkingLot(1);
//        Car car = new Car();
//        parkingLot.park(car);
//        Car extraCar = new Car();
//        //when
//        Ticket ticket = parkingLot.park(extraCar);
//
//        //then
//        assertNull(ticket);
//    }

    @Test
    void should_return_exception_with_error_message_when_park_given_parking_lot_without_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        Car extraCar = new Car();
        //when

        //then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> parkingLot.park(extraCar)
        );
        assertEquals("No available position.", exception.getMessage());
    }
}
