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
public class ParkingManagerView extends JFrame {
    private ParkingSystem parkingSystem;
    private JTable parkingSpacesTable;
    private DefaultTableModel tableModel;
    private JButton addSpaceButton, removeSpaceButton, enableSpaceButton, disableSpaceButton, simulateButton;
    private JComboBox<String> spaceTypeComboBox;
    
    public ParkingManagerView() {
        parkingSystem = ParkingSystem.getInstance();
        initComponents();
        loadParkingSpaces();
    }
    
    private void initComponents() {
        setTitle("Parking Manager Console");
		setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"ID", "Type", "Status", "Occupied", "Car"};
        tableModel = new DefaultTableModel(columnNames, 0);
        parkingSpacesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(parkingSpacesTable);
        add(scrollPane, BorderLayout.CENTER);

        // Controls panel
        JPanel controlPanel = new JPanel(new GridLayout(2, 1));
        
        JPanel addRemovePanel = new JPanel(new FlowLayout());
        String[] spaceTypes = {"Regular", "Handicapped", "VIP", "Electric"};
        spaceTypeComboBox = new JComboBox<>(spaceTypes);
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
        
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        // Action listeners
        addSpaceButton.addActionListener(e -> {
            String type = (String) spaceTypeComboBox.getSelectedItem();
            parkingSystem.addNewParkingSpace(type);
            loadParkingSpaces();
        });

        removeSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String spaceId = (String) tableModel.getValueAt(selectedRow, 0);
                boolean success = parkingSystem.removeParkingSpace(spaceId);
                if (success) {
                    loadParkingSpaces();
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot remove this space", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        enableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String spaceId = (String) tableModel.getValueAt(selectedRow, 0);
                parkingSystem.enableParkingSpace(spaceId);
                loadParkingSpaces();
            }
        });

        disableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String spaceId = (String) tableModel.getValueAt(selectedRow, 0);
                parkingSystem.disableParkingSpace(spaceId);
                loadParkingSpaces();
            }
        });

        simulateButton.addActionListener(e -> {
            int selectedRow = parkingSpacesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String spaceId = (String) tableModel.getValueAt(selectedRow, 0);
                boolean currentlyOccupied = "Yes".equals(tableModel.getValueAt(selectedRow, 3));
                parkingSystem.simulateVehicleDetection(spaceId, !currentlyOccupied);
                loadParkingSpaces();
            }
        });
    }

    private void loadParkingSpaces() {
        tableModel.setRowCount(0);
        List<ParkingSpace> spaces = ParkingSystem.getInstance().getAvailableSpaces();

        for (ParkingSpace space : spaces) {
            Object[] row = {
                space.getSpaceId(),
                space.getType(),
                space.isEnabled() ? "Enabled" : "Disabled",
                space.isOccupied() ? "Yes" : "No",
                space.getParkedCar() != null ? space.getParkedCar().toString() : "None"
            };
            tableModel.addRow(row);
        }
    }

    public static void showManagerView() {
        SwingUtilities.invokeLater(() -> {
            ParkingManagerView view = new ParkingManagerView();
            view.setVisible(true);
        });
    }
}
