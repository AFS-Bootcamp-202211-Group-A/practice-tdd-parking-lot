package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_car_given_parking_lot_and_car() {
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
    public void should_return_parked_car_when_car_parked_given_parking_lot_and_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);
        Car parkedCar = parkingBoy.fetch(ticket);

        //then
        assertEquals(car, parkedCar);

    }

    @Test
    public void should_return_2_parked_cars_when_2_cars_parked_given_parking_lot_and_2_corresponding_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        Car parkedCar1 = parkingBoy.fetch(ticket1);
        Car parkedCar2 = parkingBoy.fetch(ticket2);


        //then
        assertEquals(car1, parkedCar1);
        assertEquals(car2, parkedCar2);
    }

    @Test
    public void should_return_error_message_when_no_car_parked_given_parking_lot_and_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = parkingBoy.park(car);
        Car parkedCar = parkingBoy.fetch(ticket);

        //then
        assertNotNull(parkedCar);

        Exception unrecognisedTicketException = assertThrows(UnrecognizedTicketException.class, ()->{
            parkingBoy.fetch(new Ticket());
        });
        assertEquals("Unrecognised Parking Ticket", unrecognisedTicketException.getMessage());
    }

    @Test
    public void should_return_ticket_when_10_car_parked_and_park_new_car_given_parking_lot_init_to_11_space() {
        //given
        ParkingLot parkingLot = new ParkingLot(11);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }

        Ticket ticket = parkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_error_message_when_fetch_car_given_ticket_is_unrecognised() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);


        Exception unrecognisedTicketException = assertThrows(UnrecognizedTicketException.class, ()->{
            parkingBoy.fetch(new Ticket());
        });
        assertEquals("Unrecognised Parking Ticket", unrecognisedTicketException.getMessage());

    }

    @Test
    public void should_error_message_when_10_car_parked_given_parking_lot_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }

        Exception parkingLotFullException = assertThrows(ParkingLotFullException.class, ()->{
            parkingBoy.park(new Car());
        });
        assertEquals("No available position.", parkingLotFullException.getMessage());

    }

}
