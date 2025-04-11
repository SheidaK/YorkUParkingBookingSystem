package businessLogic;
import businessLogic.SystemDatabaseFacade;
import objects.*;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SystemDatabaseFacadeTest {

    @Test
    void testAddClient() throws Exception {
        Client newClient = new Visitor("alice.smith@example.com", "aA1!");
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addClient(newClient);

        Client retrievedClient = systemFacade.getClientInfo("alice.smith@example.com");
        assertNotNull(retrievedClient);
        assertEquals(retrievedClient.getEmail(), newClient.getEmail());
    }

    @Test
    void testRemoveClient() throws Exception {
        Client clientToRemove = new Visitor("alice.smith@example.com", "aA1!");
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addClient(clientToRemove);

        systemFacade.removeClient(clientToRemove);
        Client retrievedClient = systemFacade.getClientInfo("alice.smith@example.com");
		assertNotEquals(clientToRemove, retrievedClient);
    }
    
    @Test
    void testApproveUser() throws Exception {
        Client client = new Visitor("alice.smith@example.com", "aA1!");
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addClient(client);
       
        boolean result = systemFacade.approveUser(client);
        
        assertTrue(result);
    }
    
    @Test
    void testApproveUser_Fail() throws Exception {
        Client client = new Visitor("alice.smith@example.com", "aA1!");
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();
        
        boolean result = systemFacade.approveUser(client);
        assertFalse(result);
    }

    @Test
    void testAddParkingLot() {
        ParkingLot newParkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(newParkingLot);

        ParkingLot retrievedLot = systemFacade.getParkingLotInfo("Test Lot");
        assertNotNull(retrievedLot);
        assertEquals("Test Lot", retrievedLot.getName());
    }

    @Test
    void testRemoveParkingLot() {
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);
        
        systemFacade.removeParkingLot(parkingLot.getName());

        ParkingLot retrievedLot = systemFacade.getParkingLotInfo("Test Lot");
        assertNotEquals(retrievedLot, parkingLot);
    }
    
    @Test
    void testStatusParkingLot_Enabled() {
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);
        
        boolean result = systemFacade.statusParkingLot("Test Lot", true);
        assertTrue(result);
    }

    @Test
    void testBookParkingSpace() throws Exception {
        Client client = new Visitor("visitor@example.com", "aA1!");
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);
        systemFacade.addClient(client);

        boolean bookingResult = systemFacade.bookParkingSpace("visitor@example.com", "Test Lot", 5, 20, 10, new Date(), 12, 2, "ABC123");

        assertTrue(bookingResult);
    }
    
    @Test
    void testCancelBooking() throws Exception {
        Client client = new Visitor("visitor@example.com", "aA1!");
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();
        Date testDate = new SimpleDateFormat("MM/dd/yyyy").parse("04/04/2026");

        systemFacade.addNewParkingLot(parkingLot);
        systemFacade.addClient(client);
        
        int bookingId = systemFacade.generateBookingID();
        systemFacade.bookParkingSpace("visitor@example.com", "Test Lot", 2, 20, 10, testDate, 12, 2, "ABCD123");
        boolean cancelResult = systemFacade.cancelBooking(bookingId, false);

        assertTrue(cancelResult);
    }

    @Test
    void testEditBooking() throws Exception {
        Client client = new Visitor("visitor@example.com", "aA1!");
        ParkingLot parkingLot = new ParkingLot("Test Lot","Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();
        Date testDate = new SimpleDateFormat("MM/dd/yyyy").parse("04/04/2026");

        systemFacade.addNewParkingLot(parkingLot);
        systemFacade.addClient(client);
        
        int bookingId = systemFacade.generateBookingID();
        systemFacade.bookParkingSpace("visitor@example.com", "Test Lot", 3, 30, 10, testDate, 12, 2, "ABCD123");
        boolean editResult = systemFacade.editBooking(bookingId, "Test Lot", 2, 30, testDate, 3, client, "ABCD123");

        assertTrue(editResult);
    }
    
    @Test
    void testGenerateBookingID() {
    	SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();
    	int bookingId = systemFacade.generateBookingID();
    	assertNotNull(bookingId);
    }
    
    @Test
    void testExtendBooking() throws Exception {
        Client client = new Visitor("visitor@example.com", "aA1!");
        ParkingLot parkingLot = new ParkingLot("Test Lot","Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();
        Date testDate = new SimpleDateFormat("MM/dd/yyyy").parse("04/04/2026");

        systemFacade.addNewParkingLot(parkingLot);
        systemFacade.addClient(client);
        
        int bookingId = systemFacade.generateBookingID();
        systemFacade.bookParkingSpace("visitor@example.com", "Test Lot", 3, 30, 10, testDate, 12, 2, "ABCD123");
        boolean extendResult = systemFacade.extendBooking(bookingId,testDate, 10 ,3);

        assertTrue(extendResult);    
        }
    

    @Test
    void testRevenueCalculation() {
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        int initialRevenue = systemFacade.getRevenue();
        systemFacade.addRevenue(50);

        assertEquals(initialRevenue + 50, systemFacade.getRevenue()); 
    }

    @Test
    void testParkingSpaceAvailability() {
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);

        List<ParkingSpace> availableSpaces = systemFacade.getAvailableSpaces(parkingLot);

        assertNotNull(availableSpaces);
        assertTrue(availableSpaces.size() > 0); 
    }

    @Test
    void testDisableParkingSpace() {
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);

        systemFacade.disableParkingSpace(parkingLot, 3);

        ParkingSpace disabledSpace = parkingLot.findSpaceById(3);
        assertFalse(disabledSpace.isEnabled());
    }
}