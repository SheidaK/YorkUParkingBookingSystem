package objects;

public class ParkingSpace {
    private int spaceId;
    private String type;
    private boolean occupied;
    private boolean enabled;
    private ParkingSensor sensor;
    private ParkingLot parkingLot; // Reference to the containing parking lot
    private Car parkedCar; // Store the parked car

    // Constructor
    public ParkingSpace(int spaceId, String type) {
        this.spaceId = spaceId;
        this.type = type;
        this.occupied = false;
        this.enabled = true;
        // Create a sensor ID based on the space ID
        String sensorId = "SENSOR-" + spaceId;
        this.sensor = new ParkingSensor(sensorId, this);
        this.parkedCar = null;
    }

    // Getters and setters
    public int getSpaceId() {
        return spaceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    // Check if occupied at a specific time
    public boolean isOccupied(int time) {
        // Implement time-based occupation check
        // This is a simplified version - in a real app, you'd check against scheduled times
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

    public ParkingSensor getSensor() {
        return sensor;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // Parking functionality
    public boolean parkCar(Car car) {
        if (!occupied && enabled) {
            occupied = true;
            parkedCar = car; // Store the car reference
            return true;
        }
        return false;
    }

    public Car removeCar() {
        if (occupied) {
            occupied = false;
            Car car = parkedCar; // Get the reference to return
            parkedCar = null;    // Clear the reference
            return car;          // Return the actual car
        }
        return null;
    }

    // Time-based occupation methods
    public void occupyTime(int bookingID, int time) {
        // Occupy the space for a specific time slot
        this.occupied = true;
    }

    public void unoccupyTime(int bookingID) {
        // Free up the space for a specific booking
        this.occupied = false;
    }

    public void unoccupy(int bookingID) {
        // Free up the space for a specific booking
        this.occupied = false;
    }
}