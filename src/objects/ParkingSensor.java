package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Observer pattern for parking sensors
 * Notifies subscribers when parking status changes
 */
public class ParkingSensor implements Cloneable{
    private int sensorId;
    private boolean occupied;
    private ParkingSpace monitoredSpace;
    private List<ParkingStatusObserver> observers = new ArrayList<>();
    
    public ParkingSensor(int parkingSpaceID, ParkingSpace monitoredSpace)  {
        this.sensorId = parkingSpaceID;
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
    
    private void update(ParkingSpace monitoredSpace2, boolean occupied2) {
		// TODO Auto-generated method stub
		
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
    public int getSensorId() {
        return sensorId;
    }
    
    public boolean isOccupied() {
        return occupied;
    }
    
    public ParkingSpace getMonitoredSpace() {
        return monitoredSpace;
    }
    
    public ParkingSensor clone(int parkingSpaceID, ParkingSpace monitoredSpace) {
        try {
            ParkingSensor cloned = (ParkingSensor) super.clone();
            cloned.sensorId = parkingSpaceID;
            cloned.monitoredSpace = monitoredSpace;
            cloned.occupied = false;
            cloned.observers = new ArrayList<>();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Failed to clone ParkingSpace", e);
        }
    }
}
