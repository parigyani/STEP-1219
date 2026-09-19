package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1001, "John Doe", 25, 5000.0, "Savings", "1234");

        System.out.println("=== Activity 3: Enhanced Account Test ===");
        System.out.println("Initial Balance: Rs " + account.getBalance() + " | Status: " + account.getStatus());

        boolean result = account.withdraw(1000, "1234");
        System.out.println("Withdraw with correct PIN: " + (result ? "SUCCESS" : "FAILED")
                + " | Balance: Rs " + account.getBalance());

        result = account.withdraw(500, "9999");
        System.out.println("Withdraw with wrong PIN: " + (result ? "SUCCESS" : "FAILED")
                + " | Balance: Rs " + account.getBalance());

        account.suspend();
        System.out.println("Account Suspended.");

        result = account.withdraw(500, "1234");
        System.out.println("Withdraw on SUSPENDED account: " + (result ? "SUCCESS" : "FAILED")
                + " | Balance: Rs " + account.getBalance());

        account.activate();
        System.out.println("Account Re-Activated.");

        account.changePin("1234", "5678");
        System.out.println("PIN Changed Successfully.");

        result = account.withdraw(1000, "5678");
        System.out.println("Withdraw with new PIN: " + (result ? "SUCCESS" : "FAILED")
                + " | Balance: Rs " + account.getBalance());
    }
}
