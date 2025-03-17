package businessLogic;

import objects.*;
import java.util.List;

/**
 * Implements the Facade pattern to provide a simplified interface to the parking subsystem
 */
public class ParkingSystem implements ParkingLotObserver {
    // Singleton pattern
    private static ParkingSystem instance;
    
    private ParkingLot parkingLot;
    private BookingSystem bookingSystem;
    
    // Private constructor for Singleton pattern
    private ParkingSystem() {
        this.parkingLot = ParkingLot.getInstance();
        this.parkingLot.addObserver(this);
        
        // Get reference to the booking system (also a singleton)
        try {
            this.bookingSystem = BookingSystem.getInstance();
        } catch (Exception e) {
            System.err.println("Warning: BookingSystem not initialized yet. Will be set later.");
        }
    }
    
    // Singleton getInstance method
    public static synchronized ParkingSystem getInstance() {
        if (instance == null) {
            instance = new ParkingSystem();
        }
        return instance;
    }
    
    // Set the booking system reference if not available at construction time
    public void setBookingSystem(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }
    
    // Facade methods for client interaction
    public List<ParkingSpace> getAvailableSpaces() {
        return parkingLot.getAvailableSpaces();
    }
    
    public boolean parkCar(String spaceId, Car car) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            return space.parkCar(car);
        }
        return false;
    }
    
    public Car removeCar(String spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            return space.removeCar();
        }
        return null;
    }
    
    // Manager operations
    public void enableParkingSpace(String spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            space.setEnabled(true);
        }
    }
    
    public void disableParkingSpace(String spaceId) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null) {
            space.setEnabled(false);
        }
    }
    
    public void addNewParkingSpace(String type) {
        int nextId = parkingLot.getAllSpaces().size() + 1;
        ParkingSpace newSpace = new ParkingSpace("P" + nextId, type);
        parkingLot.addParkingSpace(newSpace);
    }
    
    public boolean removeParkingSpace(String spaceId) {
        return parkingLot.removeParkingSpace(spaceId);
    }
    
    // Simulate sensor detection
    public void simulateVehicleDetection(String spaceId, boolean detected) {
        ParkingSpace space = parkingLot.findSpaceById(spaceId);
        if (space != null && space.getSensor() != null) {
            space.getSensor().detectVehicle(detected);
        }
    }
    
    // Observer implementation
    @Override
    public void onParkingSpaceStatusChanged(ParkingSpace space) {
        // Notify booking system of changes if needed
        if (bookingSystem != null) {
            bookingSystem.updateParkingAvailability(space);
        }
    }
    
    @Override
    public void onAvailabilityChanged(int availableSpaces) {
        // Can be used to trigger system-wide notifications
        System.out.println("Parking availability changed: " + availableSpaces + " spaces available");
    }
}
