package com.techelevator.view;

import java.util.List;

public interface Sellable {

    List<String> getName();
    List<Double> getPrice();
    List<String> getSlot();
    int getInventory();
    String getSound();

}
