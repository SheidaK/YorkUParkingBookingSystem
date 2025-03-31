package main.java.objects;

public class FacultyMember extends UniversityMember {
	public FacultyMember(String email, String password) {
		super(email, password);
		this.setParkingRate(8);
	}
	public String getValidationStatus() {
    	if(isValidated()) {
    		return "Validated";
    	}else {return "NotValidated";}
    }

}
