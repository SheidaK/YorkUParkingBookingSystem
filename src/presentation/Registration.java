package presentation;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import businessLogic.SystemDatabase;
import objects.Client;
import objects.ClientFactory;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Registration extends JFrame {
	protected static JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField email;
	public Registration() {
		frame = new JFrame("Registration");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setBounds(533, 336, 209, 21);
		frame.getContentPane().add(submitButton);
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBackground(new Color(255, 0, 0));
		txtrWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 27));
		txtrWelcomeToThe.setText("Welcome to The YorkU Parkining System!");
		txtrWelcomeToThe.setBounds(10, 10, 1271, 89);
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JComboBox clientType = new JComboBox<String>();
		clientType.setFont(new Font("Tahoma", Font.PLAIN, 24));
		clientType.setBounds(428, 109, 443, 55);
		clientType.addItem("Register as:");
		clientType.addItem("Visitor");
		clientType.addItem("Student");
		clientType.addItem("FacultyMember");
		clientType.addItem("NonFacultyStaff");

		frame.getContentPane().add(clientType);
		
		JLabel emailLbl = new JLabel("Enter Email");
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailLbl.setBounds(428, 193, 181, 13);
		frame.getContentPane().add(emailLbl);
		
		JLabel passwordLbl = new JLabel("Enter Password");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLbl.setBounds(428, 234, 166, 13);
		frame.getContentPane().add(passwordLbl);
		
		JLabel lblNewLabel = new JLabel("Enter Passowrd Again");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(428, 274, 166, 21);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(620, 278, 251, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(620, 234, 251, 19);
		frame.getContentPane().add(passwordField_1);
		ImageIcon icon;
		icon = new ImageIcon(this.getClass().getResource("/res/Campus_header_gr_3.jpg"));;
		JLabel iconLbl = new JLabel(icon);
		iconLbl.setLocation(-150, 278);
		iconLbl.setSize(1550, 516);

		frame.getContentPane().add(iconLbl);
		
		email = new JTextField();
		email.setBounds(619, 193, 252, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setForeground(new Color(255, 0, 0));
		warningLabel.setBounds(428, 313, 443, 13);
		warningLabel.setVisible(false);
		frame.getContentPane().add(warningLabel);
	    String emailFormat = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+.[com ca]$";
		SystemDatabase systemDB = SystemDatabase.getInstance();

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((String) clientType.getSelectedItem()).equals("Register as:")) {
					warningLabel.setVisible(true);
					warningLabel.setText("Please select a client type from the list.");
				}else if(email.getText().isEmpty()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Please enter email again!");
				}else if(!Pattern.compile(emailFormat)
				          .matcher(email.getText())
				          .matches()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Wrong email format.Please enter correct email!");
				}else if(passwordField.getText().isEmpty()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Please enter password again!");
				}else if(!passwordField.getText().equals(passwordField_1.getText())) {
					warningLabel.setVisible(true);
					warningLabel.setText("Entered passwords do not match!");
				}else{
					ClientFactory clientFactory = new ClientFactory();
					Client c = clientFactory.getNewClient((String) clientType.getSelectedItem(), email.getText(), passwordField.getText());
					boolean exists = false;
					for(Client existingClients:systemDB.getClients()) {
						if(existingClients.getEmail().equalsIgnoreCase(email.getText())) {
							warningLabel.setVisible(true);
							warningLabel.setText("Account already exists!");
							exists = true;
						}
					}
					boolean canRegister = true;
					if(!exists) {
						if(!((String) clientType.getSelectedItem()).equals("Visitor")) {
							if(!systemDB.registerValidation(c)) {canRegister = false;}
						}
						if(canRegister) {
							try {
								systemDB.addClient(c);
								ClientView clientView = new ClientView(c);
								clientView.setVisible(true);
								frame.setVisible(false);
								frame.dispose();
								frame.setVisible(false);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					
				}
			}
			});	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		}
}

	
