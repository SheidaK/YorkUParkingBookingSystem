package presentation;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.SystemDatabase;
import objects.Client;

import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ClientView {
	protected static JFrame frame;
    private ImageIcon icon;
    private JTable table;
	public ClientView(Client c) {

		frame = new JFrame("Client Page");
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 103, 1161, 487);
		frame.getContentPane().add(scrollPane);
		String[] columnNames = {"Date", "Time", "ParkingLot","ParkingSpace"};
        Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Bookings");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(51, 43, 633, 40);
		frame.getContentPane().add(lblNewLabel);
		JButton btnSelectToEdit = new JButton("Edit Selected Booking");
		frame.getContentPane().add(btnSelectToEdit);
		btnSelectToEdit.setBackground(new Color(255, 255, 255));
		btnSelectToEdit.setForeground(Color.BLACK);
		btnSelectToEdit.setFocusPainted(false);
		btnSelectToEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSelectToEdit.setBounds(560, 621, 196, 40);
		btnSelectToEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Page where client can edit existing bookings
				frame.setVisible(false);
				frame.dispose();
			}
			});
		
		JButton btnNewBooking = new JButton("New Boking");
		frame.getContentPane().add(btnNewBooking);
		btnNewBooking.setBackground(new Color(255, 255, 255));
		btnNewBooking.setForeground(Color.BLACK);
		btnNewBooking.setFocusPainted(false);
		btnNewBooking.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewBooking.setBounds(1056, 621, 156, 40);
		btnNewBooking.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Page where client can make a new booking
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

		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteAccount.setBounds(934, 43, 156, 37);
		frame.getContentPane().add(btnDeleteAccount);
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				systemDB.removeClient(c);
				MainPage main = new MainPage();
				frame.setVisible(false);
				frame.dispose();
			}
			});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
