package businessLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.Database;
import objects.Client;
import objects.ParkingLot;
import objects.ParkingSpace;
import objects.ParkingStatusObserver;

public class BookingSystem implements ParkingStatusObserver{
    static Map<Integer, Visit> bookings = new HashMap<Integer, Visit>();
    private static BookingSystem bookingSystem = null;
    private SystemDatabase systemDatabase;
    private ParkingSystem parkingSystem = ParkingSystem.getInstance();
	String path = "src/database/BookingsDatabase.csv";
    private Database db = new Database(path);
    private BookingSystem() throws Exception {
        // Get reference to SystemDatabase
        this.systemDatabase = SystemDatabase.getInstance();
        List<String[]> dataBookings = db.read();
		for(String[] row:dataBookings) {
			if(!row[0].isEmpty()) {
			int bookingId = Integer.valueOf(row[0].trim());
			Date date = convertIntToDate(row[1].trim());
			int startTime = Integer.valueOf(row[2].trim());
			int duration = Integer.valueOf(row[3].trim());
			ParkingLot lot = parkingSystem.getParkingLotInfo(row[4]);
			ParkingSpace s = lot.findSpaceById(Integer.valueOf(row[5]));
			Client c = systemDatabase.getClientInfo(row[6].trim());
			String license = row[7].trim();
			int moneyPaid = Integer.valueOf(row[8].trim());
			//row[1]=date
			Visit v = new Visit(bookingId,date,startTime,duration,lot,s,c,moneyPaid,license);
			s.getSensor().addObserver((ParkingStatusObserver) lot);
			bookings.put(Integer.valueOf(row[0]),v);
			}
		}
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
    public Map<Integer,Visit> getBookingsForClient(Client c){
    	Map<Integer,Visit> bookingsClient = new HashMap<Integer, Visit>();
    	for (Map.Entry<Integer, Visit> entry : bookings.entrySet()) {
    		if(entry.getValue().getClientDetail().getEmail().equals(c.getEmail())) {
    			bookingsClient.put(entry.getKey(),entry.getValue());
    		}
    	}
    	return bookingsClient;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(Map<Integer, Visit> bookings) {
        this.bookings = bookings;
    }

    public boolean bookParkingSpace(String clientEmail, String parkingLotName, int parkingSpaceID, int deposit, int time, Date date,int initialtime, int duration, String license) {
        boolean bookingComplete = false;
        int id =generateBookingID();
        // Get parking lot by ID
        ParkingLot parkingLot = null;
        for (ParkingLot lot : parkingSystem.getAvailableLots()) {
            if (lot.getName().equals(parkingLotName)) {
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
            !parkingSpot.isOccupied(date, time) && 
            parkingSpot.isEnabled() && 
            deposit >= client.getParkingRate()) {
            
            int bookingID = generateBookingID();
            parkingSpot.occupyTime(bookingID,date, time);
            
            SystemDatabase.addRevenue(deposit);
           // Date date = new Date();
			Visit visit = new Visit(bookingID,date,time,duration,parkingLot,parkingSpot,client,deposit,license);

            bookings.put(bookingID, visit);
            parkingSpot.occupyTime(bookingID, date, initialtime);
            bookingComplete = true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(date);
        
        if(bookingComplete) {
        	String[] newRow = {String.valueOf(id),formattedDate, String.valueOf(initialtime),String.valueOf(duration), parkingLotName, String.valueOf(parkingSpaceID),clientEmail,license,String.valueOf(deposit)};
        	db.update(newRow);
        }
        return bookingComplete;
    }

    public int generateBookingID() {
        // Simple booking ID generation
        return bookings.size() + 1;
    }

    public boolean bookParkingSpace(int bookingID, String parkingLotName, int parkingSpaceID, int time, Date date) {
        boolean bookingComplete = false;
        
        // Get parking lot by ID
        ParkingLot parkingLot = null;
        for (ParkingLot lot : systemDatabase.getParkingLots()) {
            if (lot.getName().equals(parkingLotName)) {
                parkingLot = lot;
                break;
            }
        }
        
        if (parkingLot == null) {
            return false; // Parking lot not found
        }
        
        // Get parking space by ID
        ParkingSpace parkingSpot = parkingLot.findSpaceById(parkingSpaceID);
        
        if (parkingSpot != null && !parkingSpot.isOccupied(date,time) && parkingSpot.isEnabled()) {
            parkingSpot.occupyTime(bookingID, date, time);
            bookingComplete = true;
        }
        return bookingComplete;
    }

    public boolean editBooking(int bookingID, String parkingLotName, int parkingSpaceID, int time,Date date) {
        boolean bookingEdited = false;
        
        // Get parking lot by ID
        ParkingLot parkingLot = null;
        for (ParkingLot lot : systemDatabase.getParkingLots()) {
            if (lot.getName().equals(parkingLotName)) {
                parkingLot = lot;
                break;
            }
        }
        
        if (parkingLot == null) {
            return false; // Parking lot not found
        }
        
        // Get parking space by ID
        ParkingSpace parkingSpot = parkingLot.findSpaceById(parkingSpaceID);

        if (parkingSpot != null && !parkingSpot.isOccupied(date,time) && parkingSpot.isEnabled()) {
            cancelBooking(bookingID);
            parkingSpot.unoccupyTime(bookingID);
            bookParkingSpace(bookingID, parkingLotName, parkingSpaceID, time,date);
            bookingEdited = true;
        }

        return bookingEdited;
    }

    public boolean cancelBooking(int bookingID) {
        boolean bookingCancelled = false;
        if (bookings.containsKey(bookingID)) {
            ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
            parkingSpot.unoccupy(bookingID);
            //if (confirmRefund(bookingID)) {
                bookings.remove(bookingID);
                bookingCancelled = true;
                db.remove(String.valueOf(bookingID),9);
            //}
            
        }
        return bookingCancelled;
    }

    private boolean confirmRefund(int bookingID) {
        // Get payment system and confirm refund
        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        return paymentSystem.confirmRefund(bookingID);
    }

    public boolean extendBooking(int bookingID, Date date,int time) {
        boolean bookingExtended = false;
        if (bookings.containsKey(bookingID)) {
            ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
            if (!parkingSpot.isOccupied(date,time)) {
                parkingSpot.occupyTime(bookingID,date, time);
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
    
    public boolean checkin(int bookingID, ParkingSpace s) {
    	Visit visit = Visit.getVisit(bookingID);
    	boolean checkedIn = false;
    	Date declaredTime = new Date(System.currentTimeMillis() - (15 * 60 * 1000));
    	if (declaredTime.compareTo(visit.getStartTime()) < 0)
    		checkedIn = true;
    	return checkedIn;
    }

    private boolean confirmPayment(int bookingID, int payment) {
        // Get payment system and confirm payment
        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        return paymentSystem.confirmPayment(bookingID, "CREDIT_CARD", payment);
    }
    
	@Override
	public void update(ParkingSpace s, boolean occupied) {
    	String bookingId = s.getBookingId();
    	Visit visit = Visit.getVisit(bookingId);
    	if (occupied == false) {
    		checkout(Integer.valueOf(s.getBookingId()), visit.getDuration() * visit.getClientDetail().getParkingRate() - visit.getMoneyPaid());
    	}
    	
    	else if (occupied == true && s.getParkedCar().getLicensePlate().equals(visit.getLicence())) {
    		checkin(Integer.valueOf(s.getBookingId()), s);
    	}		
	}
    
    public void updateParkingAvailability(ParkingSpace space) {
        // This method is for updating parking availability when changes occur
        // For example, when space status changes, update any affected bookings
    }
    private Date convertIntToDate(String dateString) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date= null;
         try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return date;
        }



}