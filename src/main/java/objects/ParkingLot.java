package main.java.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.businessLogic.ParkingLotObserver;

/**
 * Implements the Singleton pattern for the ParkingLot
 * Ensures there is only one instance of the parking lot in the system
 */
public class ParkingLot  implements ParkingStatusObserver{
    // Singleton instance
    private static ParkingLot instance;
    
    private String name;
    private String location;
    private int capacity;
    private int id; // Added ID field
    private boolean enabled;
    private ArrayList<ParkingSpace> spaces;
    
    // Private constructor for Singleton pattern
    public ParkingLot(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.spaces = new ArrayList<>();
        this.capacity=capacity;
        this.enabled = true; 
        int parkingSpaceID = 1;
        ParkingSpace p = new ParkingSpace(parkingSpaceID,"Regular");
        spaces.add(p);
        ParkingSensor s = new ParkingSensor(parkingSpaceID,p);
    	p.assignSensor(s);
    	s.addObserver(p);
        ParkingSpace clonedParkingSpace;
        ParkingSensor clonedParkingSensor;
        for(int i=1;i<100;i++) {
        	clonedParkingSpace = p.clone();
        	parkingSpaceID++;
        	clonedParkingSpace.setSpaceId(parkingSpaceID);
        	clonedParkingSensor =s.clone(parkingSpaceID, p);
        	clonedParkingSpace.assignSensor(clonedParkingSensor);
        	spaces.add(clonedParkingSpace);
        	clonedParkingSensor.addObserver(clonedParkingSpace);
        }
    }
    //Setters
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
        
    // Getters
    public String getName() {
        return name;
    }
    
    public int getTotalCapacity() {
        return capacity;
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
        return enabled ? "Enabled" : "Disabled";
    }

	public void setStatus(boolean enabled) {
		this.enabled = enabled;
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
    public int getId() {
        return id;
    }
    public ParkingSpace findSpaceById(int spaceId) {
        for (ParkingSpace space : spaces) {
            if (space.getSpaceId()==spaceId) {
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
	@Override
	public void update(ParkingSpace space, boolean occupied) {
		// TODO Auto-generated method stub
		
	}

}

