package main.java.businessLogic;

import java.util.ArrayList;
import java.util.List;

import main.java.database.Database;
import main.java.objects.Client;
import main.java.objects.ClientFactory;
import main.java.objects.Manager;
import main.java.objects.SuperManager;

public class ManagementSystem {
    private static ManagementSystem instance = null;
	private static  ArrayList<Manager> managers = new ArrayList<Manager>();
    String path = "src/main/resources/database/SystemDatabaseManagers.csv";
	Database dbManagers = new Database(path);
	private ManagementSystem() throws Exception {
		List<String[]> dataManagers= dbManagers.read();
		for(String[] row:dataManagers) {
			Manager manager;
			if(isSuperManager(row[2])) {
				manager = new SuperManager();
			}else {
				manager = new Manager(row[0],row[1]);
			}
			managers.add(manager);
		}
	}
	public static ManagementSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }
	public ArrayList<Manager> addManager(Manager manager) {
		if (!managers.contains(manager)) {
			managers.add(manager);
			String[] lst = {manager.getUserName(),manager.getPassword(), "Manager"};
			dbManagers.update(lst);
		}
		return this.managers;
		
	}
	
	/**
	 * 
	 * @param username
	 */
	public ArrayList<Manager> removeManager(String username) {
		for(Manager m: managers) {
			if(m.getUserName().equals(username)) {
				managers.remove(m);
				dbManagers.remove(username,3);
				break;
			}
		}
		return this.managers;
	}
	public ArrayList<Manager> getManager(){
		return managers;
	}
	public Manager getManagerInfo(String userName) {
		// TODO Auto-generated method stub
		for (Manager m: getManager() ) {
			if(m!=null) {
			if(m.getUserName().trim().equals(userName.trim())) {
				return m;
			}
			}
		}
		return null;
	}
	public boolean isSuperManager(String email) {
		if(email.equals(SuperManager.getInstance().getUserName())) {
			return true;
		}
		return false;
		
	}
	

}
