package objects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class ParkingSensorTest {
    
    private ParkingSensor sensor;
    private ParkingSpace space;
    private MockObserver observer;

    class MockObserver implements ParkingStatusObserver {
        private boolean wasNotified = false;
        private ParkingSpace updatedSpace;
        private boolean updatedOccupiedStatus;
        
        @Override
        public void update(ParkingSpace space, boolean occupied) {
            this.wasNotified = true;
            this.updatedSpace = space;
            this.updatedOccupiedStatus = occupied;
        }
        
        public boolean wasNotified() {
            return wasNotified;
        }
        
        public ParkingSpace getUpdatedSpace() {
            return updatedSpace;
        }
        
        public boolean getUpdatedOccupiedStatus() {
            return updatedOccupiedStatus;
        }
        
        public void reset() {
            wasNotified = false;
            updatedSpace = null;
        }
    }
    
    @BeforeEach
    void setUp() {
        space = new ParkingSpace(1, "Regular");
        sensor = new ParkingSensor(1, space);
        observer = new MockObserver();
    }
    
    @Test
    void testConstructor() {
        assertEquals(1, sensor.getSensorId());
        assertEquals(space, sensor.getMonitoredSpace());
        assertFalse(sensor.isOccupied());
    }
    
    @Test
    void testAddObserver() {
        sensor.addObserver(observer);
        sensor.detectVehicle(true);
        assertTrue(observer.wasNotified());
    }
    
    @Test
    void testRemoveObserver() {
        sensor.addObserver(observer);
        sensor.removeObserver(observer);
        sensor.detectVehicle(true);
        assertFalse(observer.wasNotified());
    }
    
    @Test
    void testDetectVehicleTrue() {
        sensor.addObserver(observer);
        sensor.detectVehicle(true);
        assertTrue(sensor.isOccupied());
        assertTrue(space.isOccupied());
        assertTrue(observer.wasNotified());
        assertEquals(space, observer.getUpdatedSpace());
        assertTrue(observer.getUpdatedOccupiedStatus());
    }
    
    @Test
    void testDetectVehicleFalse() {
        // First set to true, then to false
        sensor.detectVehicle(true);
        observer.reset();
        sensor.addObserver(observer);
        
        sensor.detectVehicle(false);
        assertFalse(sensor.isOccupied());
        assertFalse(space.isOccupied());
        assertTrue(observer.wasNotified());
        assertEquals(space, observer.getUpdatedSpace());
        assertFalse(observer.getUpdatedOccupiedStatus());
    }
    
    @Test
    void testDetectVehicleNoChange() {
        sensor.addObserver(observer);
        sensor.detectVehicle(false); 
        assertFalse(observer.wasNotified());
    }
    
    @Test
    void testGetSensorId() {
        assertEquals(1, sensor.getSensorId());
    }
    
    @Test
    void testIsOccupied() {
        assertFalse(sensor.isOccupied());
        sensor.detectVehicle(true);
        assertTrue(sensor.isOccupied());
    }
    
    @Test
    void testGetMonitoredSpace() {
        assertEquals(space, sensor.getMonitoredSpace());
    }
    
    @Test
    void testClone() {
        ParkingSpace newSpace = new ParkingSpace(2, "VIP");
        ParkingSensor clonedSensor = sensor.clone(2, newSpace);
        
        assertEquals(2, clonedSensor.getSensorId());
        assertEquals(newSpace, clonedSensor.getMonitoredSpace());
        assertFalse(clonedSensor.isOccupied());
        
        assertEquals(1, sensor.getSensorId());
        assertEquals(space, sensor.getMonitoredSpace());
    }
    
    @Test
    void testMultipleObservers() {
        MockObserver observer2 = new MockObserver();
        sensor.addObserver(observer);
        sensor.addObserver(observer2);
        
        sensor.detectVehicle(true);
        
        assertTrue(observer.wasNotified());
        assertTrue(observer2.wasNotified());
    }
}