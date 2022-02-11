package com.techelevator;

import com.techelevator.view.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT};
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String DOLLAR = "1.00";
    private static final String TWO_DOLLARS = "2.00";
    private static final String FIVE_DOLLARS = "5.00";
    private static final String TEN_DOLLARS = "10.00";
    private static final String[] FEED_MONEY_MENU_OPTIONS = {DOLLAR, TWO_DOLLARS, FIVE_DOLLARS, TEN_DOLLARS};

    private VendingMachine vendingMachine = new VendingMachine();

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                vendingMachine.vendingMachineItems();
                // display vending machine items

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

                while (true) {

                    System.out.println("Current Money Provided: " + vendingMachine.getVendingBalance().getBalance());
                    String purchaseMenuChoice = (String) this.menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                    if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        System.out.print("How much money would you like to add? ");
                        String feedMoneyMenuChoice = (String) this.menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);

                        vendingMachine.getVendingBalance().addMoney(Double.parseDouble(feedMoneyMenuChoice));

                    } else if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

                        System.out.println("Enter items code: ");
                        //String itemCodeChoice = (String) this.menu.getChoiceFromOptions(ITEM_CODES);
                        Scanner userInput = new Scanner(System.in);
                        String itemSelected = userInput.nextLine();
                        vendingMachine.selectItem(itemSelected);

                    } else {
                        break;
                    }
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
