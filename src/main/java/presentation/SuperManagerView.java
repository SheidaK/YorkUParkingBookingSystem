package main.java.presentation;

import main.java.objects.Manager;
import main.java.objects.SuperManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.java.businessLogic.SystemDatabaseFacade;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.ActionListener;

/**
 * GUI for the SuperManager to create new manager accounts
 */
public class SuperManagerView extends JFrame {
    private SuperManager superManager;
    private JTable managersTable;
    private DefaultTableModel tableModel;
    private JButton createButton, removeButton;
    private JButton btnApprovalRequest;
    private JButton btnParkingView;
    SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
    private JButton signOutButton;

    public SuperManagerView() {
        superManager = SuperManager.getInstance();
        initComponents();
        loadManagers();
    }

    private void initComponents() {
        setTitle("Super Manager Console");
		setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Username","Password", "Role"};
        tableModel = new DefaultTableModel(columnNames, 0);
        managersTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(managersTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Input Panel
        FlowLayout fl_inputPanel = new FlowLayout();
        fl_inputPanel.setAlignOnBaseline(true);
        JPanel inputPanel = new JPanel(fl_inputPanel);
        createButton = new JButton("Create Manager");
        removeButton = new JButton("Remove Selected");
        inputPanel.add(createButton);
        inputPanel.add(removeButton);

        getContentPane().add(inputPanel, BorderLayout.SOUTH);
        
        btnApprovalRequest = new JButton("Approval Requests");
        btnApprovalRequest.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ApprovalRequestsView parkingView = new ApprovalRequestsView();
    			setVisible(false);
    			dispose();
        	}
        });
        inputPanel.add(btnApprovalRequest);
        
        btnParkingView = new JButton("Manage Parking Lots");
        btnParkingView.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Page where manager can view list of parking lots and the parking spaces within it and can enable/disable parking lots/parking spaces.
    			ParkingLotManagerView parkingView = new ParkingLotManagerView(0);
        		parkingView.showManagerView(0);
    			setVisible(false);
    			dispose();
        	}
        });
        inputPanel.add(btnParkingView);
        
        signOutButton = new JButton("Sign Out");
        signOutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainPage home = new MainPage();
        		setVisible(false);
				dispose();
        	}
        });
        inputPanel.add(signOutButton);

        // Action Listeners
        createButton.addActionListener(this::createManager);
        removeButton.addActionListener(this::removeManager);
    }

    private void createManager(ActionEvent e) {
		String[] account = superManager.generateManagerAccount();
		String username = account[0];
		String password = account[1];

        Manager m = new Manager(username, password);
        systemDB.addManager(m);
        loadManagers();
    }

    private void removeManager(ActionEvent e) {
        int selectedRow = managersTable.getSelectedRow();
        if (selectedRow >= 0) {
            String username = (String) tableModel.getValueAt(selectedRow, 0);
            if(username.equals("superManager")) {
                JOptionPane.showMessageDialog(this, "Not possible to remove the super manager account.", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
            	systemDB.removeManager(username);
            	loadManagers();
            }
        }            
    }

    private void loadManagers() {
        tableModel.setRowCount(0);
        List<Manager> managers = systemDB.getManagers();
        if(managers != null) {for (Manager manager : managers) {
            tableModel.addRow(new Object[]{manager.getUserName(), manager.getPassword(),manager.getRole()});
        }
        }
    }

    public static void showSuperManagerView() {
        SwingUtilities.invokeLater(() -> {
            SuperManagerView view = new SuperManagerView();
            view.setVisible(true);
        });
    }
}
