package businessLogic;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import database.Database;
import objects.Client;
import objects.ClientFactory;
import objects.Manager;
import objects.ParkingLot;
import objects.SuperManager;
import objects.ParkingSpace;

public class SystemDatabase {
	
	private static ArrayList<Client> clients = new ArrayList<Client>();
	private static  ArrayList<Manager> managers = new ArrayList<Manager>();
	private static ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	String path = "src/database/SystemDatabaseClients.csv";
	String path2 = "src/database/SystemDatabaseManagers.csv";
	static int revenue;
	Database dbClient = new Database(path);
	Database dbManagers = new Database(path2);

	private static SystemDatabase systemDatabase = null;

	private SystemDatabase(ArrayList<Client> clients, ArrayList<Manager> managers, ArrayList<ParkingLot> parkingLots, int revenue) throws Exception{
		super();
		this.clients = clients;
		List<String[]> dataClients = dbClient.read();
		ClientFactory clientFactory = new ClientFactory();
		for(String[] row:dataClients) {
			Client newClient = clientFactory.getNewClient(row[2],row[0],row[1]);
			clients.add(newClient);
		}
		this.managers = managers;
		List<String[]> dataManagers= dbManagers.read();
		for(String[] row:dataManagers) {
			Manager manager;
			if(isSuperManager(row[2])) {
				manager = new SuperManager();
			}else {
				manager = new Manager(row[0],row[1]);
			}
			managers.add(manager);
		}
		this.parkingLots = parkingLots;
		SystemDatabase.revenue = revenue;
	}
	
	public static synchronized SystemDatabase getInstance(){
		if (systemDatabase == null) {
			try {
				systemDatabase = new SystemDatabase(clients, managers, parkingLots, revenue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return systemDatabase;

	}
	/**
	 * @return the clients
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}
	/**
	 * @param clients
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
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
	 * @return the parkingLots
	 */
	public ArrayList<ParkingLot> getParkingLots() {
		return parkingLots;
	}
	/**
	 * @param parkingLots
	 */
	public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
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
	/**
	 * 
	 * @param client
	 */
	public void addClient(Client client) throws Exception {
		if (!clients.contains(client)) {
			clients.add(client);
			String clientType = client.getClass().getName().replace("objects.","");
			String[] lst = {client.getEmail(),client.getPassword(), clientType};
			dbClient.update(lst);
		}
	}
	/**
	 * 
	 * @param client
	 */
	public void removeClient(Client client) {
		if (clients.contains(client)) {
			clients.remove(client);
		}
		dbClient.remove(client.getEmail(),3);
	}
	

	
	/**
	 * 
	 * @param manager
	 */
	public void addManager(Manager manager) {
		if (!managers.contains(manager)) {
			managers.add(manager);
			String[] lst = {manager.getUserName(),manager.getPassword(), "Manager"};
			dbManagers.update(lst);
		}
		
	}
	
	/**
	 * 
	 * @param username
	 */
	public void removeManager(String username) {
		for(Manager m: managers) {
			if(m.getUserName().equals(username)) {
				managers.remove(m);
				dbManagers.remove(username,3);
				break;
			}
		}
	}
	public ArrayList<Manager> getManager(){
		return managers;
	}
	
	/**
	 * 
	 * @param parkingLot
	 */
	public void removeParkingLot(ParkingLot parkingLot) {
		if (parkingLots.contains(parkingLot)) {
			parkingLots.remove(parkingLot);
		}
	}
	
	public boolean addParkingLot() {
	    ParkingLot newLot = ParkingLot.getInstance("Lot_" + parkingLots.size(), 100); // Assign a unique name and default capacity
	    parkingLots.add(newLot);
	    return true;
	}

	  public boolean setParkingLotStatus(String lotName, boolean enabled) {
	        for (ParkingLot lot : parkingLots) {
	            if (lot.getName().equals(lotName)) { // Match by name instead of ID
	                lot.setEnabled(enabled);
	                return true;
	            }
	        }
	        return false;
	    }

	  public boolean setParkingSpaceStatus(String lotName, String parkingSpaceID, boolean enabled) {
	        for (ParkingLot lot : parkingLots) {
	            if (lot.getName().equals(lotName)) {
	                ParkingSpace space = lot.findSpaceById(parkingSpaceID); // Correct method
	                if (space != null) {
	                    space.setEnabled(enabled);
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    public boolean approveUser(Client user) {
	        if (!clients.contains(user)) {
	            return false;
	        }
	        user.setValidated(true);
	        return true;
	    }

//	    public boolean createNewManagerAccount() {
//	        String newManagerUsername = "manager" + (managers.size() + 1);
//	        String newManagerPassword = "Pass" + (managers.size() + 100);
//	        managers.add(new Manager(newManagerUsername, newManagerPassword));
//	        return true;
//	    }

	
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
	public Client getClientInfo(String email) {
		for (Client c: getClients() ) {
			if(c!=null) {
			if(c.getEmail().trim().equals(email.trim())) {
				return c;
			}
			}
		}
		return null;
	}
	public boolean registerValidation(Client c) {
		//ManagerFacade manager = new ManagerFacde();
		//return manager.validateUniversityMember(this);
		return true;
	}

	public Manager getManagerInfo(String userName) {
		// TODO Auto-generated method stub
		for (Manager m: getManagers() ) {
			if(m!=null) {
			if(m.getUserName().trim().equals(userName.trim())) {
				return m;
			}
			}
		}
		return null;
	}
	public boolean isSuperManager(String email) {
		if(email.equals(SuperManager.getInstance().getUserName())) {
			return true;
		}
		return false;
		
	}
	
}
