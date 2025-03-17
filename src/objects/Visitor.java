package objects;
import businessLogic.SystemDatabase;

public class Visitor extends Client {
	public Visitor(String email, String password) {
		super(email, password);
		register(email,password);
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
		try {
			systemDB.addClient(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}


}
