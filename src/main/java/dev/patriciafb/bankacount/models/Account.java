package dev.patriciafb.bankacount.models;

public class Account {

    private double balance;
    private int numberConsignments;
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

    public double getBalance() {
        return this.balance;
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
    }
}