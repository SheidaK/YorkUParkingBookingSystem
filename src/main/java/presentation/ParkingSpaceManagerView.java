package main.java.presentation;

import main.java.businessLogic.ParkingSystem;
import main.java.businessLogic.SystemDatabaseFacade;
import main.java.objects.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * GUI for parking lot managers to maintain parking services
 */
public class ParkingSpaceManagerView extends JFrame {
   // private ParkingSystem parkingSystem;
    private JTable parkingSpacesTable;
    private DefaultTableModel tableModel;
    private JButton enableSpaceButton, disableSpaceButton, simulateButton;
    private JButton btnNewButton;
    SystemDatabaseFacade systemDB;

    public ParkingSpaceManagerView(ParkingLot parkingLot,int page) {
        try {
        	systemDB = SystemDatabaseFacade.getInstance();
			initComponents(parkingLot,page);
	        loadParkingSpaces(parkingLot);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    private void initComponents(ParkingLot parkingLot, int page) {
        setTitle("Parking Manager Console");
		setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = { "ID", "Type", "Status", "Occupied","SensorID", "Car"};
        tableModel = new DefaultTableModel(columnNames, 0);
        parkingSpacesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(parkingSpacesTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Controls panel
        JPanel controlPanel = new JPanel(new GridLayout(2, 1));
        String[] spaceTypes = {"Regular", "Handicapped", "VIP", "Electric"};

        JPanel actionPanel = new JPanel(new FlowLayout());
        enableSpaceButton = new JButton("Enable Space");
        disableSpaceButton = new JButton("Disable Space");
        simulateButton = new JButton("Simulate Car Detection");

        actionPanel.add(enableSpaceButton);
        actionPanel.add(disableSpaceButton);
        actionPanel.add(simulateButton);
        controlPanel.add(actionPanel);
        
        btnNewButton = new JButton("Back to Parking Lot Selection");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ParkingLotManagerView v = new ParkingLotManagerView(page);
        		v.showManagerView(page);
        		setVisible(false);
        		dispose();
        	}
        });
        actionPanel.add(btnNewButton);
        
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        enableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
            	Integer spaceId =  (Integer) tableModel.getValueAt(selectedRow, 0);
            	systemDB.enableParkingSpace(parkingLot, Integer.valueOf(spaceId));
                loadParkingSpaces(parkingLot);
            }
        });

        disableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                Integer spaceId =  (Integer) tableModel.getValueAt(selectedRow, 0);
                systemDB.disableParkingSpace(parkingLot, spaceId);
                loadParkingSpaces(parkingLot);
            }
        });

        simulateButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                int spaceId = (int) tableModel.getValueAt(selectedRow, 0);
                boolean currentlyOccupied = "Yes".equals(tableModel.getValueAt(selectedRow, 3));
                systemDB.simulateVehicleDetection(parkingLot, Integer.valueOf(spaceId), !currentlyOccupied);
                loadParkingSpaces(parkingLot);
            }
        });
    }

    private void loadParkingSpaces(ParkingLot parkingLot) {
        tableModel.setRowCount(0);
        List<ParkingSpace> spaces;
		try {
			spaces = systemDB.getAvailableSpaces(parkingLot);
			for (ParkingSpace space : spaces) {
	            Object[] row = {
	                space.getSpaceId(),
	                space.getType(),
	                space.isEnabled() ? "Enabled" : "Disabled",
	                space.isOccupied() ? "Yes" : "No",
	                space.getSpaceId(),
	                space.getParkedCar() != null ? space.getParkedCar().toString() : "None"
	            };
	            tableModel.addRow(row);
	            
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

        
        
    

    public static void showManagerView(ParkingLot parkingLot,int page) {
        SwingUtilities.invokeLater(() -> {
            ParkingSpaceManagerView view = new ParkingSpaceManagerView(parkingLot,page);
            view.setVisible(true);
        });
    }
    }

