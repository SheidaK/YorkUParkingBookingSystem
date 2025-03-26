package businessLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import database.Database;
import objects.Client;
import objects.ParkingLot;
import objects.ParkingSensor;
import objects.ParkingSpace;
import objects.ParkingStatusObserver;

public class BookingSystem implements ParkingStatusObserver{
    Map<Integer, Visit> bookings = new HashMap<Integer, Visit>();
    private static BookingSystem bookingSystem = null;
    private ClientSystem clientSystem;
    private ParkingSystem parkingSystem = ParkingSystem.getInstance();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	String path = "src/database/BookingsDatabase.csv";
    private Database db = new Database(path);
    private BookingSystem() throws Exception {
        // Get reference to SystemDatabase
        this.clientSystem = ClientSystem.getInstance();
        startNoShowCheck(); //initalize periodic no show check
        List<String[]> dataBookings = db.read();
		for(String[] row:dataBookings) {
			if(!row[0].isEmpty()) {
			int bookingId = Integer.valueOf(row[0].trim());
			Date date = convertIntToDate(row[1].trim());
			int startTime = Integer.valueOf(row[2].trim());
			int duration = Integer.valueOf(row[3].trim());
			ParkingLot lot = parkingSystem.getParkingLotInfo(row[4]);
			ParkingSpace s = lot.findSpaceById(Integer.valueOf(row[5]));
			s.occupyTime(bookingId, date, startTime, duration);
			Client c = clientSystem.getClientInfo(row[6].trim());
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
    		if(entry.getValue().getClientDetail()!=null) {
	    		if(entry.getValue().getClientDetail().getEmail().equals(c.getEmail())) {
	    			bookingsClient.put(entry.getKey(),entry.getValue());
	    		}
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
        //int id =generateBookingID();
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
        int bookingID=0;
        // Get client by email
        Client client = clientSystem.getClientInfo(clientEmail);
        if (parkingSpot != null && client != null && 
            !parkingSpot.isOccupied(date, time,duration) && 
            parkingSpot.isEnabled() && 
            deposit >= client.getParkingRate()) {

        	bookingID = generateBookingID();
            //parkingSpot.occupyTime(bookingID,date, time,duration);
            SystemDatabaseFacade.addRevenue(deposit);

           // Date date = new Date();
			Visit visit = new Visit(bookingID,date,time,duration,parkingLot,parkingSpot,client,deposit,license);

            bookings.put(bookingID, visit);
            parkingSpot.occupyTime(bookingID, date, initialtime,duration);
            bookingComplete = true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(date);
        
        if(bookingComplete) {
        	String[] newRow = {String.valueOf(bookingID),formattedDate, String.valueOf(initialtime),String.valueOf(duration), parkingLotName, String.valueOf(parkingSpaceID),clientEmail,license,String.valueOf(deposit)};
        	db.update(newRow);
        }
        return bookingComplete;
    }

    public int generateBookingID() {
        // Simple booking ID generation
        return bookings.size() + 1;
    }

    public boolean bookParkingSpace(int bookingID, String parkingLotName, int parkingSpaceID, int time, Date date,int duration) {
        boolean bookingComplete = false;
        
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
       
        if (parkingSpot != null && !parkingSpot.isOccupied(date,time,duration) && parkingSpot.isEnabled()) {
            parkingSpot.occupyTime(bookingID, date, time,duration);
            bookingComplete = true;
            
        }
        return bookingComplete;
    }

    public boolean editBooking(int bookingID, String parkingLotName, int parkingSpaceID, int time,Date date,int duration,Client c,String license) {
        boolean bookingEdited = false;
        
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
        
        if (parkingSpot != null && !parkingSpot.isOccupied(date,time,duration) && parkingSpot.isEnabled()) {
        	 Date currentDate = new Date();
             Date bookedDate = bookings.get(bookingID).convertIntToDate(bookings.get(bookingID).getInitialTime());
             if (currentDate.before(bookedDate)){
                // int id =generateBookingID();
            	 cancelBooking(bookingID,true);
            	 parkingSpot.unoccupyTime(bookingID);
            	 bookParkingSpace(c.getEmail(), parkingLotName,parkingSpaceID,c.getParkingRate(), time,date,time,duration,license);
	        	
	             
	            bookingEdited = true;
             }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(date);
        if(bookingEdited) {
        	String[] newRow = {String.valueOf(bookingID),formattedDate, String.valueOf(time),String.valueOf(duration), parkingLotName, String.valueOf(parkingSpaceID),c.getEmail(),license,String.valueOf(c.getParkingRate())};
        	db.overWrite(String.valueOf(bookingID), newRow,9);
        }

        return bookingEdited;
    }



    public boolean cancelBooking(int bookingID, boolean newBooking) {
        boolean bookingCancelled = false;
        if (checkForNoShow(bookingID)&& !newBooking) {
        	checkout(bookingID, Visit.getVisit(bookingID).getClientDetail().getParkingRate());
            bookings.remove(bookingID);
            bookingCancelled = true;
            db.remove(String.valueOf(bookingID),9);
        }
        else if (bookings.containsKey(bookingID)) {
            ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
            Date currentDate = new Date();
            Date bookedDate = bookings.get(bookingID).convertIntToDate(bookings.get(bookingID).getInitialTime());
            if (currentDate.before(bookedDate)){
            //if (confirmRefund(bookingID)) {
                parkingSpot.unoccupy(bookingID);
                bookings.remove(bookingID);
                bookingCancelled = true;
                db.remove(String.valueOf(bookingID),9);
            //}
            }
            
        }
        return bookingCancelled;
    }

    private boolean confirmRefund(int bookingID) {
        // Get payment system and confirm refund
        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        return paymentSystem.confirmRefund(bookingID);
    }

    public boolean extendBooking(int bookingID, Date date,int time,int duration) {
        boolean bookingExtended = false;
        if (bookings.containsKey(bookingID)) {
            ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
            Date currentDate = new Date();
            Date endDate = bookings.get(bookingID).getEndTime();
            if (currentDate.before(endDate) && !parkingSpot.isOccupied(date,time,duration)) {
            	bookings.get(bookingID).setDuration(duration);
            	db.overWrite(String.valueOf(bookingID),9,3,String.valueOf(duration),0);
                //parkingSpot.occupyTime(bookingID,date, time,duration);
                bookingExtended = true;
            }
        }
        return bookingExtended;
    }

    public boolean checkout(int bookingID, int payment) {
        Visit visit = Visit.getVisit(bookingID);
        Date currentTime = new Date();
        if (currentTime.before(visit.getEndTime())) {
            return false;
        }
        
        ParkingSpace s = visit.getParkingSpace();
        boolean checkedOut = false;

        // if (confirmPayment(bookingID, payment)) {
            checkedOut = true;
            if (visit.getEndTime() == null) {
                visit.setEndTime(currentTime);
            } 
        //} else {
        //    return false;
        //}

        new Thread(() -> {
            try {
                Thread.sleep(200); 
                if (!checkIfVehicleLeft(bookingID, s.getSpaceId())) {
                    System.out.println("Vehicle is still in the parking space after checkout.");
                }
            } catch (InterruptedException e) {
            }
        }).start();

        return checkedOut;
    }
    
    public boolean checkin(int bookingID, ParkingSpace s) {
    	Visit visit = Visit.getVisit(bookingID);
    	boolean checkedIn = false;
    	if (visit.hasExceededHour())
    		checkedIn = true;
    	return checkedIn;
    }

    private boolean confirmPayment(int bookingID, int payment) {
        // Get payment system and confirm payment
        PaymentSystem paymentSystem = PaymentSystem.getInstance();
        return paymentSystem.confirmPayment(bookingID, "CREDIT_CARD", payment);
    }
    
    public boolean checkForNoShow(int bookingId) {
        Visit visit = bookings.get(bookingId);
        if (visit != null && visit.hasExceededHour() && !visit.isCheckedIn()) {
            return true; 
        }
        return false;
    }
    
    public void checkForNoShows() {
        for (Visit visit : bookings.values()) {
            if (visit.hasExceededHour() && !visit.isCheckedIn()) {
            	cancelBooking(Integer.valueOf(visit.getBookingID()),false);
            }
            else 
            	visit.setDuration();
        }
    }
    
    private void startNoShowCheck() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            checkForNoShows(); 
        }, 0, 1, TimeUnit.HOURS); 
    }
    
    private boolean checkIfVehicleLeft(int bookingID, int parkingSpaceId) {
    	Visit visit = Visit.getVisit(bookingID);
        ParkingSpace s = visit.getParkingSpace();
        if (s.isOccupied() && s.getParkedCar().getLicensePlate().equalsIgnoreCase(visit.getLicence())) {
        	return false;
        } else {
        	return true;
        }
    }
    
	@Override
	public void update(ParkingSpace s, boolean occupied) {
    	String bookingId = s.getBookingId();
    	Visit visit = Visit.getVisit(bookingId);
    	if (occupied == false) {
    		checkout(Integer.valueOf(s.getBookingId()), visit.getDuration() * visit.getClientDetail().getParkingRate() - visit.getMoneyPaid());
    	}
    	
    	else if (occupied == true && s.getParkedCar().getLicensePlate().equalsIgnoreCase(visit.getLicence())) {
    		checkin(Integer.valueOf(s.getBookingId()), s);
    	}		
	}
    
    public void updateParkingAvailability(ParkingSpace space) {
        // This method is for updating parking availability when changes occur
        // For example, when space status changes, update any affected bookings
    }
    private Date convertIntToDate(String dateString) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
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