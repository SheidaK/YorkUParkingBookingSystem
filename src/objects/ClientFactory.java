package objects;

public class ClientFactory {
		Client newClient;
		public Client getNewClient(String buttonClientType, String email, String password){
			if (buttonClientType=="Visitor"){
				newClient = new Visitor(email, password);				
			}else if(buttonClientType=="FacultyMember"){
				newClient = new FacultyMember(email,password);
			}else if(buttonClientType =="NonFacultyStaff"){
				newClient = new NonFacultyStaff(email,password);
			}else if(buttonClientType =="Student"){
				newClient =  new Student(email,password);
			}else {return null;}
			return newClient;
		}
}
