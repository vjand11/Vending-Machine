package com.techelevator.view;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        String begBal = balance.toString();
        balance = balance.add(moneyAdded);
        String newBal = balance.toString();
        logFile(" FEED MONEY: $", begBal, newBal);
    }

    public void updateBalance(BigDecimal price) {
        String begBal = balance.toString();
        if (balance.compareTo(price) >= 0) {
            balance = balance.subtract(price);
            String newBal = balance.toString();
            logFile(" Item selected ", begBal, newBal);
        } else
            throw new IllegalArgumentException("You do not have enough money for purchase.");
    }

    public BigDecimal calculateChange(BigDecimal balanceRemaining) {

        BigDecimal quarters = (balanceRemaining.remainder(QUARTER));
        BigDecimal dimes = (quarters.remainder(DIME));
        BigDecimal nickels = (dimes.remainder(NICKEL));
        BigDecimal numQuarters = (balanceRemaining.subtract(quarters).divide(QUARTER));
        BigDecimal numDimes = ((quarters)).divide(DIME, 0, RoundingMode.DOWN);
        BigDecimal numNickels = ((dimes)).divide(NICKEL);
        System.out.println("Number of quarters to return: " + numQuarters);
        System.out.println("Number of dimes to return: " + numDimes);
        System.out.println("Number of nickels to return: " + numNickels);
        return getBalance();
    }

    public BigDecimal returnChange(BigDecimal remainingBalance) {
        String begBal = balance.toString();
        updateBalance(remainingBalance);
        String endBal = balance.toString();
        logFile(" GIVE CHANGE: $", begBal, endBal);
        return getBalance();
    }

    public void logFile(String message, String startingBalance, String endingBalance) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

        try (PrintWriter logFile = new PrintWriter(new FileWriter("log.txt", true))) {

            String formattedDate = dateFormatter.format(LocalDateTime.now());

            logFile.println(formattedDate + message + startingBalance + endingBalance);

        } catch (FileNotFoundException e) {
            System.out.println("Error creating file");
        } catch (IOException e) {
            System.out.println("Caught an IOException. Message: " + e.getMessage());
        }

    }


}
