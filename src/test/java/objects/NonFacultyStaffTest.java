package test.java.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.objects.Client;
import main.java.objects.FacultyMember;
import main.java.objects.NonFacultyStaff;
import main.java.objects.Student;

public class NonFacultyStaffTest {
	NonFacultyStaff staff;
	String testEmail = "staff@gmail.com";
	String testPassword ="aA2!";
	@BeforeAll
	public void setUp() {
		staff = new NonFacultyStaff(testEmail,testPassword);
	}
	@Test
	public void testClassType() {
		assertTrue(staff.getClass().getName().contains("NonFacultyStaff"));
	}
	@Test
	public void testClassType2() {
		Client student = new Student(testEmail,testPassword);
		assertFalse(staff.getClass().equals(student.getClass()));

	}
	@Test
	public void testClassType3() {
		Client staff2 = new NonFacultyStaff("test@gmail.com",testPassword);
		assertTrue(staff.getClass().equals(staff2.getClass()));

	}
	@Test
	public void testEmail() {
		assertTrue(staff.getEmail().equals("staff@gmail.com"));

	}
	@Test
	public void testEmail2() {
		assertFalse(staff.getEmail().equals("facultyMember2@gmail.com"));

	}
	@Test
	public void testPassword() {
		assertTrue(staff.getPassword().equals("aA2!"));

	}
	@Test
	public void testPassword2() {
		assertFalse(staff.getPassword().equals("aA13!"));

	}
	@Test
	public void testIsValidated() {
		assertFalse(staff.isValidated());

	}
	@Test
	public void testGetValidationStatus() {
		assertEquals(staff.getValidationStatus(),"NotValidated");
	}
	@Test
	public void testSetValidated() {
		staff.setValidated(true);
		assertTrue(staff.isValidated());

	}
	@Test
	public void testGetValidationStatus2() {
		assertEquals(staff.getValidationStatus(),"Validated");
	}

	@Test
	public void testGetParkingRate() {
		assertEquals(staff.getParkingRate(),10);
	}
}
