package businessLogic;

import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

// Payment Strategy Interface
public interface PaymentStrategy {
    boolean processPayment(int amount);
    boolean processRefund(int amount);
}

// Concrete Payment Strategies
class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(int amount) {
        System.out.println("Processing payment via Credit Card: $" + amount);
        return true;
    }

    @Override
    public boolean processRefund(int amount) {
        System.out.println("Refunding Credit Card payment: $" + amount);
        return true;
    }
}

class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(int amount) {
        System.out.println("Processing payment via Debit Card: $" + amount);
        return true;
    }

    @Override
    public boolean processRefund(int amount) {
        System.out.println("Refunding Debit Card payment: $" + amount);
        return true;
    }
}

class MobilePaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(int amount) {
        System.out.println("Processing payment via Mobile Payment: $" + amount);
        return true;
    }

    @Override
    public boolean processRefund(int amount) {
        System.out.println("Refunding Mobile Payment: $" + amount);
        return true;
    }
}