import java.util.ArrayList;

import objects.Client;

public class SystemDatabase {
	
	ArrayList<Client> clients = new ArrayList<Client>();
	ArrayList<Managers> managers = new ArrayList<Managers>();
	ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	static int revenue;
	
	private static SystemDatabase systemDatabase = null;

	private SystemDatabase(ArrayList<Client> clients, ArrayList<Managers> managers, ArrayList<ParkingLot> parkingLots, int revenue) {
		super();
		this.clients = clients;
		this.managers = managers;
		this.parkingLots = parkingLots;
		SystemDatabase.revenue = revenue;
	}
	
	public static synchronized SystemDatabase getInstance() {
		if (systemDatabase == null) {
			systemDatabase = new SystemDatabase(clients, managers, parkingLots, revenue);
		return systemDatabase;
		}
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
	public ArrayList<Managers> getManagers() {
		return managers;
	}
	/**
	 * @param managers the managers to set
	 */
	public void setManagers(ArrayList<Managers> managers) {
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
	public void addClient(Client client) {
		if (!clients.contains(client)) 
			clients.add(client);
		
	}
	
	/**
	 * 
	 * @param client
	 */
	public void removeClient(Client client) {
		if (clients.contains(client))
			clients.remove(client);
	}
	
	/**
	 * 
	 * @param manager
	 */
	public void addManager(Manager manager) {
		if (!managers.contians(manager))
			managers.add(manager);
	}
	
	/**
	 * 
	 * @param manager
	 */
	public void removeManager(Manager manager) {
		if (managers.contians(manager))
			managers.remove(manager);
	}
	
	/*8
	 * 
	 */
	public void addParkingLot(ParkingLot parkingLot) {
		if (!parkingLots.contians(parkingLot))
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
}
