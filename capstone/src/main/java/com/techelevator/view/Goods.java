package com.techelevator.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Goods implements Sellable {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
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
