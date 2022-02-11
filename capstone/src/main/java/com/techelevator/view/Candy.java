package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

public class Candy extends Goods implements Sellable {

    public Candy(List<String> name, List<Double> price, List<String> slot, int inventory, String sound) {
        super(name, price, slot, inventory, "Munch Munch, Yum!");
    }


    public Candy() {

    }
}
