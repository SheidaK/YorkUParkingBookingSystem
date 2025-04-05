package test.java.businessLogic;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.businessLogic.ClientSystem;
import main.java.objects.Client;
import main.java.objects.FacultyMember;
import main.java.objects.Student;

public class ClientSystemTest {
//	@Test
//	public void testClientSystem() {}
	ClientSystem clientSystem;
	Client client = new FacultyMember("professor@gmail.com","aA5!");

//	@Test
//	public void setUpThrowsException() throws Exception{
//		
//	}
	@BeforeAll
	public void setUp() throws Exception {
		clientSystem = ClientSystem.getInstance();
	}
	
	@Test
	public void testGetClientsEmails() {
		ArrayList<Client> clients = clientSystem.getClients();
		ArrayList<String> expectedClientEmails= new ArrayList<String>();
		expectedClientEmails.add("a@gmail.com");
		expectedClientEmails.add("student@gmail.com");
		expectedClientEmails.add("visitor@gmail.com");
		expectedClientEmails.add("faculty@gmail.com");
		ArrayList<String> actualClientEmails= new ArrayList<String>();
		for(Client c:clients) {
			actualClientEmails.add(c.getEmail());
		}
        assertEquals(expectedClientEmails, actualClientEmails);
		
	}
	@Test
	public void testGetClientsPassword() {
		ArrayList<Client> clients = clientSystem.getClients();
		ArrayList<String> expectedClientPassword= new ArrayList<String>();
		expectedClientPassword.add("aA1!");
		expectedClientPassword.add("aA2!");
		expectedClientPassword.add("aA3!");
		expectedClientPassword.add("aA4!");
		ArrayList<String> actualClientPassword= new ArrayList<String>();
		for(Client c:clients) {
			actualClientPassword.add(c.getPassword());
		}
        assertEquals(expectedClientPassword, actualClientPassword);
		
	}
	@Test
	public void testGetClientType() {
		ArrayList<Client> clients = clientSystem.getClients();
		ArrayList<Integer> expectedClientType= new ArrayList<Integer>();
		expectedClientType.add(15);
		expectedClientType.add(5);
		expectedClientType.add(15);
		expectedClientType.add(8);
		ArrayList<Integer> actualClientType= new ArrayList<Integer>();
		for(Client c:clients) {
			actualClientType.add(c.getParkingRate());
		}
        assertEquals(expectedClientType, actualClientType);
		
	}
	@Test
	public void testAddClient() throws Exception {
		clientSystem.addClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
		assertTrue(clients.get(clients.size()-1).getEmail()=="professor@gmail.com");
	}
	@Test
	public void testGetClientInfo() {
		Client c = clientSystem.getClientInfo("professor@gmail.com");
		assertTrue(c.getEmail()=="professor@gmail.com");
	}
	@Test
	public void testGetClientInfo2() {
		Client c = clientSystem.getClientInfo("professor@gmail.com");
		assertTrue(c.getPassword()=="aA5!");
	}
	@Test
	public void testGetClientInfo3() {
		Client c = clientSystem.getClientInfo("professor@gmail.com");
		assertTrue(c.getClass().getName().contains("FacultyMember"));
	}
	@Test
	public void testRemoveClient() {
		clientSystem.removeClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
		assertFalse(clients.get(clients.size()-1).getEmail()=="professor@gmail.com");
	}
	
	@Test
	public void testChangeValidationStatus() {
		clientSystem.changeValidationStatus("a@gmail.com","NotValidated");
		assertEquals(clientSystem.getClientInfo("a@gmail.com").getValidationStatus(),"NotValidated");
	}

}
