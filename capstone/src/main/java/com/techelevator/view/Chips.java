package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Chips extends Goods implements Sellable {

    private Map<String, Double> chipGoods = new HashMap<>();

    public Chips() {
        super("Potato Crisps", 3.05, "A1", 5, "Crunch Crunch, Yum!");
    }

    public Map<String, Double> getChipGoods() {
        chipGoods.put("Potato Crisps", 3.05);
        chipGoods.put("Stackers", 1.45);
        chipGoods.put("Grain Waves", 2.75);
        chipGoods.put("Cloud Popcorn", 3.65);
        return chipGoods;
    }
}
