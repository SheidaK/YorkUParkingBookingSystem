package objects;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private String location;
    private int capacity;
    private int id; // Added ID field
    private boolean enabled;
    private List<ParkingSpace> spaces;

    public ParkingLot(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.enabled = true;
        this.spaces = new ArrayList<>();
        
        // Initialize parking spaces
        for (int i = 1; i <= capacity; i++) {
            ParkingSpace space = new ParkingSpace(i, "Standard");
            space.setParkingLot(this); // Set reference to this parking lot
            spaces.add(space);
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapcity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return enabled ? "Enabled" : "Disabled";
    }

    public void setStatus(boolean status) {
        this.enabled = status;
    }

    // Parking space management
    public List<ParkingSpace> getAllSpaces() {
        return spaces;
    }

    public List<ParkingSpace> getAvailableSpaces() {
        List<ParkingSpace> availableSpaces = new ArrayList<>();
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied() && space.isEnabled()) {
                availableSpaces.add(space);
            }
        }
        return availableSpaces;
    }

    public ParkingSpace findSpaceById(int spaceId) {
        for (ParkingSpace space : spaces) {
            if (space.getSpaceId() == spaceId) {
                return space;
            }
        }
        return null;
    }

    public void addParkingSpace(ParkingSpace space) {
        space.setParkingLot(this);
        spaces.add(space);
    }

    public boolean removeParkingSpace(int spaceId) {
        ParkingSpace spaceToRemove = findSpaceById(spaceId);
        if (spaceToRemove != null) {
            return spaces.remove(spaceToRemove);
        }
        return false;
    }
}