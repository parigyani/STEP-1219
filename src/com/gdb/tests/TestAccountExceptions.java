package com.gdb.tests;

import com.gdb.domain.Account;
import com.gdb.exceptions.*;

public class TestAccountExceptions {
    public static void main(String[] args) {
        System.out.println("=== Activity 5: Custom Exceptions Test ===");

        Account account = new Account(1001, "John Doe", 25, 5000.0, "Savings", "1234");

        try {
            account.withdraw(1000, "9999");
        } catch (InvalidPinException e) {
            System.out.println("Caught InvalidPinException as expected: " + e.getMessage());
        } catch (AccountException e) {
            System.out.println("Unexpected AccountException: " + e.getMessage());
        }

        account.suspend();

        try {
            account.withdraw(1000, "1234");
        } catch (InactiveAccountException e) {
            System.out.println("Caught InactiveAccountException as expected: " + e.getMessage());
        } catch (AccountException e) {
            System.out.println("Unexpected AccountException: " + e.getMessage());
        }

        account.activate();

        try {
            account.deposit(-100);
        } catch (InvalidAmountException e) {
            System.out.println("Caught InvalidAmountException as expected: " + e.getMessage());
        }

        try {
            account.withdraw(10000, "1234");
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught InsufficientBalanceException as expected: " + e.getMessage());
        } catch (AccountException e) {
            System.out.println("Unexpected AccountException: " + e.getMessage());
        }

        try {
            account.withdraw(1000, "1234");
            System.out.println("Successful withdrawal completed: Rs 1000.0 | New Balance: Rs "
                    + account.getBalance());
        } catch (AccountException e) {
            System.out.println("Unexpected failure: " + e.getMessage());
        }
    }
}
