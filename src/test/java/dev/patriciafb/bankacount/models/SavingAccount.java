package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class SavingAccount {
    @Test
    public void testSavingsAccountInactive() { // Make the method public
        SavingsAccount account = new SavingsAccount(5000, 5);
        account.deposit(6000);
        assertTrue(account.getBalance() >= 10000);
    }
}