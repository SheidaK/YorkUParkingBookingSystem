package test.java.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.objects.Client;
import main.java.objects.Student;
import main.java.objects.Visitor;

public class ClientTest {
	Client client;
	String testEmail = "student@gmail.com";
	String testPassword ="aA3!";
	@Test
	public void testClassType() {
		assertTrue(client.getClass().getName().contains("Client"));
	}
	@Test
	public void testClassType2() {
		Client visitor = new Visitor(testEmail,testPassword);
		assertFalse(client.getClass().equals(visitor.getClass()));
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
	public void testGetParkingRate() {
		assertEquals(client.getParkingRate(),50);
	}
	@Test
	public void testGetEmail() {
		assertNull(client.getEmail());
	}
	@Test
	public void testSetEmail() {
		client.setEmail(testEmail);
		assertEquals(client.getEmail(),testEmail);
	}
	@Test
	public void testGetPassword() {
		assertNull(client.getPassword());
	}
	@Test
	public void testSetPassword() {
		client.setPassword(testPassword);
		assertEquals(client.getPassword(),testPassword);
	}

}