package businessLogic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaymentStrategyTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    private CreditCardPaymentStrategy creditCardStrategy;
    private DebitCardPaymentStrategy debitCardStrategy;
    private MobilePaymentStrategy mobilePaymentStrategy;
    
    @BeforeEach
    public void setUp() {
        // Redirect System.out to our ByteArrayOutputStream
        System.setOut(new PrintStream(outContent));
        
        // Initialize payment strategies
        creditCardStrategy = new CreditCardPaymentStrategy();
        debitCardStrategy = new DebitCardPaymentStrategy();
        mobilePaymentStrategy = new MobilePaymentStrategy();
    }
    
    @Test
    public void testCreditCardProcessPayment() {
        // Test method execution
        boolean result = creditCardStrategy.processPayment(100);
        
        // Verify return value
        assertTrue(result);
        
        // Verify output message
        assertTrue(outContent.toString().contains("Processing payment via Credit Card: $100"));
    }
    
    @Test
    public void testCreditCardProcessPaymentWithZeroAmount() {
        boolean result = creditCardStrategy.processPayment(0);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Processing payment via Credit Card: $0"));
    }
    
    @Test
    public void testCreditCardProcessPaymentWithNegativeAmount() {
        boolean result = creditCardStrategy.processPayment(-50);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Processing payment via Credit Card: $-50"));
    }
    
    @Test
    public void testCreditCardProcessRefund() {
        boolean result = creditCardStrategy.processRefund(100);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Refunding Credit Card payment: $100"));
    }
    
    @Test
    public void testCreditCardProcessRefundWithZeroAmount() {
        boolean result = creditCardStrategy.processRefund(0);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Refunding Credit Card payment: $0"));
    }
    
    @Test
    public void testDebitCardProcessPayment() {
        boolean result = debitCardStrategy.processPayment(200);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Processing payment via Debit Card: $200"));
    }
    
    @Test
    public void testDebitCardProcessPaymentWithLargeAmount() {
        boolean result = debitCardStrategy.processPayment(10000);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Processing payment via Debit Card: $10000"));
    }
    
    @Test
    public void testDebitCardProcessRefund() {
        boolean result = debitCardStrategy.processRefund(200);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Refunding Debit Card payment: $200"));
    }
    
    @Test
    public void testMobilePaymentProcessPayment() {
        boolean result = mobilePaymentStrategy.processPayment(50);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Processing payment via Mobile Payment: $50"));
    }
    
    @Test
    public void testMobilePaymentProcessRefund() {
        boolean result = mobilePaymentStrategy.processRefund(50);
        assertTrue(result);
        assertTrue(outContent.toString().contains("Refunding Mobile Payment: $50"));
    }
}