package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine implements Sellable {

    private final File inputFile = new File("vendingmachine.csv");

    private Map<String, Double> goodsMap = new HashMap<>();

    private Balance vendingBalance = new Balance(0.00);

    private Item vendingGoods = new Item();

    private Map<String, Item> inventory = new HashMap<>();

    public Balance getVendingBalance() {
        return vendingBalance;
    }

    public void setVendingBalance(Balance vendingBalance) {
        this.vendingBalance = vendingBalance;
    }

    // TODO - How to implement array? Do we need an array?
    public void vendingMachineItems() {
        String vendingItems = "";
        try (Scanner file = new Scanner(inputFile)) {
            while (file.hasNextLine()) {
                vendingItems = file.nextLine();

                String[] parts = vendingItems.split("\\|");
                if (parts[3].equalsIgnoreCase("chips")) {
                    Item item = new Chips(parts[0], parts[1], new BigDecimal(parts[2]));
                    inventory.put(parts[0], item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String[]> getGoodsMap() {
//        goodsMap.put("Potato Crisps", 3.05);
//        goodsMap.put("Stackers", 1.45);
//        goodsMap.put("Grain Waves", 2.75);
//        goodsMap.put("Cloud Popcorn", 3.65);
//        goodsMap.put("Moonpie", 1.80);
//        goodsMap.put("Cowtales", 1.50);
//        goodsMap.put("Wonka Bar", 1.50);
//        goodsMap.put("Crunchie", 1.75);
//        goodsMap.put("Cola", 1.25);
//        goodsMap.put("Dr. Salt", 1.50);
//        goodsMap.put("Mountain Melter", 1.50);
//        goodsMap.put("Heavy", 1.50);
//        goodsMap.put("U-Chews", .85);
//        goodsMap.put("Little League Chew", .95);
//        goodsMap.put("Chiclets", .75);
//        goodsMap.put("Triplemint", .75);

        goodsMap.put();

        return goodsMap;
    }

//    public void callSlot(String itemsSelected) {
//        Sellable[] vendingItemsForSale = new Sellable[]{new Gum(), new Candy(), new Drinks(), new Chips()};
//        for (Sellable sellable : vendingItemsForSale) {
//            String sound = sellable.getSound();
//            String slot = sellable.getSlot();
//            if (itemsSelected.contains(slot)) {
//                System.out.println(getName() + getPrice() + sound);
//            }
//        }
//    }

    @Override
    public List<String> getName() {
        return null;
    }

    @Override
    public List<Double> getPrice() {
        return null;
    }

    @Override
    public List<String> getSlot() {
        return null;
    }

    @Override
    public int getInventory() {
        return 0;
    }

    @Override
    public String getSound() {
        return null;
    }

//    public void selectItem() {
//
//        for (Sellable sellable : vendingItemsForSale) {
//            String sound = sellable.getSound();
//            String slot = sellable.getSlot();
//
//            if (slot.contains("A1")) {
//                System.out.println(sound);
//
//            }
//        }
//    }

//    public String getName() {
//        return null;
//    }
//
//    public double getPrice() {
//        return 0;
//    }
//
//    @Override
//    public String getSlot() {
//        return null;
//    }
//
//    @Override
//    public int getInventory() {
//        return 0;
//    }
//
//    @Override
//    public String getSound() {
//        return null;
//    }

}
