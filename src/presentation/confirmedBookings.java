package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

import businessLogic.*;
import objects.*;


public class ConfirmedBookings {
    
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Confirmed Bookings");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Table model setup
            String[] columnNames = {"Booking ID", "Client Email", "Parking Space", "Date"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Load data from BookingSystem
            loadBookings(model);

            // Button Panel
            JPanel buttonPanel = new JPanel();
            JButton refreshButton = new JButton("Refresh");
            refreshButton.addActionListener(e -> loadBookings(model)); // Refresh on button click
            buttonPanel.add(refreshButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void loadBookings(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing data

        // Fetch bookings from BookingSystem
        BookingSystem bookingSystem = BookingSystem.getInstance();
        Map<String, Visit> bookings = bookingSystem.getBookings();

        for (Map.Entry<String, Visit> entry : bookings.entrySet()) {
            String bookingId = entry.getKey();
            Visit visit = entry.getValue();
            model.addRow(new Object[]{
                bookingId, visit.getClientDetail().getEmail(), visit.getParkingSpace(), visit.getDate(),
            });
        }
    }
}



