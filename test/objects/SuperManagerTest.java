package objects;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.lang.reflect.Field;
import java.util.regex.Pattern;


public class SuperManagerTest {
    private SuperManager superManager;
    
    @Before
    public void setUp() throws Exception {
        // Reset the singleton before each test
        resetSingleton();
        
        // Get a new instance
        superManager = SuperManager.getInstance();
    }
    
    @After
    public void tearDown() throws Exception {
        resetSingleton();
    }
    
    private void resetSingleton() throws Exception {
        Field instance = SuperManager.class.getDeclaredField("supermanager");
        instance.setAccessible(true);
        instance.set(null, null);
        
        // Reset the manager ID counter for predictable tests
        Field managerIdField = SuperManager.class.getDeclaredField("managerID");
        managerIdField.setAccessible(true);
        managerIdField.set(null, 1);
    }
    
    @Test
    public void testGetInstance() {
        SuperManager instance1 = SuperManager.getInstance();
        SuperManager instance2 = SuperManager.getInstance();
        
        // Verify singleton pattern
        assertSame(instance1, instance2);
    }
    
    @Test
    public void testConstructor() {
        // Test that constructor properly initializes fields via parent
        assertEquals("superManager", superManager.getUserName());
        assertEquals("ParkingS25!", superManager.getPassword());
    }
    
    @Test
    public void testGetUserName() {
        assertEquals("superManager", superManager.getUserName());
    }
    
    @Test
    public void testGetRole() {
        assertEquals("Super Manager", superManager.getRole());
    }
    
    @Test
    public void testGenerateManagerAccountUsername() {
        // First call should generate "Manager1"
        String[] account1 = superManager.generateManagerAccount();
        assertEquals("Manager1", account1[0]);
        
        // Second call should generate "Manager2"
        String[] account2 = superManager.generateManagerAccount();
        assertEquals("Manager2", account2[0]);
        
        // Third call should generate "Manager3"
        String[] account3 = superManager.generateManagerAccount();
        assertEquals("Manager3", account3[0]);
    }
    
    @Test
    public void testGenerateManagerAccountPasswordLength() {
        String[] account = superManager.generateManagerAccount();
        String password = account[1];
        
        // Password should be exactly 16 characters (4 chars from each category)
        assertEquals(16, password.length());
    }
    
    @Test
    public void testGenerateManagerAccountPasswordComplexity() {
        String[] account = superManager.generateManagerAccount();
        String password = account[1];
        
        // Password should contain at least one lowercase letter
        assertTrue(Pattern.compile("[a-z]").matcher(password).find());
        
        // Password should contain at least one uppercase letter
        assertTrue(Pattern.compile("[A-Z]").matcher(password).find());
        
        // Password should contain at least one digit
        assertTrue(Pattern.compile("[0-9]").matcher(password).find());
        
        // Password should contain at least one special character
        assertTrue(Pattern.compile("[!@#$%^&*()\\-_=+\\[\\]{}|;:,.<>?]").matcher(password).find());
    }
    
    @Test
    public void testGenerateManagerAccountMultipleAccounts() {
        // Generate multiple accounts and verify they're all different
        String[] account1 = superManager.generateManagerAccount();
        String[] account2 = superManager.generateManagerAccount();
        String[] account3 = superManager.generateManagerAccount();
        
        // Usernames should be different
        assertNotEquals(account1[0], account2[0]);
        assertNotEquals(account2[0], account3[0]);
        assertNotEquals(account1[0], account3[0]);
        
        // Passwords should be different
        assertNotEquals(account1[1], account2[1]);
        assertNotEquals(account2[1], account3[1]);
        assertNotEquals(account1[1], account3[1]);
    }
    
    @Test
    public void testGenenratedPasswordsAreUnique() {
        // Generate multiple accounts and verify passwords are unique
        String[] account1 = superManager.generateManagerAccount();
        String[] account2 = superManager.generateManagerAccount();
        String[] account3 = superManager.generateManagerAccount();
        String[] account4 = superManager.generateManagerAccount();
        String[] account5 = superManager.generateManagerAccount();
        
        // Create an array of all passwords
        String[] passwords = {
            account1[1], account2[1], account3[1], account4[1], account5[1]
        };
        
        // Check each pair of passwords for uniqueness
        for (int i = 0; i < passwords.length; i++) {
            for (int j = i + 1; j < passwords.length; j++) {
                assertNotEquals(passwords[i], passwords[j]);
            }
        }
    }
    
    @Test
    public void testSuperManagerInheritance() {
        // Verify SuperManager is a subclass of Manager
        assertTrue(superManager instanceof Manager);
    }
    
    @Test
    public void testManagerIncrementingID() {
        // Generate accounts and verify the username contains incrementing IDs
        String[] account1 = superManager.generateManagerAccount();
        assertEquals("Manager1", account1[0]);
        
        String[] account2 = superManager.generateManagerAccount();
        assertEquals("Manager2", account2[0]);
        
        String[] account3 = superManager.generateManagerAccount();
        assertEquals("Manager3", account3[0]);
    }
    
    @Test
    public void testGenerateManagerAccountReturnType() {
        String[] account = superManager.generateManagerAccount();
        
        // Should return an array with exactly 2 elements
        assertEquals(2, account.length);
        
        // Both elements should be non-null strings
        assertNotNull(account[0]);
        assertNotNull(account[1]);
        assertTrue(account[0] instanceof String);
        assertTrue(account[1] instanceof String);
    }
}