package dev.patriciafb.bankacount.models;

public class Account {
    protected double balance;
    protected int numberOfDeposits = 0;
    protected int numberOfWithdrawals = 0;
    protected double annualInterestRate;
    protected double monthlyFee = 0;

    public Account(double initialBalance, double annualInterestRate) {
    }
   
    public void deposit(double amount) {
    }

    public double getBalance() {
        return this.balance;
    }

    /*private int numberConsignments;
    private int numberRetirements;

    public Account(double initialBalance, int initialConsignments) {
        this.balance = initialBalance;
        this.numberConsignments = initialConsignments;
        this.numberRetirements = 0;
    }

    public void record(double amount) {
        this.balance += amount;
        this.numberConsignments++;
    }

    

    public int getNumberConsignments() {
        return numberConsignments;
    }

    public boolean getMoney(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            this.numberRetirements++;
            return true;
        }
        return false;
    }

    public int getNumberRetirement() {
        return this.numberRetirements;
    }*/
}
