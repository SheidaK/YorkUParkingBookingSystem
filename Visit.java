import java.util.*;

public class Visit {
	Date date = new Date(); //change date from String to Date(?), might help with calculating time
	Client clientDetail;
	ParkingLot parkingLot;
	ParkingSpace parkingSpace;
	int moneyPaid = 0;
	//consider adding a time
	public Visit(Date date, Client clientDetail, ParkingLot parkingLot, ParkingSpace parkingSpace, int moneyPaid) {
		super();
		this.date = date;
		this.clientDetail = clientDetail;
		this.parkingLot = parkingLot;
		this.parkingSpace = parkingSpace;
		this.moneyPaid = moneyPaid;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	
	
}
