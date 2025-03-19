package objects;

import java.util.ArrayList;

public class Manager {
	protected String email;
	protected String password;
	public Manager(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return "Manager";
	}

}
