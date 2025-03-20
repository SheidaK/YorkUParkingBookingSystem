package businessLogic;

import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class PaymentSystem {
    private static PaymentSystem instance = null;
    private HashMap<Integer, Integer> transactions;
    private HashMap<Integer, String> paymentMethods; // Stores payment methods per transaction

    // Allowed payment methods
    private static final Set<String> ALLOWED_PAYMENT_METHODS = new HashSet<>(
        Arrays.asList("CREDIT_CARD", "DEBIT_CARD", "MOBILE_PAYMENT")
    );

    private PaymentSystem() {
        transactions = new HashMap<>();
        paymentMethods = new HashMap<>();
    }

    public static PaymentSystem getInstance() {
        if (instance == null) {
            instance = new PaymentSystem();
        }
        return instance;
    }

    // Confirm payment with a specific method (only if valid)
    public boolean confirmPayment(int bookingID, String paymentMethod, int amount) {
        if (!ALLOWED_PAYMENT_METHODS.contains(paymentMethod.toUpperCase())) {
            System.out.println("Error: Invalid payment method. Accepted methods: CREDIT_CARD, DEBIT_CARD, MOBILE_PAYMENT");
            return false;
        }

        if (transactions.containsKey(bookingID)) {
            return false; // Transaction already exists
        }
        
        transactions.put(bookingID, amount);
        paymentMethods.put(bookingID, paymentMethod.toUpperCase()); // Store the validated payment method
        return true;
    }

    // Confirm refund
    public boolean confirmRefund(int bookingID) {
        if (!transactions.containsKey(bookingID)) {
            return false; // No transaction found
        }
        transactions.remove(bookingID);
        paymentMethods.remove(bookingID); // Remove associated payment method
        return true;
    }

    // Retrieve payment method used for a transaction
    public String getPaymentMethod(int bookingID) {
        return paymentMethods.getOrDefault(bookingID, "Unknown");
    }

    // Get allowed payment methods
    public static Set<String> getAllowedPaymentMethods() {
        return ALLOWED_PAYMENT_METHODS;
    }
}
