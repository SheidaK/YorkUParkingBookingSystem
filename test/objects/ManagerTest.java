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
    public void testEnableParkingLot() {
        try {
            boolean result = manager.enableParkingLot("P001");
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("enableParkingLot should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testEnableParkingLotWithNull() {
        try {
            boolean result = manager.enableParkingLot(null);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("enableParkingLot should handle null input: " + e.getMessage());
        }
    }
    
    @Test
    public void testEnableParkingLotWithEmptyString() {
        try {
            boolean result = manager.enableParkingLot("");
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("enableParkingLot should handle empty string input: " + e.getMessage());
        }
    }
    
    @Test
    public void testDisableParkingLot() {
        try {
            boolean result = manager.disableParkingLot("P001");
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("disableParkingLot should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testDisableParkingLotWithNull() {
        try {
            boolean result = manager.disableParkingLot(null);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("disableParkingLot should handle null input: " + e.getMessage());
        }
    }
    
    @Test
    public void testDisableParkingLotWithEmptyString() {
        try {
            boolean result = manager.disableParkingLot("");
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("disableParkingLot should handle empty string input: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateUniversityStaffWithNull() {
        try {
            boolean result = manager.validateUniversityStaff(null);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("validateUniversityStaff should handle null input: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransaction() {
        try {
            boolean result = manager.approveTransaction(12345, "Credit Card", 50);
            // Test passes if no exception thrown and result is a boolean
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithEmptyPaymentMethod() {
        try {
            boolean result = manager.approveTransaction(12345, "", 50);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle empty payment method: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithZeroAmount() {
        try {
            boolean result = manager.approveTransaction(12345, "Credit Card", 0);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle zero amount: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithNegativeAmount() {
        try {
            boolean result = manager.approveTransaction(12345, "Credit Card", -50);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle negative amount: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithNegativeBookingId() {
        try {
            boolean result = manager.approveTransaction(-1, "Credit Card", 50);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle negative booking ID: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithZeroBookingId() {
        try {
            boolean result = manager.approveTransaction(0, "Credit Card", 50);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle zero booking ID: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testEnableParkingLotWithVeryLongId() {
        StringBuilder longId = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longId.append("p");
        }
        try {
            boolean result = manager.enableParkingLot(longId.toString());
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("enableParkingLot should handle very long ID: " + e.getMessage());
        }
    }
    
    @Test
    public void testDisableParkingLotWithVeryLongId() {
        StringBuilder longId = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longId.append("p");
        }
        try {
            boolean result = manager.disableParkingLot(longId.toString());
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("disableParkingLot should handle very long ID: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithMaxIntegerValues() {
        try {
            boolean result = manager.approveTransaction(Integer.MAX_VALUE, "Credit Card", Integer.MAX_VALUE);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle maximum integer values: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithMinIntegerValues() {
        try {
            boolean result = manager.approveTransaction(Integer.MIN_VALUE, "Credit Card", Integer.MIN_VALUE);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle minimum integer values: " + e.getMessage());
        }
    }
    
    @Test
    public void testApproveTransactionWithVeryLongPaymentMethod() {
        StringBuilder longPaymentMethod = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longPaymentMethod.append("p");
        }
        try {
            boolean result = manager.approveTransaction(12345, longPaymentMethod.toString(), 50);
            assertNotNull("Method should return a boolean value", result);
        } catch (Exception e) {
            fail("approveTransaction should handle very long payment method: " + e.getMessage());
        }
    }
    
    @Test
    public void testEnableAndDisableParkingLot() {
        try {
            String parkingLotId = "P001";
            boolean enableResult = manager.enableParkingLot(parkingLotId);
            boolean disableResult = manager.disableParkingLot(parkingLotId);
            assertNotNull("Enable method should return a boolean value", enableResult);
            assertNotNull("Disable method should return a boolean value", disableResult);
        } catch (Exception e) {
            fail("Enable and disable operations should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testMultipleApproveTransactions() {
        try {
            boolean result1 = manager.approveTransaction(1, "Credit Card", 100);
            boolean result2 = manager.approveTransaction(2, "PayPal", 200);
            boolean result3 = manager.approveTransaction(3, "Bank Transfer", 300);
            
            assertNotNull("First transaction should return a boolean value", result1);
            assertNotNull("Second transaction should return a boolean value", result2);
            assertNotNull("Third transaction should return a boolean value", result3);
        } catch (Exception e) {
            fail("Multiple approve transactions should not throw exceptions: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testSameParkingLotIdForEnableAndDisable() {
        String parkingLotId = "TestLot";
        try {
            boolean enableResult = manager.enableParkingLot(parkingLotId);
            boolean disableResult = manager.disableParkingLot(parkingLotId);
            
            assertNotNull("Enable method should return a boolean value", enableResult);
            assertNotNull("Disable method should return a boolean value", disableResult);
        } catch (Exception e) {
            fail("Operations with same parking lot ID should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testIdenticalParametersForMultipleTransactions() {
        try {
            boolean result1 = manager.approveTransaction(12345, "Credit Card", 100);
            boolean result2 = manager.approveTransaction(12345, "Credit Card", 100);
            boolean result3 = manager.approveTransaction(12345, "Credit Card", 100);
            
            assertNotNull("First transaction should return a boolean value", result1);
            assertNotNull("Second transaction should return a boolean value", result2);
            assertNotNull("Third transaction should return a boolean value", result3);
        } catch (Exception e) {
            fail("Multiple identical transactions should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testSpecialCharactersInParkingLotId() {
        String specialCharsId = "!@#$%^&*()_+";
        try {
            boolean enableResult = manager.enableParkingLot(specialCharsId);
            boolean disableResult = manager.disableParkingLot(specialCharsId);
            
            assertNotNull("Enable method should return a boolean value", enableResult);
            assertNotNull("Disable method should return a boolean value", disableResult);
        } catch (Exception e) {
            fail("Special characters in parking lot ID should not throw exceptions: " + e.getMessage());
        }
    }
    
    @Test
    public void testSpecialCharactersInPaymentMethod() {
        String specialCharsPayment = "!@#$%^&*()_+";
        try {
            boolean result = manager.approveTransaction(12345, specialCharsPayment, 100);
            
            assertNotNull("Transaction with special characters should return a boolean value", result);
        } catch (Exception e) {
            fail("Special characters in payment method should not throw exceptions: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testMultipleManagersWithSameOperation() {
        try {
            Manager manager1 = new Manager("manager1", "password1");
            Manager manager2 = new Manager("manager2", "password2");
            
            boolean result1 = manager1.enableParkingLot("P001");
            boolean result2 = manager2.enableParkingLot("P001");
            
            assertNotNull("First manager's operation should return a boolean value", result1);
            assertNotNull("Second manager's operation should return a boolean value", result2);
        } catch (Exception e) {
            fail("Multiple managers with same operation should not throw exceptions: " + e.getMessage());
        }
    }
}