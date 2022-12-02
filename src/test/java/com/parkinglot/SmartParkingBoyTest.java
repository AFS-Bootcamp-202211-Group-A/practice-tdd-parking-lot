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
    void should_return_second_parking_lot_when_park_given_first_of_the_two_parking_lot_is_full_and_car(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
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
}
