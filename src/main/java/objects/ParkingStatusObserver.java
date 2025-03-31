package main.java.objects;
/**
 * Observer interface for the Observer pattern
 */
public interface ParkingStatusObserver {
   public abstract void update(ParkingSpace space, boolean occupied);
}