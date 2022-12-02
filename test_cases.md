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
