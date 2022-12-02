package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    void should_return_parking_lots_which_has_more_empty_position_when_park_given_smart_parking_boy_and_two_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(20));  // cap:20 used:15
        parkingLotList.add(new ParkingLot(10)); // cap:10 used:1  <win

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        for (int parked = 0; parked<15;parked++){
            Car dummyCar = new Car();
            standardParkingBoy.park(dummyCar);
        }

        Car car = new Car();
        //when

        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertEquals(parkingLotList.get(1),ticket.getSelectedParkingLot());
    }


}
