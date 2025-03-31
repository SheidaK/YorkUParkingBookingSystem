package main.java.businessLogic;

import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


public class PaymentSystem {
    private static PaymentSystem instance = null;
    private HashMap<Integer, Integer> transactions;
    private HashMap<Integer, PaymentStrategy> paymentStrategies;

    // Allowed payment methods
    private static final Set<String> ALLOWED_PAYMENT_METHODS = new HashSet<>(
        Arrays.asList("CREDIT_CARD", "DEBIT_CARD", "MOBILE_PAYMENT")
    );

    private PaymentSystem() {
        transactions = new HashMap<>();
        paymentStrategies = new HashMap<>();
    }

    public static PaymentSystem getInstance() {
        if (instance == null) {
            instance = new PaymentSystem();
        }
        return instance;
    }

    // Factory method to create payment strategy
    private PaymentStrategy createPaymentStrategy(String paymentMethod) {
        switch (paymentMethod.toUpperCase()) {
            case "CREDIT_CARD":
                return new CreditCardPaymentStrategy();
            case "DEBIT_CARD":
                return new DebitCardPaymentStrategy();
            case "MOBILE_PAYMENT":
                return new MobilePaymentStrategy();
            default:
                throw new IllegalArgumentException("Invalid payment method");
        }
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
        
        try {
            PaymentStrategy paymentStrategy = createPaymentStrategy(paymentMethod);
            
            // Process payment
            if (paymentStrategy.processPayment(amount)) {
                transactions.put(bookingID, amount);
                paymentStrategies.put(bookingID, paymentStrategy);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Confirm refund
    public boolean confirmRefund(int bookingID) {
        if (!transactions.containsKey(bookingID)) {
            return false; // No transaction found
        }
        
        int amount = transactions.get(bookingID);
        PaymentStrategy paymentStrategy = paymentStrategies.get(bookingID);
        
        if (paymentStrategy.processRefund(amount)) {
            transactions.remove(bookingID);
            paymentStrategies.remove(bookingID);
            return true;
        }
        return false;
    }

    // Retrieve payment method used for a transaction
    public String getPaymentMethod(int bookingID) {
        PaymentStrategy strategy = paymentStrategies.get(bookingID);
        if (strategy instanceof CreditCardPaymentStrategy) return "CREDIT_CARD";
        if (strategy instanceof DebitCardPaymentStrategy) return "DEBIT_CARD";
        if (strategy instanceof MobilePaymentStrategy) return "MOBILE_PAYMENT";
        return "Unknown";
    }

    // Get allowed payment methods
    public static Set<String> getAllowedPaymentMethods() {
        return ALLOWED_PAYMENT_METHODS;
    }
}
