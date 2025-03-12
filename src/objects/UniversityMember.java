package objects;
import businessLogic.SystemDatabase;
public abstract class UniversityMember extends Client {

	public UniversityMember(String email, String password) {
		super(email, password);
		// TODO Auto-generated constructor stub
	}
	SystemDatabase systemDB = SystemDatabase.getInstance();
	ManagerFacade manager = new ManagerFacde();

	@Override
	public boolean register(String email, String password) {
		this.email = email;
		this.password = password;
		if (validateRegistration(this.getEmail())){
			systemDB.addClient(this);
			return true;
		}
		return false;
	}
		
	
	public boolean validateRegistration(String email){
		return manager.validateUniversityMember(this);
	}
	
}
