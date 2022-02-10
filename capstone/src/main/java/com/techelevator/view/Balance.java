package com.techelevator.view;

public class Balance {

    private double balance;

    public Balance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double addMoney (double moneyAdded) {
        balance += moneyAdded;
        return getBalance();
    }

    public double returnChange(double funds) {
        balance -= funds;
        return getBalance();
    }
}
