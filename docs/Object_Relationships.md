Relationships
==============

Ride "1" ------ "1" Rider
Ride "1" ------ "1" Driver
Ride "1" ------ "1" FareReceipt

Driver "*" ---- "1" VehicleType
Ride "*" ------ "1" VehicleType

Ride "*" ------ "1" RideStatus