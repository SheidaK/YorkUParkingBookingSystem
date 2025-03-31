package main.java.objects;
public class Visitor extends Client {
	public Visitor(String email, String password) {
		super(email, password);
		this.setParkingRate(15);
	}
	public String getValidationStatus() {
	    
	    return "Validated";
	    
	}
}
