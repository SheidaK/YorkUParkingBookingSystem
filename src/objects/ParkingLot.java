package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import businessLogic.ParkingLotObserver;

/**
 * Implements the Singleton pattern for the ParkingLot
 * Ensures there is only one instance of the parking lot in the system
 */
public class ParkingLot implements ParkingStatusObserver {
    // Singleton instance
    private static ParkingLot instance;
    
    private String name;
    private String location;
    private int totalCapacity;
    private List<ParkingSpace> spaces;
    private Map<String, ParkingSensor> sensors;
    private List<ParkingLotObserver> observers;
    private boolean enabled;
    
    // Private constructor for Singleton pattern
    public ParkingLot(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.totalCapacity = capacity;
        this.spaces = new ArrayList<>();
        this.sensors = new HashMap<>();
        this.observers = new ArrayList<>();
        this.enabled = true; 
        int parkingSpaceID = 1;
        ParkingSpace p = new ParkingSpace(parkingSpaceID,"Regular");
        spaces.add(p);
        ParkingSensor s = new ParkingSensor(parkingSpaceID,p);
    	p.assignSensor(s);
        ParkingSpace clonedParkingSpace;
        ParkingSensor clonedParkingSensor;
        for(int i=1;i<100;i++) {
        	clonedParkingSpace = p.clone();
        	parkingSpaceID++;
        	clonedParkingSpace.setSpaceId(parkingSpaceID);
        	clonedParkingSensor =s.clone(parkingSpaceID, p);
        	clonedParkingSpace.assignSensor(clonedParkingSensor);
        	spaces.add(clonedParkingSpace);
        }
    }
    
    // Singleton getInstance method
    public static synchronized ParkingLot getInstance(String name,String location, int capacity) {
        if (instance == null) {
            instance = new ParkingLot(name,location, capacity);
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
    
    private void notifyAvailabilityChanged(List<ParkingSpace> list) {
        for (ParkingLotObserver observer : observers) {
            observer.onAvailabilityChanged(list);
        }
    }
    
    // Implementation of ParkingStatusObserver interface
    @Override
    public void update(ParkingSpace space, boolean occupied) {
        notifySpaceStatusChanged(space);
        notifyAvailabilityChanged(getAvailableSpaces());
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
    // Parking lot management
    public void addParkingSpace(ParkingSpace space) {
        spaces.add(space);
        
        // Create and associate a sensor
        ParkingSensor sensor = new ParkingSensor(space.getSpaceId(), space);
        sensor.addObserver(this);
        sensors.put(String.valueOf(sensor.getSensorId()), sensor);
        space.assignSensor(sensor);
        
        notifyAvailabilityChanged(getAvailableSpaces());
    }
    
    public boolean removeParkingSpace(int spaceId) {
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
    
    public ParkingSpace findSpaceById(int spaceId) {
        for (ParkingSpace space : spaces) {
            if (space.getSpaceId()==spaceId) {
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
    public List<ParkingSpace> getAllSpaces() {
        return spaces;
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
    
//    public List<ParkingSpace> getAllSpaces() {
//        return new ArrayList<>(spaces);
//    }
    
    public Map<String, ParkingSensor> getAllSensors() {
        return new HashMap<>(sensors);
    }

	public String getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	public int getCapcity() {
		// TODO Auto-generated method stub
		return getAvailableSpaces().size();
	}
	
	public String getStatus() {
		// TODO Auto-generated method stub
		if(this.enabled) {return "Enabled";}else {return "Disabled";}
	}

	public void setStatus(boolean enabled) {
		this.enabled = enabled;
	}
}

