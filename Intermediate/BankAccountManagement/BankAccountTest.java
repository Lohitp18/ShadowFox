import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount("Vinay", 1000);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(500);
        account.withdraw(200);
        List<String> history = account.getTransactionHistory();
        assertTrue(history.contains("Deposited: 500.0"));
        assertTrue(history.contains("Withdrawn: 200.0"));
    }
}
