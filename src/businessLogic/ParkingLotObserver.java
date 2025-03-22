package businessLogic;

import java.util.List;

import objects.ParkingSpace;

/**
 * Observer interface for the ParkingLot
 */
public interface ParkingLotObserver {
    void onParkingSpaceStatusChanged(ParkingSpace space);
    void onAvailabilityChanged(List<ParkingSpace> list);
}
