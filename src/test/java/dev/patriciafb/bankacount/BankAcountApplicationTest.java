package dev.patriciafb.bankacount;

import dev.patriciafb.bankacount.controller.AccountController;
import dev.patriciafb.bankacount.models.Account;
import dev.patriciafb.bankacount.service.AccountService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAcountApplicationTest {

    private Account account;
    private AccountService accountService;
    private AccountController accountController;

    @BeforeEach
    void setUp() {
        account = mock(Account.class);
        accountService = new AccountService(account);
        accountController = new AccountController(accountService);
    }
    @Test
    void testDeposit() {
        doNothing().when(account).deposit(500);
        accountController.deposit(500);

        verify(account, times(1)).deposit(500);
    }

    @Test
    void testWithdrawSuccess() {
        when(account.withdraw(300)).thenReturn(true);
        accountController.withdraw(300);
        verify(account, times(1)).withdraw(300);
    }

    @Test
    void testWithdrawFailure() {
        when(account.withdraw(1500)).thenReturn(false);
        accountController.withdraw(1500);
        verify(account, times(1)).withdraw(1500);
    }
}