package com.gdb.domain;

public class SavingsAccount extends Account {
    private double minBalance = 1000.0;
    private double interestRate = 4.0;

    public SavingsAccount(int accountNumber, String customerName, int customerAge,
                          double balance, String pin) {
        super(accountNumber, customerName, customerAge, balance, "SAVINGS", pin);
    }

    public SavingsAccount(int accountNumber, String customerName, int customerAge,
                          double balance, String pin, double minBalance, double interestRate) {
        super(accountNumber, customerName, customerAge, balance, "SAVINGS", pin);
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate / 100;
    }
}
