package objects;

public class FacultyMember extends UniversityMember {
	public FacultyMember(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}

	public static int parkingRate = 8;

	@Override
	public boolean register(String email, String password) {
		return super.register(getEmail(), getEmail());
		
	}
	

}
