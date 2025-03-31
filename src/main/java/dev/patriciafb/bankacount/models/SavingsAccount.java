package dev.patriciafb.bankacount.models;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(double initialBalance, double annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.isActive = initialBalance >= 10000;
    }
}
