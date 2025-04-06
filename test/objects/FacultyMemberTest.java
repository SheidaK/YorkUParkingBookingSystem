package objects;

import objects.UniversityMember;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import objects.Client;
import objects.FacultyMember;
import objects.Student;
public class FacultyMemberTest {
	static FacultyMember member;
	static String testEmail = "facultyMember@gmail.com";
	static String testPassword ="aA1!";
	@BeforeAll
	public static void setUp() {
		member = new FacultyMember(testEmail,testPassword);
	}
	@Test
	public void testClassType() {
		assertTrue(member.getClass().getName().contains("FacultyMember"));
	}
	@Test
	public void testClassType2() {
		Client student = new Student(testEmail,testPassword);
		assertFalse(member.getClass().equals(student.getClass()));

	}
	@Test
	public void testClassType3() {
		Client member2 = new FacultyMember("test@gmail.com",testPassword);
		assertTrue(member.getClass().equals(member2.getClass()));

	}
	@Test
	public void testEmail() {
		assertTrue(member.getEmail().equals("facultyMember@gmail.com"));

	}
	@Test
	public void testEmail2() {
		assertFalse(member.getEmail().equals("facultyMember2@gmail.com"));

	}
	@Test
	public void testPassword() {
		assertTrue(member.getPassword().equals("aA1!"));

	}
	@Test
	public void testPassword2() {
		assertFalse(member.getPassword().equals("aA13!"));

	}
	@Test
	public void testIsValidated() {
		assertFalse(member.isValidated());

	}
	@Test

	public void testGetValidationStatus() {
		assertEquals(member.getValidationStatus(),"NotValidated");
	}
	@Test
	public void testSetValidated() {
		member.setValidated(true);
		assertTrue(member.isValidated() && member.getValidationStatus().equals("Validated"));

	}

	@Test
	public void testGetParkingRate() {
		assertEquals(member.getParkingRate(),8);
	}
}