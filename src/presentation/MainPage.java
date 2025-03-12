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
public class MainPage {
	protected static JFrame frame;
    private ImageIcon icon;
    private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainPage();
	}

	/**
	 * Create the application.
	 */
	public MainPage() {

		// Background Image
		icon = new ImageIcon(this.getClass().getResource("/res/imageCampus.jpg"));

		frame = new JFrame("York_University_Campus - Welcome!");
		frame.setSize(1280, 720);
		frame.getContentPane().setLayout(null);
		
				// Login for Client
				JButton btnLogInClient = new JButton("Client Login");
				frame.getContentPane().add(btnLogInClient);
				btnLogInClient.setBackground(new Color(59, 89, 182));
				btnLogInClient.setForeground(Color.WHITE);
				btnLogInClient.setFocusPainted(false);
				btnLogInClient.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnLogInClient.setBounds(137, 97, 196, 40);
				
						// Manager Login
						JButton btnManager = new JButton("Manager Login");
						frame.getContentPane().add(btnManager);
						btnManager.setBackground(new Color(59, 89, 182));
						btnManager.setForeground(Color.WHITE);
						btnManager.setFocusPainted(false);
						btnManager.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnManager.setBounds(992, 97, 175, 40);
						
								// Register Client Profile
								JButton btnSignUp = new JButton("Client Registeration");
								frame.getContentPane().add(btnSignUp);
								btnSignUp.setBackground(new Color(59, 89, 182));
								btnSignUp.setForeground(Color.WHITE);
								btnSignUp.setFocusPainted(false);
								btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 12));
								btnSignUp.setBounds(577, 97, 156, 40);
								label = new JLabel(icon);
								label.setSize(1280, 720);
								frame.getContentPane().add(label);
								btnSignUp.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Registration register = new Registration();
										register.setVisible(true);
										frame.setVisible(false);
										frame.dispose();
									}
								});
						btnManager.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ManagerView managerView = new ManagerView();
								managerView.setVisible(true);
								frame.setVisible(false);
								frame.dispose();

							}
						});
				btnLogInClient.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login = new Login();
						login.setVisible(true);
						frame.setVisible(false);
						frame.dispose();
					}
				});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
