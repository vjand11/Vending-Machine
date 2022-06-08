package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VendingMachine {

    private final File inputFile = new File("C:\\Users\\VANDERSO\\OneDrive - Insight\\Documents\\Projects\\repos\\Vending-Machine\\capstone\\vendingmachine.csv");

    private Balance vendingBalance = new Balance(BigDecimal.ZERO);

    private Map<String, Item> inventory = new HashMap<>();

    public Balance getVendingBalance() {
        return vendingBalance;
    }

    public void setVendingBalance(Balance vendingBalance) {
        this.vendingBalance = vendingBalance;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void loadInventory() {
        String vendingItems = "";
        try (Scanner file = new Scanner(inputFile)) {
            while (file.hasNextLine()) {
                vendingItems = file.nextLine();

                String[] parts = vendingItems.split("\\|");
                if (parts[3].equalsIgnoreCase("chip")) {
                    Item item = new Chips(parts[0], parts[1], new BigDecimal(parts[2]));
                    inventory.put(parts[0], item);
                } else if (parts[3].equalsIgnoreCase("candy")) {
                    Item item = new Candy(parts[0], parts[1], new BigDecimal(parts[2]));
                    inventory.put(parts[0], item);
                } else if (parts[3].equalsIgnoreCase("gum")) {
                    Item item = new Gum(parts[0], parts[1], new BigDecimal(parts[2]));
                    inventory.put(parts[0], item);
                } else if (parts[3].equalsIgnoreCase("drink")) {
                    Item item = new Drinks(parts[0], parts[1], new BigDecimal(parts[2]));
                    inventory.put(parts[0], item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayItems() {

        for (Map.Entry<String, Item> pair : inventory.entrySet()) {
            if (pair.getValue().getQuantity() <= 0) {
                System.out.println(pair.getKey() + " | " + pair.getValue().getName() + " | $" + pair.getValue().getPrice() + " | Item SOLD OUT");
            } else {
                System.out.println(pair.getKey() + " | " + pair.getValue().getName() + " | $" + pair.getValue().getPrice() + " | " + pair.getValue().getQuantity() + " available");
            }
        }
    }

    public void purchaseItem(String slotSelected) {

        if (inventory.containsKey(slotSelected)) {
            int quantity = inventory.get(slotSelected).getQuantity();
            BigDecimal userBalance = vendingBalance.getBalance();
            BigDecimal itemPrice = inventory.get(slotSelected).getPrice();

            if (quantity > 0 && userBalance.compareTo(itemPrice) > 0) {
                inventory.get(slotSelected).dispense();
                vendingBalance.logFile(inventory.get(slotSelected).getName(), userBalance.toString(),
                        userBalance.subtract(itemPrice).toString());
                vendingBalance.updateBalance(itemPrice);
                System.out.println(inventory.get(slotSelected).getSound());
                System.out.println("You selected: " + inventory.get(slotSelected).getName() + " which costs: $" + itemPrice);
            } else if (quantity > 0 && userBalance.compareTo(itemPrice) < 0) {
                System.out.println("You don't have enough money to buy this item");
                System.out.println("Please add additional funds or select another item");
            } else if (quantity < 1) {
                System.out.println("Item is sold out");
            }

        } else {
            System.out.println("Invalid input, please try again");
        }
    }
}
