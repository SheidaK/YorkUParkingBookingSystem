package test.java.objects;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.*;

import main.java.objects.Client;
import main.java.objects.ClientFactory;
import main.java.objects.FacultyMember;
import main.java.objects.NonFacultyStaff;
import main.java.objects.Student;
import main.java.objects.Visitor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClientFactoryTest {
	ClientFactory factory = new ClientFactory();
	@Test
	public void getNewVisitorTest1(){
		Client visitor = factory.getNewClient("Visitor", "visitor@gmail.com", "aA1!");
		assertTrue(visitor.getClass().getName().contains("Visitor"));
	}
	@Test
	public void getNewVisitorTest2(){
		Client visitor = factory.getNewClient("Visitor", "visitor@gmail.com", "aA1!");
		assertTrue(visitor.getEmail().equals("visitor@gmail.com"));
	}
	@Test
	public void getNewVisitorTest3(){
		Client visitor = factory.getNewClient("Visitor", "visitor@gmail.com", "aA1!");
		assertTrue(visitor.getPassword().equals("aA1!"));
	}
	@Test
	public void getNewFacultyMemberTest1(){
		Client facultyMember = factory.getNewClient("FacultyMember", "faculty@gmail.com", "aA2!");
		assertTrue(facultyMember.getClass().getName().contains("FacultyMember"));
	}
	@Test
	public void getNewFacultyMemberTest2(){
		Client facultyMember = factory.getNewClient("FacultyMember", "faculty@gmail.com", "aA2!");
		assertTrue(facultyMember.getEmail().equals("faculty@gmail.com"));	
	}
	@Test
	public void getNewFacultyMemberTest3(){
		Client facultyMember = factory.getNewClient("FacultyMember", "faculty@gmail.com", "aA2!");
		assertTrue(facultyMember.getPassword().equals("aA2!"));	
	}
	@Test
	public void getNewNonFacultyStaffTest1(){
		Client nonFacultyStaff = factory.getNewClient("NonFacultyStaff", "staff@gmail.com", "aA3!");
		assertTrue(nonFacultyStaff.getClass().getName().contains("NonFacultyStaff"));
	}
	@Test
	public void getNewNonFacultyStaffTest2(){
		Client nonFacultyStaff = factory.getNewClient("NonFacultyStaff", "staff@gmail.com", "aA3!");
		assertTrue(nonFacultyStaff.getEmail().equals("staff@gmail.com"));
	}
	@Test
	public void getNewNonFacultyStaffTest3(){
		Client nonFacultyStaff = factory.getNewClient("NonFacultyStaff", "staff@gmail.com", "aA3!");
		assertTrue(nonFacultyStaff.getPassword().equals("aA3!"));
	}
	@Test
	public void getNewStudentTest1(){
		Client student = factory.getNewClient("Student", "student@gmail.com", "aA4!");
		assertTrue(student.getClass().getName().contains("Student"));
	}
	@Test
	public void getNewStudentTest2(){
		Client student = factory.getNewClient("Student", "student@gmail.com", "aA4!");
		assertTrue(student.getEmail().equals("student@gmail.com"));
	}
	@Test
	public void getNewStudentTest3(){
		Client student = factory.getNewClient("Student", "student@gmail.com", "aA4!");
		assertTrue(student.getPassword().equals("aA4!"));
	}
	@Test
	public void incorrectClientTypeTest1(){
		Client studentInvalid = factory.getNewClient("Studentdfg", "student2@gmail.com", "aA5!");
		assertNull(studentInvalid);
	}
}
