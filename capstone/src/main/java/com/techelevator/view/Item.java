package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String slot;
    private int inventory = 5;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;


    public Item(String slot, int inventory, String name, BigDecimal price,) {
        this.slot = slot;
        this.inventory = inventory;
        this.name = name;
        this.price = price;
    }

    public Item() {
    }


    public String getSlot() {
        return slot;
    }

    public int getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
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
