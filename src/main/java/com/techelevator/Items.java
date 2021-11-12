package com.techelevator;

public class Items {
    private String slot;
    private String name;
    private double price;
    private int stock;
    private String saying;

    public Items(String slot, String name, double price, String type, int stock) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.stock = 5;
    }

    public String getSaying(String slot) {

        if (slot != null && slot != "") {
            if (slot.contains("A")) {
                saying = "Crunch Crunch, Yum!";
            } else if (slot.contains("B")) {
                saying = "Munch Munch, Yum!";
            } else if (slot.contains("C")) {
                saying = "Glug Glug, Yum!";
            } else if (slot.contains("D")) {
                saying = "Chew Chew, Yum!";
            } else {
                saying = "Slot was not valid.";
            }
        } else {
            saying = "Slot was not valid.";
        }

        return saying;
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }


        public void setStock ( int stock){
            this.stock = stock;

        }
    }

