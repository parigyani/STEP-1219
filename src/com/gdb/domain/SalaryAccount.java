package com.gdb.domain;

public class SalaryAccount extends Account {
    private String employerName;
    private int inactiveMonths = 0;

    public SalaryAccount(int accountNumber, String customerName, int customerAge,
                         double balance, String pin, String employerName) {
        super(accountNumber, customerName, customerAge, balance, "SALARY", pin);
        this.employerName = employerName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public int getInactiveMonths() {
        return inactiveMonths;
    }

    public void setInactiveMonths(int inactiveMonths) {
        this.inactiveMonths = inactiveMonths;
    }

    public void incrementInactiveMonths() {
        inactiveMonths++;
    }
}
