package com.techelevator;

import com.techelevator.view.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private static final BigDecimal[] FEED_MONEY_MENU_OPTIONS = {BigDecimal.valueOf(100,2), BigDecimal.valueOf(200, 2),
            BigDecimal.valueOf(500, 2), BigDecimal.valueOf(1000,2)};

    private VendingMachine vendingMachine = new VendingMachine();

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        vendingMachine.loadInventory();

        while (true) {
            System.out.println();
            System.out.println("**************************************************************");
            System.out.println("Welcome to the Vending Machine! Please select an option below.");
            System.out.println("**************************************************************");
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            System.out.println();

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                vendingMachine.displayItems();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

                while (true) {

                    System.out.println("Current Money Provided: $" + vendingMachine.getVendingBalance().getBalance());
                    String purchaseMenuChoice = (String) this.menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

                    if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                        System.out.print("How much money would you like to add? ");
                        BigDecimal feedMoneyMenuChoice = (BigDecimal) this.menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
                        vendingMachine.getVendingBalance().addMoney(feedMoneyMenuChoice);

                    } else if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

                        vendingMachine.displayItems();

                        System.out.print("Enter item code: ");
                        Scanner userInput = new Scanner(System.in);
                        String itemSelected = userInput.nextLine().toUpperCase();
                        vendingMachine.purchaseItem(itemSelected);

                    } else {
                        BigDecimal currentBalance = vendingMachine.getVendingBalance().getBalance();
                        System.out.println("Your current balance is $" + vendingMachine.getVendingBalance().getBalance());
                        System.out.println("We are returning your change! ");
                        System.out.println(vendingMachine.getVendingBalance().calculateChange(currentBalance));
                        System.out.println("Your new balance is: ");
                        System.out.println(vendingMachine.getVendingBalance().returnChange(currentBalance));
                        break;
                    }
                }
            } else {
                System.out.println("**************************************************");
                System.out.println("Thank you for using this Vending Machine, goodbye!");
                System.out.println("**************************************************");
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
