package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);

    }

    @Test
    public void should_return_parked_car_when_car_parked_given_parking_lot_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);
        Car parkedCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, parkedCar);

    }

    @Test
    public void should_return_2_parked_cars_when_2_cars_parked_given_parking_lot_and__2_corresponding_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        Car parkedCar1 = parkingBoy.fetch(ticket1);
        Car parkedCar2 = parkingBoy.fetch(ticket2);


        //then
        assertEquals(car1, parkedCar1);
        assertEquals(car2, parkedCar2);
    }



}
