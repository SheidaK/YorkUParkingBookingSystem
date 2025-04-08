package businessLogic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Field;
import java.util.ArrayList;

import objects.Manager;
import objects.SuperManager;

public class ManagementSystemTest {
    private ManagementSystem managementSystem;
    
    @Before
    public void setUp() throws Exception {
        // Reset the singleton if it exists
        resetSingleton();
        
        // Get a fresh instance
        managementSystem = ManagementSystem.getInstance();
    }
    
    @After
    public void tearDown() throws Exception {
        resetSingleton();
    }
    
    private void resetSingleton() throws Exception {
        // Use reflection to reset the singleton instance
        Field instance = ManagementSystem.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        
        // Also reset managers list if needed
        Field managers = ManagementSystem.class.getDeclaredField("managers");
        managers.setAccessible(true);
        managers.set(null, new ArrayList<Manager>());
    }
    
    @Test
    public void testGetInstance() throws Exception {
        ManagementSystem instance1 = ManagementSystem.getInstance();
        ManagementSystem instance2 = ManagementSystem.getInstance();
        
        // Verify singleton pattern
        assertSame(instance1, instance2);
    }
    
    @Test
    public void testInitialization() throws Exception {
        // Verify managers list is initialized
        ArrayList<Manager> managers = managementSystem.getManager();
        assertNotNull(managers);
        // Size will depend on your database setup, so just check it's not null
    }
    
    @Test
    public void testAddAndRemoveManager() throws Exception {
        // Get initial size
        int initialSize = managementSystem.getManager().size();
        
        // Create a unique manager that won't conflict with existing ones
        String uniqueUsername = "testManager" + System.currentTimeMillis();
        Manager newManager = new Manager(uniqueUsername, "testPassword");
        
        // Add manager
        ArrayList<Manager> updatedManagers = managementSystem.addManager(newManager);
        assertEquals(initialSize + 1, updatedManagers.size());
        
        // Verify manager is in the list
        boolean found = false;
        for (Manager m : updatedManagers) {
            if (m.getUserName().equals(uniqueUsername)) {
                found = true;
                break;
            }
        }
        assertTrue("Added manager should be in the list", found);
        
        // Remove manager
        ArrayList<Manager> afterRemoval = managementSystem.removeManager(uniqueUsername);
        assertEquals(initialSize, afterRemoval.size());
        
        // Verify manager is removed
        boolean stillFound = false;
        for (Manager m : afterRemoval) {
            if (m.getUserName().equals(uniqueUsername)) {
                stillFound = true;
                break;
            }
        }
        assertFalse("Removed manager should not be in the list", stillFound);
    }
    
    @Test
    public void testGetManagerInfo() throws Exception {
        // Add a test manager
        String uniqueUsername = "testManager" + System.currentTimeMillis();
        Manager newManager = new Manager(uniqueUsername, "testPassword");
        managementSystem.addManager(newManager);
        
        // Get manager info
        Manager retrieved = managementSystem.getManagerInfo(uniqueUsername);
        
        // Verify correct manager was retrieved
        assertNotNull("Manager should be found", retrieved);
        assertEquals(uniqueUsername, retrieved.getUserName());
        assertEquals("testPassword", retrieved.getPassword());
        
        // Clean up
        managementSystem.removeManager(uniqueUsername);
    }
    
    @Test
    public void testGetManagerInfoWithTrimming() throws Exception {
        // Add a test manager
        String uniqueUsername = "testManager" + System.currentTimeMillis();
        Manager newManager = new Manager(uniqueUsername, "testPassword");
        managementSystem.addManager(newManager);
        
        // Get manager info with spaces around the username
        Manager retrieved = managementSystem.getManagerInfo("  " + uniqueUsername + "  ");
        
        // Verify correct manager was retrieved
        assertNotNull("Manager should be found even with spaces", retrieved);
        assertEquals(uniqueUsername, retrieved.getUserName());
        
        // Clean up
        managementSystem.removeManager(uniqueUsername);
    }
    
    @Test
    public void testGetManagerInfoNonExistent() throws Exception {
        // Try to get a manager that doesn't exist
        Manager manager = managementSystem.getManagerInfo("nonExistentManager" + System.currentTimeMillis());
        
        // Verify manager was not found
        assertNull(manager);
    }
    
    @Test
    public void testRemoveNonExistentManager() throws Exception {
        // Get initial size
        int initialSize = managementSystem.getManager().size();
        
        // Try to remove a manager that doesn't exist
        ArrayList<Manager> updatedManagers = managementSystem.removeManager("nonExistentManager" + System.currentTimeMillis());
        
        // Size should not change
        assertEquals(initialSize, updatedManagers.size());
    }
    
    @Test
    public void testIsSuperManager() throws Exception {
        // Test with superManager username
        boolean isSuperManager = managementSystem.isSuperManager("superManager");
        assertTrue(isSuperManager);
        
        // Test with regular manager username
        String regularManagerName = "regularManager" + System.currentTimeMillis();
        Manager regularManager = new Manager(regularManagerName, "password");
        managementSystem.addManager(regularManager);
        
        boolean isNotSuperManager = managementSystem.isSuperManager(regularManagerName);
        assertFalse(isNotSuperManager);
        
        // Clean up
        managementSystem.removeManager(regularManagerName);
    }
    
    @Test
    public void testMultipleManagersAddition() throws Exception {
        // Get initial size
        int initialSize = managementSystem.getManager().size();
        
        // Add multiple managers
        String username1 = "testManager1" + System.currentTimeMillis();
        String username2 = "testManager2" + System.currentTimeMillis();
        String username3 = "testManager3" + System.currentTimeMillis();
        
        Manager manager1 = new Manager(username1, "password1");
        Manager manager2 = new Manager(username2, "password2");
        Manager manager3 = new Manager(username3, "password3");
        
        managementSystem.addManager(manager1);
        managementSystem.addManager(manager2);
        managementSystem.addManager(manager3);
        
        // Verify all managers were added
        ArrayList<Manager> updatedManagers = managementSystem.getManager();
        assertEquals(initialSize + 3, updatedManagers.size());
        
        // Clean up
        managementSystem.removeManager(username1);
        managementSystem.removeManager(username2);
        managementSystem.removeManager(username3);
    }
    
    @Test
    public void testManagerAdditionWithSameNameDifferentCase() throws Exception {
        // Get initial size
        int initialSize = managementSystem.getManager().size();
        
        // Add a manager with a unique name
        String baseName = "testManager" + System.currentTimeMillis();
        String lowerName = baseName.toLowerCase();
        String upperName = baseName.toUpperCase();
        
        // Add manager with lowercase name
        Manager lowerManager = new Manager(lowerName, "password1");
        managementSystem.addManager(lowerManager);
        
        // Add manager with uppercase name (should be considered different)
        Manager upperManager = new Manager(upperName, "password2");
        ArrayList<Manager> updatedManagers = managementSystem.addManager(upperManager);
        
        // Since usernames are case-sensitive in this system, both should be added
        assertEquals(initialSize + 2, updatedManagers.size());
        
        // Verify both managers exist with correct passwords
        Manager retrievedLower = managementSystem.getManagerInfo(lowerName);
        Manager retrievedUpper = managementSystem.getManagerInfo(upperName);
        
        assertNotNull(retrievedLower);
        assertNotNull(retrievedUpper);
        assertEquals("password1", retrievedLower.getPassword());
        assertEquals("password2", retrievedUpper.getPassword());
        
        // Clean up
        managementSystem.removeManager(lowerName);
        managementSystem.removeManager(upperName);
    }
}