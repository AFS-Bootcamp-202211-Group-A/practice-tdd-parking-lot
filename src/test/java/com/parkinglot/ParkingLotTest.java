package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //should
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_given_ticket_and_parked_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        Car fetchedCar = parkingLot.fetch(ticket);
        //should
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_correct_car_when_fetch_given_two_ticket_and_two_parked_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        //when
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        //should
        assertEquals(car1,fetchedCar1);
    }
    @Test
    void should_return_null_when_fetch_given_wrong_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = new Ticket();
        //when
        Car fetchedCar1 = parkingLot.fetch(ticket2);
        //should
        assertNull(fetchedCar1);
    }
    @Test
    void should_return_null_when_fetch_given_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
        //when
        Car hopeToFetchCar = parkingLot.fetch(ticket);
        //should
        assertNull(hopeToFetchCar);
    }
    @Test
    void should_return_null_when_park_given_full_parking_lot(){
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car();
        Ticket ticket1 = parkingLot.park(new Car());
        Ticket ticket2 = parkingLot.park(new Car());
        //when
        Ticket ticket = parkingLot.park(car);
        //should
        assertNull(ticket);
    }
    @Test
    void should_return_exception_when_fetch_given_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket unrecognizedTicket = new Ticket();
        //when
        //should
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> parkingLot.fetch(unrecognizedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }
}
