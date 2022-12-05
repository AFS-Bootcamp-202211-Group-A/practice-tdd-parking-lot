Story 1
[] Case 1 - 
    Given a parking lot, and a car, 
    When park the car, 
    Then return a parking ticket.

[] Case 2 - 
    Given a valid parking ticket, 
    When pass the parking ticket, 
    Then return the corresponding car.

[] Case 3 - 
    Given customers receives their corresponding tickets, 
    When pass their parking tickets, 
    Then return corresponding cars.

[X] Case 4 - 
    Given a wrong parking ticket, 
    When pass the parking ticket, 
    Then should not return car.

[X] Case 5 - 
    Given no ticket, 
    When pass the parking ticket, 
    Then should not return car.

[X] Case 6 - 
    Given a used ticket, 
    When pass the parking ticket, 
    Then should not return car.

[X] Case 7 - 
    Given the parking slot has reached its capacity, 
    When park the car, 
    Then should not return any tickets.

Story 2

[] Case 1 -
    Given a wrong parking ticket,
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 2 -
    Given no ticket,
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 3 -
    Given a used ticket,
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 4 -
    Given the parking slot has reached its capacity,
    When park the car,
    Then should throw exception with error msg "No available position".


Story 3

[] Case 1 -
    Given a parking lot, a car, and a parking boy
    When park the car,
    Then return a parking ticket.


[] Case 2 -
    Given customers receives their corresponding tickets, a parking boy
    When pass their parking tickets,
    Then return corresponding cars.

Story 4

[] Case 1 -
    Given two parking lot with capacity of one, two cars, a parking boy
    When park the car,
    Then should return two parking tickets.

[] Case 2 -
    Given two valid parking ticket, a parking boy
    When pass the parking tickets,
    Then return the corresponding cars.

Story 5

[] Case 1 -
    Given a parking lot, and a car, a smart parking boy
    When park the car,
    Then return a parking ticket.

[] Case 2 -
    Given a valid parking ticket, a smart parking boy
    When pass the parking ticket,
    Then return the corresponding car.

[] Case 3 -
    Given customers receives their corresponding tickets, a smart parking boy
    When pass their parking tickets,
    Then return corresponding cars.

[] Case 4 -
    Given a wrong parking ticket, a smart parking boy
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 5 -
    Given no ticket, a smart parking boy
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 6 -
    Given a used ticket, a smart parking boy
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 7 -
    Given the parking slot has reached its capacity, a smart parking boy
    When park the car,
    Then should throw exception with error msg "No available position".

[] Case 8 -
    Given two parking lot with capacity of two, three cars, a parking boy
    When park the car,
    Then should return three parking tickets, 2 in parking lot 1, 1 in parking lot 2.

[] Case 9 -
    Given three valid parking ticket, a parking boy
    When pass the parking tickets,
    Then return the corresponding cars.


