package test.java.businessLogic;

import main.java.businessLogic.SystemDatabaseFacade;
import main.java.objects.*;
import org.junit.jupiter.api.Test;

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
        assertEquals(retrievedClient, newClient);
    }

    @Test
    void testRemoveClient() throws Exception {
        Client clientToRemove = new Visitor("alice.smith@example.com","aA1!");
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addClient(clientToRemove);
        systemFacade.removeClient(clientToRemove);

        Client retrievedClient = systemFacade.getClientInfo("alice.smith@example.com");
        assertNull(retrievedClient); 
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
        systemFacade.removeParkingLot(parkingLot);

        ParkingLot retrievedLot = systemFacade.getParkingLotInfo("Test Lot");
        assertNull(retrievedLot); 
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
    void testEditBooking() throws Exception {
        Client client = new Visitor("visitor@example.com", "aA1!");
        ParkingLot parkingLot = new ParkingLot("Test Lot","Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);
        systemFacade.addClient(client);

        systemFacade.bookParkingSpace("visitor@example.com", "Test Lot", 3, 30, 10, new Date(), 12, 2, "ABCD123");

        boolean editResult = systemFacade.editBooking(1, "Test Lot", 3, 15, new Date(), 3, client, "ABCD123");

        assertTrue(editResult);
    }

    @Test
    void testCancelBooking() throws Exception {
        Client client = new Visitor("visitor@example.com", "aA1!");
        ParkingLot parkingLot = new ParkingLot("Test Lot", "Keele Campus", 10);
        SystemDatabaseFacade systemFacade = SystemDatabaseFacade.getInstance();

        systemFacade.addNewParkingLot(parkingLot);
        systemFacade.addClient(client);

        systemFacade.bookParkingSpace("visitor@example.com", "Test Lot", 2, 20, 10, new Date(), 12, 2, "ABCD123");

        boolean cancelResult = systemFacade.cancelBooking(1, false);

        assertTrue(cancelResult);
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