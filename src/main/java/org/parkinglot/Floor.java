package org.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class Floor {
    private int floorNumber;
    private Map<VehicleType, Integer> capacity;
    private Map<Integer, VehicleSpace> spaces;

    public Floor(int floorNumber, Map<VehicleType, Integer> capacity) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.spaces = new HashMap<>();
        initializeSpaces();
    }

    private void initializeSpaces() {
        for (VehicleType type : capacity.keySet()) {
            int numSpaces = capacity.get(type);
            for (int i = 1; i <= numSpaces; i++) {
                spaces.put(i, new VehicleSpace(i, type));
            }
        }
    }

    public Map<VehicleType, Integer> getCapacity() {
        return capacity;
    }

    public Map<Integer, VehicleSpace> getSpaces() {
        return spaces;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setCapacity(Map<VehicleType, Integer> capacity) {
        this.capacity = capacity;
    }

    public void setSpaces(Map<Integer, VehicleSpace> spaces) {
        this.spaces = spaces;
    }
}
