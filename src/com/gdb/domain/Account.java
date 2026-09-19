package com.gdb.domain;

import com.gdb.exceptions.*;

public class Account {
    private int accountNumber;
    private String customerName;
    private int customerAge;
    private double balance;
    private String accountType;
    private String pin;
    private String status;

    public Account(int accountNumber, String customerName, int customerAge,
                   double balance, String accountType, String pin) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.balance = balance;
        this.accountType = accountType;
        this.pin = pin;
        this.status = "ACTIVE";
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount, String enteredPin) throws AccountException {
        if (!pin.equals(enteredPin)) {
            throw new InvalidPinException("Invalid PIN entered");
        }

        if (!status.equals("ACTIVE")) {
            throw new InactiveAccountException("Account is not active");
        }

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds in account");
        }

        balance -= amount;
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

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPin() {
        return pin;
    }

    public String getStatus() {
        return status;
    }
}
