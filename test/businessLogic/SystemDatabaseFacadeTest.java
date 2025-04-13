package businessLogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.Manager;
import objects.ParkingLot;
import objects.ParkingSpace;
import objects.Student;
import objects.SuperManager;
import objects.Visitor;

class SystemDatabaseFacadeTest {
    
    private SystemDatabaseFacade facade;
    private Client testClient;
    private Manager testManager;
    private ParkingLot testLot;
    private int initialRevenue;
    
    @BeforeEach
    void setUp() throws Exception {
        facade = SystemDatabaseFacade.getInstance();
        testClient = new Visitor("test@example.com", "password");
        testManager = new Manager("testManager", "password");
        testLot = new ParkingLot("TestLot", "Test Location", 5);
        initialRevenue = facade.getRevenue();
    }
    
    @Test
    void testGetInstance() {
        SystemDatabaseFacade instance1 = SystemDatabaseFacade.getInstance();
        SystemDatabaseFacade instance2 = SystemDatabaseFacade.getInstance();
        assertSame(instance1, instance2);
    }
    
    @Test
    void testGetClients() {
        ArrayList<Client> clients = facade.getClients();
        assertNotNull(clients);
    }
    
    @Test
    void testAddAndRemoveClient() throws Exception {
        int initialSize = facade.getClients().size();
        facade.addClient(testClient);
        assertEquals(initialSize + 1, facade.getClients().size());
        
        facade.removeClient(testClient);
        assertEquals(initialSize, facade.getClients().size());
    }
    
    @Test
    void testGetClientInfo() throws Exception {
        facade.addClient(testClient);
        Client retrievedClient = facade.getClientInfo("test@example.com");
        assertNotNull(retrievedClient);
        assertEquals("test@example.com", retrievedClient.getEmail());
        facade.removeClient(testClient);
    }
    
    @Test
    void testGetClientInfoNonExistent() {
        Client retrievedClient = facade.getClientInfo("nonexistent@example.com");
        assertNull(retrievedClient);
    }
    
    @Test
    void testRegisterValidation() {
        boolean result = facade.registerValidation(testClient);
        assertTrue(result);
    }
    
    @Test
    void testApproveUserSuccess() throws Exception {
        facade.addClient(testClient);
        boolean result = facade.approveUser(testClient);
        assertTrue(result);
        assertTrue(testClient.isValidated());
        facade.removeClient(testClient);
    }
    
    @Test
    void testApproveUserFailure() {
        Client nonExistentClient = new Student("nonexistent@example.com", "password");
        boolean result = facade.approveUser(nonExistentClient);
        assertFalse(result);
    }
    
    @Test
    void testChangeValidationStatus() throws Exception {
        facade.addClient(testClient);
        facade.changeValidationStatus("test@example.com", "Validated");
        Client retrievedClient = facade.getClientInfo("test@example.com");
        assertTrue(retrievedClient.isValidated());
        
        facade.changeValidationStatus("test@example.com", "NotValidated");
        retrievedClient = facade.getClientInfo("test@example.com");
        assertFalse(retrievedClient.isValidated());
        
        facade.removeClient(testClient);
    }
    
    @Test
    void testGetAvailableLots() {
        ArrayList<ParkingLot> lots = facade.getAvailableLots();
        assertNotNull(lots);
    }
    
    @Test
    void testAddAndRemoveParkingLot() {
        int initialSize = facade.getAvailableLots().size();
        
        facade.addNewParkingLot(testLot);
        assertEquals(initialSize + 1, facade.getAvailableLots().size());
        
        facade.removeParkingLot(testLot);
        assertEquals(initialSize, facade.getAvailableLots().size());
    }
    
    @Test
    void testGetParkingLotInfo() {
        facade.addNewParkingLot(testLot);
        ParkingLot retrievedLot = facade.getParkingLotInfo("TestLot");
        assertNotNull(retrievedLot);
        assertEquals("TestLot", retrievedLot.getName());
        facade.removeParkingLot(testLot);
    }
    
    @Test
    void testGetParkingLotInfoNonExistent() {
        ParkingLot retrievedLot = facade.getParkingLotInfo("NonExistentLot");
        assertNull(retrievedLot);
    }
    
    @Test
    void testStatusParkingLot() {
        facade.addNewParkingLot(testLot);
        boolean result = facade.statusParkingLot("TestLot", false);
        assertTrue(result);
        
        ParkingLot retrievedLot = facade.getParkingLotInfo("TestLot");
        assertFalse(retrievedLot.isEnabled());
        
        result = facade.statusParkingLot("TestLot", true);
        assertTrue(result);
        
        retrievedLot = facade.getParkingLotInfo("TestLot");
        assertTrue(retrievedLot.isEnabled());
        
        facade.removeParkingLot(testLot);
    }
    
    @Test
    void testStatusParkingLotNonExistent() {
        boolean result = facade.statusParkingLot("NonExistentLot", true);
        assertFalse(result);
    }
    
