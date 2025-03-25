package objects;
import businessLogic.SystemDatabaseFacade;
public abstract class UniversityMember extends Client {

	public UniversityMember(String email, String password) {
		super(email, password);
	}
	//ManagerFacade manager = new ManagerFacde();


		
//	
//	public boolean validateRegistration(String email){
//		return manager.validateUniversityMember(this);
//	}
//	
}
