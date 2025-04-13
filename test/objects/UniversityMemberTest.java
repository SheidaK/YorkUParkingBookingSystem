package objects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.Student;
import objects.UniversityMember;
import objects.Visitor;

public class UniversityMemberTest {
	
	String testEmail = "student@gmail.com";
	String testPassword ="aA3!";
	UniversityMember member=new Student(testEmail,testPassword);
	@Test
	public void testClassType() {
		assertTrue(member.getClass().getSuperclass().getName().contains("UniversityMember"));
	}
	@Test
	public void testClassType2() {
		Client visitor = new Visitor(testEmail,testPassword);
		assertFalse(member.getClass().equals(visitor.getClass()));
	}
	@Test
	public void testClassType3() {
		Client visitor = new Visitor(testEmail,testPassword);
		assertFalse(member.getClass().getSuperclass().equals(visitor.getClass().getSuperclass()));
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
	public void testSetParkingRate() {
		member.setParkingRate(50);
		assertEquals(member.getParkingRate(),50);
	}
	@Test
	public void testGetEmail() {
		assertEquals(member.getEmail(),"student@gmail.com");	
	}
	@Test
	public void testSetEmail() {
		member.setEmail(testEmail);
		assertEquals(member.getEmail(),testEmail);
	}
	@Test
	public void testGetPassword() {
		assertEquals(member.getPassword(),"aA3!");	}
	@Test
	public void testSetPassword() {
		member.setPassword(testPassword);
		assertEquals(member.getPassword(),testPassword);
	}
	@Test
	public void testGetValidationStatus() {
		member.setValidated(true);
		assertEquals(member.getValidationStatus(),"Validated");
	}
	@Test 
	public void testGetValidationStatus2() {
		member.setValidated(false);
		assertEquals(member.getValidationStatus(),"NotValidated");
	}
	
}