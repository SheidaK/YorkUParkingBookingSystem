package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import businessLogic.PaymentSystem;
import objects.Client;

public class ConfirmBookingPage extends JFrame {
    private JLabel parkingSpaceLabel;
    private JComboBox<String> paymentMethodDropdown;
    private JButton confirmPaymentButton;
    private String licensePlate;
    private int parkingSpaceID;

    public ConfirmBookingPage(Client c, String licensePlate, int parkingSpaceID) {
        this.licensePlate = licensePlate;
        this.parkingSpaceID = parkingSpaceID;
        setTitle("Confirm Booking and Pay");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Display parking space info
        add(new JLabel("Parking Space:"));
        parkingSpaceLabel = new JLabel(String.valueOf(parkingSpaceID));
        add(parkingSpaceLabel);

        // Payment method selection
        add(new JLabel("Select Payment Method:"));
        paymentMethodDropdown = new JComboBox<>(new String[]{"CREDIT_CARD", "DEBIT_CARD", "MOBILE_PAYMENT"});
        add(paymentMethodDropdown);

        // Confirm payment button
        confirmPaymentButton = new JButton("Confirm & Pay");
        add(confirmPaymentButton);

        // Button action
        confirmPaymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paymentMethod = (String) paymentMethodDropdown.getSelectedItem();
                boolean success = PaymentSystem.getInstance().confirmPayment(parkingSpaceID, paymentMethod, 10);

               // if (success) {
                    JOptionPane.showMessageDialog(null, "Payment Successful! Your parking is confirmed.");
//                    try {
//						EditBookings p = new EditBookings(c);
						setVisible(false);
						dispose();
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
                   
              //  } else {
                 //   JOptionPane.showMessageDialog(null, "Payment Failed. Try a different method.");
               // }
            }
        });
    }
    public static void showCofirmBookingPageView(Client c, String licensePlate, int parkingSpaceID) {
        SwingUtilities.invokeLater(() -> {
            ConfirmBookingPage view;
			try {
				view = new ConfirmBookingPage(c,licensePlate, parkingSpaceID);
				view.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        });
    }
}
