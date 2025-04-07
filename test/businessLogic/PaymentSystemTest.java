package businessLogic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Set;

public class PaymentSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private PaymentSystem paymentSystem;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        paymentSystem = PaymentSystem.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        // Reset singleton for next test
        Field instance = PaymentSystem.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        System.setOut(originalOut);
    }

    @Test
    public void testGetInstance() {
        PaymentSystem instance1 = PaymentSystem.getInstance();
        PaymentSystem instance2 = PaymentSystem.getInstance();
        
        // Verify singleton pattern
        assertSame(instance1, instance2);
    }

    @Test
    public void testConfirmPaymentValid() {
        boolean result = paymentSystem.confirmPayment(1, "CREDIT_CARD", 100);
        assertTrue(result);
    }

    @Test
    public void testConfirmPaymentInvalidMethod() {
        boolean result = paymentSystem.confirmPayment(2, "INVALID_METHOD", 100);
        assertFalse(result);
        assertTrue(outContent.toString().contains("Error: Invalid payment method"));
    }

    @Test
    public void testConfirmPaymentDuplicate() {
        // First payment should succeed
        boolean result1 = paymentSystem.confirmPayment(3, "DEBIT_CARD", 100);
        assertTrue(result1);
        
        // Second payment with same booking ID should fail
        boolean result2 = paymentSystem.confirmPayment(3, "DEBIT_CARD", 200);
        assertFalse(result2);
    }

    @Test
    public void testConfirmPaymentWithMobilePayment() {
        boolean result = paymentSystem.confirmPayment(4, "MOBILE_PAYMENT", 150);
        assertTrue(result);
    }

    @Test
    public void testConfirmPaymentWithLowerCase() {
        boolean result = paymentSystem.confirmPayment(5, "credit_card", 200);
        assertTrue(result);
    }

    @Test
    public void testConfirmRefundValid() {
        // Setup: make a payment first
        paymentSystem.confirmPayment(6, "CREDIT_CARD", 300);
        
        // Test refund
        boolean result = paymentSystem.confirmRefund(6);
        assertTrue(result);
    }

    @Test
    public void testConfirmRefundInvalid() {
        // No prior payment for booking ID 999
        boolean result = paymentSystem.confirmRefund(999);
        assertFalse(result);
    }

    @Test
    public void testGetPaymentMethod() {
        // Setup: make payments with different methods
        paymentSystem.confirmPayment(7, "CREDIT_CARD", 100);
        paymentSystem.confirmPayment(8, "DEBIT_CARD", 200);
        paymentSystem.confirmPayment(9, "MOBILE_PAYMENT", 300);
        
        // Test retrieval
        assertEquals("CREDIT_CARD", paymentSystem.getPaymentMethod(7));
        assertEquals("DEBIT_CARD", paymentSystem.getPaymentMethod(8));
        assertEquals("MOBILE_PAYMENT", paymentSystem.getPaymentMethod(9));
    }

    @Test
    public void testGetPaymentMethodUnknown() {
        // No payment for booking ID 999
        assertEquals("Unknown", paymentSystem.getPaymentMethod(999));
    }

    @Test
    public void testGetAllowedPaymentMethods() {
        Set<String> methods = PaymentSystem.getAllowedPaymentMethods();
        
        // Verify all expected methods are present
        assertTrue(methods.contains("CREDIT_CARD"));
        assertTrue(methods.contains("DEBIT_CARD"));
        assertTrue(methods.contains("MOBILE_PAYMENT"));
        
        // Verify set size (no unexpected methods)
        assertEquals(3, methods.size());
    }
}