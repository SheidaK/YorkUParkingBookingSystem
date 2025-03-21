package businessLogic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import objects.Client;
import objects.ParkingSpace;


public class BookingSystem {
	static Map<String, Visit> bookings = new HashMap<String, Visit>();
	private ParkingSystem parkingSystem;
	
	private static BookingSystem bookingSystem = null;
	
	private BookingSystem(Map<String, Visit> bookings) {
		super();
		BookingSystem.bookings = bookings;
		this.parkingSystem = ParkingSystem.getInstance();
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
        return new HashMap<>(bookings);
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Map<Integer, Visit> bookings) {
		this.bookings = bookings;
	}
	
	public boolean bookParkingSpace(String clientLicense, int parkingSpaceID, int deposit, int time) {
		boolean bookingComplete = false;
		ParkingSpace parkingSpot = parkingSpaceID.getParkingSpace(); 
		Client client = clientLicense.getClient();

		if (!parkingSpot.isOccupied()
			&& parkingSpot.isEnabled()
			&& deposit >= clientLicense.getParkingRate())
			{
			String bookingID = UUID.randomUUID().toString();
			if (parkingSystem.parkCar(String.valueOf(parkingSpaceID), client.getCar()))
				bookingComplete = true;

			SystemDatabase.addRevenue(deposit);
			Date date = new Date();
			Visit visit = new Visit(date, client, parkingSpot.getParkingLot(), parkingSpot, deposit); //need to figure out date
			bookings.put(bookingID, visit);
		}
		return bookingComplete;
	}
	
	public boolean bookParkingSpace(int bookingID, int ParkingID, int time) {
		boolean bookingComplete = false;
		ParkingSpace parkingSpot = ParkingID.getParkingSpace();
		if (!parkingSpot.isOccupied() && parkingSpot.isEnabled() && parkingSystem.parkCar(String.valueOf(ParkingID), client.getCar())) {
			bookingComplete = true;
		}
		return bookingComplete;
	}
	
	public boolean editBooking(int bookingID, int ParkingID, int time) {
		boolean bookingEdited = false;
		ParkingSpace parkingSpot = ParkingID.getParkingSpace();
		
		if (!parkingSpot.isOccupied() && parkingSpot.isEnabled()) {
			cancelBooking(bookingID);
			parkingSpot.removeCar(String.valueOf(ParkingID));
			bookParkingSpace(bookingID, ParkingID, time);
		}
		
		return bookingEdited;
	}
	
	public boolean cancelBooking(int bookingID) {
		boolean bookingCancelled = false;
			if (bookings.containsKey(bookingID)) {
				ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
				parkingSpot.removeCar(parkingSpot);
				bookings.remove(bookingID);
				if (PaymentSystem.confirmRefund(bookingID))
					bookingCancelled = true;
			}
		return bookingCancelled;
	}
	
	public boolean extendBooking(int bookingID, int time) {
		boolean bookingExtended = false;
		Client client = bookings.get(bookingID).getClientDetail();
		ParkingSpace parkingSpot = bookings.get(bookingID).getParkingSpace();
		if (bookings.containsKey(bookingID) && !parkingSpot.isOccupied()) {
			parkingSpot.parkCar(bookingID, client.getCar());
			bookingExtended = true;
		}
		return bookingExtended;
	}
	
	public boolean checkout(int bookingID, int payment) {
		boolean checkedOut = false;
		if (PaymentSystem.confirmPayment(bookingID)) 
			checkedOut = true;
		
		return checkedOut;
	}
	
}
