package main.java.presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import java.util.Map.Entry;

import main.java.businessLogic.*;
import main.java.objects.*;


public class confirmedBookings {
    
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Confirmed Bookings");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Table model setup
            String[] columnNames = {"Booking ID", "Client Email", "Parking Space", "Parking Lot", "Date", "Duration"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Load data from BookingSystem
            try {
				loadBookings(model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Button Panel
            JPanel buttonPanel = new JPanel();
            JButton refreshButton = new JButton("Refresh");
            refreshButton.addActionListener(e -> {
				try {
					loadBookings(model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}); // Refresh on button click
            buttonPanel.add(refreshButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void loadBookings(DefaultTableModel model) throws Exception {
        model.setRowCount(0); // Clear existing data

        // Fetch bookings from BookingSystem
        SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
        Map<Integer, Visit> bookings = systemDB.getBookings();

        for (Entry<Integer, Visit> entry : bookings.entrySet()) {
            Integer bookingId = entry.getKey();
            Visit visit = entry.getValue();
            model.addRow(new Object[]{
                bookingId, visit.getClientDetail().getEmail(), visit.getParkingSpace(), visit.getParkingLot(), visit.getDuration()
            });
        }
    }
}


