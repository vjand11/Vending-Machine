package com.techelevator.view;

import java.util.List;

public class Drinks extends Goods implements Sellable {

    public Drinks(List<String> name, List<Double> price, List<String> slot, int inventory, String sound) {
        super(name, price, slot, inventory, "Glug Glug, Yum!");
    }

    public Drinks() {

    }
}
