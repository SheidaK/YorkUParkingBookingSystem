package objects;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ManagerTest {
    
    private Manager manager;
    
    @Before
    public void setUp() {
        manager = new Manager("testManager", "testPassword");
    }
    
    @Test
    public void testConstructor() {
        assertEquals("testManager", manager.getUserName());
        assertEquals("testPassword", manager.getPassword());
    }
    
    @Test
    public void testGetUserName() {
        assertEquals("testManager", manager.getUserName());
    }
    
    @Test
    public void testGetPassword() {
        assertEquals("testPassword", manager.getPassword());
    }
    
    @Test
    public void testGetRole() {
        assertEquals("Manager", manager.getRole());
    }
    
    @Test
    public void testManagerWithEmptyCredentials() {
        Manager emptyManager = new Manager("", "");
        assertEquals("", emptyManager.getUserName());
        assertEquals("", emptyManager.getPassword());
        assertEquals("Manager", emptyManager.getRole());
    }
    
    @Test
    public void testManagerWithNullCredentials() {
        Manager nullManager = new Manager(null, null);
        assertNull(nullManager.getUserName());
        assertNull(nullManager.getPassword());
        assertEquals("Manager", nullManager.getRole());
    }
    
    @Test
    public void testManagerWithSpecialCharacters() {
        String specialChars = "!@#$%^&*()_+";
        Manager specialManager = new Manager(specialChars, specialChars);
        assertEquals(specialChars, specialManager.getUserName());
        assertEquals(specialChars, specialManager.getPassword());
    }
    
    @Test
    public void testManagerWithLongCredentials() {
        // Create a very long string
        StringBuilder longString = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longString.append("a");
        }
        String longCredential = longString.toString();
        
        Manager longManager = new Manager(longCredential, longCredential);
        assertEquals(longCredential, longManager.getUserName());
        assertEquals(longCredential, longManager.getPassword());
        assertEquals(1000, longManager.getUserName().length());
    }
    
    @Test
    public void testManagerWithWhitespaceCredentials() {
        String whitespace = "   ";
        Manager whitespaceManager = new Manager(whitespace, whitespace);
        assertEquals(whitespace, whitespaceManager.getUserName());
        assertEquals(whitespace, whitespaceManager.getPassword());
    }
    
    @Test
    public void testManagerEquality() {
        Manager manager1 = new Manager("testManager", "testPassword");
        Manager manager2 = new Manager("testManager", "testPassword");
        Manager manager3 = new Manager("differentManager", "testPassword");
        
        // Java default equality compares references, not values
        assertNotEquals(manager1, manager2);
        assertNotEquals(manager1, manager3);
    }
}