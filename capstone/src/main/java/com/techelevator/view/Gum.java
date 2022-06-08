package com.techelevator.view;

import java.math.BigDecimal;
import java.util.List;

public class Gum extends Item {

    public Gum(String slot, String name, BigDecimal price) {
        super(slot, 5, name, price);
    }

    @Override
   public String getSound() {
        return "Chew Chew, Yum!";
    }
}
