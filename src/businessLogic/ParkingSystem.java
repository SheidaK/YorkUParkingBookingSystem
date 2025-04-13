package businessLogic;

import objects.*;

import java.util.ArrayList;
import java.util.List;

import database.Database;

/**
 * Implements the Facade pattern to provide a simplified interface to the parking subsystem
 */
public class ParkingSystem  {
    // Singleton pattern
    private static ParkingSystem instance;
	String path = "src/database/ParkingLotDatabase.csv";
	String path2 = "src/database/ParkingSpaceDatabase.csv";

	Database dbParkingLots = new Database(path);
	Database dbParkingSpace = new Database(path2);
    private ArrayList<ParkingLot> parkingLot=new ArrayList<ParkingLot>();
    //private BookingSystem bookingSystem;
    private int numOfSensors=0;
    
    // Private constructor for Singleton pattern
    private ParkingSystem() throws Exception {
        List<String[]> dataParkingLots = dbParkingLots.read();
		for(String[] row:dataParkingLots) {
			ParkingLot l = new ParkingLot(row[0],row[1],Integer.valueOf(row[3].trim()));
			if(row[2].trim().equals("Enabled")) {
				l.setStatus(true);
			}else {l.setStatus(false);}
			parkingLot.add(l);
		}
		List<String[]> dataParkingSpace = dbParkingSpace.read();
		int sensor = 1;
			for(String[] row:dataParkingSpace) {
				ParkingLot l = getParkingLotInfo(row[0]);
				if(l!=null) {
					ParkingSpace s = l.findSpaceById(Integer.valueOf(row[1].trim()));
					if(row[2].trim().equals("Enabled")) {
						s.setEnabled(true);
					}else {
						s.setEnabled(false);
					}
					if(row[3].trim().equals("Occupied")) {
						s.setOccupied(true);
					}else {
						s.setOccupied(false);
					}
					ParkingSensor newSensor = new ParkingSensor(Integer.valueOf(row[1].trim()),s);
					s.assignSensor(newSensor);
				}
				
			}
    }
    
    // Singleton getInstance method
    public static synchronized ParkingSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ParkingSystem();
        }
        return instance;
    }
  
    public List<ParkingSpace> getAvailableSpaces(ParkingLot parkingLot) {
        return parkingLot.getAllSpaces();
    }
    
    public boolean parkCar(ParkingLot parkingLot,int spaceId, Car car) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            return space.parkCar(car);
        }
        return false;
    }
    
    public Car removeCar(ParkingLot parkingLot, int spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            return space.removeCar();
        }
        return null;
    }
    
    // Manager operations
    public void enableParkingSpace(ParkingLot parkingLot, int spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(Integer.valueOf(spaceId));
        if (space != null) {
            space.setEnabled(true);
            dbParkingSpace.overWrite(String.valueOf(spaceId),7,2,"Enabled",1 );
        }
    }
    
    public void disableParkingSpace(ParkingLot parkingLot, int spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(Integer.valueOf(spaceId));
        if (space != null) {
            space.setEnabled(false);
            dbParkingSpace.overWrite(String.valueOf(spaceId),7,2,"Disabled" ,1);
        }
    }

    
    public void addNewParkingSpace(ParkingLot parkingLot,String type) {
        int nextId = parkingLot.getAllSpaces().size() + 1;
        ParkingSpace newSpace = new ParkingSpace(nextId, type);
        parkingLot.addParkingSpace(newSpace);
    }
    
    public boolean removeParkingSpace(ParkingLot parkingLot, int spaceId) {
        return parkingLot.removeParkingSpace(spaceId);
    }
    
    // Simulate sensor detection
    public void simulateVehicleDetection(ParkingLot parkingLot, int spaceId, boolean detected) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null && space.getSensor() != null) {
            space.getSensor().detectVehicle(detected);
        }
    }
    

   
    public void onAvailabilityChanged(int availableSpaces) {
        // Can be used to trigger system-wide notifications
        System.out.println("Parking availability changed: " + availableSpaces + " spaces available");
    }

	//@Override
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
				dbParkingSpace.remove(name,7 );
				removed = true;
				break;
			}
		}
		return removed;
	}

	public boolean statusParkingLot(String name, boolean enabled) {
		// TODO Auto-generated method stub
		for(ParkingLot l: parkingLot) {
			if(l.getName().equals(name)) {
				l.setStatus(enabled);
				if(enabled) {
					dbParkingLots.overWrite(name,4,2,"Enabled",0 );
				}else {
					dbParkingLots.overWrite(name,4,2,"Disabled",0 );
				}
				return true;
			}
		}
		return false;
	}

	public ArrayList<ParkingLot> getAvailableLots() {
		// TODO Auto-generated method stub
		return parkingLot;
	}

	public void addNewParkingLot(ParkingLot newParkingLot) {
		// TODO Auto-generated method stub
		if (!parkingLot.contains(newParkingLot)) {
			parkingLot.add(newParkingLot);
			String[] lst = {newParkingLot.getName(), newParkingLot.getLocation(), newParkingLot.getStatus(),String.valueOf(newParkingLot.getCapcity())};
			dbParkingLots.update(lst);
			
			for(ParkingSpace s: newParkingLot.getAllSpaces()) {
				String[] lst_spaces = {newParkingLot.getName(),String.valueOf(s.getSpaceId()),s.getEnablesString(),s.getOccupiedString(),String.valueOf(s.getSensor().getSensorId()),null};
				dbParkingSpace.update(lst_spaces);
			}
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
	public int getNumofSensor() {
		return numOfSensors;
	}
	public void increaseNumofSensor() {
		 numOfSensors++;
	}
	


	

}
