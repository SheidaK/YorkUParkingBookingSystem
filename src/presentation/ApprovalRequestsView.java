package presentation;
import presentation.ParkingManagerView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.SystemDatabase;
import objects.Client;
import objects.Manager;

public class ApprovalRequestsView {
	protected static JFrame frame;
    private ImageIcon icon;
    private JTable table;
	public ApprovalRequestsView() {

		frame = new JFrame("Manager: Approval Requests");
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 103, 1161, 487);
		frame.getContentPane().add(scrollPane);
		String[] columnNames = {"Request Type", "Client Email", "Details"};
        Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(51, 43, 871, 40);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText("Requests For Approval");
		JButton btnSelectToApprove = new JButton("Approve");
		frame.getContentPane().add(btnSelectToApprove);
		btnSelectToApprove.setBackground(new Color(255, 255, 255));
		btnSelectToApprove.setForeground(Color.BLACK);
		btnSelectToApprove.setFocusPainted(false);
		btnSelectToApprove.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelectToApprove.setBounds(560, 621, 196, 40);
		btnSelectToApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Request approved, if request is transaction, the money owned by client is reduced. 
				//If request is client registration validation, notify client and allow clients to login.				frame.setVisible(false);
				frame.dispose();
			}
			});
		
		JButton btnParkingLots = new JButton("Manage Parking Lots");
		frame.getContentPane().add( btnParkingLots);
		btnParkingLots.setBackground(new Color(255, 255, 255));
		btnParkingLots.setForeground(Color.BLACK);
		btnParkingLots.setFocusPainted(false);
		btnParkingLots.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnParkingLots.setBounds(898, 43, 190, 40);
		btnParkingLots.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Page where manager can view list of parking lots and the parking spaces within it and can enable/disable parking lots/parking spaces.
			ParkingManagerView parkingView = new ParkingManagerView();
			frame.setVisible(false);
			frame.dispose();
		}
		});						
		
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignOut.setBounds(1111, 43, 101, 37);
		frame.getContentPane().add(btnSignOut);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main = new MainPage();
				frame.setVisible(false);
				frame.dispose();
			}
			});
		
	    SystemDatabase systemDB = SystemDatabase.getInstance();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}

