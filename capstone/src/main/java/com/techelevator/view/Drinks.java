package com.techelevator.view;

public class Drinks extends Goods implements Sellable {

    public Drinks(String name, double price, String slot, int inventory, String sound) {
        super(name, price, slot, inventory, sound);
    }

}
