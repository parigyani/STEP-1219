package com.gdb.domain;

public class Account {
    private int accountNumber;
    private String customerName;
    private int customerAge;
    private double balance;
    private String accountType;
    private boolean active;

    public Account(int accountNumber, String customerName, int customerAge,
                   double balance, String accountType, boolean active) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.balance = balance;
        this.accountType = accountType;
        this.active = active;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance && active) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Age: " + customerAge);
        System.out.println("Balance: Rs " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Active: " + active);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
