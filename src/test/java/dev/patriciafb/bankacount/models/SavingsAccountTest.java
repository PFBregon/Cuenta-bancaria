package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount(15000, 5); 
    }
    @Test
    public void testSavingsAccountActivation() {
        SavingsAccount account = new SavingsAccount(5000, 5);
        account.deposit(6000);
        assertTrue(account.getBalance() >= 10000, "Account should be active");
    }

    @Test
    void testWithdrawFromInactiveAccount() {
        savingsAccount.withdraw(6000); 
        savingsAccount.generateMonthlyStatement(); 
        assertFalse(savingsAccount.withdraw(1000), "No debería permitir retirar de una cuenta inactiva");
    }
}