package com.techelevator.view;

import java.math.BigDecimal;
import java.util.List;

public class Drinks extends Item {

    public Drinks(String slot, String name, BigDecimal price) {
        super(slot, 5, name, price, "Glug Glug, Yum!");
    }

    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
