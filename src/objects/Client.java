package objects;
import java.util.ArrayList;

public abstract class Client {
	protected String email;
	protected String password;
	private Car car;
	private ArrayList<Integer> bookings;
	private boolean isValidated;
//	BookingSystem bookingSystem = BookingSystem.getInstance();
//	PaymentSystem paymentSystem = PaymentSystem.getInstance();
	public int money=0;
	public Client(String email, String password) {
		this.email = email;
		this.password = password;
		this.isValidated = false;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public Car getCarInfo() {
		return car;
	}
	public ArrayList<Integer> getBookingsList(){
		return bookings;
	}

    public boolean isValidated() {
        return isValidated;
    }

    // Method to set validation status
    public void setValidated(boolean validated) {
        this.isValidated = validated;
    }
//	public void bookParkingSpace(int parkingSpaceID, int deposit, int time) {
//		bookingSystem.bookParkingSpace(this.car.vehicleLicense,parkingSpaceID,deposit,time);
//	}
//	public void editBooking(int bookingID, int parkingSpaceID, int time) {
//		bookingSystem.editBooking(bookingID, parkingSpaceID, time);
//	}
//	public void cancelBooking(int bookingID) {
//		bookingSystem.cancelBooking(bookingID);
//	}
//	public void extendTime(int bookingID, int time) {
//		bookingSystem.extendBooking(bookingID, time);
//	}
//	public boolean pay(int bookingID, int money, String paymentMethod) {
//		paymentSystem.confirmPayment(bookingID, money, paymentMethod);
//		
//	}
}
