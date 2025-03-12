package objects;

public class Student extends UniversityMember {

	public Student(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}
	public static int parkingRate = 5;
	@Override
	public boolean register(String email, String password) {
		return super.register(getEmail(), getEmail());
		
	}
}
