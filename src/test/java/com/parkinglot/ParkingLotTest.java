package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();


        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);

    }

    @Test
    public void should_return_parked_car_when_car_parked_given_parking_lot_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);
        Car parkedCar = parkingLot.fetch(ticket);

        //then
        assertEquals(car, parkedCar);

    }

    @Test
    public void should_return_2_parked_cars_when_2_cars_parked_given_parking_lot_and__2_corresponding_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Car parkedCar1 = parkingLot.fetch(ticket1);
        Car parkedCar2 = parkingLot.fetch(ticket2);


        //then
        assertEquals(car1, parkedCar1);
        assertEquals(car2, parkedCar2);
    }

    @Test
    public void should_return_null_when_no_car_parked_given_parking_lot_and_unexisting_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car parkedCar = parkingLot.fetch(new Ticket());

        //then
        assertNull(parkedCar);
    }

    @Test
    public void should_return_null_when_no_car_parked_given_parking_lot_and_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);
        Car parkedCar = parkingLot.fetch(ticket);

        Car parkedCarAgain = parkingLot.fetch(ticket);

        //then
        assertNull(parkedCarAgain);
    }

    @Test
    public void should_return_null_when_10_car_parked_given_parking_lot_full() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }

        Ticket ticket = parkingLot.park(new Car());

        //then
        assertNull(ticket);
    }
}
