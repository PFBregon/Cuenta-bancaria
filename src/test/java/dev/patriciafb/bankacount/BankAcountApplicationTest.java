package dev.patriciafb.bankacount;

import dev.patriciafb.bankacount.controller.AccountController;
import dev.patriciafb.bankacount.models.Account;
import dev.patriciafb.bankacount.models.CheckingAccount;
import dev.patriciafb.bankacount.models.SavingsAccount;
import dev.patriciafb.bankacount.service.AccountService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BankAcountApplicationTest {

@SpringBootTest
@RunWith(SpringRunner.class)
public class BankAccountApplicationTest {

    private Account savingsAccount;
    private AccountService accountService;
    private AccountController accountController;
    private Account checkingAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount(15000, 5);
        checkingAccount = new CheckingAccount(1000, 5);
        accountService = new AccountService(savingsAccount); 
        accountController = new AccountController(accountService);
    }

    @Test
    void testDeposit() {
        accountController.deposit(500);
        assertEquals(15500, savingsAccount.getBalance(), "El saldo debería incrementar en 500");
    }

    @Test
    void testWithdrawSuccess() {
        boolean result = accountController.withdraw(500);
        assertTrue(result, "El retiro debería ser exitoso");
        assertEquals(14500, savingsAccount.getBalance(), "El saldo debería disminuir en 500");
    }

    @Test
    void testWithdrawFailure() {
        boolean result = accountController.withdraw(20000); 
        assertFalse(result, "El retiro debería fallar");
        assertEquals(15000, savingsAccount.getBalance(), "El saldo no debería cambiar");
    }

    @Test
    void testGenerateMonthlyStatement() {
        accountController.generateMonthlyStatement();
        assertTrue(savingsAccount.getBalance() > 15000, "El saldo debería incluir intereses mensuales");
    }
}
}