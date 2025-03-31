package main.java.objects;

/**
 * Represents a car that can park in the parking system
 */
public class Car {
    private String licensePlate;
    private String model;
    private String color;
    private Client owner;
    
    public Car(String licensePlate, String model, String color, Client owner) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.owner = owner;
    }
    
    // Getters and setters
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Client getOwner() {
        return owner;
    }
    
    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
    @Override
    public String toString() {
        return licensePlate + " - " + model + " (" + color + ")";
    }
}