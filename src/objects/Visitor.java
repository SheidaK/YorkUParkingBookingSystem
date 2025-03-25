package objects;
import businessLogic.SystemDatabaseFacade;

public class Visitor extends Client {
	public Visitor(String email, String password) {
		super(email, password);
		this.setParkingRate(15);
	}
}
