package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private final File inputFile = new File("vendingmachine.csv");

    private Balance vendingBalance = new Balance(0.00);

    private Item vendingGoods = new Item();

    private Map<String, Item> inventory = new HashMap<>();

    public Balance getVendingBalance() {
        return vendingBalance;
    }

    public void setVendingBalance(Balance vendingBalance) {
        this.vendingBalance = vendingBalance;
    }

    public void vendingMachineItems() {
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
        String vendingItems = "";
        try (Scanner file = new Scanner(inputFile)) {
            while (file.hasNextLine()) {
                vendingItems = file.nextLine();

                String[] parts = vendingItems.split("\\|");
                System.out.println(parts[0] + " " + parts[1] + " $" + parts[2] + " " + vendingGoods.getQuantity() + " Available");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void purchaseItem(String slotSelected) {

        if (inventory.containsKey(slotSelected)) {

        }
    }

}
