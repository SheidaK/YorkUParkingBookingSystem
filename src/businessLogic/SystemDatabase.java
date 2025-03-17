package businessLogic;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import objects.Client;
import objects.ClientFactory;
import objects.Managers;
import objects.ParkingLot;

public class SystemDatabase {
	
	private static ArrayList<Client> clients = new ArrayList<Client>();
	private static  ArrayList<Managers> managers = new ArrayList<Managers>();
	private static ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	String path = "src/database/SystemDatabase.csv";
	static int revenue;
	
	private static SystemDatabase systemDatabase = null;

	private SystemDatabase(ArrayList<Client> clients, ArrayList<Managers> managers, ArrayList<ParkingLot> parkingLots, int revenue) throws Exception{
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
		//while(reader.readRecord()){
		while (reader.readRecord()) {
			System.out.println(reader.get("Client Type")+" "+reader.get("Email")+" "+reader.get("Password"));
			Client newClient = clientFactory.getNewClient(reader.get("Client Type"),reader.get("Email"),reader.get("Password"));
			//clients.add(newClient);
		}
		//this.managers = managers;
		//this.parkingLots = parkingLots;
		SystemDatabase.revenue = revenue;
	}
	
	public static synchronized SystemDatabase getInstance(){
		if (systemDatabase == null) {
			
			try {
				systemDatabase = new SystemDatabase(clients, managers, parkingLots, revenue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
//	public ArrayList<Managers> getManagers() {
//		return managers;
//	}
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
		if (!clients.contains(client)) 
			clients.add(client);
		System.out.println(client.getEmail()+" sfs "+client.getPassword());

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
			 for (String[] row : existingData) {
				 csvOutput.writeRecord(row);
	            }
			csvOutput.writeRecord(lst);
//			csvOutput.write(client.getEmail());
//			csvOutput.write(client.getPassword());
//			csvOutput.write(client.getClass().getName());
			reader.close();
			csvOutput.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param client
	 */
	public void removeClient(Client client) {
		if (clients.contains(client))
			clients.remove(client);
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
		for (Client c: clients ) {
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}
	
}
