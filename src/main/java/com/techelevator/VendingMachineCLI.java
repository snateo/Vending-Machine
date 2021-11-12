package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;


// Vending Machine Command Line Interface application

public class VendingMachineCLI{
	private Map<String, Items> inventoryList = new LinkedHashMap<>();
	public Map<String, Items> getInventoryList() {
		return inventoryList;
	}

	DateFormat dateFormat2 = new SimpleDateFormat(" dd/MM/yyyy hh:mm:ss aa ");
	String dateString2 = dateFormat2.format(new Date()).toString();
	private int totalSales = 0;

	public VendingMachineCLI(File file) throws FileNotFoundException {
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String[] description;
			description = reader.nextLine().split("\\|");
			double price = Double.parseDouble(description[2]);
			inventoryList.put(description[0], new Items(description[0], description[1], price, description[3], 5));
		}
	}

	public List<String> itemDisplay() {
		List<String> itemsAsAList = new ArrayList<>();
		Set<String> keys = inventoryList.keySet();
		for (String key : keys) {
			Items product = inventoryList.get(key);
			StringBuffer itemAsString = new StringBuffer();
			itemAsString.append(product.getSlot() + " - ");
			itemAsString.append(product.getName() + " - ");
			itemAsString.append(product.getPrice() + " - ");


			if (product.getStock() == 0) {
				itemAsString.append("OUT OF STOCK!");
				itemsAsAList.add(itemAsString.toString());

			} else {
				itemAsString.append("Stock: " + product.getStock());
				itemsAsAList.add(itemAsString.toString());
			}
		}
		return itemsAsAList;
	}

	public double makeAPurchase(Purchases p, String slot) {
		File log = new File("log.txt");
		try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {

			writer.println(dateString2 + " ITEM: " + this.getInventoryList().get(slot).getName() + " " + "$" + getInventoryList().get(slot).getPrice() + " " + "$" + p.getCurrentBalance());

		} catch (Exception e) {
			System.out.println("The log was not written!");
		}

		double balance = p.getCurrentBalance();
		balance = Math.round(balance * 100.00) / 100.00;

		System.out.println("Balance: $" + balance);

		while (!getInventoryList().containsKey(slot)) {
			System.out.println("Slot does not exist...");
			return p.getCurrentBalance();
		}

		if (getInventoryList().get(slot).getPrice() <= balance && this.getItem(slot).getStock() > 0) {
			this.getItem(slot).setStock(getItem(slot).getStock() - 1);
			System.out.println("You have chosen: " + getInventoryList().get(slot).getName());
			balance = p.getCurrentBalance();


//          } if (getInventoryList().get(slot).getPrice() <= balance) {

//             this.getItem(slot).setStock(getItem(slot).getStock() - 1);
			System.out.println(" Purchase successful. ");
			System.out.println(" Thank you for purchasing " + getInventoryList().get(slot).getName());
			System.out.println(this.getItem(slot).getSaying(slot));

			balance -= getInventoryList().get(slot).getPrice();
			balance = Math.round(balance * 100.00) / 100.00;
			p.setCurrentBalance(balance);
			System.out.println("\nYou have $" + p.getCurrentBalance() + " remaining.");
			totalSales++;

		} else if (balance < this.getItem(slot).getPrice()) {
			System.out.println("Insufficient funds!");

		} else if (this.getItem(slot).getStock() == 0) {
			System.out.println("Out of stock!");
		}
		return p.getCurrentBalance();
	}

	private Items getItem (String slot) {
		return getInventoryList().get(slot);
	}
}







