package com.techelevator.view;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal balance;

    public Balance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal addMoney(BigDecimal moneyAdded) {
        balance = balance.add(moneyAdded);
        return getBalance();
    }

    public BigDecimal updateBalance(BigDecimal price) {
        if (balance.compareTo(price) >= 0) {
            balance = balance.subtract(price);
            return getBalance();
        } else
        throw new IllegalArgumentException("You do not have enough money for purchase.");
    }

    public BigDecimal returnChange(BigDecimal remainingBalance) {
        balance = updateBalance(remainingBalance);
        return getBalance();
    }


}
