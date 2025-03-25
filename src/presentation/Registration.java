package presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

import businessLogic.SystemDatabaseFacade;
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
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setForeground(new Color(255, 0, 0));
		warningLabel.setBounds(428, 344, 443, 13);
		warningLabel.setVisible(false);
		JLabel passwordWarning = new JLabel("");
		passwordWarning.setForeground(new Color(255, 0, 0));
		passwordWarning.setBounds(428, 367, 443, 21);
		frame.getContentPane().add(passwordWarning);
		frame.getContentPane().add(warningLabel);
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBackground(new Color(255, 155, 155));
		txtrWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 27));
		txtrWelcomeToThe.setText("Welcome to The YorkU Parkining System!");
		txtrWelcomeToThe.setBounds(345, 44, 936, 55);
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setBounds(539, 313, 209, 21);
		frame.getContentPane().add(submitButton);
		
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
		emailLbl.setBounds(428, 174, 181, 13);
		frame.getContentPane().add(emailLbl);
		
		JLabel passwordLbl = new JLabel("Enter Password");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLbl.setBounds(428, 210, 166, 13);
		frame.getContentPane().add(passwordLbl);
		
		JLabel lblNewLabel = new JLabel("Enter Passowrd Again");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(428, 239, 166, 21);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(620, 243, 251, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(620, 210, 251, 19);
		frame.getContentPane().add(passwordField_1);
		ImageIcon icon;
		icon = new ImageIcon(this.getClass().getResource("/res/Campus_header_gr_3.jpg"));;
		JLabel iconLbl = new JLabel(icon);
		iconLbl.setLocation(-150, 334);
		iconLbl.setSize(1550, 460);

		frame.getContentPane().add(iconLbl);
		
		email = new JTextField();
		email.setBounds(619, 174, 252, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
	    String emailFormat = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+.[com ca]$";
		SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warningLabel.setVisible(true);
				passwordWarning.setText("");
				if(((String) clientType.getSelectedItem()).equals("Register as:")) {
					warningLabel.setText("Please select a client type from the list.");
				}else if(email.getText().isEmpty()) {
					warningLabel.setText("Please enter email again!");
				}else if(!Pattern.compile(emailFormat)
				          .matcher(email.getText())
				          .matches()) {
					warningLabel.setText("Wrong email format.Please enter correct email!");
				}else if(passwordField.getText().isEmpty()) {
					warningLabel.setText("Please enter password again!");
				}else if(!strongPassword(passwordField_1.getText(),passwordWarning)){
					warningLabel.setText("Entered passwords is not in the correct format.");
				}else if(!passwordField.getText().equals(passwordField_1.getText())) {
					warningLabel.setText("Entered passwords do not match!");
				}else{
					warningLabel.setVisible(false);

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
						} else {
							// Automatically validate visitors
							c.setValidated(true);
						}
						if(canRegister) {
							try {
								if(!((String) clientType.getSelectedItem()).equals("Visitor")) {
									c.setValidated(false);
									JOptionPane.showMessageDialog(
										frame,
										"Registration successful! Your account is pending approval by a manager.\n" + 
										"Please wait for email confirmation before logging in.",
										"Registration Complete",
										JOptionPane.INFORMATION_MESSAGE
									);
								} else {
									JOptionPane.showMessageDialog(
										frame,
										"Registration successful! You can now log in.",
										"Registration Complete",
										JOptionPane.INFORMATION_MESSAGE
									);
								}
								
								systemDB.addClient(c);
								
								Login loginPage = new Login(true);
								frame.setVisible(false);
								frame.dispose();
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					
				}
			}
			});	
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(1031, 122, 166, 33);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 155, 155));
		panel.setBounds(0, 1, 1266, 99);
		frame.getContentPane().add(panel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Password must be a combination of uppercase letters, lowercase letters, numbers and symbols");
		lblNewLabel_1.setBounds(399, 283, 683, 13);
		frame.getContentPane().add(lblNewLabel_1);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main = new MainPage();
				main.frame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		}
	protected boolean strongPassword(String password, JLabel warning) {
		boolean strongPassword = true;
		warning.setText("");
		String warningLabel = "Entered password doesn't contain:";
		if(!password.matches(".*[a-z].*")){
			warningLabel +="lower case letter,";
			strongPassword = false;
		}
		if(!password.matches(".*[A-Z].*")) {
			warningLabel +="\t"+"upper case letter,";
			strongPassword = false;
		}
		if(!password.matches(".*[0-9].*")) {
			warningLabel +="\t"+"numbers,";
			strongPassword = false;
		}
		if(!password.matches(".*[^a-zA-Z0-9\\s].*")) {
			warningLabel +="\t"+"symbols";
			strongPassword = false;
		}
		if(!strongPassword) {
			warning.setText(warningLabel);
			return false;
		}
		return true;
	}
}

	
