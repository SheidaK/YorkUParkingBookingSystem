package objects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.Student;
import objects.Visitor;

public class ClientTest {
	String testEmail = "visitor@gmail.com";
	String testPassword ="aA3!";
	Client client=new Visitor(testEmail,testPassword);

	@Test
	public void testClassType() {
		assertTrue(client.getClass().getSuperclass().getName().contains("Client"));
	}
	@Test
	public void testClassType2() {
		Client student = new Student(testEmail,testPassword);
		assertFalse(client.getClass().equals(student.getClass()));
	}
	@Test
	public void testClassType3() {
		Client student = new Student(testEmail,testPassword);
		assertFalse(client.getClass().getSuperclass().equals(student.getClass().getSuperclass()));
	}
	
	@Test
	public void testIsValidated() {
		assertFalse(client.isValidated());
	}
	@Test
	public void testSetValidated() {
		client.setValidated(true);
		assertTrue(client.isValidated());
	}

	@Test
	public void testSetParkingRate() {
		client.setParkingRate(50);
		assertEquals(client.getParkingRate(),50);
	}
	@Test
	public void testGetEmail() {
		assertEquals(client.getEmail(),"visitor@gmail.com");	
	}
	@Test
	public void testSetEmail() {
		client.setEmail(testEmail);
		assertEquals(client.getEmail(),testEmail);
	}
	@Test
	public void testGetPassword() {
		assertEquals(client.getPassword(),"aA3!");
	}
	@Test
	public void testSetPassword() {
		client.setPassword(testPassword);
		assertEquals(client.getPassword(),testPassword);
	}

}
