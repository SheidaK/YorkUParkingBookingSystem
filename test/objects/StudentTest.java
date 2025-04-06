package objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.NonFacultyStaff;
import objects.Student;
import objects.Visitor;

public class StudentTest {
	static Student student;
	static String testEmail = "student@gmail.com";
	static String testPassword ="aA3!";
	@BeforeAll
	public static void setUp() {
		student = new Student(testEmail,testPassword);
	}
	@Test
	public void testClassType() {
		assertTrue(student.getClass().getName().contains("Student"));
	}
	@Test
	public void testClassType2() {
		Client visitor = new Visitor(testEmail,testPassword);
		assertFalse(student.getClass().equals(visitor.getClass()));

	}
	@Test
	public void testClassType3() {
		Client student2 = new Student("test@gmail.com",testPassword);
		assertTrue(student.getClass().equals(student2.getClass()));

	}
	@Test
	public void testEmail() {
		assertTrue(student.getEmail().equals("student@gmail.com"));

	}
	@Test
	public void testEmail2() {
		assertFalse(student.getEmail().equals("facultyMember2@gmail.com"));

	}
	@Test
	public void testPassword() {
		assertTrue(student.getPassword().equals("aA3!"));

	}
	@Test
	public void testPassword2() {
		assertFalse(student.getPassword().equals("aA13!"));

	}
	@Test
	public void testIsValidated() {
		assertFalse(student.isValidated());

	}
	@Test
	public void testGetValidationStatus() {
		assertEquals(student.getValidationStatus(),"NotValidated");
	}
	@Test
	public void testSetValidated() {
		student.setValidated(true);
		assertTrue(student.isValidated() && student.getValidationStatus().equals("Validated"));

	}

	@Test
	public void testGetParkingRate() {
		assertEquals(student.getParkingRate(),5);
	}
}
