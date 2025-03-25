package businessLogic;

import java.util.ArrayList;
import java.util.List;

import database.Database;
import objects.Client;
import objects.ClientFactory;

public class ClientSystem {
	private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ClientSystem instance = null;
	String path = "src/database/SystemDatabaseClients.csv";
	Database dbClient = new Database(path);
	private ClientSystem() throws Exception {
		List<String[]> dataClients = dbClient.read();
		ClientFactory clientFactory = new ClientFactory();
		for(String[] row:dataClients) {
			Client newClient = clientFactory.getNewClient(row[2],row[0],row[1]);
			if(row[3].trim().equals("Validated")) {
			newClient.setValidated(true);
			}else {	newClient.setValidated(false);}
			clients.add(newClient);
		}
	}
	public static ClientSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ClientSystem();
        }
        return instance;
    }
	public ArrayList<Client> getClients() {
		return clients;
	}
	/**
	 * @param clients
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public ArrayList<Client> addClient(Client client) throws Exception {
		if (!clients.contains(client)) {
			clients.add(client);
			String clientType = client.getClass().getName().replace("objects.","");
			String[] lst = {client.getEmail(),client.getPassword(), clientType,client.getValidationStatus()};
			dbClient.update(lst);
		}
		return this.clients;
	}
	/**
	 * 
	 * @param client
	 */
	public ArrayList<Client> removeClient(Client client) {
		if (clients.contains(client)) {
			clients.remove(client);
		}
		dbClient.remove(client.getEmail(),3);
		return this.clients;
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
	public void changeValidationStatus(String email, String status) {
		dbClient.overWrite(email, 4, 3, status,0 );
	}

}
