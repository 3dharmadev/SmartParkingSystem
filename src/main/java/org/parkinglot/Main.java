package org.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Initialization
        Map<VehicleType, Integer> capacityPerFloor = new HashMap<>();
        capacityPerFloor.put(VehicleType.CAR, 2);

        ParkingLot parkingLot = new ParkingLot(2, capacityPerFloor);

        // Add vehicles
        Vehicle car1 = new Vehicle("ABC123", "Blue", VehicleType.CAR);
        Vehicle car2 = new Vehicle("XYZ456", "Red", VehicleType.CAR);

        parkingLot.addVehicle(car1, 1);
        parkingLot.addVehicle(car2, 1);

        // Check availability
        parkingLot.printAvailability(1, VehicleType.CAR);

        // Try to add another car (should throw an error)
        Vehicle car3 = new Vehicle("DEF789", "Green", VehicleType.CAR);
        parkingLot.addVehicle(car3, 1);

        // Remove a vehicle
        parkingLot.removeVehicle("ABC123", VehicleType.CAR);

        // Check availability after removal
        parkingLot.printAvailability(1, VehicleType.CAR);
    }
}