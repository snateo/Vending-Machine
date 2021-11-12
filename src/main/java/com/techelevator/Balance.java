package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Balance {
    private double currentBalance;

    public Balance() {
    }

    DateFormat dateFormat2 = new SimpleDateFormat(" dd/MM/yyyy hh:mm:ss aa ");
    String dateString2 = dateFormat2.format(new Date()).toString();

    public double feedMoney(double currency) {

        File log = new File("log.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {

            writer.println(dateString2 + " MONEY FED: " + "$" + currency + " " + "$" + getCurrentBalance() + " ");

        } catch (Exception e) {
            System.out.println("NOT LOGGING");
        }

        if (currency == 0.0 || (currency == 1.0) || (currency == 2.0) || (currency == 5.0) || (currency == 10.0)) {
            currentBalance += currency;
        } else {
            System.out.println("Incorrect value!");
        }

        System.out.println("Current Money Provided: $" + currency);
        System.out.println("Your new balance is: $" + currentBalance);
        setCurrentBalance(currentBalance);

        return currentBalance;
    }

    public double finishTransaction() {
        System.out.println("Your change is " + getCurrentBalance());

        double currentCents = getCurrentBalance() * 100;
        int pennies = 0;
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        int dollars = 0;

        File log = new File("log.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {

            writer.println(dateString2 + " CHANGE: " + "$" + getCurrentBalance() + " " + " $0.00");

        } catch (Exception e) {
            System.out.println("NOT LOGGING");
        }


        if (currentCents < 1) {
            System.out.println("Thank you, come again");
        } else {
            // we are not using dollars on this change portion
//            while (currentCents >= 100) {
//                currentCents -= 100;
//                dollars++;
//            }

            while (currentCents >= 25) {
                currentCents -= 25;
                quarters++;
            }
            while (currentCents >= 10) {
                currentCents -= 10;
                dimes++;
            }
            while (currentCents >= 5) {
                currentCents -= 5;
                nickels++;
            }
            pennies = (int) currentCents;
        }

        System.out.println("In total, you should have recieved:");
//        System.out.println("Number of Dollars: " + dollars);
        System.out.println("Number of Quarters: " + quarters);
        System.out.println("Number of Dimes: " + dimes);
        System.out.println("Number of Nickels: " + nickels);
        System.out.println("Number of Pennies: " + pennies);

        currentBalance = currentCents - pennies;

        return currentBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

}
//    public double feedMoney(int amountToFeed) {
//        return getCurrentBalance();
//    }




//    public double feedMoney(int amountToFeed) {
//        return getCurrentBalance();
//    }

//    public double returnMoney(double currentBalance) {
//        return customersMoney;
//    }

    //    public double feedMoney(int amountToFeed) {
//
//        return getCurrentBalance();



    // Getters

//    public static double getCurrentBalance() {
//        return currentBalance;
//    }
//
//    public double getMoneyFed() {
//        return moneyFed;
//    }

//    public double customersMoney() {
//        return customersMoney;
//    }









