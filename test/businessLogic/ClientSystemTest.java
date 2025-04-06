package businessLogic;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import objects.Client;
import businessLogic.ClientSystem;
import objects.FacultyMember;
import objects.Student;
public class ClientSystemTest {
//	@Test
//	public void testClientSystem() {}
	static ClientSystem clientSystem;
	static Client client = new FacultyMember("test@gmail.com","aA5!");

//	@Test
//	public void setUpThrowsException() throws Exception{
//		
//	}
	@BeforeAll
	public static void setUp() throws Exception {
		clientSystem = ClientSystem.getInstance();
	}
	@Test
	public void testAddClient() throws Exception {
		clientSystem.addClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
		assertTrue(clients.get(clients.size()-1).getEmail()=="test@gmail.com");
		clientSystem.removeClient(client);

	}
	
	@Test
	public void testGetClientsEmails() throws Exception {
		clientSystem.addClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
        assertEquals("test@gmail.com", clients.get(clients.size()-1).getEmail());
		//clientSystem.removeClient(client);
		clientSystem.removeClient(client);

	}
	@Test
	public void testGetClientsPassword() throws Exception {
		clientSystem.addClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
        assertEquals("aA5!", clients.get(clients.size()-1).getPassword());
		//clientSystem.removeClient(client);
		clientSystem.removeClient(client);
		
	}
	
	@Test
	public void testGetClientType() throws Exception {
		clientSystem.addClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
        assertEquals(8, clients.get(clients.size()-1).getParkingRate());        
		clientSystem.removeClient(client);

	}
	
	@Test
	@Order(5)
	public void testGetClientInfo() throws Exception {
		clientSystem.addClient(client);
		Client c = clientSystem.getClientInfo("test@gmail.com");
		assertEquals(c.getEmail(),"test@gmail.com");
		clientSystem.removeClient(client);

	}
	@Test
	public void testGetClientInfo2() throws Exception {
		clientSystem.addClient(client);
		ArrayList<Client> clients = clientSystem.getClients();
		Client c = clientSystem.getClientInfo("test@gmail.com");
		assertEquals(c.getPassword(),"aA5!");
		clientSystem.removeClient(client);

	}
	@Test
	public void testGetClientInfo3() throws Exception {
		clientSystem.addClient(client);

		Client c = clientSystem.getClientInfo("test@gmail.com");
		assertTrue(c.getClass().getName().contains("FacultyMember"));
		clientSystem.removeClient(client);

	}
	@Test
	public void testChangeValidationStatus() throws Exception {
		clientSystem.addClient(client);
		clientSystem.changeValidationStatus("test@gmail.com","NotValidated");
		assertEquals(clientSystem.getClientInfo("test@gmail.com").getValidationStatus(),"NotValidated");
		clientSystem.removeClient(client);

	}
	@Test
	public void testRemoveClient() throws Exception {
		clientSystem.addClient(client);
		Client c =clientSystem.getClientInfo("test@gmail.com");
		clientSystem.removeClient(client);
		assertNotEquals(c, clientSystem.getClientInfo("test@gmail.com"));
	}
	@Test
	public void testSetClients() {
		ArrayList<Client> oldList = clientSystem.getClients();
		ArrayList<Client> newList =new ArrayList<Client>();
		for(int i=0;i<3;i++) {
			Client c = new Student("test"+i,"aA5!");
			newList.add(c);
		}
		clientSystem.setClients(newList);
		assertNotEquals(newList,oldList);
	}
	
	
}