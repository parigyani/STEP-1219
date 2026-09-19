package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestAccountSubclasses {
    public static void main(String[] args) {
        System.out.println("=== Activity 8: Polymorphism Test ===");

        Account savings = new SavingsAccount(
                "1001", "John Doe", 25, 10000.0, "ACTIVE", "1234");

        try {
            savings.withdraw(9500.0, "1234");
            System.out.println("[Savings] Withdraw 9500 (breaches min balance 1000): [FAIL]");
        } catch (MinimumBalanceViolationException e) {
            System.out.println("[Savings] Withdraw 9500 (breaches min balance 1000): Caught MinimumBalanceViolationException [PASS]");
        } catch (AccountException e) {
            System.out.println("[Savings] Unexpected exception: " + e.getMessage() + " [FAIL]");
        }

        Account current = new CurrentAccount(
                "1002", "Jane Smith", 30, 5000.0, "ACTIVE", "1234", 25000.0);

        try {
            current.withdraw(10000.0, "1234");

            if (current.getBalance() == -5000.0) {
                System.out.println("[Current] Withdraw with Overdraft (Balance goes to -5000): SUCCESS [PASS]");
            } else {
                System.out.println("[Current] Withdraw with Overdraft: WRONG BALANCE [FAIL]");
            }
        } catch (AccountException e) {
            System.out.println("[Current] Withdraw with Overdraft: FAILED [FAIL]");
        }

        try {
            current.withdraw(30000.0, "1234");
            System.out.println("[Current] Withdraw exceeding Overdraft (exceeds -25000): [FAIL]");
        } catch (InsufficientBalanceException e) {
            System.out.println("[Current] Withdraw exceeding Overdraft (exceeds -25000): Caught InsufficientBalanceException [PASS]");
        } catch (AccountException e) {
            System.out.println("[Current] Unexpected exception: " + e.getMessage() + " [FAIL]");
        }

        Account fixedDeposit = new FixedDepositAccount(
                "1003", "Bob Smith", 35, 20000.0, "ACTIVE", "1234", 12, 6.5);

        try {
            fixedDeposit.withdraw(1000.0, "1234");
            System.out.println("[FixedDeposit] Withdraw attempt: [FAIL]");
        } catch (AccountException e) {
            System.out.println("[FixedDeposit] Withdraw attempt: Caught AccountException [PASS]");
        }

        System.out.println("All polymorphic behaviors verified!");
    }
}
