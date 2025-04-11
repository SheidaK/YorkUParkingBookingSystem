
package businessLogic;


import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.ParkingLot;
import objects.ParkingSpace;
import objects.Visitor;
import businessLogic.*;


class BookingSystemTest {

    private BookingSystem bookingSystem;
    private Client testClient;
    private ParkingLot testLot;
    private ParkingSpace testSpace;
    private Date testDate;
    private ClientSystem clientSystem;
    private ParkingSystem parkingSystem;
    
  /*  @BeforeEach
    void setUp() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(1, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }
    */
    
    @AfterEach
    void tearDown() throws Exception {
        BookingSystem bs = BookingSystem.getInstance();
        Map<Integer, Visit> bookings = bs.getBookings();
        if (bookings != null) {
            bookings.clear();
        }    }
    
    //1
    @Test
    void testBookParkingSpace_Success() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(1, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000);
        
        int bookingId = bookingSystem.generateBookingID();
        boolean result = bookingSystem.bookParkingSpace(
                testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(result, "Booking should be successful.");
        bookingSystem.cancelBooking(bookingId, result);
    }
    
    

    @Test
    void testBookParkingSpace_AlreadyOccupied() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(2, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 1, 50, 10, testDate, 10, 2, "WXYZ789");
        assertFalse(result, "Booking should fail because the space is occupied.");

    }
    
    @Test
    public void testBookingWithInvalidLotName() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(3, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), "invalid", testSpace.getSpaceId(), 50, 10, testDate, 10, 1, "ABCD123");
        assertFalse(result, "Booking should fail with an invalid parking lot name.");
    }
    
    @Test
    void testCancelBooking_Success() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(5, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        int bookingId = bookingSystem.generateBookingID(); 
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(),50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "booking success");
        boolean result = bookingSystem.cancelBooking(bookingId, false);
        assertTrue(result, "Booking should be successfully canceled.");
        bookingSystem.cancelBooking(bookingId, result);
    }

    	

    @Test
    void testCancelBooking_NonExistent() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(6, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        boolean result = bookingSystem.cancelBooking(999, false);
        assertFalse(result, "Cancellation should fail for a non-existent booking.");
    }
    

    @Test
    void testExtendBooking_Success() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(7, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        int bookingID = bookingSystem.generateBookingID();
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "booking success");
        boolean result = bookingSystem.extendBooking(bookingID, testDate, 11, 2);
        assertTrue(result, "Booking should be successfully extended.");
        bookingSystem.cancelBooking(bookingID, result);

    }
   
    

    @Test
    void testExtendBooking_SpaceOccupied() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(8, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        bookingSystem.bookParkingSpace("another@example.com", testLot.getName(), testSpace.getSpaceId(), 50, 12, testDate, 12, 2, "WXYZ789");
        boolean result = bookingSystem.extendBooking(bookingID, testDate, 12, 1);
        assertFalse(result, "Extension should fail because another booking exists.");
    }


    @Test
    void testCheckForNoShow() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(9, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.checkForNoShow(bookingID);
        assertTrue(result, "No-show should be detected.");
        bookingSystem.cancelBooking(bookingID, result);
    }


    @Test
    void testCheckout_BeforeBookingTime() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(11, "Regular");
        parkingSystem.addNewParkingSpace(testLot, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000);
        
        int bookingID = bookingSystem.generateBookingID();
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "booking success");
        boolean result = bookingSystem.checkout(bookingID, 50);
        assertFalse(result, "Checkout should fail before start time.");
        bookingSystem.cancelBooking(bookingID, result);

    }


    @Test
    void testEditBooking_Success() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testSpace = new ParkingSpace(12, "Regular");
        testLot.addParkingSpace(testSpace);
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        int bookingID = bookingSystem.generateBookingID();
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "Booking successful");
        boolean result = bookingSystem.editBooking(bookingID, testLot.getName(), testSpace.getSpaceId(), 15, testDate, 2, testClient, "ABCD123");
        assertTrue(result, "Editing booking should be successful.");
        bookingSystem.cancelBooking(bookingID, result);

    }
    

}
