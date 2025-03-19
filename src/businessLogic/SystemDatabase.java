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
		if (!managers.contains(manager))
			managers.add(manager);
	}
	
	/**
	 * 
	 * @param manager
	 */
	public void removeManager(Manager manager) {
		if (managers.contains(manager))
			managers.remove(manager);
	}
	
	/*8
	 * 
	 */
	public void addParkingLot(ParkingLot parkingLot) {
		if (!parkingLots.contains(parkingLot))
			parkingLots.add(parkingLot);
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

	public Manager getManagerInfo(String email) {
		// TODO Auto-generated method stub
		for (Manager m: getManagers() ) {
			if(m!=null) {
			if(m.getUserName().trim().equals(email.trim())) {
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
