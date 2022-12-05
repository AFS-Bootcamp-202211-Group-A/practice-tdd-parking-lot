package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_two_parking_lot_and_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);
        //should
        assertNotNull(ticket);
    }
    @Test
    void should_return_second_parking_lot_when_park_given_two_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        parkingLot1.park(new Car());
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);
        //should
        assertEquals(parkingLot2,ticket.getParkingLotOfTheTicket());
    }
    @Test
    void should_return_car_when_park_given_two_parking_lot_and_two_car_are_in_different_parking_lot(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        parkingLot1.park(car1);
        Car car2 = new Car();
        parkingLot2.park(car2);
        Ticket ticket1 = smartParkingBoy.park(car1);
        Ticket ticket2 = smartParkingBoy.park(car2);
        //when
        Car fetchedCar1 = smartParkingBoy.fetch(ticket1);
        Car fetchedCar2 = smartParkingBoy.fetch(ticket2);
        //should
        assertEquals(car1,fetchedCar1);
        assertEquals(car2,fetchedCar2);
    }
    @Test
    void should_return_exception_when_fetch_given_unrecognized_ticket_and_two_parking_lot(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Ticket unrecognizedTicket = new Ticket();
        //when
        //should
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> smartParkingBoy.fetch(unrecognizedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }
    @Test
    void should_return_exception_when_fetch_given_used_ticket_and_two_parking_lot(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket usedTicket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(usedTicket);
        //when
        //should
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> smartParkingBoy.fetch(usedTicket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }
    @Test
    void should_return_exception_when_park_given_full_parking_lot_and_two_parking_slot(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy SmartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        SmartParkingBoy.park(new Car());
        SmartParkingBoy.park(new Car());
        //when
        //should
        Exception exception = assertThrows(parkingLotFullException.class,
                () -> SmartParkingBoy.park(car));
        assertEquals("No available position.",exception.getMessage());
    }
}
