package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_a_parking_lot_and_a_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        // when
        Ticket ticket = standardParkingBoy.park(car);
        // then
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_given_a_parking_lot_a_parked_car_and_a_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Ticket ticket = standardParkingBoy.park(car);
        // when
        Car fetchedCar = standardParkingBoy.fetch(ticket);
        // then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_a_parking_lot_two_parked_car_and_two_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Ticket aliceTicket = standardParkingBoy.park(aliceCar);
        Ticket bobTicket = standardParkingBoy.park(bobCar);
        // when
        Car aliceFetchedCar = standardParkingBoy.fetch(aliceTicket);
        Car bobFetchedCar = standardParkingBoy.fetch(bobTicket);
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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        // when
        standardParkingBoy.fetch(ticket);
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> standardParkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_park_given_full_parking_with_default_capacity() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        for (int i=0; i<10; ++i) {
            standardParkingBoy.park(car);
        }
        // when

        // then
        Exception exception = assertThrows(NoAvailableSpaceException.class,
                () -> standardParkingBoy.park(car));
        assertEquals("No available position.", exception.getMessage());
    }
}
