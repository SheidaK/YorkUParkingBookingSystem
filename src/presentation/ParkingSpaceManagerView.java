package presentation;

import businessLogic.ParkingSystem;
import objects.*;

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
    private ParkingSystem parkingSystem;
    private JTable parkingSpacesTable;
    private DefaultTableModel tableModel;
    private JButton addSpaceButton, removeSpaceButton, enableSpaceButton, disableSpaceButton, simulateButton;
    private JComboBox<String> spaceTypeComboBox;
    private JButton btnNewButton;
    
    public ParkingSpaceManagerView(ParkingLot parkingLot,int page) {
        try {
			parkingSystem = ParkingSystem.getInstance();
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
        
        JPanel addRemovePanel = new JPanel(new FlowLayout());
        String[] spaceTypes = {"Regular", "Handicapped", "VIP", "Electric"};
        spaceTypeComboBox = new JComboBox<String>();
        addSpaceButton = new JButton("Add Space");
        removeSpaceButton = new JButton("Remove Selected Space");

        addRemovePanel.add(new JLabel("Space Type:"));
        addRemovePanel.add(spaceTypeComboBox);
        addRemovePanel.add(addSpaceButton);
        addRemovePanel.add(removeSpaceButton);

        JPanel actionPanel = new JPanel(new FlowLayout());
        enableSpaceButton = new JButton("Enable Space");
        disableSpaceButton = new JButton("Disable Space");
        simulateButton = new JButton("Simulate Car Detection");

        actionPanel.add(enableSpaceButton);
        actionPanel.add(disableSpaceButton);
        actionPanel.add(simulateButton);

        controlPanel.add(addRemovePanel);
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

        // Action listeners
        addSpaceButton.addActionListener(e -> {
            String type = (String) spaceTypeComboBox.getSelectedItem();
            parkingSystem.addNewParkingSpace(parkingLot, type);
            loadParkingSpaces(parkingLot);
        });

        removeSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String spaceId = (String) tableModel.getValueAt(selectedRow, 0);
                boolean success = parkingSystem.removeParkingSpace(parkingLot,Integer.valueOf(spaceId));
                if (success) {
                    loadParkingSpaces(parkingLot);
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot remove this space", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        enableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
            	Integer spaceId =  (Integer) tableModel.getValueAt(selectedRow, 0);
            	parkingSystem.enableParkingSpace(parkingLot, Integer.valueOf(spaceId));
                loadParkingSpaces(parkingLot);
            }
        });

        disableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                Integer spaceId =  (Integer) tableModel.getValueAt(selectedRow, 0);
                parkingSystem.disableParkingSpace(parkingLot, spaceId);
                loadParkingSpaces(parkingLot);
            }
        });

        simulateButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String spaceId = (String) tableModel.getValueAt(selectedRow, 0);
                boolean currentlyOccupied = "Yes".equals(tableModel.getValueAt(selectedRow, 3));
                parkingSystem.simulateVehicleDetection(parkingLot, Integer.valueOf(spaceId), !currentlyOccupied);
                loadParkingSpaces(parkingLot);
            }
        });
        addRemovePanel.setVisible(false);
    }

    private void loadParkingSpaces(ParkingLot parkingLot) {
        tableModel.setRowCount(0);
        List<ParkingSpace> spaces;
		try {
			spaces = ParkingSystem.getInstance().getAvailableSpaces(parkingLot);
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

