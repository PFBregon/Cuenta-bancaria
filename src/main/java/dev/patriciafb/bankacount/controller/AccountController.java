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

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        boolean success = accountService.makeWithdrawal(amount);
        if (success) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
        return success; 
    }
    
    

    public void generateMonthlyStatement() {
        accountService.generateMonthlyStatement();
        System.out.println("Monthly statement generated.");
    }

    public void displayAccountStatus() {
        String status = accountService.getAccountStatus();
        System.out.println("Account Status: " + status);
    }
}
