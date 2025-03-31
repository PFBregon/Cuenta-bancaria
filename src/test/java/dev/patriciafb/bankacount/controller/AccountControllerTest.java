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

}
