[Story 1]
Case 1 - 
Given a parking lot, and a car,
When park the car, 
Return a parking ticket.

Case 2 - 
Given a ticket & parked car, 
When fetch car, 
Return a car

Case 3 - 
Given two parked car,
When fetch car.
Return correct car

''' Replaced by [Story 2] Case 7,8,9 
Case 4 - 
Given a wrong ticket, 
When fetch car, 
Return null car

Case 5 - 
Given a used ticket, 
When fetch car, 
Return null car

Case 6 - 
Given a full parking lot, and a car, 
When park the car, 
Return null ticket
'''

[Story 2]
Case 7 -
Given unrecognized ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 8 -
Given a used ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 9 -
Given a full parking lot, and a car,
When park the car,
Return exception message: "No available position."

[Story 3]
Case 10 -
Given a parking boy, parking lot and car,
When park car,
Return ticket

Case 11 -
Given a parking boy, ticket & parked car,
When fetch car,
Return a car

Case 12 -
Given parking boy, two parked car,
When fetch car.
Return correct car

Case 13 -
Given parking boy, unrecognized ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 14 -
Given parking boy, a used ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 15 -
Given parking boy, a full parking lot, and a car,
When park the car,
Return exception message: "No available position."

[Story4]
Case 16 -
Given a parking boy, two not full parking lot and car,
When park car, 
Return ticket

Case 17 -
Given a parking boy, car, two parking lot and first one of it is full
When park car, 
Return car was parked to parking lot two

Case 19 -
Given parking boy, two parked car, two parking lot, two cars are not in the same parking lot
When fetch car.
Return correct car from correct parking lot

Case 20 -
Given parking boy, unrecognized ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 21 -
Given parking boy, a used ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 22 -
Given parking boy, two full parking lot, and a car
When park the car,
Return exception message: "No available position."

[Story5]
Case 22 -
Given a smart parking boy, two not full parking lot and car,
When park car,
Return ticket

Case 23 -
Given a smart parking boy, car, two parking lot and first one of it is full
When park car,
Return car was parked to parking lot two

Case 24 -
Given a smart parking boy, two parked car, two parking lot, two cars are not in the same parking lot
When fetch car.
Return correct car from correct parking lot

Case 25 -
Given a smart parking boy, unrecognized ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 26 -
Given a smart parking boy, a used ticket,
When fetch car,
Return exception message: "Unrecognized parking ticket."

Case 27 -
Given a smart parking boy, two full parking lot, and a car
When park the car,
Return exception message: "No available position."