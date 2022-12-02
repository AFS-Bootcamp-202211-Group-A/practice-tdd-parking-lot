package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        //should
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_given_ticket_and_parked_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        //should
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_correct_car_when_fetch_given_two_ticket_and_two_parked_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        //should
        assertEquals(car1,fetchedCar1);
    }
    @Test
    void should_return_exception_when_fetch_given_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket unrecognizedTicket = new Ticket();
        //when
        //should
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> parkingBoy.fetch(unrecognizedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }
    @Test
    void should_return_exception_when_fetch_given_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket usedTicket = parkingBoy.park(car);
        parkingBoy.fetch(usedTicket);
        //when
        //should
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> parkingBoy.fetch(usedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }
    @Test
    void should_return_exception_when_park_given_full_parking_lot(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        parkingBoy.park(new Car());
        //when
        //should
        Exception exception = assertThrows(parkingLotFullException.class,
                () -> parkingBoy.park(car));
        assertEquals("No available position.",exception.getMessage());
    }
    @Test
    void should_return_ticket_when_park_given_two_parking_lot_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        //should
        assertNotNull(ticket);
    }
    @Test
    void should_return_second_parking_lot_when_park_given_first_of_the_two_parking_lot_is_full_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot1.park(new Car());
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        //should
        assertEquals(parkingLot2,parkingBoy.getParkingLotPosition(ticket));
    }
}
