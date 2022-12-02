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

[] Case 8 -
    Given a wrong parking ticket,
    When pass the parking ticket,
    Then should throw exception with error msg "Unrecognized packing ticket".

[] Case 9 -
    Given the parking slot has reached its capacity,
    When park the car,
    Then should throw exception with error msg "No available position".

Story 3

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
