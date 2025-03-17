package objects;

public class ClientFactory {
		Client newClient;
		public Client getNewClient(String buttonClientType, String email, String password){
			if (buttonClientType.equals("Visitor")){
				newClient = new Visitor(email, password);				
			}else if(buttonClientType.equals("FacultyMember")){
				newClient = new FacultyMember(email,password);
			}else if(buttonClientType.equals("NonFacultyStaff")){
				newClient = new NonFacultyStaff(email,password);
			}else if(buttonClientType.equals("Student")){
				newClient =  new Student(email,password);
			}else {return null;}
			return newClient;
		}
}
