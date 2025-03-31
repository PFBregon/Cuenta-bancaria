package dev.patriciafb.bankacount.controller;

import dev.patriciafb.bankacount.service.AccountService; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountControllerTest {

    private AccountService accountService;
    private AccountController accountController;

    @BeforeEach
    void setUp() {
        accountService = mock(AccountService.class);
        accountController = new AccountController(accountService);
    }

    @Test
    void testDeposit() {
        doNothing().when(accountService).makeDeposit(500);
        accountController.deposit(500);

        verify(accountService, times(1)).makeDeposit(500);
    }

    @Test
    void testWithdrawSuccess() {
        when(accountService.makeWithdrawal(300)).thenReturn(true);

        accountController.withdraw(300);
        verify(accountService, times(1)).makeWithdrawal(300);
    }

    @Test
    void testWithdrawFailure() {
        when(accountService.makeWithdrawal(1500)).thenReturn(false);
        accountController.withdraw(1500);

        verify(accountService, times(1)).makeWithdrawal(1500);
    }

    @Test
    void testGenerateMonthlyStatement() {
        doNothing().when(accountService).generateMonthlyStatement();
        accountController.generateMonthlyStatement();

        verify(accountService, times(1)).generateMonthlyStatement();
    }

    @Test
    void testDisplayAccountStatus() {
        String mockStatus = "Balance: 1000.00, Deposits: 2, Withdrawals: 1, Monthly Fee: 0.00";
        when(accountService.getAccountStatus()).thenReturn(mockStatus);
        String status = accountService.getAccountStatus();
        assertThat(status).isEqualTo(mockStatus);
    }

}
