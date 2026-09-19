package com.gdb.domain;

public class CurrentAccount extends Account {
    private double overdraftLimit = 25000.0;

    public CurrentAccount(int accountNumber, String customerName, int customerAge,
                          double balance, String pin) {
        super(accountNumber, customerName, customerAge, balance, "CURRENT", pin);
    }

    public CurrentAccount(int accountNumber, String customerName, int customerAge,
                          double balance, String pin, double overdraftLimit) {
        super(accountNumber, customerName, customerAge, balance, "CURRENT", pin);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
