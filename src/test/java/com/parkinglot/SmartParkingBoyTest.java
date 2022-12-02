package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_second_parking_lot_when_park_given_two_parking_slot_and_second_few_empty_position_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        parkingLot1.park(car1);
        Car car2 = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car2);

        //then
        assertEquals(car2, parkingLot2.fetch(ticket));
    }

    @Test
    void should_park_first_parking_lot_when_park_given_two_parking_slot_and_first_few_empty_position_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        parkingLot2.park(car1);
        Car car2 = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car2);

        //then
        assertEquals(car2, parkingLot1.fetch(ticket));
    }
}
