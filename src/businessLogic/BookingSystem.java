package businessLogic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import objects.Client;
import objects.ParkingLot;
import objects.ParkingSpace;

public class BookingSystem {
    static Map<Integer, Visit> bookings = new HashMap<Integer, Visit>();
    private static BookingSystem bookingSystem = null;
    private SystemDatabase systemDatabase;
    private ParkingSystem parkingSystem;

    private BookingSystem() throws Exception {
        // Get reference to SystemDatabase
        this.systemDatabase = SystemDatabase.getInstance();
    }
    
    private ParkingSystem ParkingSystem() throws Exception {
    	// Get reference to ParkingSystem
        if (parkingSystem == null) {
            parkingSystem = ParkingSystem.getInstance();
        }
        return parkingSystem;
    }

    public static synchronized BookingSystem getInstance() throws Exception {
        if (bookingSystem == null)
            bookingSystem = new BookingSystem();
        return bookingSystem;
    }
    

    /**
     * @return the bookings
     */
    public Map<Integer, Visit> getBookings() {
        return bookings;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(Map<Integer, Visit> bookings) {
        this.bookings = bookings;
    }

    public boolean bookParkingSpace(String clientEmail, int parkingLotID, int parkingSpaceID, int deposit, int time) {
        boolean bookingComplete = false;
        
        // Get parking lot by ID
        ParkingLot parkingLot = null;
        for (ParkingLot lot : systemDatabase.getParkingLots()) {
            if (lot.getId() == parkingLotID) {
                parkingLot = lot;
                break;
            }
        }
        
        if (parkingLot == null) {
            return false; // Parking lot not found
        }
        
        // Get parking space by ID
        ParkingSpace parkingSpot = parkingLot.findSpaceById(parkingSpaceID);
        
        // Get client by email
        Client client = systemDatabase.getClientInfo(clientEmail);
        
        if (parkingSpot != null && client != null && 
            !parkingSpot.isOccupied(time) && 
            parkingSpot.isEnabled() && 
            deposit >= client.getParkingRate()) {
            
            int bookingID = generateBookingID();
            parkingSpot.occupyTime(bookingID, time);
            
            SystemDatabase.addRevenue(deposit);
            
            Date date = new Date();
            Visit visit = new Visit(date, date, client, parkingLot, parkingSpot, deposit, String.valueOf(bookingID));
            bookings.put(bookingID, visit);
            bookingComplete = true;
        }
        return bookingComplete;
    }

    private int generateBookingID() {
        // Simple booking ID generation
        return bookings.size() + 1;
    }

    public boolean bookParkingSpace(int bookingID, int parkingLotID, int parkingSpaceID, int time) {
        boolean bookingComplete = false;
        
        // Get parking lot by ID
        ParkingLot parkingLot = null;
        for (ParkingLot lot : systemDatabase.getParkingLots()) {
            if (lot.getId() == parkingLotID) {
                parkingLot = lot;
                break;
            }
        }
        
        if (parkingLot == null) {
            return false; // Parking lot not found
        }
        
        // Get parking space by ID
        ParkingSpace parkingSpot = parkingLot.findSpaceById(parkingSpaceID);
        
        if (parkingSpot != null && !parkingSpot.isOccupied(time) && parkingSpot.isEnabled()) {
            parkingSpot.occupyTime(bookingID, time);
            bookingComplete = true;
        }
        return bookingComplete;
    }

    public boolean editBooking(int bookingID, int parkingLotID, int parkingSpaceID, int time) {
        boolean bookingEdited = false;
        
        // Get parking lot by ID
        ParkingLot parkingLot = null;
        for (ParkingLot lot : systemDatabase.getParkingLots()) {
            if (lot.getId() == parkingLotID) {
                parkingLot = lot;
                break;
            }
        }
        
        if (parkingLot == null) {
            return false; // Parking lot not found
        }
        
        // Get parking space by ID
        ParkingSpace parkingSpot = parkingLot.findSpaceById(parkingSpaceID);

        if (parkingSpot != null && !parkingSpot.isOccupied(time) && parkingSpot.isEnabled()) {
            cancelBooking(bookingID);
            parkingSpot.unoccupyTime(bookingID);
            bookParkingSpace(bookingID, parkingLotID, parkingSpaceID, time);
            bookingEdited = true;
        }

        return bookingEdited;
    }

    public boolean cancelBooking(int bookingID) {
        boolean bookingCancelled = false;
        if (bookings.containsKey(bookingID)) {
            ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
            parkingSpot.unoccupy(bookingID);
            bookings.remove(bookingID);
            if (confirmRefund(bookingID))
                bookingCancelled = true;
        }
        return bookingCancelled;
    }

    private boolean confirmRefund(int bookingID) {
        // Get payment system and confirm refund
        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        return paymentSystem.confirmRefund(bookingID);
    }

    public boolean extendBooking(int bookingID, int time) {
        boolean bookingExtended = false;
        if (bookings.containsKey(bookingID)) {
            ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
            if (!parkingSpot.isOccupied(time)) {
                parkingSpot.occupyTime(bookingID, time);
                bookingExtended = true;
            }
        }
        return bookingExtended;
    }

    public boolean checkout(int bookingID, int payment) {
    	Visit visit = Visit.getVisit(bookingID);
        boolean checkedOut = false;
        if (confirmPayment(bookingID, payment)) {
            checkedOut = true;
            Date currentTime = new Date();
            visit.setEndTime(currentTime);
        }

        return checkedOut;
    }

    private boolean confirmPayment(int bookingID, int payment) {
        // Get payment system and confirm payment
        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        return paymentSystem.confirmPayment(bookingID, "CREDIT_CARD", payment);
    }

    public void updateParkingAvailability(ParkingSpace space) {
        // This method is for updating parking availability when changes occur
        // For example, when space status changes, update any affected bookings
    }
}