package com.techelevator.view;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal balance = BigDecimal.ZERO;
    private static final BigDecimal QUARTER = BigDecimal.valueOf(0.25);
    private static final BigDecimal NICKEL = BigDecimal.valueOf(0.05);
    private static final BigDecimal DIME = BigDecimal.valueOf(0.10);
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100.00);

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addMoney(BigDecimal moneyAdded) {
        balance = balance.add(moneyAdded);
    }

    public void updateBalance(BigDecimal price) {
        if (balance.compareTo(price) >= 0) {
            balance = balance.subtract(price);
        } else
        throw new IllegalArgumentException("You do not have enough money for purchase.");
    }

    public BigDecimal calculateChange(BigDecimal balanceRemaining) {

        BigDecimal quarters = (balanceRemaining.remainder(QUARTER));
        BigDecimal dimes = (quarters.remainder(DIME));
        BigDecimal nickels = (dimes.remainder(NICKEL));
        BigDecimal numQuarters = (balanceRemaining.subtract(quarters).divide(QUARTER));
        BigDecimal numDimes = ((quarters)).divide(DIME);
        BigDecimal numNickels = ((dimes)).divide(NICKEL);
        System.out.println("Number of quarters to return: " + numQuarters);
        System.out.println("Number of dimes to return: " + numDimes);
        System.out.println("Number of nickels to return: " + numNickels);
        return getBalance();
    }

    public BigDecimal returnChange(BigDecimal remainingBalance) {
        updateBalance(remainingBalance);
        return getBalance();
    }


}
