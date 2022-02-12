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

    public BigDecimal addMoney (BigDecimal moneyAdded) {
        balance = balance.add(moneyAdded);
        return getBalance();
    }

    public BigDecimal returnChange(BigDecimal price) {
        balance = balance.subtract(price);
        return getBalance();
    }

}
