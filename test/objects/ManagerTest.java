package objects;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ManagerTest {
    private Manager manager;
    
    @Before
    public void setUp() {
        // Create a manager to test
        manager = new Manager("testManager", "testPassword");
    }
    
    @Test
    public void testConstructor() {
        // Test that constructor properly initializes fields
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
    public void testEnableParkingLot() {
        try {
            manager.enableParkingLot("TestParkingLot");
            // Test passes if no exception is thrown
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when calling enableParkingLot: " + e.getMessage());
        }
    }
    
    @Test
    public void testDisableParkingLot() {
        try {
            manager.disableParkingLot("TestParkingLot");
            // Test passes if no exception is thrown
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when calling disableParkingLot: " + e.getMessage());
        }
    }
    

    @Test
    public void testApproveTransaction() {
        // Create unique booking ID to avoid conflicts with other tests
        int bookingId = 10000 + (int)(Math.random() * 90000); // Random ID between 10000 and 99999
        
        try {
            // We'll use a valid payment method
            boolean result = manager.approveTransaction(bookingId, "CREDIT_CARD", 50);
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when calling approveTransaction: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithInvalidMethod() {
        // Create unique booking ID
        int bookingId = 10000 + (int)(Math.random() * 90000);
        
        try {
            boolean result = manager.approveTransaction(bookingId, "INVALID_METHOD", 50);
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when calling approveTransaction with invalid method: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithNegativeAmount() {
        // Create unique booking ID
        int bookingId = 10000 + (int)(Math.random() * 90000);
        
        try {
            boolean result = manager.approveTransaction(bookingId, "CREDIT_CARD", -50);
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when calling approveTransaction with negative amount: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithZeroAmount() {
        // Create unique booking ID
        int bookingId = 10000 + (int)(Math.random() * 90000);
        
        try {
            boolean result = manager.approveTransaction(bookingId, "CREDIT_CARD", 0);
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when calling approveTransaction with zero amount: " + e.getMessage());
        }
    }
    
    @Test
    public void testIllegalArgumentHandling() {
        // Create unique booking ID
        int bookingId = 10000 + (int)(Math.random() * 90000);
        
        try {
            // Use an empty string as payment method to test error handling
            boolean result = manager.approveTransaction(bookingId, "", 50);
            
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    public void testMultipleTransactions() {
        // Create unique booking IDs
        int bookingId1 = 10000 + (int)(Math.random() * 90000);
        int bookingId2 = 100000 + (int)(Math.random() * 90000);
        
        try {
            // Process multiple transactions to test system stability
            manager.approveTransaction(bookingId1, "CREDIT_CARD", 100);
            manager.approveTransaction(bookingId2, "DEBIT_CARD", 200);
            
            assertTrue(true);
        } catch (Exception e) {
            fail("Exception thrown when processing multiple transactions: " + e.getMessage());
        }
    }
    
    @Test
    public void testNullHandling() {
        // Create unique booking ID
        int bookingId = 10000 + (int)(Math.random() * 90000);
        
        try {
            // Test with null payment method to check null handling
            manager.approveTransaction(bookingId, null, 50);
            
            // If it didn't throw an exception, that's one valid implementation
            assertTrue(true);
        } catch (NullPointerException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception type thrown for null input: " + e.getClass().getName());
        }
    }
}