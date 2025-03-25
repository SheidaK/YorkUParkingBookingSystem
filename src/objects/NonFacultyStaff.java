package objects;
public class NonFacultyStaff extends UniversityMember {
	public NonFacultyStaff(String email, String password) {
		super(email, password);
		this.setParkingRate(10);
	}
}
