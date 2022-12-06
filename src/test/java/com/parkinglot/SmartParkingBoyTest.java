package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should_park_first_parkinglot_when_park_given_a_smart_parking_boy_who_manage_two_parking_lot_both_with_same_number_of_empty_positions_and_a_car() {
        // given
        ParkingLot parkinglot1 = new ParkingLot(2);
        ParkingLot parkinglot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = Stream.of(parkinglot1, parkinglot2).collect(Collectors.toList());
        SmartParkingBoy  smartParkingBoy = new SmartParkingBoy (parkingLots);
        Car car = new Car();

        // when
        Ticket parkingTicket = smartParkingBoy.park(car);

        // then
        Car fetchedCar = parkinglot1.fetch(parkingTicket);
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_park_to_second_parking_lot_when_park_given_a_smart_parking_boy_who_manage_two_parking_lots_that_second_one_has_more_empty_positions_and_a_car() {
        // given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(3);
        List<ParkingLot> parkingLots = Stream.of(firstParkingLot, secondParkingLot).collect(Collectors.toList());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();

        // when
        Ticket parkingTicket = smartParkingBoy.park(car);

        // then
        Car fetchedCar = secondParkingLot.fetch(parkingTicket);
        assertEquals(car, fetchedCar);
    }

}
