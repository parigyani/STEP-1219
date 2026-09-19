package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1001, "John Doe", 25, 5000.0, "Savings", true);

        System.out.println("=== Activity 1: Basic Account Test ===");
        System.out.println("Initial Balance: Rs " + account.getBalance());

        System.out.println("Deposit Rs 1000: " + (account.deposit(1000) ? "SUCCESS" : "FAILED"));
        System.out.println("Balance: Rs " + account.getBalance());

        System.out.println("Withdraw Rs 500: " + (account.withdraw(500) ? "SUCCESS" : "FAILED"));
        System.out.println("Balance: Rs " + account.getBalance());

        System.out.println("Withdraw Rs 10000: " + (account.withdraw(10000) ? "SUCCESS" : "FAILED"));
        System.out.println("Balance: Rs " + account.getBalance());
    }
}
