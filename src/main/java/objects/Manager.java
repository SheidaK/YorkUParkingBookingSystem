package main.java.objects;

import java.util.ArrayList;
import java.util.HashMap;

import main.java.businessLogic.PaymentSystem;
import main.java.businessLogic.SystemDatabaseFacade;


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



    // Enable a parking lot
    public boolean enableParkingLot(String parkingLotID) {
        return SystemDatabaseFacade.getInstance().statusParkingLot(parkingLotID, true);
    }

    // Disable a parking lot
    public boolean disableParkingLot(String parkingLotID) {
        return SystemDatabaseFacade.getInstance().statusParkingLot(parkingLotID, false);
    }

    // Validate University Staff
    public boolean validateUniversityStaff(Client user) {
        return SystemDatabaseFacade.getInstance().approveUser(user);
    }

    // Approve transaction for booking
    public boolean approveTransaction(int bookingID, String paymentMethods, int amount) {
        return PaymentSystem.getInstance().confirmPayment(bookingID, paymentMethods, amount);
    }
}
