package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;

import businessLogic.*;
import objects.*;

public class EditBookings {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Confirmed Bookings");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 400);
            frame.setLayout(new BorderLayout());

            // Table model setup
            String[] columnNames = {"Booking ID", "Client Name", "Parking Space", "Start Time", "End Time"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Load data from BookingSystem
            loadBookings(model);

            // Button Panel
            JPanel buttonPanel = new JPanel();
            JButton refreshButton = new JButton("Refresh");
            JButton editButton = new JButton("Edit Booking");
            JButton cancelButton = new JButton("Cancel Booking");
            JButton extendButton = new JButton("Extend Booking");

            refreshButton.addActionListener(e -> loadBookings(model));
            editButton.addActionListener(e -> editBooking(table, model));
            cancelButton.addActionListener(e -> cancelBooking(table, model));
            extendButton.addActionListener(e -> extendBooking(table, model));

            buttonPanel.add(refreshButton);
            buttonPanel.add(editButton);
            buttonPanel.add(cancelButton);
            buttonPanel.add(extendButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    private static void loadBookings(DefaultTableModel model) {
        model.setRowCount(0); // Clear existing data

        // Fetch bookings from BookingSystem
        BookingSystem bookingSystem = BookingSystem.getInstance();
        Map<Integer, Visit> bookings = bookingSystem.getBookings();

        for (Entry<Integer, Visit> entry : bookings.entrySet()) {
            Integer bookingId = entry.getKey();
            Visit visit = entry.getValue();
            model.addRow(new Object[]{
                bookingId, visit.getClientDetail().getEmail(), visit.getParkingSpace(), visit.getDate()
            });
        }
    }

    private static void editBooking(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int bookingId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
        int parkingId = Integer.parseInt(JOptionPane.showInputDialog("Enter new parking ID:"));
        int newTime = Integer.parseInt(JOptionPane.showInputDialog("Enter new time (in hours):"));
    
        
        if (parkingId > 0 && newTime > 0) {
            BookingSystem.getInstance().editBooking(bookingId, parkingId, newTime);
            loadBookings(model);
        }
    }

    private static void cancelBooking(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int bookingId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this booking?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            BookingSystem.getInstance().cancelBooking(bookingId);
            loadBookings(model);
        }
    }

    private static void extendBooking(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to extend.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int bookingId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
        String extraTime = JOptionPane.showInputDialog("Enter extra time to extend (in hours):");
        
        if (extraTime != null) {
            BookingSystem.getInstance().extendBooking(bookingId, Integer.parseInt(extraTime));
            loadBookings(model);
        }
    }
}
