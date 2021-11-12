package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Purchases extends Balance {
    private double currentBalance;

    public Purchases() {
        super();
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File newFile = new File("vendingmachine.csv");
        Purchases p;
        VendingMachineCLI vm = new VendingMachineCLI(newFile);

        boolean keepGoingMain = true;
        while (keepGoingMain) {

            // Main Menu
            System.out.println("(1) See Items available");
            System.out.println("(2) Make a purchase");
            System.out.println("(3) Exit\n");
            System.out.print("Please pick an option!: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\nPlease enter one of the options above: ");
                scanner.next();
            }


            int choice = scanner.nextInt();
            keepGoingMain = false;


            if (choice == 1) {
                for (String items : vm.itemDisplay()) {
                    System.out.println(items);
                }
                System.out.println("");

                keepGoingMain = true;
            }

            // Purchase menu
            if (choice == 2) {
                p = new Purchases();
                boolean keepGoingPurchase = true;
                while (keepGoingPurchase) {
                    System.out.println("\n(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction\n");
                    System.out.print("Please pick an option:");

                    while (!scanner.hasNextInt()) {
                        System.out.print("Please enter one of the options above: ");
                        scanner.next();
                    }
                    int purchaseSelector = scanner.nextInt();


                    if (purchaseSelector == 1) {

                        int feedMoneyChoice = 0;
                        do {
                            System.out.print("Would you like to put $1, $2, $5, $10? (Enter \"0\" to stop): ");
                            while (!scanner.hasNextInt()) {
                                System.out.print("Please enter one of the amounts above: ");
                                scanner.next();
                            }
                            feedMoneyChoice = scanner.nextInt();
                            p.setCurrentBalance(p.feedMoney(feedMoneyChoice));

                        } while (feedMoneyChoice != 0);

                    }
                    if (purchaseSelector == 2) {
                        for (String items : vm.itemDisplay()) {
                            System.out.println(items);
                        }
                        System.out.print("\nSelect an item from the list: ");
                        scanner.reset();
                        String selectItem = scanner.next().toUpperCase();
                        vm.makeAPurchase(p, selectItem);

                    }
                    keepGoingPurchase = true;


                    if (purchaseSelector == 3) {
                        System.out.print("Money left in machine: " + p.finishTransaction());

                        System.out.println("\nThank you for your purchase!\n");
                        System.out.println("Money left in machine: " + p.finishTransaction());

                        System.out.println("Thank you for your purchase!");
                        keepGoingPurchase = false;
                    }
                }
            }
            if (choice == 3) {
                System.out.println("Thank you!");
                System.exit(1);
            } else {
                keepGoingMain = true;
                System.out.println("\nPlease pick one of the options below");
            }

        }
    }


    @Override
    public double getCurrentBalance() {
        return currentBalance;
    }


    @Override
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}









//            System.out.println("(1) Feed Money");
//                    System.out.println("(2) Select Product");
//                    System.out.println(("(3) Finish Transaction"));
//
////            System.out.println("Current balance: " + getCurrentBalance());
//
//                    System.out.println("Please pick an option: ");

