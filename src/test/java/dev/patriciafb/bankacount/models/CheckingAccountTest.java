package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CheckingAccountTest {
    @Test
    public void testOverdraft() {
        CheckingAccount account = new CheckingAccount(1000, 5);
        boolean result = account.withdraw(1500); 
    
        System.out.println("Después del retiro - Balance: " + account.getBalance() + ", Overdraft: " + account.getOverdraft());
    
        assertEquals(true, result, "El retiro de dinero debería ser exitoso");
        assertEquals(0, account.getBalance(), "El saldo debería ser 0 después del sobregiro");
        assertEquals(500, account.getOverdraft(), "El sobregiro debería ser 500");
    }
}    