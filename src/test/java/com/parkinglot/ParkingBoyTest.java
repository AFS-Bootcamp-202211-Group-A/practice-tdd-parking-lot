package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parkingboy_and_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parkingboy_parked_car_and_a_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_parkingboy_two_parked_cars_and_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Ticket aliceTicket = parkingBoy.park(aliceCar);
        Ticket bobTicket = parkingBoy.park(bobCar);
        //when
        Car aliceFetchedCar = parkingBoy.fetch(aliceTicket);
        Car bobFetchedCar = parkingBoy.fetch(bobTicket);
        //then
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }

    @Test
    void should_return_exception_when_fetch_car_given_parkingboy_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car aliceCar = new Car();
        parkingBoy.park(aliceCar);
        //when
        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(new Ticket()));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }
    @Test
    void should_return_exception_when_fetch_car_given_parkingboy_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(ticket);

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }
    @Test
    void should_return_exception_when_park_given_parkingboy_fulled_parking_lot_and_car() {
        //given
        final int CAPACITY = 10;
        ParkingLot parkingLot = new ParkingLot(CAPACITY);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        for (int i = 0; i < CAPACITY; i++) {
            Car dummyCar = new Car();
            parkingBoy.park(dummyCar);
        }
        //when
        //then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(car));
        assertEquals(exception.getMessage(), "No available position");
    }
}
