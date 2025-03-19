package objects;

import java.util.List;

import businessLogic.SystemDatabase;

public class SuperManager extends Manager {
	private static SuperManager supermanager = null;
	private static String email = "superManager@gmail.com";
	private static String password = "123";

	public SuperManager() {
		super(email,password );
		// TODO Auto-generated constructor stub
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

	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeManager(String username) {
		// TODO Auto-generated method stub
		
	}

	public boolean createManager(String username, String password, String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
