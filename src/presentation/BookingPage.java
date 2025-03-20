package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import businessLogic.ParkingSystem;
import businessLogic.BookingSystem;

public class BookingPage extends JFrame {
    private JComboBox<String> parkingLotDropdown;
    private JComboBox<String> parkingSpaceDropdown;
    private JTextField licensePlateField;
    private JButton bookButton;
    private ParkingSystem parkingSystem;

    public BookingPage() {
        setTitle("Book a Parking Space");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        parkingSystem = ParkingSystem.getInstance();

        // Parking lot selection
        add(new JLabel("Select Parking Lot:"));
        parkingLotDropdown = new JComboBox<>(new String[]{"Lot A", "Lot B", "Lot C"}); // Dummy values
        add(parkingLotDropdown);

        // Parking space selection
        add(new JLabel("Select Parking Space:"));
        parkingSpaceDropdown = new JComboBox<>(new String[]{"101", "102", "103"}); // Dummy values
        add(parkingSpaceDropdown);

        // License plate input
        add(new JLabel("Enter License Plate:"));
        licensePlateField = new JTextField();
        add(licensePlateField);

        // Book button
        bookButton = new JButton("Book Now");
        add(bookButton);

        // Button action
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String licensePlate = licensePlateField.getText();
                if (licensePlate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid license plate.");
                    return;
                }

                int parkingSpaceID = Integer.parseInt((String) parkingSpaceDropdown.getSelectedItem());
                boolean success = BookingSystem.getInstance().bookParkingSpace(licensePlate, parkingSpaceID, 5, 2);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Booking Successful!");
                    dispose(); // Close the window after successful booking
                    new ConfirmBookingPage(licensePlate, parkingSpaceID).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Booking Failed. Space might be unavailable.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new BookingPage().setVisible(true);
    }
}
