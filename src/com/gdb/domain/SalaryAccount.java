package com.gdb.domain;

public class SalaryAccount extends Account {
    private int inactiveMonths;
    private String employerName;

    public SalaryAccount(String accountNumber, String name, int age, double balance,
                         String status, String pin, String employerName) {
        super(accountNumber, name, age, balance, "SALARY", status, pin);
        this.employerName = employerName;
        this.inactiveMonths = 0;
    }

    public int getInactiveMonths() {
        return inactiveMonths;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void incrementInactiveMonths() {
        inactiveMonths++;
    }
}
