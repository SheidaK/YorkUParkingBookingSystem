package businessLogic;

import objects.*;

import java.util.ArrayList;
import java.util.List;

import database.Database;

/**
 * Implements the Facade pattern to provide a simplified interface to the parking subsystem
 */
public class ParkingSystem implements ParkingLotObserver {
    // Singleton pattern
    private static ParkingSystem instance;
	String path = "src/database/ParkingLotDatabase.csv";
	Database dbParkingLots = new Database(path);

    private ArrayList<ParkingLot> parkingLot=new ArrayList<ParkingLot>();
    private BookingSystem bookingSystem;
    
    // Private constructor for Singleton pattern
    private ParkingSystem() throws Exception {
        //this.parkingLot = ParkingLot.getInstance();
        //this.parkingLot.addObserver(this);
        
        // Get reference to the booking system (also a singleton)
        try {
            this.bookingSystem = BookingSystem.getInstance();
        } catch (Exception e) {
            System.err.println("Warning: BookingSystem not initialized yet. Will be set later.");
        }
        List<String[]> dataParkingLots = dbParkingLots.read();
		for(String[] row:dataParkingLots) {
			ParkingLot l = new ParkingLot(row[0],row[1],Integer.valueOf(row[3].trim()));
			if(row[2].trim().equals("Enabled")) {
				l.setStatus(true);
			}else {l.setStatus(false);}
			parkingLot.add(l);
		}
    }
    
    // Singleton getInstance method
    public static synchronized ParkingSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ParkingSystem();
        }
        return instance;
    }
    
    // Set the booking system reference if not available at construction time
    public void setBookingSystem(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }
    
    // Facade methods for client interaction
    public List<ParkingSpace> getAvailableSpaces(ParkingLot parkingLot) {
        return parkingLot.getAvailableSpaces();
    }
    
    public boolean parkCar(ParkingLot parkingLot, String spaceId, Car car) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            return space.parkCar(car);
        }
        return false;
    }
    
    public Car removeCar(ParkingLot parkingLot, String spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            return space.removeCar();
        }
        return null;
    }
    
    // Manager operations
    public void enableParkingSpace(ParkingLot parkingLot, String spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            space.setEnabled(true);
        }
    }
    
    public void disableParkingSpace(ParkingLot parkingLot, String spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            space.setEnabled(false);
        }
    }
    
    public void addNewParkingSpace(ParkingLot parkingLot,String type) {
        int nextId = parkingLot.getAllSpaces().size() + 1;
        ParkingSpace newSpace = new ParkingSpace("P" + nextId, type);
        parkingLot.addParkingSpace(newSpace);
    }
    
    public boolean removeParkingSpace(ParkingLot parkingLot, String spaceId) {
        return parkingLot.removeParkingSpace(spaceId);
    }
    
    // Simulate sensor detection
    public void simulateVehicleDetection(ParkingLot parkingLot, String spaceId, boolean detected) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null && space.getSensor() != null) {
            space.getSensor().detectVehicle(detected);
        }
    }
    
    // Observer implementation
    @Override
    public void onParkingSpaceStatusChanged(ParkingSpace space) {
        // Notify booking system of changes if needed
        if (bookingSystem != null) {
            bookingSystem.updateParkingAvailability(space);
        }
    }
    
   
    public void onAvailabilityChanged(int availableSpaces) {
        // Can be used to trigger system-wide notifications
        System.out.println("Parking availability changed: " + availableSpaces + " spaces available");
    }

	@Override
	public void onAvailabilityChanged(List<ParkingSpace> list) {
		// TODO Auto-generated method stub
		
	}


	public boolean removeParkingLot(String name) {
		// TODO Auto-generated method stub
		boolean removed = false;
		for(ParkingLot l: parkingLot) {
			if(l.getName().equals(name)) {
				parkingLot.remove(l);
				dbParkingLots.remove(name,4);
				removed = true;
				break;
			}
		}
		return removed;
	}

	public void statusParkingLot(String name, boolean enabled) {
		// TODO Auto-generated method stub
		for(ParkingLot l: parkingLot) {
			if(l.getName().equals(name)) {
				l.setStatus(enabled);
				break;
			}
		}
	}

	public List<ParkingLot> getAvailableLots() {
		// TODO Auto-generated method stub
		return parkingLot;
	}

	public void addNewParkingLot(ParkingLot newParkingLot) {
		// TODO Auto-generated method stub
		if (!parkingLot.contains(newParkingLot)) {
			parkingLot.add(newParkingLot);
			String[] lst = {newParkingLot.getName(), newParkingLot.getLocation(), newParkingLot.getStatus(),String.valueOf(newParkingLot.getCapcity())};
			dbParkingLots.update(lst);
		}
	}
	public ParkingLot getParkingLotInfo(String name) {
		for(ParkingLot l: parkingLot) {
			if(l.getName().equals(name)) {
				return l;
			}
		}    
		return null;
	}

}
