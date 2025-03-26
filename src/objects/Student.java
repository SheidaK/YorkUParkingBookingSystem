package objects;

public class Student extends UniversityMember {

	public Student(String email, String password) {
		super(email, password);
		this.setParkingRate(5);
	}
	public String getValidationStatus() {
    	if(isValidated()) {
    		return "Validated";
    	}else {return "NotValidated";}
    }
}
