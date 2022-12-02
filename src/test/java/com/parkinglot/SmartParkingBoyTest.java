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
        for (int parked = 0; parked < 15; parked++) {
            Car dummyCar = new Car();
            standardParkingBoy.park(dummyCar);
        }

        Car car = new Car();
        //when

        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertEquals(parkingLotList.get(1), ticket.getSelectedParkingLot());
    }

    @Test
    void should_return_right_car_with_each_ticket_when_fetch_the_car_twice_given_2_parkinglots_and_both_parked_car_and_two_ticket_and_smart_boy() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);

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
    void should__return_exception_when_fetch_car_given_smart_parkingboy_unrecognized_ticket_and_2_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);

        Car aliceCar = new Car();
        parkingBoy.park(aliceCar);
        //when
        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(new Ticket()));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }

    @Test
    void should_return_exception_when_fetch_car_given_smart_parkingboy_used_ticket_and_2_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);

        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(ticket);

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }

    @Test
    void should_return_exception_when_park_given_smart_parkingboy_fulled_parking_lot_and_car_and_2_parking_lots() {
        //given
        final int CAPACITY = 1;
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(CAPACITY));
        parkingLotList.add(new ParkingLot(CAPACITY));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        Car car = new Car();

        for (int i = 0; i < CAPACITY*parkingLotList.size(); i++) {
            Car dummyCar = new Car();
            parkingBoy.park(dummyCar);
        }
        //when
        //then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(car));
        assertEquals(exception.getMessage(), "No available position");
    }
}
