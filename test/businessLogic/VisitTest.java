package businessLogic;

import objects.Client;
import objects.ParkingLot;
import objects.ParkingSpace;
import objects.Visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class VisitTest {

    private Client testClient;
    private ParkingLot testLot;
    private ParkingSpace testSpace;
    private Date date;
    private String plate;

    @BeforeEach
    public void setup() {
        testClient = new Visitor("test@example.com", "aA1!");
        testLot = new ParkingLot("Test Lot", "Keele Campus", 15);
        testSpace = new ParkingSpace(1, "Regular");
        plate = "ABCD123";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.APRIL, 10);
        date = new Date();
    }

    @Test
    public void testVisitCreation() {
        Visit visit = new Visit(1, date, 10, 2, testLot, testSpace, testClient, 50, plate);
        assertEquals(plate, visit.getLicence());
        assertEquals(2, visit.getDuration());
        assertEquals(testClient, visit.getClientDetail());
    }

    @Test
    public void testStartTimeConversion() {
        Visit visit = new Visit(2, date, 9, 1, testLot, testSpace, testClient, 50, plate);
        Date start = visit.getStartTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        assertEquals(9, cal.get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void testEndTimeCalculation() {
        Visit visit = new Visit(3, date, 8, 3, testLot, testSpace, testClient, 50, plate);
        Date endTime = visit.getEndTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(endTime);
        assertEquals(11, cal.get(Calendar.HOUR_OF_DAY)); 
    }

    @Test
    public void testDurationIncrement() {
        Visit visit = new Visit(4, date, 12, 1, testLot, testSpace, testClient, 5, plate);
        visit.setDuration(2);
        assertEquals(2, visit.getDuration());
    }

    @Test
    public void testManualDurationSet() {
        Visit visit = new Visit(5, date, 13, 1, testLot, testSpace, testClient, 15, plate);
        visit.setDuration(4);
        assertEquals(4, visit.getDuration());
    }

    @Test
    public void testCheckIn() {
        Visit visit = new Visit(6, date, 14, 2, testLot, testSpace, testClient, 10, plate);
        assertFalse(visit.isCheckedIn());
        visit.checkIn();
        assertTrue(visit.isCheckedIn());
    }

    @Test
    public void testFormattedStartTime() {
        Visit visit = new Visit(7, date, 10, 1, testLot, testSpace, testClient, 5, plate);
        String formatted = visit.getFormattedStartTime();
        assertTrue(formatted.matches("\\d{2}/\\d{2}/\\d{4}"));
    }

    @Test
    public void testVisitLookupById() {
        Visit visit = new Visit(8, date, 11, 2, testLot, testSpace, testClient, 8, plate);
        Visit retrieved = Visit.getVisit("8");
        assertNotNull(retrieved);
        assertEquals(plate, retrieved.getLicence());
    }

    @Test
    public void testHasExceededHourTrue() {
        Visit visit = new Visit(9, date, 6, 2, testLot, testSpace, testClient, 6, plate);
        Date oldTime = new Date(System.currentTimeMillis() - 2 * 60 * 60 * 1000); 
        visit.getStartTime();
        visit.setStartTime(oldTime);
        assertTrue(visit.hasExceededHour());
    }
    
    @Test
    public void testGetVisitById() {
        Visit visit = new Visit(10, date, 10, 1, testLot, testSpace, testClient, 50, plate);
        
        Visit retrievedVisit = Visit.getVisit("10");
        
        assertNotNull(retrievedVisit);
        assertEquals(visit.getBookingID(), retrievedVisit.getBookingID());
    }

    @Test
    public void testSetMoneyPaid() {
        Visit visit = new Visit(11, date, 10, 1, testLot, testSpace, testClient, 10, plate);
        
        visit.setMoneyPaid(10);
        assertEquals(10, visit.getMoneyPaid());
        
        visit.setMoneyPaid(20);
        
        assertEquals(20, visit.getMoneyPaid());
    }

}

