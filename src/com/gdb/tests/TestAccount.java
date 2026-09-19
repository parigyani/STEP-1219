package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 4: Enhanced Account Test Suite ===");

        int passed = 0;

        try {
            new Account(1001, "Underage", 17, 1000.0, "SAVINGS", "1234");
            System.out.println("Test 1 (Underage Customer Rejection): [FAIL]");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1 (Underage Customer Rejection): [PASS]");
            passed++;
        }

        Account account = new Account(1001, "John Doe", 25, 5000.0, "SAVINGS", "1234");

        if (!account.withdraw(1000, "9999") && account.getBalance() == 5000.0) {
            System.out.println("Test 2 (Wrong PIN Rejection): [PASS]");
            passed++;
        } else {
            System.out.println("Test 2 (Wrong PIN Rejection): [FAIL]");
        }

        if (account.withdraw(1000, "1234") && account.getBalance() == 4000.0) {
            System.out.println("Test 3 (Correct PIN Withdrawal): [PASS]");
            passed++;
        } else {
            System.out.println("Test 3 (Correct PIN Withdrawal): [FAIL]");
        }

        account.changePin("1234", "5678");

        if (!account.validatePin("1234") && account.validatePin("5678")) {
            System.out.println("Test 4 (PIN Change & Old PIN Invalidation): [PASS]");
            passed++;
        } else {
            System.out.println("Test 4 (PIN Change & Old PIN Invalidation): [FAIL]");
        }

        account.suspend();

        if (!account.withdraw(500, "5678") && account.getBalance() == 4000.0) {
            System.out.println("Test 5 (Suspended Account Block): [PASS]");
            passed++;
        } else {
            System.out.println("Test 5 (Suspended Account Block): [FAIL]");
        }

        account.activate();

        if (account.withdraw(1000, "5678") && account.getBalance() == 3000.0) {
            System.out.println("Test 6 (Reactivation & Success): [PASS]");
            passed++;
        } else {
            System.out.println("Test 6 (Reactivation & Success): [FAIL]");
        }

        if (passed == 6) {
            System.out.println("All Enhanced Account tests passed!");
        }
    }
}
