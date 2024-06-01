package com.sda;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Deposit amount must be greater than 0.");
            return false;
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
            return false;
        }
    }
    public boolean transfer(double amount, BankAccount recipientAccount) {
        if (withdraw(amount)) {
            recipientAccount.deposit(amount);
            return true;
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
            return false;
        }
    }
    public double getBalance() {
        return balance;
    }
}