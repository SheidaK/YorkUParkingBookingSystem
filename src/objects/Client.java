package objects;

public class Client {
    private String email;
    private String password;
    private boolean validated;
    private int parkingRate; 

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
        this.validated = false;
        this.parkingRate = 50; 
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public int getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(int parkingRate) {
        this.parkingRate = parkingRate;
    }
}