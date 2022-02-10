package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private Map<String, Double> goodsMap = new HashMap<>();

    private Balance vendingBalance = new Balance(0.00);

    public Balance getVendingBalance() {
        return vendingBalance;
    }

    public void setVendingBalance(Balance vendingBalance) {
        this.vendingBalance = vendingBalance;
    }

    // create map of item name and value

    //create method that accepts slot code and return the map at that string


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

    public boolean returnItems (String slot) {
        if (slot.contains("A1")) {
            return goodsMap.containsKey("Potato Crisps");
        }
        else return false;
    }
}
