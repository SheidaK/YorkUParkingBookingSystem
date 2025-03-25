package objects;

public class Student extends UniversityMember {

	public Student(String email, String password) {
		super(email, password);
		this.setParkingRate(5);
	}
}
