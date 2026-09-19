package com.gdb.tests;

import com.gdb.domain.*;

public class TestAccountSubclasses {
    public static void main(String[] args) {
        System.out.println("=== Activity 7: Account Subclasses Test ===");

        SavingsAccount savings = new SavingsAccount(
                1001, "John Doe", 25, 10000.0, "1234");

        CurrentAccount current = new CurrentAccount(
                1002, "Jane Smith", 30, 5000.0, "1234");

        FixedDepositAccount fixedDeposit = new FixedDepositAccount(
                1003, "Bob Smith", 35, 20000.0, "1234");

        SalaryAccount salary = new SalaryAccount(
                1004, "Alice", 28, 15000.0, "1234", "Infosys");

        System.out.println("Savings Account Created: Balance Rs "
                + savings.getBalance() + " | Min Balance: Rs "
                + savings.getMinBalance());

        System.out.println("Current Account Created: Overdraft Limit Rs "
                + current.getOverdraftLimit());

        System.out.println("Fixed Deposit Created: Tenure "
                + fixedDeposit.getTenureMonths() + " months | Interest: "
                + fixedDeposit.getInterestRate() + "%");

        System.out.println("Salary Account Created: Employer "
                + salary.getEmployerName());

        System.out.println("All subclasses instantiated successfully!");
    }
}
