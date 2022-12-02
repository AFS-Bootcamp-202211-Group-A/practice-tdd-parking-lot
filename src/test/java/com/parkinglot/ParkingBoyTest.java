package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parkingboy_and_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parkingboy_parked_car_and_a_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_parkingboy_two_parked_cars_and_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
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
    void should_return_exception_when_fetch_car_given_parkingboy_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car aliceCar = new Car();
        parkingBoy.park(aliceCar);
        //when
        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(new Ticket()));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }
    @Test
    void should_return_exception_when_fetch_car_given_parkingboy_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(ticket);

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }
    @Test
    void should_return_exception_when_park_given_parkingboy_fulled_parking_lot_and_car() {
        //given
        final int CAPACITY = 10;
        ParkingLot parkingLot = new ParkingLot(CAPACITY);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        for (int i = 0; i < CAPACITY; i++) {
            Car dummyCar = new Car();
            parkingBoy.park(dummyCar);
        }
        //when
        //then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(car));
        assertEquals(exception.getMessage(), "No available position");
    }

    @Test
    void should_park_first_parking_lot_when_park_given_parking_boy_and_2_available_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList.add(new ParkingLot(10));

        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);
        Car car = new Car();
        //when

        ParkingLot selectedParkingLot =  parkingBoy.park(car).getSelectedParkingLot();
        //then
        assertEquals(selectedParkingLot,parkingLotList.get(0));
    }

    @Test
    void should_park_at_second_parkinglot_when_park_given_first_parkinglot_full_and_standard_parking_boy() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);

        Car dummyCar = new Car();
        parkingBoy.park(dummyCar);

        Car car = new Car();
        //when
        ParkingLot selectedParkingLot =  parkingBoy.park(car).getSelectedParkingLot();
        //then
        assertEquals(selectedParkingLot,parkingLotList.get(1));
    }
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_the_car_twice_given_2_parkinglots_and_both_parked_car_and_two_ticket() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);

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
    void should__return_exception_when_fetch_car_given_parkingboy_unrecognized_ticket_and_2_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);

        Car aliceCar = new Car();
        parkingBoy.park(aliceCar);
        //when
        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(new Ticket()));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }
    @Test
    void should_return_exception_when_fetch_car_given_parkingboy_used_ticket_and_2_parking_lots() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);

        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(ticket);

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals(exception.getMessage(), "Unrecognized parking ticket");
    }
    @Test
    void should_return_exception_when_park_given_parkingboy_fulled_parking_lot_and_car_and_2_parking_lots() {
        //given
        final int CAPACITY = 1;
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(CAPACITY));
        parkingLotList.add(new ParkingLot(CAPACITY));
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);
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
