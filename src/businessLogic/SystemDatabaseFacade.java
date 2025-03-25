package businessLogic;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import database.Database;
import objects.Client;
import objects.ClientFactory;
import objects.Manager;
import objects.ParkingLot;
import objects.SuperManager;
import objects.ParkingSpace;

public class SystemDatabaseFacade {
	
	private static ArrayList<Client> clients = new ArrayList<Client>();
	private static  ArrayList<Manager> managers = new ArrayList<Manager>();
	private static ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	static int revenue;
	ClientSystem clientSystem;
	ManagementSystem managementSystem;
	ParkingSystem parkingSystem;
	BookingSystem bookingSystem;
	private static SystemDatabaseFacade systemDatabase = null;

	private SystemDatabaseFacade(ArrayList<Client> clients, ArrayList<Manager> managers, ArrayList<ParkingLot> parkingLots, int revenue) throws Exception{
		super();
		clientSystem = ClientSystem.getInstance();
		managementSystem= ManagementSystem.getInstance();
		parkingSystem = ParkingSystem.getInstance();
		bookingSystem = bookingSystem.getInstance();
		SystemDatabaseFacade.revenue = revenue;
	}
	
	public static synchronized SystemDatabaseFacade getInstance(){
		if (systemDatabase == null) {
			try {
				systemDatabase = new SystemDatabaseFacade(clients, managers, parkingLots, revenue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return systemDatabase;

	}
	//methods related to Client System.
	/**
	 * @return the clients
	 */
	public ArrayList<Client> getClients() {
		return clientSystem.getClients();
	}
	/**
	 * @param clients
	 */
	public void addClient(Client client) throws Exception {
		this.clients = clientSystem.addClient(client);
	}
	/**
	 * 
	 * @param client
	 */
	public void removeClient(Client client) {
		this.clients= clientSystem.removeClient(client);
	}
	public Client getClientInfo(String email) {
		return clientSystem.getClientInfo(email);
	}
	public boolean registerValidation(Client user) {
		return true;
	}
	public boolean approveUser(Client user) {
	        if (!clients.contains(user)) {
	            return false;
	        }
	        user.setValidated(true);
	        return true;
	}
	

	
	//ParkingLot related methods
	
	/**
	 * @return the parkingLots
	 */
	public ArrayList<ParkingLot> getAvailableLots() {
        return parkingSystem.getAvailableLots();
	}
	/**
	 * @param parkingLots
	 */
	public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}
	public List<ParkingSpace> getAvailableSpaces(ParkingLot parkingLot) {
        return parkingSystem.getAvailableSpaces(parkingLot);
    }
	public ParkingLot getParkingLotInfo(String name) {
		return parkingSystem.getParkingLotInfo(name);

	}
	/**
	 * 
	 * @param parkingLot
	 */
	public void removeParkingLot(ParkingLot parkingLot) {
		parkingSystem.removeParkingLot(parkingLot.getName());
	}
	public boolean statusParkingLot(String name, boolean enabled) {
		return parkingSystem.statusParkingLot(name,enabled);
	}
	public boolean removeParkingLot(String name) {
		return parkingSystem.removeParkingLot(name);

	}
	public void enableParkingSpace(ParkingLot parkingLot, int spaceId) {
		parkingSystem.enableParkingSpace(parkingLot,spaceId);
    }
    
    public void disableParkingSpace(ParkingLot parkingLot, int spaceId) {
		parkingSystem.disableParkingSpace(parkingLot,spaceId);
    }
//
//	  public boolean setParkingLotStatus(String lotName, boolean enabled) {
//	        for (ParkingLot lot : parkingLots) {
//	            if (lot.getName().equals(lotName)) { // Match by name instead of ID
//	                lot.setEnabled(enabled);
//	                return true;
//	            }
//	        }
//	        return false;
//	    }

//	  public boolean setParkingSpaceStatus(String lotName, int parkingSpaceID, boolean enabled) {
//	        for (ParkingLot lot : parkingLots) {
//	            if (lot.getName().equals(lotName)) {
//	                ParkingSpace space = lot.findSpaceById(parkingSpaceID); // Correct method
//	                if (space != null) {
//	                    space.setEnabled(enabled);
//	                    return true;
//	                }
//	            }
//	        }
//	        return false;
//	    }
	  public void addNewParkingLot(ParkingLot newParkingLot) {
			parkingSystem.addNewParkingLot(newParkingLot);
		}
	  public void simulateVehicleDetection(ParkingLot parkingLot, int spaceId, boolean detected) {
	       parkingSystem.simulateVehicleDetection(parkingLot, spaceId, detected);
	    }

	
	//Methods related to Management System.
	/**
	 * @return the managers
	 */
	public ArrayList<Manager> getManagers() {
		return managers;
	}
	/**
	 * @param managers the managers to set
	 */
	public void setManagers(ArrayList<Manager> managers) {
		this.managers = managers;
	}
	/**
	 * 
	 * @param manager
	 */
	public void addManager(Manager manager) {
		this.managers= managementSystem.addManager(manager);
	}
	
	public void removeManager(String username) {
		this.managers= managementSystem.removeManager(username);

	}
	public Manager getManagerInfo(String userName) {
		// TODO Auto-generated method stub
		return managementSystem.getManagerInfo(userName);
	}
	public boolean isSuperManager(String email) {
		return managementSystem.isSuperManager(email);	
	}
	
	/**
	 * 
	 * @param profit
	 */
	public static void addRevenue(int profit) {
		revenue = revenue + profit;
	}
	
	public void removeRevenue (int loss) {
		revenue = revenue - loss;
	}
	/**
	 * @return the revenue
	 */
	public int getRevenue() {
		return revenue;
	}
	/**
	 * @param revenue
	 */
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	//methods realted to booking system
	 public Map<Integer, Visit> getBookings() {
	        return bookingSystem.getBookings();
	 }
	public Map<Integer,Visit> getBookingsForClient(Client c){
		return bookingSystem.getBookingsForClient(c);
	}
    public boolean bookParkingSpace(String clientEmail, String parkingLotName, int parkingSpaceID, int deposit, int time, Date date,int initialtime, int duration, String license) {
    	return bookingSystem.bookParkingSpace(clientEmail, parkingLotName, parkingSpaceID, deposit, time, date,initialtime, duration, license);
    }
    public boolean editBooking(int bookingID, String parkingLotName, int parkingSpaceID, int time,Date date,int duration,Client c,String license) {
    	return bookingSystem.editBooking(bookingID,parkingLotName,parkingSpaceID,time,date,duration,c,license);

    }
    public boolean cancelBooking(int bookingID, boolean newBooking) {
        return bookingSystem.cancelBooking(bookingID,newBooking);
    }
    public int generateBookingID() {
        // Simple booking ID generation
        return bookingSystem.generateBookingID();
    }
    public boolean extendBooking(int bookingID, Date date,int time,int duration) {
    	return bookingSystem.extendBooking(bookingID,date,time,duration);

    }
	
	
}
