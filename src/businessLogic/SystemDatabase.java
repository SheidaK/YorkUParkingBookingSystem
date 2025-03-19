package businessLogic;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
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
	
	private static SystemDatabase systemDatabase = null;

	private SystemDatabase(ArrayList<Client> clients, ArrayList<Manager> managers, ArrayList<ParkingLot> parkingLots, int revenue) throws Exception{
		super();
		this.clients = clients;
		File file = new File(path);
		if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		ClientFactory clientFactory = new ClientFactory();
		while (reader.readRecord()) {
			Client newClient = clientFactory.getNewClient(reader.get("Client Type"),reader.get("Email"),reader.get("Password"));
			clients.add(newClient);
		}
		reader.close();
		this.managers = managers;
		CsvReader reader2 = new CsvReader(path2); 
		reader2.readHeaders();
		while (reader2.readRecord()) {
			Manager manager;
			if(isSuperManager(reader2.get("UserName"))) {
				manager = new SuperManager();
			}else {
				manager = new Manager(reader2.get("UserName"),reader2.get("Password"));
			}
			managers.add(manager);
		}
		reader.close();
		//this.parkingLots = parkingLots;
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
//	/**
//	 * @param managers the managers to set
//	 */
//	public void setManagers(ArrayList<Managers> managers) {
//		this.managers = managers;
//	}
//	/**
//	 * @return the parkingLots
//	 */
//	public ArrayList<ParkingLot> getParkingLots() {
//		return parkingLots;
//	}
//	/**
//	 * @param parkingLots
//	 */
//	public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
//		this.parkingLots = parkingLots;
//	}
//	/**
//	 * @return the revenue
//	 */
//	public int getRevenue() {
//		return revenue;
//	}
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
		try {
			CsvReader reader = new CsvReader(path);
            CsvWriter csvOutput = new CsvWriter(new FileWriter(path, true), ',');
            reader.readHeaders(); // Skip headers if present
            String clientType = client.getClass().getName().replace("objects.","");
			String[] lst = {client.getEmail(),client.getPassword(), clientType};
			 List<String[]> existingData = new ArrayList<>();
			 while (reader.readRecord()) {
				 existingData.add(reader.getValues()); // Write the existing records to the new file
	         }
			csvOutput.writeRecord(lst);
			reader.close();
			csvOutput.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			CsvReader reader = new CsvReader(path);
            reader.readHeaders(); // Skip headers if present
			 List<String[]> existingData = new ArrayList<>();
			 String[] header = new String[3];
			 header = reader.getHeaders();
			 existingData.add(header);
			 while (reader.readRecord()) {
				 String[] row = reader.getValues();
				 if(!row[0].equals(client.getEmail())) {
					 existingData.add(row);
				 }
	         }
			 reader.close();
			 CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
			 for (String[] row : existingData) {
				 csvOutput.writeRecord(row);
	            }
			csvOutput.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
//	/**
//	 * 
//	 * @param manager
//	 */
//	public void addManager(Manager manager) {
//		if (!managers.contians(manager))
//			managers.add(manager);
//	}
//	
//	/**
//	 * 
//	 * @param manager
//	 */
//	public void removeManager(Manager manager) {
//		if (managers.contians(manager))
//			managers.remove(manager);
//	}
//	
//	/*8
//	 * 
//	 */
//	public void addParkingLot(ParkingLot parkingLot) {
//		if (!parkingLots.contians(parkingLot))
//			parkingLots.add(parkingLot);
//	}
//	
//	/**
//	 * 
//	 * @param parkingLot
//	 */
//	public void removeParkingLot(ParkingLot parkingLot) {
//		if (parkingLots.contains(parkingLot)) {
//			parkingLots.remove(parkingLot);
//		}
//	}
	
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
