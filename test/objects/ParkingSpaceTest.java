package objects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.text.SimpleDateFormat;

class ParkingSpaceTest {
    
    private ParkingSpace space;
    private ParkingSensor sensor;
    
    class TestCar extends Car {
        public TestCar(String licensePlate, String model, String color) {
            super(licensePlate, model, color, null); 
        }
    }
    
    @BeforeEach
    void setUp() {
        space = new ParkingSpace(1, "Regular");
        sensor = new ParkingSensor(1, space);
        space.assignSensor(sensor);
    }
    
    @Test
    void testConstructor() {
        assertEquals(1, space.getSpaceId());
        assertEquals("Regular", space.getType());
        assertFalse(space.isOccupied());
        assertTrue(space.isEnabled());
        assertNull(space.getParkedCar());
    }
    
    @Test
    void testAssignSensor() {
        assertEquals(sensor, space.getSensor());
    }
    
    @Test
    void testParkCar() {
        TestCar car = new TestCar("ABC123", "Toyota", "Blue");
        assertTrue(space.parkCar(car));
        assertEquals(car, space.getParkedCar());
        assertTrue(space.isOccupied());
    }
    
    @Test
    void testParkCarWhenOccupied() {
        TestCar car1 = new TestCar("ABC123", "Toyota", "Blue");
        TestCar car2 = new TestCar("XYZ789", "Honda", "Red");
        
        space.parkCar(car1);
        assertFalse(space.parkCar(car2));
        assertEquals(car1, space.getParkedCar()); // Original car should still be there
    }
    
    @Test
    void testParkCarWhenDisabled() {
        TestCar car = new TestCar("ABC123", "Toyota", "Blue");
        space.setEnabled(false);
        assertFalse(space.parkCar(car));
        assertNull(space.getParkedCar());
    }
    
    @Test
    void testRemoveCar() {
        TestCar car = new TestCar("ABC123", "Toyota", "Blue");
        space.parkCar(car);
        Car removedCar = space.removeCar();
        assertEquals(car, removedCar);
        assertFalse(space.isOccupied());
        assertNull(space.getParkedCar());
    }
    
    @Test
    void testRemoveCarWhenEmpty() {
        assertNull(space.removeCar());
    }
    
    @Test
    void testClone() {
        ParkingSpace cloned = space.clone();
        
        // Check properties are preserved correctly
        assertEquals(space.getSpaceId(), cloned.getSpaceId());
        assertEquals(space.getType(), cloned.getType());
        assertEquals(space.isEnabled(), cloned.isEnabled());
        
        // Check reset properties
        assertNull(cloned.getParkedCar());
        assertFalse(cloned.isOccupied());
        assertNull(cloned.getSensor());
    }
    
    @Test
    void testSetSpaceId() {
        space.setSpaceId(100);
        assertEquals(100, space.getSpaceId());
    }
    
    @Test
    void testSetOccupied() {
        space.setOccupied(true);
        assertTrue(space.isOccupied());
    }
    
    @Test
    void testSetEnabled() {
        space.setEnabled(false);
        assertFalse(space.isEnabled());
    }
    
    @Test
    void testSetType() {
        space.setType("VIP");
        assertEquals("VIP", space.getType());
    }
    
    @Test
    void testGetEnabledString() {
        assertEquals("Enabled", space.getEnablesString());
        space.setEnabled(false);
        assertEquals("Disabled", space.getEnablesString());
    }
    
    @Test
    void testGetOccupiedString() {
        assertEquals("Available", space.getOccupiedString());
        space.setOccupied(true);
        assertEquals("Occupied", space.getOccupiedString());
    }
    
    @Test
    void testUpdate() {
        space.update(space, true);
        assertTrue(space.isOccupied());
    }
    
    @Test
    void testToString() {
        String expected = "Space 1 (Regular): Enabled, Available, Sensor Attached";
        assertEquals(expected, space.toString());
    }
    
    @Test
    void testOccupyTimeAndIsOccupied() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = format.parse("01/01/2025");
        
       
        assertFalse(space.isOccupied(date, 10, 2));
        
        space.occupyTime(123, date, 10, 2);
        
        assertTrue(space.isOccupied(date, 10, 2));
        
        assertFalse(space.isOccupied(date, 13, 1));
    }
}