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
    void should_return_exception_with_error_message_when_fetch_given_used_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        // when
        parkingLot.fetch(ticket);
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> parkingLot.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_park_given_full_parking_with_default_capacity() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        for (int i=0; i<10; ++i) {
            parkingLot.park(car);
        }
        // when

        // then
        Exception exception = assertThrows(NoAvailableSpaceException.class,
                () -> parkingLot.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_park_given_full_parking_with_3_capacity() {
        // given
        int capacity = 3;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();
        for (int i=0; i<capacity; ++i) {
            parkingLot.park(car);
        }
        // when

        // then
        Exception exception = assertThrows(NoAvailableSpaceException.class,
                () -> parkingLot.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Ticket unrecognizedParkingTicket = new Ticket();
        // when

        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> parkingLot.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
