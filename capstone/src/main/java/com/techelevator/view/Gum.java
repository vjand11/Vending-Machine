package com.techelevator.view;

public class Gum extends Goods implements Sellable {

    public Gum(String name, double price, String slot, int inventory, String sound) {
        super(name, price, slot, inventory, "Chew Chew, Yum!");
    }

    public Gum() {

    }
}
