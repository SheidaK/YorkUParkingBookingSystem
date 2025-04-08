package objects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class ParkingLotTest {
    
    private ParkingLot parkingLot;

    class TestCar extends Car {
        public TestCar(String licensePlate, String model, String color) {
            super(licensePlate, model, color, null); 
        }
    }
    
    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot("Test Lot", "Test Location", 100);
    }
    
    @Test
    void testConstructor() {
        assertEquals("Test Lot", parkingLot.getName());
        assertEquals("Test Location", parkingLot.getLocation());
        assertTrue(parkingLot.isEnabled());
        assertEquals(100, parkingLot.getAllSpaces().size());
    }
    
    @Test
    void testSetEnabled() {
        parkingLot.setEnabled(false);
        assertFalse(parkingLot.isEnabled());
    }
    
    @Test
    void testSetName() {
        parkingLot.setName("New Name");
        assertEquals("New Name", parkingLot.getName());
    }
    
    @Test
    void testSetLocation() {
        parkingLot.setLocation("New Location");
        assertEquals("New Location", parkingLot.getLocation());
    }
    
    @Test
    void testSetCapacity() {
        parkingLot.setCapacity(200);
        assertEquals(200, parkingLot.getTotalCapacity());
    }
    
    @Test
    void testSetId() {
        parkingLot.setId(123);
        assertEquals(123, parkingLot.getId());
    }
    
    @Test
    void testGetStatus() {
        assertEquals("Enabled", parkingLot.getStatus());
        parkingLot.setStatus(false);
        assertEquals("Disabled", parkingLot.getStatus());
    }
    
    @Test
    void testGetAvailableSpaces() {
        List<ParkingSpace> availableSpaces = parkingLot.getAvailableSpaces();
        assertEquals(100, availableSpaces.size());
        
        // Park a car in the first space
        ParkingSpace firstSpace = parkingLot.findSpaceById(1);
        TestCar car = new TestCar("ABC123", "Toyota", "Blue");
        firstSpace.parkCar(car);
        
        availableSpaces = parkingLot.getAvailableSpaces();
        assertEquals(99, availableSpaces.size());
    }
    
    @Test
    void testGetAllSpaces() {
        List<ParkingSpace> allSpaces = parkingLot.getAllSpaces();
        assertEquals(100, allSpaces.size());
    }
    
    @Test
    void testGetAvailableSpacesCount() {
        assertEquals(100, parkingLot.getAvailableSpacesCount());
        
        // Disable a space
        ParkingSpace firstSpace = parkingLot.findSpaceById(1);
        firstSpace.setEnabled(false);
        
        assertEquals(99, parkingLot.getAvailableSpacesCount());
    }
    
    @Test
    void testFindSpaceById() {
        ParkingSpace space = parkingLot.findSpaceById(1);
        assertNotNull(space);
        assertEquals(1, space.getSpaceId());
        
        // Test with non-existent ID
        assertNull(parkingLot.findSpaceById(101));
    }
    
    @Test
    void testAddParkingSpace() {
        int initialSize = parkingLot.getAllSpaces().size();
        ParkingSpace newSpace = new ParkingSpace(101, "VIP");
        parkingLot.addParkingSpace(newSpace);
        
        assertEquals(initialSize + 1, parkingLot.getAllSpaces().size());
        assertNotNull(parkingLot.findSpaceById(101));
    }
    
    @Test
    void testRemoveParkingSpace() {
        assertTrue(parkingLot.removeParkingSpace(1));
        assertEquals(99, parkingLot.getAllSpaces().size());

        assertFalse(parkingLot.removeParkingSpace(101));
    }
    
    @Test
    void testUpdate() {

        ParkingSpace space = parkingLot.findSpaceById(1);
        parkingLot.update(space, true);
  
    }
    
    @Test
    void testGetCapcity() {
        assertEquals(100, parkingLot.getCapcity());
    }
    
    @Test
    void testSetStatus() {
        parkingLot.setStatus(false);
        assertFalse(parkingLot.isEnabled());
        assertEquals("Disabled", parkingLot.getStatus());
    }
}