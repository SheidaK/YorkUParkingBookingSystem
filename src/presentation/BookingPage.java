package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import businessLogic.BookingSystem;
import businessLogic.SystemDatabase;
import objects.ParkingLot;
import objects.ParkingSpace;

public class BookingPage extends JFrame {
    // First panel components - Date and time selection
    private JPanel dateTimePanel;
    private JSpinner dateSpinner;
    private JSpinner hourSpinner;
    private JComboBox<String> amPmComboBox;
    private JSpinner durationSpinner;
    private JButton confirmDateTimeButton;
    
    // Second panel components - Parking selection
    private JPanel parkingSelectionPanel;
    private JComboBox<String> parkingLotDropdown;
    private JComboBox<String> parkingSpaceDropdown;
    private JTextField licensePlateField;
    private JButton bookButton;
    private JButton backButton;
    
    // System components
    private SystemDatabase systemDatabase;
    private BookingSystem bookingSystem;
    private Date selectedDate;
    private int selectedTimeSlot; // 24-hour format time slot
    private int selectedDuration; // Duration in hours
    
    // Maps to track the actual objects behind the dropdown strings
    private Map<String, ParkingLot> parkingLotMap;
    private Map<String, ParkingSpace> parkingSpaceMap;
    public BookingPage() {
        setTitle("Book a Parking Space");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Initialize system components
        systemDatabase = SystemDatabase.getInstance();
        try {
            bookingSystem = BookingSystem.getInstance();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error initializing booking system: " + e.getMessage(), 
                                         "System Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            dispose(); 
            return;
        }
        parkingLotMap = new HashMap<>();
        parkingSpaceMap = new HashMap<>();
        
        setLayout(new CardLayout());
        
        initializeDateTimePanel();
        initializeParkingSelectionPanel();
        
        add(dateTimePanel, "dateTimePanel");
        add(parkingSelectionPanel, "parkingSelectionPanel");
        
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.show(getContentPane(), "dateTimePanel");
    }
    private void initializeDateTimePanel() {
        dateTimePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Date selection
        JLabel dateLabel = new JLabel("Select Date:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        dateTimePanel.add(dateLabel, gbc);
        
        // Create a date model that starts from today
        Date today = new Date();
        SpinnerDateModel dateModel = new SpinnerDateModel(today, null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
        dateSpinner.setEditor(dateEditor);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        dateTimePanel.add(dateSpinner, gbc);
        
        // Time selection (12-hour format)
        JLabel timeLabel = new JLabel("Select Time:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        dateTimePanel.add(timeLabel, gbc);
        
        // Hour spinner (1-12)
        SpinnerNumberModel hourModel = new SpinnerNumberModel(12, 1, 12, 1);
        hourSpinner = new JSpinner(hourModel);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        dateTimePanel.add(hourSpinner, gbc);
        
        // AM/PM selector
        amPmComboBox = new JComboBox<>(new String[]{"AM", "PM"});
        gbc.gridx = 2;
        gbc.gridy = 1;
        dateTimePanel.add(amPmComboBox, gbc);
        
        // Duration selection
        JLabel durationLabel = new JLabel("Duration (hours):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        dateTimePanel.add(durationLabel, gbc);
        
        // Duration spinner (1-24 hours)
        SpinnerNumberModel durationModel = new SpinnerNumberModel(1, 1, 24, 1);
        durationSpinner = new JSpinner(durationModel);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        dateTimePanel.add(durationSpinner, gbc);
        
        // Confirm button
        confirmDateTimeButton = new JButton("Find Available Spaces");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        dateTimePanel.add(confirmDateTimeButton, gbc);
        
        // Add action listener to confirm button
        confirmDateTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected date
                selectedDate = (Date) dateSpinner.getValue();
                
                // Get the selected time (12-hour format)
                int hour12 = (Integer) hourSpinner.getValue();
                String amPm = (String) amPmComboBox.getSelectedItem();
                
                // Convert to 24-hour format
                int hour24;
                if (amPm.equals("AM")) {
                    hour24 = (hour12 == 12) ? 0 : hour12;
                } else { // PM
                    hour24 = (hour12 == 12) ? 12 : hour12 + 12;
                }
                
                selectedTimeSlot = hour24;
                
                // Get the selected duration
                selectedDuration = (Integer) durationSpinner.getValue();
                
                // Update available parking lots and spaces
                updateParkingOptions();
                
                // Switch to parking selection panel
                CardLayout cl = (CardLayout)(getContentPane().getLayout());
                cl.show(getContentPane(), "parkingSelectionPanel");
            }
        });
    }
    
    private void initializeParkingSelectionPanel() {
        parkingSelectionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Selected date and time display
        JLabel selectionLabel = new JLabel("Selected Date & Time: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        parkingSelectionPanel.add(selectionLabel, gbc);
        
        // Parking lot selection
        JLabel lotLabel = new JLabel("Select Parking Lot:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        parkingSelectionPanel.add(lotLabel, gbc);
        
        parkingLotDropdown = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 1;
        parkingSelectionPanel.add(parkingLotDropdown, gbc);
        
        // Parking space selection
        JLabel spaceLabel = new JLabel("Select Parking Space:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        parkingSelectionPanel.add(spaceLabel, gbc);
        
        parkingSpaceDropdown = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 2;
        parkingSelectionPanel.add(parkingSpaceDropdown, gbc);
        
        // License plate input
        JLabel licensePlateLabel = new JLabel("Enter License Plate:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        parkingSelectionPanel.add(licensePlateLabel, gbc);
        
        licensePlateField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 3;
        parkingSelectionPanel.add(licensePlateField, gbc);
        
        // Button panel for back and book buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        backButton = new JButton("Back");
        buttonPanel.add(backButton);
        
        bookButton = new JButton("Book Now");
        buttonPanel.add(bookButton);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        parkingSelectionPanel.add(buttonPanel, gbc);
        
        // Add action listener to back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(getContentPane().getLayout());
                cl.show(getContentPane(), "dateTimePanel");
            }
        });
        
        // Add action listener to parking lot dropdown
        parkingLotDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateParkingSpaces();
            }
        });
        
