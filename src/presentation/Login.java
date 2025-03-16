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
import javax.swing.SwingConstants;

public class Login extends JFrame {
	protected static JFrame frame;
	private JPasswordField passwordField_1;
	private JTextField email;
	private JTextField txtSignInTo;
	public Login() {
		frame = new JFrame("Registration");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(255, 255, 255));
		submitButton.setBounds(531, 278, 209, 21);
		frame.getContentPane().add(submitButton);
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBackground(new Color(255, 0, 0));
		txtrWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 27));
		txtrWelcomeToThe.setText("Welcome back to The YorkU Parkining System!");
		txtrWelcomeToThe.setBounds(10, 10, 1271, 89);
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JLabel emailLbl = new JLabel("Enter Email");
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailLbl.setBounds(428, 193, 181, 13);
		frame.getContentPane().add(emailLbl);
		
		JLabel passwordLbl = new JLabel("Enter Password");
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordLbl.setBounds(428, 234, 166, 13);
		frame.getContentPane().add(passwordLbl);
		
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
		
		txtSignInTo = new JTextField();
		txtSignInTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignInTo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSignInTo.setText("Sign in to the Parking System!");
		txtSignInTo.setBounds(428, 126, 443, 57);
		frame.getContentPane().add(txtSignInTo);
		txtSignInTo.setColumns(10);
	    String emailFormat = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+.[com ca]$";
	    SystemDatabase systemDB = SystemDatabase.getInstance();
	    Client c = systemDB.getClientInfo(email.getText());
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(email.getText().isEmpty()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Please enter email again!");
				}else if(!Pattern.compile(emailFormat)
				          .matcher(email.getText())
				          .matches()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Wrong email format.Please enter correct email!");
				}else if(passwordField_1.getText().isEmpty()) {
					warningLabel.setVisible(true);
					warningLabel.setText("Please enter password again!");
				}else if(c==null){
					warningLabel.setVisible(true);
					warningLabel.setText("Entered email does not match with any existing clients!");
				}else if(!passwordField_1.getText().equals(c.getPassword())) {
					warningLabel.setVisible(true);
					warningLabel.setText("Entered password is in correct!");
				}else {
					ClientView clientPage = new ClientView(c);
					frame.setVisible(false);
				}
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
