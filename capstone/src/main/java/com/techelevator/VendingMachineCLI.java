package com.techelevator;

import com.techelevator.view.Balance;
import com.techelevator.view.Goods;
import com.techelevator.view.Menu;
import com.techelevator.view.Sellable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Goods goods = new Goods("Stackers", 1.45);

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				String vendingItems = "";

				try (Scanner inputFile = new Scanner(new File("vendingmachine.csv"))) {
					while (inputFile.hasNextLine()) {
						vendingItems = inputFile.nextLine();
						System.out.println(vendingItems);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Menu purchaseMenu = new Menu(System.in, System.out);
				Balance startingBalance = new Balance(0.00);
				System.out.println("Current Money Provided: " + startingBalance.getBalance());

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
