package test.java.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.objects.Client;
import main.java.objects.Student;
import main.java.objects.UniversityMember;
import main.java.objects.Visitor;

public class UniversityMemberTest {
	UniversityMember member;
	String testEmail = "student@gmail.com";
	String testPassword ="aA3!";
	@Test
	public void testClassType() {
		assertTrue(member.getClass().getName().contains("UniversityMember"));
	}
	@Test
	public void testClassType2() {
		Client visitor = new Visitor(testEmail,testPassword);
		assertFalse(member.getClass().equals(visitor.getClass()));
	}
	
	@Test
	public void testIsValidated() {
		assertFalse(member.isValidated());
	}
	@Test
	public void testSetValidated() {
		member.setValidated(true);
		assertTrue(member.isValidated());
	}

	@Test
	public void testGetParkingRate() {
		assertEquals(member.getParkingRate(),50);
	}
	@Test
	public void testGetEmail() {
		assertNull(member.getEmail());
	}
	@Test
	public void testSetEmail() {
		member.setEmail(testEmail);
		assertEquals(member.getEmail(),testEmail);
	}
	@Test
	public void testGetPassword() {
		assertNull(member.getPassword());
	}
	@Test
	public void testSetPassword() {
		member.setPassword(testPassword);
		assertEquals(member.getPassword(),testPassword);
	}
}
