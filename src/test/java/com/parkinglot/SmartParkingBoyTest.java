package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_park_given_a_car_and_a_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //
        assertNotNull(ticket);
    }

    @Test
    void should_return_a_car_when_pass_a_valid_ticket_given_a_valid_ticket_and_a_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = smartParkingBoy.park(car);

        //when
        Car fetchedCar = smartParkingBoy.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_return_the_corresponding_car_when_pass_the_corresponding_valid_ticket_given_a_valid_ticket_and_a_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket1 = smartParkingBoy.park(car1);
        Ticket ticket2 = smartParkingBoy.park(car2);

        //when
        Car fetchedCar1 = smartParkingBoy.fetch(ticket1);
        Car fetchedCar2 = smartParkingBoy.fetch(ticket2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_the_wrong_ticket_given_wrong_ticket_and_a_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = smartParkingBoy.park(car);
        Ticket dummyTicket = new Ticket();

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(dummyTicket));
        assertEquals("Unrecognized packing ticket", exception.getMessage());

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_used_ticket_given_used_ticket_and_a_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = smartParkingBoy.park(car);
        Car fetchedCar = smartParkingBoy.fetch(ticket);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(ticket));
        assertEquals("Unrecognized packing ticket", exception.getMessage());

    }

    @Test
    public void should_return_exception_with_error_message_when_pass_no_ticket_given_no_ticket_and_a_smart_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Ticket ticket = smartParkingBoy.park(car);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> smartParkingBoy.fetch(null));
        assertEquals("Unrecognized packing ticket", exception.getMessage());
    }

    @Test
    public void should_return_exception_with_error_message_when_park_the_car_given_the_parking_lot_is_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            smartParkingBoy.park(car);
        }
        Car extraCar = new Car();

        //when

        //then
        Exception exception = assertThrows(UnavailableSlotException.class, () -> smartParkingBoy.park(extraCar));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    public void should_return_two_tickets_when_park_the_car_given_two_parking_lot_two_cars_one_smart_parking_boy() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);


        //when
        Ticket ticket1 = smartParkingBoy.park(new Car());
        Ticket ticket2 = smartParkingBoy.park(new Car());

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);


    }

    @Test
    public void should_return_two_cars_when_park_the_car_given_two_parking_lot_two_cars_one_smart_parking_boy() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();


        //when
        Ticket ticket1 = smartParkingBoy.park(car1);
        Ticket ticket2 = smartParkingBoy.park(car2);
        Car fetchedCar1 = smartParkingBoy.fetch(ticket1);
        Car fetchedCar2 = smartParkingBoy.fetch(ticket2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);


    }

    @Test
    public void should_return_one_car_in_parking_lot_1_when_park_the_car_given_two_parking_lot_different_capacities_one_cars_one_smart_parking_boy() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();


        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertEquals(1, parkingLot2.getTicketCarMap().size());


    }

}