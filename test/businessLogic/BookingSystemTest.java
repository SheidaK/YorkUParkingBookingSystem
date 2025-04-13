package businessLogic;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import objects.Client;
import objects.ParkingLot;
import objects.ParkingSpace;
import objects.Visitor;
import businessLogic.*;


class BookingSystemTest {

    private static BookingSystem bookingSystem;
    private static Client testClient;
    private static ParkingLot testLot;
    private static Date testDate;
    private static ClientSystem clientSystem;
    private static ParkingSystem parkingSystem;
    
    @BeforeAll
    static void  setUp() throws Exception {
        bookingSystem = BookingSystem.getInstance();
        clientSystem = ClientSystem.getInstance();
        parkingSystem = ParkingSystem.getInstance();
        testClient = new Visitor("test@example.com", "aA1!");
        clientSystem.addClient(testClient);
        testLot = new ParkingLot("Test Lot", "Keele Camplus", 15);
        parkingSystem.addNewParkingLot(testLot);
        testDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    }
    
    
    @AfterEach
    void tearDown() throws Exception {
        BookingSystem bs = BookingSystem.getInstance();
        Map<Integer, Visit> bookings = bs.getBookings();
        if (bookings != null) {
            bookings.clear();
        }    }
    

    @Test
    void testBookParkingSpace_Success() throws Exception {
        int bookingId = bookingSystem.generateBookingID();
        boolean result = bookingSystem.bookParkingSpace(
                testClient.getEmail(), testLot.getName(), 1, 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(result, "Booking should be successful.");
        bookingSystem.cancelBooking(bookingId, result);
    }
    
    @Test
    void testBookParkingSpace_Success_2() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 48 * 60 * 60 * 1000);
        
        int bookingId = bookingSystem.generateBookingID();
        boolean result = bookingSystem.bookParkingSpace(bookingId, testLot.getName(), 13, 10, testDate, 2);
        assertTrue(result, "Booking should be successful");
        bookingSystem.cancelBooking(bookingId, result);
    }

    
    

    @Test
    void testBookParkingSpace_AlreadyOccupied() throws Exception {
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 2, 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 2, 50, 10, testDate, 10, 2, "WXYZ789");
        assertFalse(result, "Booking should fail because the space is occupied.");

    }
    
    @Test 
    void testBookingParkingLotNull() throws Exception {
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 11, 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 11, 50, 10, testDate, 10, 2, "WXYZ789");
        assertFalse(result, "Booking should fail because parking lot is null.");
    }
    
    @Test
    public void testBookingWithInvalidLotName() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        boolean result = bookingSystem.bookParkingSpace(testClient.getEmail(), "invalid", 3, 50, 10, testDate, 10, 1, "ABCD123");
        assertFalse(result, "Booking should fail with an invalid parking lot name.");
    }
    
    @Test
    void testCancelBooking_Success() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        int bookingId = bookingSystem.generateBookingID(); 
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 5,50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "booking success");
        boolean result = bookingSystem.cancelBooking(bookingId, false);
        assertTrue(result, "Booking should be successfully canceled.");
        bookingSystem.cancelBooking(bookingId, result);
    }

    	

    @Test
    void testCancelBooking_NonExistent() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        boolean result = bookingSystem.cancelBooking(999, false);
        assertFalse(result, "Cancellation should fail for a non-existent booking.");
    }
    

    @Test
    void testExtendBooking_Success() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        int bookingID = bookingSystem.generateBookingID();
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 7, 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "booking success");
        boolean result = bookingSystem.extendBooking(bookingID, testDate, 11, 2);
        assertTrue(result, "Booking should be successfully extended.");
        bookingSystem.cancelBooking(bookingID, result);

    }
    

    @Test
    void testExtendBooking_SpaceOccupied() throws Exception {

        testDate = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 8, 50, 10, testDate, 10, 2, "ABCD123");
        bookingSystem.bookParkingSpace("another@example.com", testLot.getName(), 8, 50, 12, testDate, 12, 2, "WXYZ789");
        boolean result = bookingSystem.extendBooking(bookingID, testDate, 12, 1);
        assertFalse(result, "Extension should fail because another booking exists.");
    }


    @Test
    void testCheckForNoShow() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 9, 50, 10, testDate, 10, 2, "ABCD123");
        boolean result = bookingSystem.checkForNoShow(bookingID);
        assertTrue(result, "No-show should be detected.");
        bookingSystem.cancelBooking(bookingID, result);
    }


    @Test
    void testEditBooking_Success() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        
        int bookingID = bookingSystem.generateBookingID();
        boolean test = bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 12, 50, 10, testDate, 10, 2, "ABCD123");
        assertTrue(test, "Booking successful");
        boolean result = bookingSystem.editBooking(bookingID, testLot.getName(), 12, 15, testDate, 2, testClient, "ABCD123");
        assertTrue(result, "Editing booking should be successful.");
        bookingSystem.cancelBooking(bookingID, result);
    }
    
    @Test 
    void testCheckin() throws Exception {
        testDate = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        int bookingID = bookingSystem.generateBookingID();
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 12, 50, 10, testDate, 10, 2, "ABCD123");
        bookingSystem.bookParkingSpace(testClient.getEmail(), testLot.getName(), 12, 50, 10, testDate, 10, 2, "WXYZ789");
        boolean result = bookingSystem.checkin(bookingID, testLot.findSpaceById(12));
        assertTrue(result, "checkin successful");
    }
    
    @Test
    void testGetBookingsForClient() throws Exception {
        Client client = new Visitor("test@example.com", "aA1!");
        Date date = new Date();
        Visit visit1 = new Visit(1, date, 9, 2, testLot, testLot.findSpaceById(12), client, 20, "ABCD123");
        Visit visit2 = new Visit(2, date, 12, 1, testLot, testLot.findSpaceById(12), client, 10, "WXYZ789");

        Client otherClient = new Visitor("test2@example.com", "aA1!");
        Visit visit3 = new Visit(3, date, 14, 1, testLot, testLot.findSpaceById(12), otherClient, 10, "ZZZ999");

        Map<Integer, Visit> bookings = new HashMap<>();
        bookings.put(1, visit1);
        bookings.put(2, visit2);
        bookings.put(3, visit3);
        bookingSystem.setBookings(bookings);

        Map<Integer, Visit> result = bookingSystem.getBookingsForClient(client);

        assertEquals(2, result.size());
        assertTrue(result.containsKey(1));
        assertTrue(result.containsKey(2));
        assertFalse(result.containsKey(3));
    }
    @AfterAll
    static void testRemoveTestDataFromDB() {
        clientSystem.removeClient(testClient);
        parkingSystem.removeParkingLot(testLot.getName());
    }
    

}
