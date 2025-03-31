package main.java.presentation;
import main.java.presentation.ParkingSpaceManagerView;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.database.Database;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.java.businessLogic.SystemDatabaseFacade;
import main.java.objects.Client;
import main.java.objects.Manager;

public class ApprovalRequestsView {
	protected static JFrame frame;
    private ImageIcon icon;
    private JTable table;
    private DefaultTableModel model;
    private static final String UNIVERSITY_DB_PATH = "database/UniversityDatabase.csv";
    private SystemDatabaseFacade systemdb = SystemDatabaseFacade.getInstance();
	public ApprovalRequestsView() {
		frame = new JFrame("Manager: Approval Requests");
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 103, 1161, 487);
		frame.getContentPane().add(scrollPane);
		String[] columnNames = {"Request Type", "Client Email", "Details"};
        Object[][] data = {};
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		loadRequestsData();
		
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
				approveSelectedRequest();
			}
		});
		
		JButton btnParkingLots = new JButton("Manage Parking Lots");
		frame.getContentPane().add(btnParkingLots);
		btnParkingLots.setBackground(new Color(255, 255, 255));
		btnParkingLots.setForeground(Color.BLACK);
		btnParkingLots.setFocusPainted(false);
		btnParkingLots.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnParkingLots.setBounds(898, 43, 190, 40);
		btnParkingLots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParkingLotManagerView parkingView = new ParkingLotManagerView(1);
				parkingView.showManagerView(1);
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
		
	    SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	/**
	 * Load approval requests from database
	 */
	private void loadRequestsData() {
		model.setRowCount(0);
		
		// Get request data from system database
		SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
		
		ArrayList<Client> clients = systemDB.getClients();
		
		for (Client client : clients) {
			if (!client.isValidated()) {
				String clientType = client.getClass().getName().replace("objects.", "");
				model.addRow(new Object[]{"Registration", client.getEmail(), clientType + " registration request"});
			}
		}
	
		if (clients.size() > 0) {
			model.addRow(new Object[]{"Transaction", clients.get(0).getEmail(), "Booking payment: $25.00"});
		}
	}
	
	/**
	 * Approve the selected request
	 */
	private void approveSelectedRequest() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(frame, "Please select a request to approve.", 
					"No Selection", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String requestType = (String) model.getValueAt(selectedRow, 0);
		String clientEmail = (String) model.getValueAt(selectedRow, 1);
		String details = (String) model.getValueAt(selectedRow, 2);
		
		if (!isValidEmail(clientEmail)) {
			JOptionPane.showMessageDialog(frame, "Invalid email format: " + clientEmail,
					"Validation Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if ("Registration".equals(requestType)) {
			boolean isUniversityStudent = checkIfUniversityStudent(clientEmail);
			
						if (processRegistrationApproval(clientEmail, isUniversityStudent)) {
				// Send confirmation email
				sendApprovalEmail(clientEmail, "Registration Approved", 
						"Your registration has been approved. You can now log in to the system.");
				systemdb.getClientInfo(clientEmail).setValidated(true);
				systemdb.changeValidationStatus(clientEmail,"Validated");
				model.removeRow(selectedRow);
				JOptionPane.showMessageDialog(frame, "Registration approved and email sent to " + clientEmail);
			}
		} else if ("Transaction".equals(requestType)) {
			if (processTransactionApproval(clientEmail, details)) {
				
				sendApprovalEmail(clientEmail, "Transaction Approved", 
						"Your transaction has been approved: " + details);
				
				model.removeRow(selectedRow);
				JOptionPane.showMessageDialog(frame, "Transaction approved and email sent to " + clientEmail);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Unknown request type: " + requestType);
		}
	}
	
	/**
	 * Check if the provided email belongs to a university student
	 * @param email Email to check
	 * @return true if the email belongs to a university student
	 */
	private boolean checkIfUniversityStudent(String email) {
		try {
			String universityDbPath = "src/database/UniversityDatabase.csv";
			Database universityDb = new Database(universityDbPath);
			
			List<String[]> universityData = universityDb.read();
			
			for (String[] data : universityData) {
				if (data.length > 1 && data[1].trim().equalsIgnoreCase(email.trim())) {
					if (data.length > 2 && "Student".equalsIgnoreCase(data[2].trim())) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error reading university database: " + e.getMessage());
			JOptionPane.showMessageDialog(frame, "Error checking university status: " + e.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return false;
	}
	
	/**
	 * Process registration approval
	 * @param email Client email
	 * @param isUniversityStudent Whether the client is a university student
	 * @return true if the approval was successful
	 */
	private boolean processRegistrationApproval(String email, boolean isUniversityStudent) {
		try {
			SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
			
			Client client = systemDB.getClientInfo(email);
			
			if (client == null) {
				JOptionPane.showMessageDialog(frame, "Client not found: " + email,
						"Approval Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			client.setValidated(true);
			
			if (isUniversityStudent) {
				client.setParkingRate(client.getParkingRate() * 75 / 100);
				System.out.println("Approved university student: " + email + " with special rate: " + client.getParkingRate());
			} else {
				System.out.println("Approved regular client: " + email + " with standard rate: " + client.getParkingRate());
			}

			systemDB.approveUser(client);
			
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Error processing registration: " + e.getMessage(),
					"Approval Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	/**
	 * Process transaction approval
	 * @param email Client email
	 * @param details Transaction details
	 * @return true if the approval was successful
	 */
	private boolean processTransactionApproval(String email, String details) {
		try {
			SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
			Client client = systemDB.getClientInfo(email);
			
			if (client == null) {
				JOptionPane.showMessageDialog(frame, "Client not found: " + email,
						"Approval Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if (details.contains("$")) {
				String amountStr = details.substring(details.indexOf("$") + 1);
				double amount = Double.parseDouble(amountStr);
			
				SystemDatabaseFacade.addRevenue((int)amount);
				
				System.out.println("Processed transaction of $" + amount + " for " + email);
				System.out.println("System revenue now: $" + systemDB.getRevenue());
			}
			
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Error processing transaction: " + e.getMessage(),
					"Approval Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	/**
	 * Validate email format
	 * @param email Email to validate
	 * @return true if the email format is valid
	 */
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email != null && email.matches(emailRegex);
	}
	
	/**
	 * Send approval email to client
	 * @param to Recipient email
	 * @param subject Email subject
	 * @param body Email body
	 */
	private void sendApprovalEmail(String to, String subject, String body) {
		try {
			System.out.println("\n===== EMAIL NOTIFICATION =====");
			System.out.println("To: " + to);
			System.out.println("Subject: " + subject);
			System.out.println("Body: " + body);
			System.out.println("==============================\n");

			logEmailToFile(to, subject, body);
			
		} catch (Exception e) {
			System.err.println("Error logging email notification: " + e.getMessage());
		}
	}
	
	/**
	 * Log email details to a file for tracking
	 * @param to Recipient email
	 * @param subject Email subject
	 * @param body Email body
	 */
	private void logEmailToFile(String to, String subject, String body) {
		String logFile = "email_notifications.log";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timestamp = dateFormat.format(new Date());
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
			writer.println("===== EMAIL NOTIFICATION: " + timestamp + " =====");
			writer.println("To: " + to);
			writer.println("Subject: " + subject);
			writer.println("Body: " + body);
			writer.println("==============================\n");
		} catch (IOException e) {
			System.err.println("Error writing to email log file: " + e.getMessage());
		}
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}