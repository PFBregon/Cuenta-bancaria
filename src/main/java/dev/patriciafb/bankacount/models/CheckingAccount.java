package dev.patriciafb.bankacount.models;

public class CheckingAccount extends Account {
    private double overdraft; 

    public CheckingAccount(double initialBalance, double annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false; 
    
        System.out.println("Antes del retiro - Balance: " + balance + ", Overdraft: " + overdraft);
    
        if (amount <= balance) { 
            balance -= amount; 
        } else {
            double remainingAmount = amount - balance; 
            overdraft += remainingAmount; 
            balance = 0; 
        }
    
        numberOfWithdrawals++;
    
        System.out.println("Después del retiro - Balance: " + balance + ", Overdraft: " + overdraft);
    
        return true;
    }
    

    @Override
    public void deposit(double amount) {
        if (amount <= 0) return;

        if (overdraft > 0) {
            overdraft -= amount; 
            if (overdraft < 0) {
                balance = Math.abs(overdraft); 
                overdraft = 0;
            }
        } else {
            balance += amount; 
        }

        numberOfDeposits++;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public String printAccountDetails() {
        return String.format("Balance: %.2f, Monthly Fee: %.2f, Transactions: %d, Overdraft: %.2f",
                balance, monthlyFee, numberOfDeposits + numberOfWithdrawals, overdraft);
    }
}
