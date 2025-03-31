package main.java.objects;
public class NonFacultyStaff extends UniversityMember {
	public NonFacultyStaff(String email, String password) {
		super(email, password);
		this.setParkingRate(10);
	}
	public String getValidationStatus() {
    	if(isValidated()) {
    		return "Validated";
    	}else {return "NotValidated";}
    }
}
