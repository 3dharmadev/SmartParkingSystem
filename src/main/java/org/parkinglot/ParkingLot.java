package org.parkinglot;

import java.util.HashMap;
import java.util.Map;

public
class ParkingLot {
    private int totalFloors;
    private Map<Integer, Floor> floors;

    public ParkingLot(int totalFloors, Map<VehicleType, Integer> capacityPerFloor) {
        this.totalFloors = totalFloors;
        this.floors = new HashMap<>();
        initializeFloors(capacityPerFloor);
    }

    private void initializeFloors(Map<VehicleType, Integer> capacityPerFloor) {
        for (int i = 1; i <= totalFloors; i++) {
            floors.put(i, new Floor(i, capacityPerFloor));
        }
    }

    public boolean addVehicle(Vehicle vehicle, int floorNumber) {
        if (floorNumber < 1 || floorNumber > totalFloors) {
            System.out.println("Invalid floor number.");
            return false;
        }

        Floor floor = floors.get(floorNumber);
        Map<VehicleType, Integer> floorCapacity = floor.getCapacity();
        VehicleType vehicleType = vehicle.getType();

        if (!floorCapacity.containsKey(vehicleType)) {
            System.out.println("Invalid vehicle type for this floor.");
            return false;
        }

        int availableSpaces = 0;

        for (VehicleSpace space : floor.getSpaces().values()) {
            if (space.getType() == vehicleType && space.isAvailable()) {
                availableSpaces++;
            }
        }

        if (availableSpaces == 0) {
            System.out.println("No available spaces for " + vehicleType + " on floor " + floorNumber + ".");
            return false;
        }

        for (VehicleSpace space : floor.getSpaces().values()) {
            if (space.getType() == vehicleType && space.isAvailable()) {
                space.occupy();
                System.out.println(vehicleType + " with registration number " + vehicle.getRegistrationNumber() +
                        " parked at space " + space.getSpaceNumber() + " on floor " + floorNumber + ".");
                return true;
            }
        }

        return false;
    }

    public boolean removeVehicle(String registrationNumber, VehicleType vehicleType) {
        for (Floor floor : floors.values()) {
            for (VehicleSpace space : floor.getSpaces().values()) {
                if (!space.isAvailable() && space.getType() == vehicleType) {
                    space.vacate();
                    System.out.println(vehicleType + " with registration number " +
                            registrationNumber + " removed from space " + space.getSpaceNumber() +
                            " on floor " + floor.getFloorNumber() + ".");
                    return true;
                }
            }
        }
        System.out.println("Vehicle with registration number " + registrationNumber + " not found in the parking lot.");
        return false;
    }


    public void printAvailability(int floorNumber, VehicleType vehicleType) {
        if (floorNumber < 1 || floorNumber > totalFloors) {
            System.out.println("Invalid floor number.");
            return;
        }

        Floor floor = floors.get(floorNumber);

        if (floor.getCapacity().containsKey(vehicleType)) {
            int totalCapacity = floor.getCapacity().get(vehicleType);
            int availableSpaces = 0;

            for (VehicleSpace space : floor.getSpaces().values()) {
                if (space.getType() == vehicleType && space.isAvailable()) {
                    availableSpaces++;
                }
            }

            System.out.println("Available spaces for " + vehicleType + " on floor " + floorNumber + ": " +
                    availableSpaces + " out of " + totalCapacity + ".");
        } else {
            System.out.println("Invalid vehicle type for this floor.");
        }
    }
}
