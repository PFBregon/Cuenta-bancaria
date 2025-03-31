package dev.patriciafb.bankacount.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {

    private CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount(1000, 5); 
    }

    @Test
    void testOverdraftWhenWithdrawingMoreThanBalance() {
        checkingAccount.withdraw(1500); 
        assertEquals(0, checkingAccount.getBalance(), "El saldo debería ser 0 después de un sobregiro");
        assertEquals(500, checkingAccount.getOverdraft(), "El sobregiro debería ser 500");
    }

    @Test
    void testReduceOverdraftWithDeposit() {
        checkingAccount.withdraw(1500); 
        checkingAccount.deposit(300);
        assertEquals(0, checkingAccount.getBalance(), "El saldo debería seguir siendo 0");
        assertEquals(200, checkingAccount.getOverdraft(), "El sobregiro debería reducirse a 200");
    }

    @Test
    void testClearOverdraftWithDeposit() {
        checkingAccount.withdraw(1500); 
        checkingAccount.deposit(600); 
        assertEquals(100, checkingAccount.getBalance(), "El saldo debería ser 100 después de cubrir el sobregiro");
        assertEquals(0, checkingAccount.getOverdraft(), "El sobregiro debería eliminarse");
    }
}