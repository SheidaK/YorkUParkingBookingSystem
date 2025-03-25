package businessLogic;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;


import objects.*;

public class Visit {	
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    private static Map<String, Visit> visitDatabase = new HashMap<>();

    private int bookingId;
    private Date date;
    private int startTime;
    private Date startTimeDate;
    private Date endTimeDate;
    private int duration;
    private ParkingLot lot;
    private ParkingSpace s;
    private Client clientDetail;
    private String license;
    private boolean checkedIn;
	int moneyPaid;
	public Visit(int bookingId,Date date, int startTime, int duration, ParkingLot lot, ParkingSpace s,Client c, int moneyPaid,String license) {
		this.bookingId=bookingId;
		this.date=date;
		this.startTime=startTime;
		this.duration=duration;
		this.lot=lot;
		this.s=s;
		this.clientDetail=c;
		this.license = license;
		String id = String.valueOf(bookingId);
		this.checkedIn = false;
		visitDatabase.putIfAbsent(id, this);
	}
	/**
	 * @return the start time
	 */
	public Date getStartTime() {
		startTimeDate = convertIntToDate(this.startTime);
		return startTimeDate;
	}
	public int getInitialTime() {
		return startTime;
	}
	/**
	 * @param date the date to set
	 */
	public void setStartTime(int newStartTime) {
        this.startTimeDate = convertIntToDate(newStartTime);
	}
	
    public void setStartTime(Date newStartTime) {
        if (newStartTime != null && newStartTime.after(startTimeDate))
            this.startTimeDate = newStartTime;
      
    }
	
    public Date getEndTime() {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(getStartTime());
    	calendar.add(Calendar.HOUR,this.duration);
    	this.endTimeDate = calendar.getTime();
        return endTimeDate;
    }
    
	public void setEndTime(int newEndTime) {
        this.endTimeDate = convertIntToDate(newEndTime);
	}
	
    
    public void setEndTime(Date newEndTime) {
        if (newEndTime != null && newEndTime.after(startTimeDate))
            this.endTimeDate = newEndTime;
      
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
		return lot;
	}
	/**
	 * @param parkingLot the parkingLot to set
	 */
	public void setParkingLot(ParkingLot parkingLot) {
		this.lot = parkingLot;
	}
	/**
	 * @return the parkingSpace
	 */
	public ParkingSpace getParkingSpace() {
		return s;
	}
	/**
	 * @param parkingSpace the parkingSpace to set
	 */
	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.s = parkingSpace;
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
		return String.valueOf(this.bookingId);
	}
	
	public void setBookingID(String bookingID) {
		this.bookingId = Integer.valueOf(bookingID);
	}
	
    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkIn() {
        this.checkedIn = true;
    }
	
	public static Visit getVisit(String bookingID) {
		return visitDatabase.get(bookingID);
	}
	
    public boolean hasExceededHour() {
        long timeDifference = new Date().getTime() - startTime;
        return timeDifference > (1 * 60 * 60 * 1000);
    }
    
	public static Visit getVisit(int bookingID) {
		String str = String.valueOf(bookingID);
		return visitDatabase.get(str);
	}
	
    public String getFormattedStartTime() {
        return DATE_FORMAT.format(startTime);
    }
    
    public String getFormattedEndTime() {
        return DATE_FORMAT.format(endTimeDate);
    }
    
    Date convertIntToDate(int startTime) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.date);
        calendar.set(Calendar.HOUR_OF_DAY, startTime);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        return calendar.getTime(); // Return the Date object
        
    }
    
    public void setDuration() {
    	this.duration =+ 1;
    }
    
    public void setDuration(int time) {
    	this.duration = time;
    }
    
	public int getDuration() {
		return duration;
//		    long durationInMillis = endTimeDate.getTime() - startTimeDate.getTime(); 
//		    int durationInHours = (int) (durationInMillis / (1000 * 60 * 60));
//		    return durationInHours; 
	}
	public String getLicence() {
		// TODO Auto-generated method stub
		return this.license;
	}
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}
	public String getDateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate;
	}
		
}