package businessLogic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import database.Database;
import objects.*;

class ParkingSystemTest {
    
    private ParkingSystem parkingSystem;
    private ParkingLot testParkingLot;
    
    class TestCar extends Car {
        public TestCar(String licensePlate, String model, String color) {
            super(licensePlate, model, color, null); 
        }
    }
    

    @BeforeEach
    void setUp() throws Exception {
       
        testParkingLot = new ParkingLot("Test Lot", "Test Location", 10);
       
        parkingSystem = ParkingSystem.getInstance();
    }
    
    @Test
    void testGetInstance() throws Exception {
        assertNotNull(ParkingSystem.getInstance());
    }
    
    @Test
    void testGetAvailableSpaces() {
        List<ParkingSpace> spaces = parkingSystem.getAvailableSpaces(testParkingLot);
        assertNotNull(spaces);
    }
    
    @Test
    void testParkCar() {
        TestCar car = new TestCar("ABC123", "Toyota", "Blue");
        boolean result = parkingSystem.parkCar(testParkingLot, 1, car);
        assertTrue(result);

        result = parkingSystem.parkCar(testParkingLot, 999, car);
        assertFalse(result);
    }
    
    @Test
    void testRemoveCar() {
 
        TestCar car = new TestCar("ABC123", "Toyota", "Blue");
        parkingSystem.parkCar(testParkingLot, 1, car);

        Car removedCar = parkingSystem.removeCar(testParkingLot, 1);
        assertEquals(car, removedCar);
        
        removedCar = parkingSystem.removeCar(testParkingLot, 1);
        assertNull(removedCar);
        
        removedCar = parkingSystem.removeCar(testParkingLot, 999);
        assertNull(removedCar);
    }
    
    @Test
    void testEnableParkingSpace() {
        ParkingSpace space = testParkingLot.findSpaceById(1);
        space.setEnabled(false);
        
        parkingSystem.enableParkingSpace(testParkingLot, 1);
        assertTrue(space.isEnabled());
    }
    
    @Test
    void testDisableParkingSpace() {
        ParkingSpace space = testParkingLot.findSpaceById(1);
        
        parkingSystem.disableParkingSpace(testParkingLot, 1);
        assertFalse(space.isEnabled());
    }
    
    @Test
    void testAddNewParkingSpace() {
        int initialCount = testParkingLot.getAllSpaces().size();
        
        parkingSystem.addNewParkingSpace(testParkingLot, "VIP");
        
        assertEquals(initialCount + 1, testParkingLot.getAllSpaces().size());
        ParkingSpace newSpace = testParkingLot.findSpaceById(initialCount + 1);
        assertNotNull(newSpace);
        assertEquals("VIP", newSpace.getType());
    }
    
    @Test
    void testRemoveParkingSpace() {
        int initialCount = testParkingLot.getAllSpaces().size();
        
        boolean result = parkingSystem.removeParkingSpace(testParkingLot, 1);
        assertTrue(result);
        assertEquals(initialCount - 1, testParkingLot.getAllSpaces().size());
        
        result = parkingSystem.removeParkingSpace(testParkingLot, 999);
        assertFalse(result);
    }
    
    @Test
    void testSimulateVehicleDetection() {
        ParkingSpace space = testParkingLot.findSpaceById(1);
        assertFalse(space.isOccupied());
        
        parkingSystem.simulateVehicleDetection(testParkingLot, 1, true);
        assertTrue(space.isOccupied());
        
        parkingSystem.simulateVehicleDetection(testParkingLot, 1, false);
        assertFalse(space.isOccupied());
    }
    
    @Test
    void testGetNumofSensor() {
        int initialCount = parkingSystem.getNumofSensor();
        parkingSystem.increaseNumofSensor();
        assertEquals(initialCount + 1, parkingSystem.getNumofSensor());
    }
    
    @Test
    void testAddNewParkingLot() {
        ParkingLot newParkingLot = new ParkingLot("New Lot", "New Location", 5);
        int initialSize = parkingSystem.getAvailableLots().size();
        
        parkingSystem.addNewParkingLot(newParkingLot);

        assertTrue(parkingSystem.getAvailableLots().contains(newParkingLot));
    }
    
    @Test
    void testOnAvailabilityChanged() {
        parkingSystem.onAvailabilityChanged(10);
    
        List<ParkingSpace> spaces = new ArrayList<>();
        parkingSystem.onAvailabilityChanged(spaces);

    }
    
    @Test
    void testGetParkingLotInfo() {
      
        ParkingLot newParkingLot = new ParkingLot("Test Lookup", "Test Location", 5);
        parkingSystem.addNewParkingLot(newParkingLot);
        
        ParkingLot found = parkingSystem.getParkingLotInfo("Test Lookup");
        assertNotNull(found);
        assertEquals("Test Lookup", found.getName());

        ParkingLot notFound = parkingSystem.getParkingLotInfo("Non-existent Lot");
        assertNull(notFound);
    }
}