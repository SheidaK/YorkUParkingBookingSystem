package objects;
import businessLogic.SystemDatabaseFacade;
public abstract class UniversityMember extends Client {
	public UniversityMember(String email, String password) {
		super(email, password);
	}
	public String getValidationStatus() {
    	if(isValidated()) {
    		return "Validated";
    	}else {return "NotValidated";}
    }

}
