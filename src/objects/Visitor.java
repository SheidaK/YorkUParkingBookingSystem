package objects;
import businessLogic.SystemDatabase;

public class Visitor extends Client {
	public Visitor(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	public static int parkingRate = 15;
	SystemDatabase systemDB = SystemDatabase.getInstance();

	@Override
	public boolean register(String email, String password) {
		for(Client c:systemDB.getClients()) {
			if(c.email.equalsIgnoreCase(email)) {
				return false;
			}
		}
		systemDB.addClient(this);
		return true;
	}


}
