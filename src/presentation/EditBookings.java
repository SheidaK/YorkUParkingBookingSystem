package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import businessLogic.*;
import objects.*;

public class EditBookings {
    private static Client c;
	public EditBookings(Client c) {
			this.c = c;
            JFrame frame = new JFrame("Confirmed Bookings");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1280, 720);
            frame.getContentPane().setLayout(new BorderLayout());

            // Table model setup
            String[] columnNames = {"Booking ID", "Client Email", "Date","Starting Time","Parking Space", "Parking Lot", "Duration"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

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
            JButton editButton = new JButton("Edit Selected Booking");
            JButton cancelButton = new JButton("Cancel Selected Booking");
            JButton extendButton = new JButton("Extend Selected Booking");

            refreshButton.addActionListener(e -> {
				try {
					loadBookings(model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
            editButton.addActionListener(e -> {
				try {
					editBooking(table, model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
            cancelButton.addActionListener(e -> {
				try {
					cancelBooking(table, model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
            extendButton.addActionListener(e -> {
				try {
					extendBooking(table, model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

            buttonPanel.add(refreshButton);
            buttonPanel.add(editButton);
            buttonPanel.add(cancelButton);
            buttonPanel.add(extendButton);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            
            JButton newBookingButton = new JButton("New Booking");
            newBookingButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		//Page where client can make a new booking
        			try {
        				BookingPage p = new BookingPage(c);
        				p.showBookingPageView();
        				frame.setVisible(false);
        				frame.dispose();
        			} catch (Exception e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
        			
            	}
            });
            buttonPanel.add(newBookingButton);
            
            JButton signOutButton = new JButton("Sign Out");
            signOutButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		MainPage main = new MainPage();
    				frame.setVisible(false);
    				frame.dispose();
            	}
            });
            buttonPanel.add(signOutButton);
    	    SystemDatabase systemDB = SystemDatabase.getInstance();

            JButton deleteAccountButton = new JButton("Delete Account");
            deleteAccountButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		systemDB.removeClient(c);
    				MainPage main = new MainPage();
    				frame.setVisible(false);
    				frame.dispose();
            	}
            });
            buttonPanel.add(deleteAccountButton);

            frame.setVisible(true);
       
    }

    private static void loadBookings(DefaultTableModel model) throws Exception {
        model.setRowCount(0); 

        BookingSystem bookingSystem = BookingSystem.getInstance();
        Map<Integer, Visit> bookings = bookingSystem.getBookingsForClient(c);

        for (Entry<Integer, Visit> entry : bookings.entrySet()) {
            Integer bookingId = entry.getKey();
            Visit visit = entry.getValue();
            model.addRow(new Object[]{
                    bookingId, visit.getClientDetail().getEmail(), visit.getDateString(),visit.getInitialTime(),visit.getParkingSpace().getSpaceId(),
                    visit.getParkingLot().getName(), visit.getDuration()
            });
        }
    }


    private static void editBooking(JTable table, DefaultTableModel model) throws Exception {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int bookingId = (int) model.getValueAt(selectedRow, 0);
        String parkingLotName = (String) model.getValueAt(selectedRow, 3); // Parking lot name
        int parkingSpaceId = (int) model.getValueAt(selectedRow, 2); // Parking space ID
        int time = Integer.parseInt(JOptionPane.showInputDialog("Enter new duration in hours:"));
        BookingSystem bookingSystem = BookingSystem.getInstance();
                
                
        if (bookingSystem.editBooking(bookingId, parkingLotName, parkingSpaceId, time)) {
            loadBookings(model);  // Reload the updated bookings table
            JOptionPane.showMessageDialog(null, "Booking updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "This time slot is not available.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
   

    private static void cancelBooking(JTable table, DefaultTableModel model) throws Exception {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int bookingId = (int) model.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this booking?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            BookingSystem.getInstance().cancelBooking(bookingId);
            loadBookings(model);
        }
    }

    private static void extendBooking(JTable table, DefaultTableModel model) throws Exception {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a booking to extend.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int bookingId = (int) model.getValueAt(selectedRow, 0);

        int extraTime = Integer.parseInt(JOptionPane.showInputDialog("Enter extra time to extend (in hours):"));

        BookingSystem bookingSystem = BookingSystem.getInstance();
        if (bookingSystem.extendBooking(bookingId, extraTime)) {
            loadBookings(model);
            JOptionPane.showMessageDialog(null, "Booking extended successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Unable to extend the booking. The parking spot might not be available.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void editBookingPageView(Client c) {
        SwingUtilities.invokeLater(() -> {
            EditBookings view;
			try {
				view = new EditBookings(c);
				//view.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        });
    }

}
