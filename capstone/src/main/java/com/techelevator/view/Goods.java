package com.techelevator.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Goods implements Sellable {
    private String slot;
    private int inventory = 5;
    private String name;
    private double price;
    private String sound;

    public Goods(String name, double price, String slot, int inventory, String sound) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.inventory = inventory;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

//    public String vendingFile() {
//
////        String vendingItems = "";
////        try (Scanner inputFile = new Scanner("vendingmachine.csv")) {
////
////            while (inputFile.hasNextLine()) {
////                vendingItems = inputFile.nextLine();
////
////            }
////        }
//        return vendingItems;
//    }

}
