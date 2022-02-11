package com.techelevator.view;

import java.math.BigDecimal;
import java.util.List;

public class Candy extends Item {

    private String sound;

    public Candy(String slot, String name, BigDecimal price) {
        super(slot, 5, name, price);
    }

    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
