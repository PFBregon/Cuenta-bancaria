package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class SavingAccountTest {
    @Test
    public void testSavingsAccountInactive() {
        SavingsAccount account = new SavingsAccount(5000, 5);
        account.deposit(6000);
        System.out.println("Now your balance account ar: " + account.getBalance());
        assertTrue(account.getBalance() >= 10000);
    }
}