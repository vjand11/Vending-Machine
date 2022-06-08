package com.techelevator.view;

import java.math.BigDecimal;
import java.util.List;

public class Candy extends Item {

    public Candy(String slot, String name, BigDecimal price) {
        super(slot, 5, name, price);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
