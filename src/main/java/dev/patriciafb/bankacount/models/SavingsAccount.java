package dev.patriciafb.bankacount.models;

public class SavingsAccount extends Account {
    private boolean isActive;

    public SavingsAccount(double initialBalance, double annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.isActive = initialBalance >= 10000;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("The savings account is inactive. Cannot withdraw.");
            return false;
        }
        return super.withdraw(amount); 
    }
   
    @Override
    public void generateMonthlyStatement() {
        if (getNumberOfWithdrawals() > 4) {
            this.monthlyFee += (getNumberOfWithdrawals() - 4) * 1000; 
        }
        super.generateMonthlyStatement(); 
        this.isActive = getBalance() >= 10000; 
    }

    @Override
    public String printAccountDetails() {
        int totalTransactions = getNumberOfDeposits() + getNumberOfWithdrawals();
        return String.format("Balance: %.2f, Monthly Fee: %.2f, Transactions: %d, Active: %b",
                getBalance(), monthlyFee, totalTransactions, isActive);
    }
}
