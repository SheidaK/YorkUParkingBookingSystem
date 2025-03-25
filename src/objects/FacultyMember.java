package objects;

public class FacultyMember extends UniversityMember {
	public FacultyMember(String email, String password) {
		super(email, password);
		this.setParkingRate(8);
	}

}
