package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private final File inputFile = new File("vendingmachine.csv");

    private Balance vendingBalance = new Balance(0.00);

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
            System.out.println(pair.getKey() + " " + pair.getValue().getName() + " $" + pair.getValue().getPrice() + " " + pair.getValue().getQuantity() + " available");
        }
    }

    public void purchaseItem(String slotSelected) {
        /*
        try to get item
        if does not exist thrown exception
        do we have enough to sell more?
            if no throw an exception
        if yes, decrement inventory item.dispense and play sound
         */
        if (inventory.containsKey(slotSelected)) {
            if (inventory.get(slotSelected).getQuantity() > 0) {
                inventory.get(slotSelected).dispense();
                //inventory.get(slotSelected).
            } else {
                throw new IllegalArgumentException("SOLD OUT");
            }
        } else {
            throw new IllegalArgumentException("Item does not exist");
        }
    }
}
