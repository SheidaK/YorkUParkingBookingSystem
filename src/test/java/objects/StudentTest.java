package test.java.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.objects.Client;
import main.java.objects.NonFacultyStaff;
import main.java.objects.Student;
import main.java.objects.Visitor;

public class StudentTest {
	Student student;
	String testEmail = "student@gmail.com";
	String testPassword ="aA3!";
	@BeforeAll
	public void setUp() {
		student = new Student(testEmail,testPassword);
	}
	@Test
	public void testClassType() {
		assertTrue(student.getClass().getName().contains("Student"));
	}
	@Test
	public void testClassType2() {
		Client visitor = new Visitor(testEmail,testPassword);
		assertFalse(student.getClass().equals(student.getClass()));

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
		assertTrue(student.isValidated());

	}
	@Test
	public void testGetValidationStatus2() {
		assertEquals(student.getValidationStatus(),"Validated");
	}

	@Test
	public void testGetParkingRate() {
		assertEquals(student.getParkingRate(),5);
	}
}
