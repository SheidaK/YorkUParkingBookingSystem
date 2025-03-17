package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Observer pattern for parking sensors
 * Notifies subscribers when parking status changes
 */
public class ParkingSensor {
    private String sensorId;
    private boolean occupied;
    private ParkingSpace monitoredSpace;
    private List<ParkingStatusObserver> observers;
    
    public ParkingSensor(String sensorId, ParkingSpace monitoredSpace) {
        this.sensorId = sensorId;
        this.monitoredSpace = monitoredSpace;
        this.occupied = false;
        this.observers = new ArrayList<>();
    }
    
    // Observer pattern methods
    public void addObserver(ParkingStatusObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(ParkingStatusObserver observer) {
        observers.remove(observer);
    }
    
    private void notifyObservers() {
        for (ParkingStatusObserver observer : observers) {
            observer.update(monitoredSpace, occupied);
        }
    }
    
    // Sensor functionality
    public void detectVehicle(boolean detected) {
        if (this.occupied != detected) {
            this.occupied = detected;
            monitoredSpace.setOccupied(detected);
            notifyObservers();
        }
    }
    
    // Getters and setters
    public String getSensorId() {
        return sensorId;
    }
    
    public boolean isOccupied() {
        return occupied;
    }
    
    public ParkingSpace getMonitoredSpace() {
        return monitoredSpace;
    }
}

/**
 * Observer interface for the Observer pattern
 */
interface ParkingStatusObserver {
    void update(ParkingSpace space, boolean occupied);
}