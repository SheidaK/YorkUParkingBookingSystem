package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the Singleton pattern for the ParkingLot
 * Ensures there is only one instance of the parking lot in the system
 */
public class ParkingLot implements ParkingStatusObserver {
    // Singleton instance
    private static ParkingLot instance;
    
    private String name;
    private int totalCapacity;
    private List<ParkingSpace> spaces;
    private Map<String, ParkingSensor> sensors;
    private List<ParkingLotObserver> observers;
    
    // Private constructor for Singleton pattern
    private ParkingLot(String name, int capacity) {
        this.name = name;
        this.totalCapacity = capacity;
        this.spaces = new ArrayList<>();
        this.sensors = new HashMap<>();
        this.observers = new ArrayList<>();
    }
    
    // Singleton getInstance method
    public static synchronized ParkingLot getInstance(String name, int capacity) {
        if (instance == null) {
            instance = new ParkingLot(name, capacity);
        }
        return instance;
    }
    
    // Static method to get the instance without parameters (assumes already initialized)
    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot has not been initialized yet");
        }
        return instance;
    }
    
    // Observer pattern for ParkingLot
    public void addObserver(ParkingLotObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(ParkingLotObserver observer) {
        observers.remove(observer);
    }
    
    private void notifySpaceStatusChanged(ParkingSpace space) {
        for (ParkingLotObserver observer : observers) {
            observer.onParkingSpaceStatusChanged(space);
        }
    }
    
    private void notifyAvailabilityChanged(int availableSpaces) {
        for (ParkingLotObserver observer : observers) {
            observer.onAvailabilityChanged(availableSpaces);
        }
    }
    
    // Implementation of ParkingStatusObserver interface
    @Override
    public void update(ParkingSpace space, boolean occupied) {
        notifySpaceStatusChanged(space);
        notifyAvailabilityChanged(getAvailableSpaces());
    }
    
    // Parking lot management
    public void addParkingSpace(ParkingSpace space) {
        spaces.add(space);
        
        // Create and associate a sensor
        ParkingSensor sensor = new ParkingSensor("S" + space.getSpaceId(), space);
        sensor.addObserver(this);
        sensors.put(sensor.getSensorId(), sensor);
        space.assignSensor(sensor);
        
        notifyAvailabilityChanged(getAvailableSpaces());
    }
    
    public boolean removeParkingSpace(String spaceId) {
        ParkingSpace spaceToRemove = findSpaceById(spaceId);
        if (spaceToRemove != null) {
            // Remove associated sensor
            ParkingSensor sensor = spaceToRemove.getSensor();
            if (sensor != null) {
                sensor.removeObserver(this);
                sensors.remove(sensor.getSensorId());
            }
            
            spaces.remove(spaceToRemove);
            notifyAvailabilityChanged(getAvailableSpaces());
            return true;
        }
        return false;
    }
    
    public ParkingSpace findSpaceById(String spaceId) {
        for (ParkingSpace space : spaces) {
            if (space.getSpaceId().equals(spaceId)) {
                return space;
            }
        }
        return null;
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
    
    public int getAvailableSpacesCount() {
        return getAvailableSpaces().size();
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getTotalCapacity() {
        return totalCapacity;
    }
    
    public List<ParkingSpace> getAllSpaces() {
        return new ArrayList<>(spaces);
    }
    
    public Map<String, ParkingSensor> getAllSensors() {
        return new HashMap<>(sensors);
    }
}

/**
 * Observer interface for the ParkingLot
 */
interface ParkingLotObserver {
    void onParkingSpaceStatusChanged(ParkingSpace space);
    void onAvailabilityChanged(int availableSpaces);
}