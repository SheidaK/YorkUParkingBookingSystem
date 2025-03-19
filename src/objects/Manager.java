package objects;

import java.util.ArrayList;

public class Manager {
	protected String userName;
	protected String password;
	public Manager(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return "Manager";
	}

}
