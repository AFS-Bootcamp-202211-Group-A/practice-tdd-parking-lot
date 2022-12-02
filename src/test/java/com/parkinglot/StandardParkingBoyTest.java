package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {

    @Test
    void should_return_ticket_when_park_given_a_parking_boy_and_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_parked_car_when_fetch_car_given_parking_lot_with_parked_car_and_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Ticket ticket = standardParkingBoy.park(car);

        //when
        Car fetchedCar = standardParkingBoy.fetch(ticket);

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_car_twice_given_parking_lot_with_two_parked_cars_and_two_ticket() {
        //given
        ParkingLot parkingLot =new ParkingLot();
        Car aliceCar = new Car();
        Car bobCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Ticket aliceTicket = standardParkingBoy.park(aliceCar);
        Ticket bobTicket = standardParkingBoy.park(bobCar);

        //when
        Car fetchedAliceCar = standardParkingBoy.fetch(aliceTicket);
        Car fetchedBobCar = standardParkingBoy.fetch(bobTicket);

        //then
        assertEquals(aliceCar, fetchedAliceCar);
        assertEquals(bobCar, fetchedBobCar);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_car_given_parking_lot_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Ticket ticket = new Ticket();
        //when
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> standardParkingBoy.fetch(ticket)
        );
        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    void should_return_exception_with_error_message_when_fetch_car_given_parking_lot_and_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(ticket);

        //when
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> standardParkingBoy.fetch(ticket)
        );

        //then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_when_park_given_parking_lot_without_any_position_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Car extraCar = new Car();
        standardParkingBoy.park(car);

        //when
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> standardParkingBoy.park(extraCar)
        );

        //then
        assertEquals("No available position.", exception.getMessage());
    }
    
    @Test
    void should_park_first_parking_lot_when_park_the_car_given_two_parking_lots_with_available_position_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = standardParkingBoy.park(car);

        //then
        assertEquals(car, parkingLot1.fetch(ticket));
    }

    @Test
    void should_park_second_parking_lot_when_park_given_two_parking_slot_and_first_full_and_second_avaliable_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot1.park(car1);

        //when
        Ticket ticket = standardParkingBoy.park(car2);

        //then
        assertEquals(car2, parkingLot2.fetch(ticket));
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_parking_lots_both_with_car_and_two_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticketForCar1 = parkingLot1.park(car1);
        Ticket ticketForCar2 = parkingLot2.park(car2);

        //when
        Car fetchedCar1 = standardParkingBoy.fetch(ticketForCar1);
        Car fetchedCar2 = standardParkingBoy.fetch(ticketForCar2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_UnrecongizedTicketException_when_fetch_given_two_parking_lots_and_unrecognized_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Ticket ticket = new Ticket();

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> standardParkingBoy.fetch(ticket)
        );

        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    void should_return_UnrecognizedTicketException_when_fetch_given_two_parking_slots_and_used_Ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingLot2.park(car);
        standardParkingBoy.fetch(ticket);

        //when

        //then
        Exception exception = assertThrows(UnrecognizedTicketException.class,
                () -> standardParkingBoy.fetch(ticket)
        );
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
