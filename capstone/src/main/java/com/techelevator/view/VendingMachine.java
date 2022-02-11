package com.techelevator.view;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class VendingMachine implements Sellable {

    private final File inputFile = new File("vendingmachine.csv");

    private Map<String, Double> goodsMap = new HashMap<>();

    private Balance vendingBalance = new Balance(0.00);

    private Goods vendingGoods = new Goods();

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
                //String[] vendingArray = new String[] {vendingItems};
                String[] vendingArray = vendingItems.split("\\|");
                System.out.println(vendingArray[0] + " " + vendingArray[1] + " $" + vendingArray[2] + " " + vendingGoods.getInventory() + " available");
                //System.out.println(Arrays.toString(vendingItems.split("\\|")));
//                for (int i = 0; i <= vendingArray.length; i++) {
//                    System.out.println(vendingArray);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Double> getGoodsMap() {
        goodsMap.put("Potato Crisps", 3.05);
        goodsMap.put("Stackers", 1.45);
        goodsMap.put("Grain Waves", 2.75);
        goodsMap.put("Cloud Popcorn", 3.65);
        goodsMap.put("Moonpie", 1.80);
        goodsMap.put("Cowtales", 1.50);
        goodsMap.put("Wonka Bar", 1.50);
        goodsMap.put("Crunchie", 1.75);
        goodsMap.put("Cola", 1.25);
        goodsMap.put("Dr. Salt", 1.50);
        goodsMap.put("Mountain Melter", 1.50);
        goodsMap.put("Heavy", 1.50);
        goodsMap.put("U-Chews", .85);
        goodsMap.put("Little League Chew", .95);
        goodsMap.put("Chiclets", .75);
        goodsMap.put("Triplemint", .75);
        return goodsMap;
    }

    public boolean selectItem(String itemCode) {
        if (itemCode.contains("A1")) {
            return goodsMap.containsKey("Potato Crisps");
        } else return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

}
