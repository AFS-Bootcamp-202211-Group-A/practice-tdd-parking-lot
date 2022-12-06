# story1
[x] Case 1 
    Given a parking lot, and a car, 
    When park the car, 
    Then return a parking ticket.

[x] Case 2 
    Given a parking lot with a parked car, and a parking ticket, 
    When fetch the car, 
    Then return the parked car.

[x] Case 3 
    Given a parking lot with two parked cars, and two parking tickets, 
    When fetch the car twice, 
    Then return the right car with each ticket

[x] Case 4 
    Given a parking lot, and a wrong parking ticket, 
    When fetch the car, 
    Then return nothing.

[x] Case 5 
    Given a parking lot, and a used parking ticket, 
    When fetch the car, 
    Then return nothing.

[x] Case 6 
    Given a parking lot without any position, and a car, 
    When park the car, 
    Then return nothing.

# story2
[x] Case 1
    Given a parking lot, and an unrecognized ticket, 
    When fetch the car, 
    Then return nothing with error message "Unrecognized parking ticket.”

[x] Case 2
    Given a parking lot, and a used ticket, 
    When fetch the car, 
    Then return nothing with error message "Unrecognized parking ticket."

[x] Case 3 
    Given a parking lot without any position, and a car, 
    When park the car, 
    Then return nothing with error message "No available position."

# story3
[x] Case 1
    Given a parking lot, a standard parking boy, and a car, 
    When park the car, 
    Then return a parking ticket.

[x] Case 2 
    Given a parking lot with a parked car, a standard parking boy, and a parking ticket, 
    When fetch the car, 
    Then return the parked car.

[x] Case 3
    Given a parking lot with two parked cars, a standard parking boy, and two parking tickets, 
    When fetch the car twice, 
    Then return the right car with each ticket

[x] Case 4
    Given a parking lot, a standard parking boy, and a wrong parking ticket, 
    When fetch the car, 
    Then return nothing with error message "Unrecognized parking ticket.”

[x] Case 5
    Given a parking lot, a standard parking boy, and a used parking ticket, 
    When fetch the car, 
    Then return nothing with error message "Unrecognized parking ticket."

[x] Case 6
    Given a parking lot without any position, a standard parking boy, and a car, 
    When park the car, 
    Then return nothing with error message "No available position."

# story4
[x] Case 1
    Given a standard parking boy, who manage two parking lots, both with available position, and a car, 
    When park the car, 
    Then the car will be parked to the first parking lot

[x] Case 2
    Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car, 
    When park the car, 
    Then the car will be parked to the second parking lot

[x] Case 3 
    Given a standard parking boy, who manage two parking lots, both with a parked car, and two parking ticket, 
    When fetch the car twice, 
    Then return the right car with each ticket

[x] Case 4
    Given a standard parking boy, who manage two parking lots, and an unrecognized ticket, 
    When fetch the car, 
    Then return nothing with error message "Unrecognized parking ticket.”

[x] Case 5
    Given a standard parking boy, who manage two parking lots, and a used ticket, 
    When fetch the car, 
    Then return nothing with error message "Unrecognized parking ticket."

[x] Case 6
    Given a standard parking boy, who manage two parking lots, both without any position, and a car, 
    When park the car, 
    Then return nothing with error message "No available position."

# story5
[x] Case 1
    Given a smart parking boy, who manage two parking lots, both with same number of empty positions, and a car
    When park the car
    Then the car will be parked to the first parking lot

[x] Case 2
    Given a smart parking boy, who manage two parking lots, second one has more empty positions, and a car
    When park the car
    Then the car will be parked to the second parking lot

[x] Case 3
    Given a smart parking boy, who manage two parking lots, both with a parked car, and two parking ticket
    When fetch the car twice
    Then return the right car with each ticket

[x] Case 4
    Given a smart parking boy, who manage two parking lots, and an unrecognized ticket
    When fetch the car
    Then return nothing with error message "Unrecognized parking ticket."

[] Case 5
    Given a smart parking boy, who manage two parking lots, and a used ticket
    When fetch the car
    Then return nothing with error message "Unrecognized parking ticket."

[] Case 6
    Given a smart parking boy, who manage two parking lots, both without any position, and a car
    When park the car
    Then return nothing with error message "No available position."