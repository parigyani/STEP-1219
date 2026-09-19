package com.gdb.domain;

public class Account {
    private int accountNumber;
    private String customerName;
    private int customerAge;
    private double balance;
    private String accountType;
    private String status;
    private String pin;

    public Account(int accountNumber, String customerName, int customerAge,
                   double balance, String accountType, String pin) {
        if (customerAge < 18) {
            throw new IllegalArgumentException("Customer must be at least 18 years old");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        if (pin == null || !pin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.balance = balance;
        this.accountType = accountType;
        this.status = "ACTIVE";
        this.pin = pin;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void changePin(String oldPin, String newPin) {
        if (!validatePin(oldPin)) {
            throw new IllegalArgumentException("Invalid old PIN");
        }
        if (newPin == null || !newPin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }
        pin = newPin;
    }

    public boolean deposit(double amount) {
        if (amount > 0 && status.equals("ACTIVE")) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, String enteredPin) {
        if (!validatePin(enteredPin)) {
            return false;
        }

        if (!status.equals("ACTIVE")) {
            return false;
        }

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public void suspend() {
        status = "SUSPENDED";
    }

    public void activate() {
        status = "ACTIVE";
    }

    public void close() {
        status = "CLOSED";
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

    public String getStatus() {
        return status;
    }

    public String getPin() {
        return pin;
    }
}