    @Test
    void testRemoveParkingLotByName() {
        ParkingLot testLot1 = new ParkingLot("TestLot1", "Test Location", 5);
        facade.addNewParkingLot(testLot1);
        boolean result = facade.removeParkingLot("TestLot1");
        assertTrue(result);
        assertNull(facade.getParkingLotInfo("TestLot1"));
        facade.removeParkingLot(testLot1);
    }
    
    @Test
    void testRemoveParkingLotNonExistent() {
        boolean result = facade.removeParkingLot("NonExistentLot");
        assertFalse(result);
    }
    
    @Test
    void testEnableAndDisableParkingSpace() {
        facade.addNewParkingLot(testLot);
        
        facade.enableParkingSpace(testLot, 1);
        assertTrue(testLot.findSpaceById(1).isEnabled());
        
        facade.disableParkingSpace(testLot, 1);
        assertFalse(testLot.findSpaceById(1).isEnabled());
        
        facade.removeParkingLot(testLot);
    }
    
    @Test
    void testGetAvailableSpaces() {
        facade.addNewParkingLot(testLot);

        java.util.List<ParkingSpace> spaces = facade.getAvailableSpaces(testLot);
        assertNotNull(spaces);
        assertTrue(spaces.contains(testLot.findSpaceById(1)));
        
        facade.removeParkingLot(testLot);
    }
    
    @Test
    void testGetManagers() {
        ArrayList<Manager> managers = facade.getManagers();
        assertNotNull(managers);
    }
    
    @Test
    void testSetManagers() {
        ArrayList<Manager> newManagers = new ArrayList<>();
        newManagers.add(testManager);
        
        ArrayList<Manager> originalManagers = new ArrayList<>(facade.getManagers());
        facade.setManagers(newManagers);
        
        ArrayList<Manager> retrievedManagers = facade.getManagers();
        assertTrue(retrievedManagers.contains(testManager));
        
        facade.setManagers(originalManagers);
    }
    
    @Test
    void testAddAndRemoveManager() {
        int initialSize = facade.getManagers().size();
        
        facade.addManager(testManager);
        assertEquals(initialSize + 1, facade.getManagers().size());
        
        facade.removeManager(testManager.getUserName());
        assertEquals(initialSize, facade.getManagers().size());
    }
    
    @Test
    void testGetManagerInfo() {
        facade.addManager(testManager);
        Manager retrievedManager = facade.getManagerInfo("testManager");
        assertNotNull(retrievedManager);
        assertEquals("testManager", retrievedManager.getUserName());
        facade.removeManager("testManager");
    }
    
    @Test
    void testGetManagerInfoNonExistent() {
        Manager retrievedManager = facade.getManagerInfo("nonExistentManager");
        assertNull(retrievedManager);
    }
    
    @Test
    void testIsSuperManager() {
        boolean result = facade.isSuperManager("superManager");
        assertTrue(result);
        
        result = facade.isSuperManager(testManager.getUserName());
        assertFalse(result);
    }
    
    @Test
    void testAddRevenue() {
        int initialRevenue = facade.getRevenue();
        
        SystemDatabaseFacade.addRevenue(100);
        assertEquals(initialRevenue + 100, facade.getRevenue());
        
        facade.setRevenue(initialRevenue);
    }
    
    @Test
    void testRemoveRevenue() {
        int initialRevenue = facade.getRevenue();
        
        facade.removeRevenue(50);
        assertEquals(initialRevenue - 50, facade.getRevenue());
        
        facade.setRevenue(initialRevenue);
    }
    
    @Test
    void testSetRevenue() {
        int initialRevenue = facade.getRevenue();
        
        facade.setRevenue(1000);
        assertEquals(1000, facade.getRevenue());
        
        facade.setRevenue(initialRevenue);
    }
    
    @Test
    void testGetBookings() {
        Map<Integer, Visit> bookings = facade.getBookings();
        assertNotNull(bookings);
    }
    
    @Test
    void testGetBookingsForClient() {
        Map<Integer, Visit> bookings = facade.getBookingsForClient(testClient);
        assertNotNull(bookings);
    }
    
    @Test
    void testGenerateBookingID() {
        int id = facade.generateBookingID();
        assertTrue(id > 0);
    }
    
    @Test
    void testCancelBookingNonExistent() {
        boolean result = facade.cancelBooking(-99999, false);
        assertFalse(result);
    }
    
    @Test
    void testExtendBookingNonExistent() {
        boolean result = facade.extendBooking(-99999, new Date(), 10, 2);
        assertFalse(result);
    }
        
    @Test
    void testSimulateVehicleDetection() {
        facade.addNewParkingLot(testLot);
        
        facade.simulateVehicleDetection(testLot, 1, true);
        
        facade.simulateVehicleDetection(testLot, 1, false);
        
        facade.removeParkingLot(testLot);
    }
}