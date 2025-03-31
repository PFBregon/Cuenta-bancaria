package dev.patriciafb.bankacount.controller;

import dev.patriciafb.bankacount.service.AccountService;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        accountService.makeDeposit(amount);
        System.out.println("Deposit successful.");
    }

    private void withdraw(int _) {
        // TODO
    }
}
