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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * GUI for parking lot managers to maintain parking services
 */
public class ParkingLotManagerView extends JFrame {
    //private ParkingSystem parkingSystem;
    private JTable parkingLotTable;
    private DefaultTableModel tableModel;
    private JButton addLotButton, removeSpaceButton, enableSpaceButton, disableSpaceButton;
    private JTextField location;
    private JLabel lblNewLabel;
    private JTextField name;
    private JLabel lblNewLabel_1;
    SystemDatabaseFacade systemDB;
    private JButton backButton;
    private JButton btnNewButton;

    
    public ParkingLotManagerView(int page) {
        try {
        	systemDB = SystemDatabaseFacade.getInstance();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        initComponents(page);
        loadParkingSpaces();
    }
    
    private void initComponents(int page) {
        setTitle("Parking Manager Console");
		setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Name", "Location", "Status", "Maximum Capcity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        parkingLotTable = new JTable(tableModel);
        parkingLotTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 if (e.getClickCount() == 2) {
        		 int selectedRow = parkingLotTable.getSelectedRow();
                 if (selectedRow >= 0) {
                     String name = (String) tableModel.getValueAt(selectedRow, 0);
                     ParkingLot p = systemDB.getParkingLotInfo(name);
                     ParkingSpaceManagerView view = new ParkingSpaceManagerView(p,page);
                     view.showManagerView(p,page);
                     setVisible(false);
                     dispose();
                 }
        		 }
        	}
        });
        JScrollPane scrollPane = new JScrollPane(parkingLotTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Controls panel
        JPanel controlPanel = new JPanel(new GridLayout(2, 1));
        
        JPanel addRemovePanel = new JPanel(new FlowLayout());
        addLotButton = new JButton("Add Parking Lot");
        
        
        	
        removeSpaceButton = new JButton("Remove Selected Parking Lot");
        
        lblNewLabel_1 = new JLabel("Parking Lot Name");
        addRemovePanel.add(lblNewLabel_1);
        
        name = new JTextField();
        addRemovePanel.add(name);
        name.setColumns(10);
        
        lblNewLabel = new JLabel("Parking Lot Location");
        addRemovePanel.add(lblNewLabel);
        
        location = new JTextField();
        addRemovePanel.add(location);
        location.setColumns(10);
       
        addRemovePanel.add(addLotButton);
        addRemovePanel.add(removeSpaceButton);

        JPanel actionPanel = new JPanel(new FlowLayout());
        enableSpaceButton = new JButton("Enable Parking Lot");
        disableSpaceButton = new JButton("Disable ParkingLot");
        actionPanel.add(enableSpaceButton);
        actionPanel.add(disableSpaceButton);

        controlPanel.add(addRemovePanel);
        controlPanel.add(actionPanel);
        
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(page==0) {
        			SuperManagerView v = new SuperManagerView();
        			v.showSuperManagerView();
        		}else {
        			ApprovalRequestsView v = new ApprovalRequestsView();
        			
        		}
        		setVisible(false);
        		dispose();
        	}
        });
        
        btnNewButton = new JButton("Manage Parking Spaces for Selected Parking Lot");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 int selectedRow = parkingLotTable.getSelectedRow();
                 if (selectedRow >= 0) {
                     String name = (String) tableModel.getValueAt(selectedRow, 0);
                     ParkingLot p = systemDB.getParkingLotInfo(name);
                     ParkingSpaceManagerView view = new ParkingSpaceManagerView(p,page);
                     view.showManagerView(p,page);
                     setVisible(false);
                     dispose();
                 }
        	}
        });
        actionPanel.add(btnNewButton);
        actionPanel.add(backButton);
        
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        // Action listeners
        addLotButton.addActionListener(e -> {
        	if(systemDB.getParkingLotInfo(name.getText()) != null) {
    			//ParkingLot already exists
                JOptionPane.showMessageDialog(this, "Parking Lot already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        	}else {    
        		ParkingLot parkingLot = new ParkingLot(name.getText(),location.getText(), 100);
        		systemDB.addNewParkingLot(parkingLot);
        		loadParkingSpaces();
        	}
        });

        removeSpaceButton.addActionListener(e -> {
            int selectedRow = parkingLotTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name= (String) tableModel.getValueAt(selectedRow, 0);
                boolean success = systemDB.removeParkingLot(name);
                if (success) {
                    loadParkingSpaces();
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot remove this space", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        enableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingLotTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name = (String) tableModel.getValueAt(selectedRow, 0);
                systemDB.statusParkingLot(name,true);
                loadParkingSpaces();
            }
        });

        disableSpaceButton.addActionListener(e -> {
            int selectedRow = parkingLotTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name = (String) tableModel.getValueAt(selectedRow, 0);
                systemDB.statusParkingLot(name,false);
                loadParkingSpaces();
            }
        });
    }

    private void loadParkingSpaces() {
        tableModel.setRowCount(0);
        List<ParkingLot> lots;
		try {
			lots = systemDB.getAvailableLots();
			if(lots !=null) {
				for (ParkingLot lot : lots) {
					Object[] row = {
							lot.getName(),
							lot.getLocation(),
							lot.isEnabled() ? "Enabled" : "Disabled",
									lot.getCapcity()
					};
					tableModel.addRow(row);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
            
        }
        }
        

    public static void showManagerView(int page) {
        SwingUtilities.invokeLater(() -> {
            ParkingLotManagerView view = new ParkingLotManagerView(page);
            view.setVisible(true);
        });
    }
}
