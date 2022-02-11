package com.techelevator.view;

import java.util.List;

public class Gum extends Goods implements Sellable {

    public Gum(List<String> name, List<Double> price, List<String> slot, int inventory, String sound) {
        super(name, price, slot, inventory, "Chew Chew, Yum!");
    }

    public Gum() {

    }
}
