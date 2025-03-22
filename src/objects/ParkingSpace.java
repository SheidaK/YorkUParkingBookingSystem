package objects;

import java.util.Map;

/**
 * Represents a single parking space in the parking lot.
 * Implements the Prototype pattern to allow cloning of parking spaces.
 */
public class ParkingSpace implements Cloneable {
    private int spaceId;
    private boolean occupied;
    private boolean enabled;
    private Car parkedCar;
    private ParkingSensor sensor;
    private String type; // Regular, Handicapped, VIP, etc.
    private Map<Integer, Boolean> timeOccupancyMap;

    
    public ParkingSpace(int spaceId, String type) {
        this.spaceId = spaceId;
        this.type = type;
        this.occupied = false;
        this.enabled = true;
        this.parkedCar = null;
    }

    // Associate a sensor with this space
    public void assignSensor(ParkingSensor sensor) {
        this.sensor = sensor;
    }

    // Parking functionality
    public boolean parkCar(Car car) {
        if (!occupied && enabled) {
            this.parkedCar = car;
            this.occupied = true;
            return true;
        }
        return false;
    }

    public Car removeCar() {
        if (occupied) {
            Car car = this.parkedCar;
            this.parkedCar = null;
            this.occupied = false;
            return car;
        }
        return null;
    }

    // Prototype Pattern: Clone method
    @Override
    public ParkingSpace clone() {
        try {
            ParkingSpace cloned = (ParkingSpace) super.clone();
            cloned.parkedCar = null; // Cloning a parking space should not retain parked cars
            cloned.occupied = false; // Reset occupied status
            cloned.sensor = null; // Sensor will be assigned separately
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Failed to clone ParkingSpace", e);
        }
    }

    // Getters and setters
    public int getSpaceId() {
        return spaceId;
    }
    public void setSpaceId(int id) {
       spaceId=id;
    }


    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public String getType() {
        return type;
    }

    public ParkingSensor getSensor() {
        return sensor;
    }
    // New method to check if the space is occupied at a specific time
    public boolean isOccupiedAt(int timeSlot) {
        Boolean isOccupied = timeOccupancyMap.get(timeSlot);
        return isOccupied != null && isOccupied;
    }
    
    // Method to occupy a time slot
    public void occupyTime(int bookingId, int timeSlot) {
        timeOccupancyMap.put(timeSlot, true);
    }
    
    // Method to free up a time slot
    public void unoccupyTime(int bookingId) {
        for (Integer timeSlot : timeOccupancyMap.keySet()) {
            timeOccupancyMap.put(timeSlot, false);
        }
    }
    @Override
    public String toString() {
        return "Space " + spaceId + " (" + type + "): " + 
               (enabled ? "Enabled" : "Disabled") + ", " +
               (occupied ? "Occupied" : "Available") + 
               (sensor != null ? ", Sensor Attached" : ", No Sensor");
    }
}
