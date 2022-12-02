package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_a_parking_lot_and_a_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        // when
        Ticket ticket = smartParkingBoy.park(car);
        // then
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_given_a_parking_lot_a_parked_car_and_a_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = smartParkingBoy.park(car);
        // when
        Car fetchedCar = smartParkingBoy.fetch(ticket);
        // then
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_right_car_when_fetch_twice_given_a_parking_lot_two_parked_car_and_two_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket aliceTicket = smartParkingBoy.park(aliceCar);
        Ticket bobTicket = smartParkingBoy.park(bobCar);
        // when
        Car aliceFetchedCar = smartParkingBoy.fetch(aliceTicket);
        Car bobFetchedCar = smartParkingBoy.fetch(bobTicket);
        // then
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }
    @Test
    void should_return_exception_with_error_message_when_fetch_given_a_parking_lot_and_a_used_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        // when
        smartParkingBoy.fetch(ticket);
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> smartParkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_park_given_full_parking_with_default_capacity() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        for (int i=0; i<10; ++i) {
            smartParkingBoy.park(car);
        }
        // when

        // then
        Exception exception = assertThrows(NoAvailableSpaceException.class,
                () -> smartParkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_park_given_full_parking_with_3_capacity() {
        // given
        int capacity = 3;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        for (int i=0; i<capacity; ++i) {
            smartParkingBoy.park(car);
        }
        // when

        // then
        Exception exception = assertThrows(NoAvailableSpaceException.class,
                () -> smartParkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_fetch_given_a_parking_lot_and_a_unrecognized_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Ticket unrecognizedParkingTicket = new Ticket();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        // when

        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> smartParkingBoy.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    void should_park_in_second_parking_lot_when_park_given_first_with_1_vacancy_and_second_with_2_vacancy_and_a_car() {
        // given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        // when
        Ticket ticket = smartParkingBoy.park(car);
        // then
        assertTrue(secondParkingLot.isRecognizedTicket(ticket));
    }
    @Test
    void should_return_exception_with_error_message_when_fetch_given_two_parking_lots_and_a_unrecognized_ticket() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Ticket unrecognizedParkingTicket = new Ticket();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        // when

        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> smartParkingBoy.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_fetch_given_two_parking_lots_and_a_used_ticket() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Ticket ticket = smartParkingBoy.park(car);
        // when
        smartParkingBoy.fetch(ticket);
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> smartParkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    void should_return_exception_with_error_message_when_park_given_full_parking_with_1_capacity_in_two_parking_lots() {
        // given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        for (int i=0; i<2; ++i) {
            smartParkingBoy.park(car);
        }
        // when

        // then
        Exception exception = assertThrows(NoAvailableSpaceException.class,
                () -> smartParkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
}