        // Add action listener to book button
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String licensePlate = licensePlateField.getText();
                if (licensePlate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid license plate.");
                    return;
                }
                
                String selectedSpaceId = (String) parkingSpaceDropdown.getSelectedItem();
                if (selectedSpaceId == null || selectedSpaceId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a parking space.");
                    return;
                }
                
                int parkingSpaceId = Integer.parseInt(selectedSpaceId);
                
                String selectedLotName = (String) parkingLotDropdown.getSelectedItem();
                ParkingLot selectedLot = parkingLotMap.get(selectedLotName);
                int parkingLotId = selectedLot.getId();
                
                // For now, create a temporary client email using license plate
                String clientEmail = licensePlate + "@example.com";
                
                // Call booking system to book the space
                boolean success = true;
                
                // We need to book the space for each hour in the duration
                for (int i = 0; i < selectedDuration; i++) {
                    int timeSlot = (selectedTimeSlot + i) % 24; // Wrap around if needed
                    
                    // Call the booking system with all required parameters
                    boolean hourSuccess = bookingSystem.bookParkingSpace(
                        clientEmail,
                        parkingLotId,
                        parkingSpaceId,
                        5, // deposit
                        timeSlot
                    );
                    
                    if (!hourSuccess) {
                        success = false;
                        break;
                    }
                }
                
                
                if (success) {
                    JOptionPane.showMessageDialog(null, "Booking Successful!");
                    dispose(); // Close the window after successful booking
                    
                    // Calculate end time
                    int endHour = (selectedTimeSlot + selectedDuration) % 24;
                    String startAmPm = selectedTimeSlot < 12 ? "AM" : "PM";
                    String endAmPm = endHour < 12 ? "AM" : "PM";
                    int startHour12 = selectedTimeSlot % 12 == 0 ? 12 : selectedTimeSlot % 12;
                    int endHour12 = endHour % 12 == 0 ? 12 : endHour % 12;
                    
                    // Format the date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    String formattedDate = dateFormat.format(selectedDate);
                    
                    // Show confirmation page
                    JOptionPane.showMessageDialog(null, 
                            "Booking Confirmed!\n" +
                            "Date: " + formattedDate + "\n" +
                            "Time: " + startHour12 + " " + startAmPm + " - " + endHour12 + " " + endAmPm + "\n" +
                            "Duration: " + selectedDuration + " hour(s)\n" +
                            "Parking Lot: " + parkingLotDropdown.getSelectedItem() + "\n" +
                            "Parking Space: " + selectedSpaceId + "\n" +
                            "License Plate: " + licensePlate,
                            "Booking Confirmation",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Booking Failed. Space might be unavailable for the entire duration or system error occurred.");
                }
            }
        });
    }
    
    private void updateParkingOptions() {
        // Update the display of selected date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        // Convert 24-hour format to 12-hour format for display
        int displayHour = selectedTimeSlot % 12;
        if (displayHour == 0) displayHour = 12;
        String amPm = selectedTimeSlot < 12 ? "AM" : "PM";
        
        // Calculate end time
        int endHour24 = (selectedTimeSlot + selectedDuration) % 24;
        int endHour12 = endHour24 % 12;
        if (endHour12 == 0) endHour12 = 12;
        String endAmPm = endHour24 < 12 ? "AM" : "PM";
        
        JLabel selectionLabel = (JLabel) parkingSelectionPanel.getComponent(0);
        selectionLabel.setText("Selected: " + dateFormat.format(selectedDate) + ", " + 
                               displayHour + " " + amPm + " - " + endHour12 + " " + endAmPm + 
                               " (" + selectedDuration + " hour(s))");
        
        // Clear existing items
        parkingLotDropdown.removeAllItems();
        parkingSpaceDropdown.removeAllItems();
        parkingLotMap.clear();
        
        // Get available parking lots from database
        ArrayList<ParkingLot> availableLots = systemDatabase.getParkingLots();
        
        // Filter enabled parking lots
        for (ParkingLot lot : availableLots) {
            if (lot.isEnabled()) {
                String lotName = lot.getName();
                parkingLotDropdown.addItem(lotName);
                parkingLotMap.put(lotName, lot);
            }
        }
        
        // Update parking spaces based on first parking lot
        if (parkingLotDropdown.getItemCount() > 0) {
            updateParkingSpaces();
        }
    }
    
    private void updateParkingSpaces() {
        // Clear existing items
        parkingSpaceDropdown.removeAllItems();
        parkingSpaceMap.clear();
        
        // Get selected parking lot
        String selectedLotName = (String) parkingLotDropdown.getSelectedItem();
        if (selectedLotName == null || selectedLotName.isEmpty()) {
            return;
        }
        
        ParkingLot selectedLot = parkingLotMap.get(selectedLotName);
        if (selectedLot == null) {
            return;
        }
        
        // Get available parking spaces for the selected lot
        ArrayList<ParkingSpace> spaces = (ArrayList<ParkingSpace>) selectedLot.getAllSpaces();
        for (ParkingSpace space : spaces) {
            // Check if space is enabled and available for the entire duration
            if (space.isEnabled() && isAvailableForDuration(space)) {
                String spaceId = String.valueOf(space.getSpaceId());
                parkingSpaceDropdown.addItem(spaceId);
                parkingSpaceMap.put(spaceId, space);
            }
        }
        
        // Disable book button if no spaces available
        bookButton.setEnabled(parkingSpaceDropdown.getItemCount() > 0);
        if (parkingSpaceDropdown.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "No parking spaces available for the selected time and duration.");
        }
    }
    
    private boolean isAvailableForDuration(ParkingSpace space) {
        // Check if the space is available for each hour in the duration
        for (int i = 0; i < selectedDuration; i++) {
            int timeSlot = (selectedTimeSlot + i) % 24; // Wrap around if needed
            
            // Use the isOccupied method that accepts a time parameter
            if (space.isOccupied(timeSlot)) {
                return false; // Not available for the entire duration
            }
        }
        return true; // Available for the entire duration
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookingPage().setVisible(true);
            }
        });
    }
}