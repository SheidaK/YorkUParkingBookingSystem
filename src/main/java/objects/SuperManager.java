package main.java.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.java.businessLogic.SystemDatabaseFacade;

public class SuperManager extends Manager {
	private static SuperManager supermanager = null;
	private static String userName = "superManager";
	private static String password = "ParkingS25!";
	private static int managerID =1;
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

	public String[] generateManagerAccount() {
		String username = "Manager"+managerID;
		managerID++;
		String lowerCaseLetters="abcdefghijklmnopqrstuvwxyz";
		String upperCaseLetters=lowerCaseLetters.toUpperCase();
		String numbers="0123456789";
		String symbols = "!@#$%^&*()-_=+[]{}|;:,.<>?";
		String[] passwordChoices = {lowerCaseLetters,upperCaseLetters,numbers,symbols};
		Random random = new Random();
		ArrayList<Character> password= new ArrayList<>();
		for(int i=0;i<4;i++) {
			password.add(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
			password.add(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
			password.add(numbers.charAt(random.nextInt(numbers.length())));
			password.add(symbols.charAt(random.nextInt(symbols.length())));
		}   
		Collections.shuffle(password);
		String passwordString="";
		for(char c:password) {
			passwordString+=c;
		}
		String[] account = {username, passwordString};
		return account;
    }

}
