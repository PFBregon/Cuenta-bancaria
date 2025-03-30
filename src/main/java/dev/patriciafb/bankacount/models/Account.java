package dev.patriciafb.bankacount.models;

public class Account {
    protected double balance;
    protected int numberOfDeposits = 0;
    protected int numberOfWithdrawals = 0;
    protected double annualInterestRate;
    protected double monthlyFee = 0;

    public Account(double balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(double amount) {
        balance += amount;
        numberOfDeposits++;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        numberOfWithdrawals++;
        return true;
    }

    public void calculateMonthlyInterest() {
        balance += balance * (annualInterestRate / 100) / 12;
    }

    public void generateMonthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public String printAccountDetails() {
        return String.format("Balance: %.2f, Deposits: %d, Withdrawals: %d, Monthly Fee: %.2f",
                balance, numberOfDeposits, numberOfWithdrawals, monthlyFee);
    }
}