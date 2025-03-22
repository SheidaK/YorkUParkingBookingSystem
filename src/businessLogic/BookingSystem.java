package businessLogic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import objects.*;

public class BookingSystem {
	static Map<String, Visit> bookings = new HashMap<String, Visit>();
	
	private static BookingSystem bookingSystem = null;
	
<<<<<<< HEAD
	private BookingSystem(Map<Integer, Visit> bookings) {
=======
	private BookingSystem(Map<String, Visit> bookings) {
>>>>>>> a29064c (changed to include duration of booking and visit)
		//super();
		this.bookings = bookings;
	}

	public static synchronized BookingSystem getInstance() {
		if (bookingSystem == null)
			bookingSystem = new BookingSystem(bookings);
		return bookingSystem;
	}
	
	/**
	 * @return the bookings
	 */
	public Map<String, Visit> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Map<String, Visit> bookings) {
		this.bookings = bookings;
	}
	

	public boolean bookParkingSpace(String clientLicense, int parkingLotID, int parkingSpaceID, int deposit, int startTime, int hours) {
		boolean bookingComplete = false;
	    long endTimeInMillis = startTime + (hours * 60 * 60 * 1000);
	    Date endTime = new Date(endTimeInMillis);

		ParkingSpace parkingSpot = parkingSpaceID.getInstance().getParkingSpace(); //Need to get parking spot info from parking spot class (parameter: ID)
		//will also need one for parking lot
		if (!parkingSpot.isOccupied(startTime, endTime) //Need to know if parking spot is occupied at start time all the way to end time
			&& parkingSpot.isEnabled() //Need to know if parking spot is enabled, info from parking spot class
			&& deposit >= clientLicense.getParkingRate()) //Need to get parking rate from client classes
			{
			String bookingID = UUID.randomUUID().toString();
			parkingSpot.setOccupied(bookingID, startTime, endTime);  //have it at end time for now but i can change to hour if needed
			//Need to be able to state what time client wants to book parking spot, can remove booking id if needed but need to occupy from 
			//start time to end time, can change end time to hours if needed
			SystemDatabase.addRevenue(deposit);
			Client client = clientLicense.getClient(); //need to be able to access client and client needs to store license plate
			Date date = new Date();
			Visit visit = new Visit(startTime, endTime, client, parkingSpot.getInstance().getParkingLot(), parkingSpot, deposit); //need to figure out date
			bookings.put(bookingID, visit);
			bookingComplete = true;
		}
		return bookingComplete;
	}
	
	public boolean bookParkingSpace(String bookingID, int ParkingID, int startTime, int hours) {
		boolean bookingComplete = false;
	    long endTimeInMillis = startTime + (hours * 60 * 60 * 1000); // Convert hours to milliseconds
	    Date endTime = new Date(endTimeInMillis);
	    
		ParkingSpace parkingSpot = ParkingID.getParkingSpace();
		if (!parkingSpot.isOccupied(startTime, endTime) && parkingSpot.isEnabled()) {
			parkingSpot.setOccupied(bookingID, startTime, endTime); 
			bookingComplete = true;
		}
		return bookingComplete;
	}
	
	public boolean editBooking(String bookingID, int ParkingID, int startTime, int hours) {
		boolean bookingEdited = false;
		ParkingSpace parkingSpot = ParkingID.getinstance().getParkingSpace();
	    long endTimeInMillis = startTime + (hours * 60 * 60 * 1000); // Convert hours to milliseconds
	    Date endTime = new Date(endTimeInMillis);
	    Visit visit = Visit.getVisit(bookingID);
		
		if (!parkingSpot.isOccupied(startTime, endTime) && parkingSpot.isEnabled()) {
			cancelBooking(bookingID);
			parkingSpot.unOccupy(startTime, endTime); //remove occupied status from start time to end time, can change to hours if needed
			bookParkingSpace(bookingID, ParkingID, startTime, hours);
			
		}
		
		return bookingEdited;
	}
	
	public boolean cancelBooking(String bookingID) {
		boolean bookingCancelled = false;
		Visit visit = Visit.getVisit(bookingID);
			if (bookings.containsKey(bookingID)) {
				ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
				parkingSpot.unOccupy(visit.startTime, visit.endTime);
				bookings.remove(bookingID);
				if (PaymentSystem.confirmRefund(bookingID))
					bookingCancelled = true;
			}
		return bookingCancelled;
	}
	
	public boolean extendBooking(String bookingID, int endTime, int hours) {
		boolean bookingExtended = false;
        Visit visit = bookings.get(bookingID);
        long currentEndTime = endTime + visit.getDuration();  // Get the current end time in hours
        Date newEndTime = new Date(currentEndTime + hours); 
		ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
		if (bookings.containsKey(bookingID) && !parkingSpot.isOccupied(currentEndTime, newEndTime)) {
			parkingSpot.setOccupied(bookingID, currentEndTime, newEndTime);
			bookingExtended = true;
		}
		return bookingExtended;
	}
	
	public boolean checkout(String bookingID, int payment, String paymentMethod) {
		boolean checkedOut = false;
		if (PaymentSystem.confirmPayment(bookingID, paymentMethod,  )) 
			checkedOut = true;
		
		return checkedOut;
	}

	public void updateParkingAvailability(ParkingSpace space) {
		// TODO Auto-generated method stub
		
	}
	
}
