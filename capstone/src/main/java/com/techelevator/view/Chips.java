package com.techelevator.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Chips extends Item {

    public Chips(String slot, String name, BigDecimal price) {
        super(slot, 5, name, price, "Crunch Crunch, Yum!");
    }

    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
