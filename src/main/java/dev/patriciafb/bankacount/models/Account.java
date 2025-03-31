package dev.patriciafb.bankacount.models;

public class Account {
    protected double balance;
    protected int numberOfDeposits = 0;
    protected int numberOfWithdrawals = 0;
    protected double annualInterestRate;
    protected double monthlyFee = 0;

    public Account(double initialBalance, double annualInterestRate) {
        this.balance = initialBalance;
        this.annualInterestRate = annualInterestRate;
    }
   
    public void deposit(double amount) {
        if (amount > 0) { 
            this.balance += amount;
            this.numberOfDeposits++;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public int getNumberOfDeposits() {
        return this.numberOfDeposits;
    }

    public int getNumberOfWithdrawals() {
        return this.numberOfWithdrawals;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) { 
            this.balance -= amount;
            this.numberOfWithdrawals++;
            return true;
        }
        return false; 
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = this.balance * (this.annualInterestRate / 100) / 12;
        this.balance += monthlyInterest;
    }

    public void generateMonthlyStatement() {
        calculateMonthlyInterest();
        this.balance -= this.monthlyFee;
    }

    public String printAccountDetails() {
        return String.format("Balance: %.2f, Deposits: %d, Withdrawals: %d, Monthly Fee: %.2f",
                balance, numberOfDeposits, numberOfWithdrawals, monthlyFee);
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}    