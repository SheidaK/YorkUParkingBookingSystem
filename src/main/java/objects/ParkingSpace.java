package main.java.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.java.businessLogic.Visit;

/**
 * Represents a single parking space in the parking lot.
 * Implements the Prototype pattern to allow cloning of parking spaces.
 */
public class ParkingSpace implements Cloneable, ParkingStatusObserver {
    private int spaceId;
    private boolean occupied;
    private boolean enabled;
    private Car parkedCar;
    private ParkingSensor sensor;
    private String type; // Regular, Handicapped, VIP, etc.
    private ParkingLot parkingLot; // Reference to the containing parking lot
    private String bookingId;
    private Map<String, Map<Integer, Integer>> occupiedTimes;


    public ParkingSpace(int spaceId, String type) {
        this.spaceId = spaceId;
        this.type = type;
        this.occupied = false;
        this.enabled = true;
        this.parkedCar = null;
        this.bookingId = "";
        this.occupiedTimes = new HashMap<>();
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
            cloned.occupiedTimes = new HashMap<>();
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
    public void setType(String type) {
        this.type = type;
    }

    public ParkingSensor getSensor() {
        return sensor;
    }
    // New method to check if the space is occupied at a specific time
    // Check if occupied at a specific time
    public boolean isOccupied(Date date, int time,int duration) {
        // Implement time-based occupation check
        // This is a simplified version - in a real app, you'd check against scheduled times
    	int time1=time;
   	 	long oneDayInMillis = 24 * 60 * 60 * 1000;
   	 	for(int i=time;i<=time+duration;i++) {
	   		if(i>24) {
	   			time = i-24;
	   	        date = new Date(date.getTime() + oneDayInMillis);
	
	   		}
	    	String dateString = getDateString(date);
	    	if(occupiedTimes.get(dateString)!=null) {
		    	if(occupiedTimes.get(dateString).get(time1)!=null) {
		    		return true;
		    	}
	    	}
    	}
    	return false;
    }

    
 // Time-based occupation methods
    public void occupyTime(int bookingId, Date date, int time, int duration) {
        // Occupy the space for a specific time slot
    	int time1=time;
    	 long oneDayInMillis = 24 * 60 * 60 * 1000;
    	for(int i=time;i<=time+duration;i++) {
    		if(i>24) {
    			time = i-24;
    	        date = new Date(date.getTime() + oneDayInMillis);

    		}
    		String dateString = getDateString(date);
    	
    		Map<Integer, Integer> innerMap = new HashMap<>();
    		innerMap.put(time1,bookingId);
    		occupiedTimes.put(dateString, innerMap);
    	}
    }

    public void unoccupyTime(int bookingID) {
        // Free up the space for a specific booking
        this.occupied = false;
    }

    public void unoccupy(int bookingID) {
        // Free up the space for a specific booking
        this.occupied = false;
        this.bookingId = "";
    }
    
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    
    public String getBookingId() {
    	return this.bookingId;
    	
    }
    
    public void update(ParkingSpace space, boolean occupied) {
        // Update the parking space based on the sensor status
        this.occupied = occupied;
    }

   
    @Override
    public String toString() {
        return "Space " + spaceId + " (" + type + "): " + 
               (enabled ? "Enabled" : "Disabled") + ", " +
               (occupied ? "Occupied" : "Available") + 
               (sensor != null ? ", Sensor Attached" : ", No Sensor");
    }

	public String getEnablesString() {
		// TODO Auto-generated method stub
		if(isEnabled()) {return "Enabled";}else {return "Disabled";}
	}
	public String getOccupiedString() {
		// TODO Auto-generated method stub
		if(isOccupied()) {return "Occupied";}else {return "Available";}
	}
	public String getDateString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate;
	}
}
