package objects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.Student;
import objects.Visitor;

public class VisitorTest {
	static Visitor visitor;
	static String testEmail = "visitor@gmail.com";
	static String testPassword ="aA4!";
	@BeforeAll
	public static void setUp() {
		visitor = new Visitor(testEmail,testPassword);
	}
	@Test
	public void testClassType() {
		assertTrue(visitor.getClass().getName().contains("Visitor"));
	}
	@Test
	public void testClassType2() {
		Client student = new Student(testEmail,testPassword);
		assertFalse(visitor.getClass().equals(student.getClass()));

	}
	@Test
	public void testClassType3() {
		Client visitor2 = new Visitor("test@gmail.com",testPassword);
		assertTrue(visitor.getClass().equals(visitor2.getClass()));

	}
	@Test
	public void testEmail() {
		assertTrue(visitor.getEmail().equals("visitor@gmail.com"));

	}
	@Test
	public void testEmail2() {
		assertFalse(visitor.getEmail().equals("facultyMember2@gmail.com"));

	}
	@Test
	public void testPassword() {
		assertTrue(visitor.getPassword().equals("aA4!"));

	}
	@Test
	public void testPassword2() {
		assertFalse(visitor.getPassword().equals("aA13!"));

	}
	@Test
	public void testIsValidated() {
		assertTrue(visitor.isValidated());

	}
	@Test
	public void testGetValidationStatus() {
		assertEquals(visitor.getValidationStatus(),"Validated");
	}	

	@Test
	public void testGetParkingRate() {
		assertEquals(visitor.getParkingRate(),15);
	}
}

