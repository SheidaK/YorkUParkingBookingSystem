package businessLogic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;


import objects.*;

public class Visit {

	Client clientDetail;
	ParkingLot parkingLot;
	ParkingSpace parkingSpace;
	Date startTime;  
	Date endTime;
	int moneyPaid = 0;
	String bookingID = "";
	
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    private static Map<String, Visit> visitDatabase = new HashMap<>();

	
	public Visit(Date startTime, Date endTime, Client clientDetail, ParkingLot parkingLot, ParkingSpace parkingSpace, int moneyPaid, String bookingID) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.clientDetail = clientDetail;
		this.parkingLot = parkingLot;
		this.parkingSpace = parkingSpace;
		this.moneyPaid = moneyPaid;
		this.bookingID = bookingID;
		
		visitDatabase.put(bookingID, getVisit(bookingID));
	}
	/**
	 * @return the start time
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param date the date to set
	 */
	public void setStartTime(Date newStartTime) {
       if (newStartTime != null && newStartTime.after(new Date()))
    	   this.startTime = newStartTime;
	}
	
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date newEndTime) {
        if (newEndTime != null && newEndTime.after(startTime))
            this.endTime = newEndTime;
      
    }
    
	/**
	 * @return the clientDetail
	 */
	public Client getClientDetail() {
		return clientDetail;
	}
	/**
	 * @param clientDetail the clientDetail to set
	 */
	public void setClientDetail(Client clientDetail) {
		this.clientDetail = clientDetail;
	}
	/**
	 * @return the parkingLot
	 */
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	/**
	 * @param parkingLot the parkingLot to set
	 */
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	/**
	 * @return the parkingSpace
	 */
	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}
	/**
	 * @param parkingSpace the parkingSpace to set
	 */
	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	/**
	 * @return the moneyPaid
	 */
	public int getMoneyPaid() {
		return moneyPaid;
	}
	/**
	 * @param moneyPaid the moneyPaid to set
	 */
	public void setMoneyPaid(int moneyPaid) {
		this.moneyPaid = moneyPaid;
	}
	
	public String getBookingID() {
		return this.bookingID;
	}
	
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	
	public static Visit getVisit(String bookingID) {
		return visitDatabase.get(bookingID);
	}
	
    public String getFormattedStartTime() {
        return DATE_FORMAT.format(startTime);
    }
    
    public String getFormattedEndTime() {
        return DATE_FORMAT.format(endTime);
    }
    
	public int getDuration() {
		    long durationInMillis = endTime.getTime() - startTime.getTime(); 
		    int durationInHours = (int) (durationInMillis / (1000 * 60 * 60));
		    return durationInHours; 
	}
	
}
