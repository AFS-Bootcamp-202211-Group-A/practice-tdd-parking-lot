## Story 1
- Case 1 - Given a parking lot, and a car, When park the car, Then return a parking ticket.


- Case 2 - Given a parking lot with car and a ticket, When fetch the car with ticket, Then return his/her car.

--- 
- Case 3 - Given a parking lot with multiple cars, and a ticket, When fetch the car with ticket, Then return his/her correspond car.
---
- Case 4 - Given a parking lot, and a wrong ticket, When fetch the car with wrong ticket,
Then return nothing.

- Case 5(could be skipped) - Given a parking lot, When fetch the car without ticket,
Then return nothing.
---
- Case 6 - Given a parking lot, and a used ticket, When fetch the car with used ticket,
Then return nothing.
--- 
- Case 7 - Given a fulled parking lot, and a car, When park a car in fulled parking lot,
Then return nothing.

## Story 2
---
- Case 1 - Given a parking lot and unrecognized ticket, When fetch the car, Then return nothing and error message unrecognized parking ticket.

- Case 2 - Given a parking lot and used ticket, When fetch the car, Then return nothing and error message unrecognized parking ticket.
---

- Case 3 - Given a fulled parking lot and car, When park the car, Then return nothing and error message no available position.

## Story 3
---
- Case 1 - Given a parking lot, a standard parking boy, and a car, When park the car, Then return a parking ticket.

- Case 2 - Given a parking lot with a parked car, a standard parking boy, and a parking ticket, When fetch the car, Then return the parked car.

- Case 3 - Given a parking lot with two parked cars, a standard parking boy, and two parking tickets, When fetch the car twice, Then return the right car with each ticket

- Case 4 - Given a parking lot, a standard parking boy, and a wrong parking ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket.”

- Case 5 - Given a parking lot, a standard parking boy, and a used parking ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket."

- Case 6 - Given a parking lot without any position, a standard parking boy, and a car, When park the car, Then return nothing with error message "No available position."

## Story 4
---
- Case 1 - Given a standard parking boy, who manage two parking lots, both with available position, and a car, When park the car, Then the car will be parked to the first parking lot

- Case 2 - Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car, When park the car, Then the car will be parked to the second parking lot

- Case 3 - Given a standard parking boy, who manage two parking lots, both with a parked car, and two parking ticket, When fetch the car twice, Then return the right car with each ticket

- Case 4 - Given a standard parking boy, who manage two parking lots, and an unrecognized ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket.”

- Case 5 - Given a standard parking boy, who manage two parking lots, and a used ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket."

- Case 6 - Given a standard parking boy, who manage two parking lots, both without any position, and a car, When park the car, Then return nothing with error message "No available position."

## Story 5

- Case 1

## Story 6