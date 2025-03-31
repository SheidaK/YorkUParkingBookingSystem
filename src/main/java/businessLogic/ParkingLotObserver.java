package main.java.businessLogic;

import java.util.List;

import main.java.objects.ParkingSpace;

/**
 * Observer interface for the ParkingLot
 */
public interface ParkingLotObserver {
    void onParkingSpaceStatusChanged(ParkingSpace space);
    void onAvailabilityChanged(List<ParkingSpace> list);
}
