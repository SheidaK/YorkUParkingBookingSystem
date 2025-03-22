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
        model.setRowCount(0); 

        BookingSystem bookingSystem = BookingSystem.getInstance();
        Map<String, Visit> bookings = bookingSystem.getBookings();

        for (Map.Entry<String, Visit> entry : bookings.entrySet()) {
            String bookingId = entry.getKey();
            Visit visit = entry.getValue();
            model.addRow(new Object[]{
                    bookingId, visit.getClientDetail().getEmail(), visit.getParkingSpace(),
                    visit.getStartTime(), visit.getEndTime()
            });
        }
    }


    private static void editBooking(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bookingId = (String) model.getValueAt(selectedRow, 0);
        int currentParkingId = (int) model.getValueAt(selectedRow, 2); // Parking ID from the table
        String currentStartTime = (String) model.getValueAt(selectedRow, 3);
        
        String newStartTime = JOptionPane.showInputDialog("Enter new start time (in format HH:00):");
        if (newStartTime != null && !newStartTime.isEmpty()) {
            if (newStartTime.matches("^(0?[1-9]|1[0-2]):00$")) {
                int newDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter new duration in hours:"));
                BookingSystem bookingSystem = BookingSystem.getInstance();
                
                int newStartHour = Integer.parseInt(newStartTime.split(":")[0]);
                
                if (bookingSystem.editBooking(bookingId, currentParkingId, newStartHour, newDuration)) {
                    loadBookings(model);
                    JOptionPane.showMessageDialog(null, "Booking updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "This time slot is not available.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid time format. Please enter time in HH:00 format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void cancelBooking(JTable table, DefaultTableModel model) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bookingId = (String) model.getValueAt(selectedRow, 0);
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

        String bookingId = (String) model.getValueAt(selectedRow, 0);
        int currentParkingId = (int) model.getValueAt(selectedRow, 2); 
        String currentEndTime = (String) model.getValueAt(selectedRow, 4);

        int extraTime = Integer.parseInt(JOptionPane.showInputDialog("Enter extra time to extend (in hours):"));

        BookingSystem bookingSystem = BookingSystem.getInstance();
        if (bookingSystem.extendBooking(bookingId, currentParkingId, extraTime)) {
            loadBookings(model);
            JOptionPane.showMessageDialog(null, "Booking extended successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Unable to extend the booking. The parking spot might not be available.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
