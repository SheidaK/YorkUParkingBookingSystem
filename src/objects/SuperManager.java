package objects;

import java.util.List;

import businessLogic.SystemDatabaseFacade;

public class SuperManager extends Manager {
	private static SuperManager supermanager = null;
	private static String userName = "superManager";
	private static String password = "ParkingS25!";

	public SuperManager() {
		super(userName,password );
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public String getRole() {
		// TODO Auto-generated method stub
		return "Super Manager";
	}
	public static SuperManager getInstance() {
		// TODO Auto-generated method stub
		if (supermanager == null) {
			try {
				supermanager = new SuperManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return supermanager;
	}

//	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
       // List<Manager> managers = systemDB.getManagers();
        //return managers;
//	}

	public void removeManager(String username) {
		// TODO Auto-generated method stub
		
	}

	public void generateManagerAccount(String username, String password) {
        
    }

}
