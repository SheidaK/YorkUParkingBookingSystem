package objects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    
    private Car car;

    private static class TestClient extends Client {
        public TestClient() {
            super("test@example.com", "password123");
        }
        
        @Override
        public String getValidationStatus() {
            return isValidated() ? "Validated" : "Not Validated";
        }
    }
    
    @BeforeEach
    void setUp() {
        TestClient client = new TestClient();
        car = new Car("ABC123", "Toyota Camry", "Blue", client);
    }
    
    @Test
    void testConstructor() {
        assertEquals("ABC123", car.getLicensePlate());
        assertEquals("Toyota Camry", car.getModel());
        assertEquals("Blue", car.getColor());
        assertNotNull(car.getOwner());
    }
    
    @Test
    void testSetLicensePlate() {
        car.setLicensePlate("XYZ789");
        assertEquals("XYZ789", car.getLicensePlate());
    }
    
    @Test
    void testSetModel() {
        car.setModel("Honda Accord");
        assertEquals("Honda Accord", car.getModel());
    }
    
    @Test
    void testSetColor() {
        car.setColor("Red");
        assertEquals("Red", car.getColor());
    }
    
    @Test
    void testSetOwner() {
        TestClient newOwner = new TestClient();
        car.setOwner(newOwner);
        assertEquals(newOwner, car.getOwner());
    }
    
    @Test
    void testToString() {
        assertEquals("ABC123 - Toyota Camry (Blue)", car.toString());
    }
    
    @Test
    void testNullLicensePlate() {
        Car car = new Car(null, "Toyota", "Blue", null);
        assertNull(car.getLicensePlate());
    }
    
    @Test
    void testEmptyLicensePlate() {
        Car car = new Car("", "Toyota", "Blue", null);
        assertEquals("", car.getLicensePlate());
    }
    
    @Test
    void testNullModel() {
        Car car = new Car("ABC123", null, "Blue", null);
        assertNull(car.getModel());
    }
    
    @Test
    void testNullColor() {
        Car car = new Car("ABC123", "Toyota", null, null);
        assertNull(car.getColor());
    }
    
    @Test
    void testNullOwner() {
        Car car = new Car("ABC123", "Toyota", "Blue", null);
        assertNull(car.getOwner());
    }
}

