
package businessLogic;


import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.ParkingLot;
import objects.ParkingSpace;
import objects.Visitor;


class BookingSystemTest {

    private BookingSystem bookingSystem;
    private Client testClient;
    private ParkingLot testLot;
    private ParkingSpace testSpace;
    private Date testDate;
    
    @BeforeEach
    void setUp() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 10);
        testSpace = new ParkingSpace(1, "");
        testLot.addParkingSpace(testSpace);
        testDate = new SimpleDateFormat("MM/dd/yyyy").parse("04/04/2025");
    }
    //1
    @Test
    void testBookParkingSpace_Success() {
        boolean result = bookingSystem.bookParkingSpace(
                testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(result, "Booking should be successful.");
    }
    
    

    @Test
    void testBookParkingSpace_AlreadyOccupied() {
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 1, 50, 10, testDate, 10, 2, "WXYZ789");
        assertFalse(result, "Booking should fail because the space is occupied.");
    }
    
    @Test
    public void testBookingWithInvalidLotName() throws Exception {
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), "invalid", testSpace.getSpaceId(), 50, 10, testDate, 10, 1, "ABCD123");
        assertFalse(result, "Booking should fail with an invalid parking lot name.");
    }
    
    @Test
    public void testBookingInThePast() throws Exception {
        Date pastDate = new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020");
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, pastDate, 10, 1, "ABCD123");
        assertFalse(result, "Booking should fail for a date in the past.");
    }

    @Test
    void testCancelBooking_Success() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.cancelBooking(bookingID, false);
        assertTrue(result, "Booking should be successfully canceled.");
    }
    	

    @Test
    void testCancelBooking_NonExistent() {
        boolean result = bookingSystem.cancelBooking(999, false);
        assertFalse(result, "Cancellation should fail for a non-existent booking.");
    }
    

    @Test
    void testExtendBooking_Success() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.extendBooking(bookingID, testDate, 12, 1);
        assertTrue(result, "Booking should be successfully extended.");
    }
   
    

    @Test
    void testExtendBooking_SpaceOccupied() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        bookingSystem.bookParkingSpace("another@example.com", testLot.getName(), testSpace.getSpaceId(), 50, 12, testDate, 12, 2, "WXYZ789");
        boolean result = bookingSystem.extendBooking(bookingID, testDate, 12, 1);
        assertFalse(result, "Extension should fail because another booking exists.");
    }


    @Test
    void testCheckForNoShow() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.checkForNoShow(bookingID);
        assertTrue(result, "No-show should be detected.");
    }


    @Test
    void testCheckout_Success() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.checkout(bookingID, 50);
        assertTrue(result, "Checkout should be successful.");
    }


    @Test
    void testCheckout_BeforeBookingTime() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.checkout(bookingID, 50);
        assertFalse(result, "Checkout should fail before start time.");
    }


    @Test
    void testEditBooking_Success() {
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), testSpace.getSpaceId(), 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.editBooking(bookingID, "Lot 2", 201, 15, testDate, 2, testClient, "ABCD123");
        assertTrue(result, "Editing booking should be successful.");
    }
    

}
