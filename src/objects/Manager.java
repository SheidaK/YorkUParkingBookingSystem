package objects;

import java.util.ArrayList;
import java.util.HashMap;

import businessLogic.PaymentSystem;
import businessLogic.SystemDatabase;


public class Manager {
    protected String userName;
    protected String password;

    public Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return "Manager";
    }

//    // Add a new parking lot
//    public boolean addParkingLot() {
//        return SystemDatabase.getInstance().addParkingLot();
//    }

    // Enable a parking lot
    public boolean enableParkingLot(String parkingLotID) {
        return SystemDatabase.getInstance().setParkingLotStatus(parkingLotID, true);
    }

    // Disable a parking lot
    public boolean disableParkingLot(String parkingLotID) {
        return SystemDatabase.getInstance().setParkingLotStatus(parkingLotID, false);
    }

//    // Enable a specific parking space
//    public boolean enableParkingSpace(String parkingLotID, String parkingSpaceID) {
//        return SystemDatabase.getInstance().setParkingSpaceStatus(parkingLotID, parkingSpaceID, true);
//    }
//
//    // Disable a specific parking space
//    public boolean disableParkingSpace(String parkingLotID, String parkingSpaceID) {
//        return SystemDatabase.getInstance().setParkingSpaceStatus(parkingLotID, parkingSpaceID, false);
//    }

    // Validate University Staff
    public boolean validateUniversityStaff(Client user) {
        return SystemDatabase.getInstance().approveUser(user);
    }

    // Approve transaction for booking
    public boolean approveTransaction(int bookingID, String paymentMethods, int amount) {
        return PaymentSystem.getInstance().confirmPayment(bookingID, paymentMethods, amount);
    }
}
