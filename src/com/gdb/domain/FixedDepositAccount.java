package com.gdb.domain;

public class FixedDepositAccount extends Account {
    private int tenureMonths = 12;
    private double interestRate = 6.5;

    public FixedDepositAccount(int accountNumber, String customerName, int customerAge,
                               double balance, String pin) {
        super(accountNumber, customerName, customerAge, balance, "FIXED_DEPOSIT", pin);
    }

    public FixedDepositAccount(int accountNumber, String customerName, int customerAge,
                               double balance, String pin, int tenureMonths, double interestRate) {
        super(accountNumber, customerName, customerAge, balance, "FIXED_DEPOSIT", pin);
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(int tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateMaturity() {
        double monthlyRate = interestRate / 100 / 12;
        return balance * Math.pow(1 + monthlyRate, tenureMonths);
    }
}
