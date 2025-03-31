package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

public class SavingAccount {
@Test
void testSavingsAccountInactive() {
    SavingsAccount account = new SavingsAccount(5000, 5);
    account.deposit(6000);
    assertTrue(account.getBalance() >= 10000);
}
}
