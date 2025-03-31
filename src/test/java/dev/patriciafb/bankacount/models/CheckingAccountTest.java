package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CheckingAccountTest {
    @Test
    void testOverdraft() {
        CheckingAccount account = new CheckingAccount(1000, 5);
        account.withdraw(1500); 
        assertEquals(0, account.getBalance());
        assertEquals(500, account.getOverdraft());
    }
}
