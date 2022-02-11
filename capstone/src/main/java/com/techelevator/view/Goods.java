package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

public class Goods {
    private List<String> slot = new ArrayList<>();
    private int inventory = 5;
    private List<String> name = new ArrayList<>();
    private List<Double> price = new ArrayList<>();
    private String sound;

    public Goods(List<String> name, List<Double> price, List<String> slot, int inventory, String sound) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.inventory = inventory;
        this.sound = sound;
    }

    public Goods() {
    }


    public List<String> getSlot() {
        return slot;
    }


    public int getInventory() {
        return inventory;
    }


    public List<String> getName() {
        return name;
    }


    public List<Double> getPrice() {
        return price;
    }


    public String getSound() {
        return sound;
    }

    public void callSlot(String itemsSelected) {
        if (itemsSelected.contains("A1")) {
            System.out.println("Potato Crisps");
        }
    }

}
