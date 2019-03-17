package com.company;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int withdrawal){
            balance -= withdrawal;
    }

    public void deposit(int deposit){
            balance += deposit;
    }

    public int getBalance() {
        return balance;
    }
}
