import java.util.*;

public class BookingSystem {
	static Map<Integer, Visit> bookings = new HashMap<Integer, Visit>();
	
	private static BookingSystem bookingSystem = null;
	
	private BookingSystem(Map<Integer, Visit> bookings) {
		super();
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
	public Map<Integer, Visit> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Map<Integer, Visit> bookings) {
		this.bookings = bookings;
	}
	
	public boolean bookParkingSpace(String clientLicense, int parkingSpaceID, int deposit, int time) {
		boolean bookingComplete = false;
		ParkingSpace parkingSpot = parkingSpaceID.getParkingSpace(); //Need to get parking spot info from parking spot class (parameter: ID)
		//will also need one for parking lot
		if (!parkingSpot.occupied(time) //Need to know if parking spot is occupied at time, need info from parking spot class
			&& parkingSpot.enabled() //Need to know if parking spot is enabled, info from parking spot class
			&& deposit >= clientLicense.getParkingRate()) //Need to get parking rate from client classes
			{
			int bookingID = 0; //create bookingID (need to think about how to generate, discuss later)
			parkingSpot.occupyTime(bookingID, time); 
			//Need to be able to state what time client wants to book parking spot, 
			//needed in parking spot class, use time and bookingID as parameter
			SystemDatabase.addRevenue(deposit);
			Client client = clientLicense.getClient(); //need to be able to access client and client needs to store license plate
			Date date = new Date();
			Visit visit = new Visit(date, client, parkingSpot.getParkingLot(), parkingSpot, deposit); //need to figure out date
			bookings.put(bookingID, visit);
			bookingComplete = true;
		}
		return bookingComplete;
	}
	
	public boolean bookParkingSpace(int bookingID, int ParkingID, int time) {
		boolean bookingComplete = false;
		ParkingSpace parkingSpot = ParkingID.getParkingSpace();
		if (!parkingSpot.occupied(time) && parkingSpot.enabled()) {
			parkingSpot.occupyTime(bookingID, time); 
			bookingComplete = true;
		}
		return bookingComplete;
	}
	
	public boolean editBooking(int bookingID, int ParkingID, int time) {
		boolean bookingEdited = false;
		ParkingSpace parkingSpot = ParkingID.getParkingSpace();
		
		if (!parkingSpot.occupied(time) && parkingSpot.enabled()) {
			cancelBooking(bookingID);
			parkingSpot.unoccupyTime(bookingID); //need a class in parking spot class that will remove time given bookingID, needs to make parking spot available
			bookParkingSpace(bookingID, ParkingID, time);
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
	
	public boolean extendBooking(int bookingID, int time) {
		boolean bookingExtended = false;
		ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
		if (bookings.containsKey(bookingID) && !parkingSpot.occupied(time)) {
			parkingSpot.occupyTime(bookingID, time);
			bookingExtended = true;
		}
		return bookingExtended;
	}
	
	public boolean checkout(int bookingID, int payment) {
		boolean checkedOut = false;
		if (confirmPayment(bookingID)) 
			checkedOut = true;
		
		return checkedOut;
	}
	
}
