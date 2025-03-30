package dev.patriciafb.bankacount.models;

public class Account {

    private double balance;
    private int numberConsignments;

    public Account(double initialBalance, int initialConsignments) {
        this.balance = initialBalance;
        this.numberConsignments = initialConsignments;
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

    public boolean getMoney(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoney'");
    }
    private void getNumberRetirement() {
        // TODO
    }

    private Offset<Double> within(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'within'");
    }
}
