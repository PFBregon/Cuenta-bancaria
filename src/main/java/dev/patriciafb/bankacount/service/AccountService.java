package dev.patriciafb.bankacount.service;

import dev.patriciafb.bankacount.models.Account;

public class AccountService {
    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void makeDeposit(double amount) {
        account.deposit(amount);
    }

    public boolean makeWithdrawal(double amount) {
        return account.withdraw(amount);
    }

    public void generateMonthlyStatement() {
        account.generateMonthlyStatement();
    }

    public String getAccountStatus() {
        return account.printAccountDetails();
    }
}