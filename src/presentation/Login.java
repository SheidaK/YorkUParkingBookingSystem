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

import businessLogic.SystemDatabaseFacade;
import objects.Client;
import objects.ClientFactory;
import objects.Manager;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	protected static JFrame frame;
	private JPasswordField passwordField_1;
	private JTextField email;
	private JTextField txtSignInTo;
	public Login(boolean pageClient) {
		frame = new JFrame("Login");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
		JLabel warningLabel = new JLabel("");
		warningLabel.setForeground(new Color(255, 0, 0));
		warningLabel.setBounds(428, 337, 443, 13);
		warningLabel.setVisible(false);
		frame.getContentPane().add(warningLabel);
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBackground(new Color(255, 155, 155));
		txtrWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 27));
		txtrWelcomeToThe.setText("   Welcome back to The YorkU Parking System!");
		txtrWelcomeToThe.setBounds(343, 42, 898, 57);
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setBounds(533, 305, 209, 21);
		frame.getContentPane().add(submitButton);
		
		JLabel emailLbl = new JLabel("");
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailLbl.setBounds(428, 223, 181, 21);
		frame.getContentPane().add(emailLbl);
		if(pageClient) {
			emailLbl.setText("Enter Email: ");
		}else {
			emailLbl.setText("Enter User Name: ");
		}
		
		JLabel passwordLbl = new JLabel("Enter Password");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLbl.setBounds(428, 264, 166, 13);
		frame.getContentPane().add(passwordLbl);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(620, 264, 251, 19);
		frame.getContentPane().add(passwordField_1);
		ImageIcon icon;
		icon = new ImageIcon(this.getClass().getResource("/res/Campus_header_gr_3.jpg"));;
		JLabel iconLbl = new JLabel(icon);
		iconLbl.setLocation(-150, 278);
		iconLbl.setSize(1550, 516);

		frame.getContentPane().add(iconLbl);
		
		email = new JTextField();
		email.setBounds(619, 223, 252, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		txtSignInTo = new JTextField();
		txtSignInTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignInTo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSignInTo.setText("Sign in to the Parking System!");
		txtSignInTo.setBounds(428, 156, 443, 57);
		frame.getContentPane().add(txtSignInTo);
		txtSignInTo.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(1035, 134, 166, 33);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 155, 155));
		panel.setBounds(0, 1, 1266, 125);
		frame.getContentPane().add(panel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main = new MainPage();
				frame.setVisible(false);
				frame.dispose();
			}
		});
	    String emailFormat = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+.[com ca]$";
	    SystemDatabaseFacade systemDB = SystemDatabaseFacade.getInstance();
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(email.getText().isEmpty()) {
					warningLabel.setVisible(true);
					if(pageClient) {
					warningLabel.setText("Please enter email again!");
					}else {
						warningLabel.setText("Please enter user name again!");
					}
				}else if(pageClient && !Pattern.compile(emailFormat)
				          .matcher(email.getText())
				          .matches()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Wrong email format.Please enter correct email!");
				}else if(passwordField_1.getText().isEmpty()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Please enter password again!");
				}else {
					if (pageClient) {
						Client c = systemDB.getClientInfo(email.getText());
						if(c==null){
							warningLabel.setVisible(true);
							warningLabel.setText("Entered username does not match with any existing clients!");
						}else if(!passwordField_1.getText().equals(c.getPassword())) {
							warningLabel.setVisible(true);
							warningLabel.setText("Entered password is incorrect!");
						}
						
						else if(!c.isValidated()) {
							warningLabel.setVisible(true);
							warningLabel.setText("Your account is pending approval by a manager. Please wait for approval email.");
						
						}else {
							EditBookings p = new EditBookings(c);
							frame.setVisible(false);
							frame.dispose();
						}
					}else {
						Manager m = systemDB.getManagerInfo(email.getText());
						if(m==null){
							warningLabel.setVisible(true);
							warningLabel.setText("Entered email does not match with any existing manger accounts!");
						}else if(!passwordField_1.getText().equals(m.getPassword())) {
							warningLabel.setVisible(true);
							warningLabel.setText("Entered password is incorrect!");
						}else {
							if(systemDB.isSuperManager(email.getText())) {
								SuperManagerView superManagerView = new SuperManagerView();
								superManagerView.showSuperManagerView();
							}else {
								ApprovalRequestsView managerView = new ApprovalRequestsView();
							}
							
							frame.setVisible(false);
							frame.dispose();
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
