package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1001, "John Doe", 25, 5000.0, "Savings", true);

        int passed = 0;

        System.out.println("=== Activity 2: Account Test Suite ===");

        if (account.getAccountNumber() == 1001) {
            System.out.println("Test 1 (Account Number): [PASS]");
            passed++;
        }

        if (account.getCustomerName().equals("John Doe")) {
            System.out.println("Test 2 (Customer Name): [PASS]");
            passed++;
        }

        if (account.getCustomerAge() == 25) {
            System.out.println("Test 3 (Customer Age): [PASS]");
            passed++;
        }

        if (account.getBalance() == 5000.0) {
            System.out.println("Test 4 (Initial Balance): [PASS]");
            passed++;
        }

        if (account.deposit(1000) && account.getBalance() == 6000.0) {
            System.out.println("Test 5 (Deposit): [PASS]");
            passed++;
        }

        if (account.withdraw(500) && account.getBalance() == 5500.0) {
            System.out.println("Test 6 (Withdrawal): [PASS]");
            passed++;
        }

        System.out.println("Tests Passed: " + passed + "/6");
    }
}
