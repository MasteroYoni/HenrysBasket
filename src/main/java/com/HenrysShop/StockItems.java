package com.HenrysShop;

public class StockItems {

    private String name;
    private String unit;
    private double price;
    private int count = 0;

    public StockItems(String name, String unit, double price) {
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }
    public int getCount(){
        return count;
    }

    public void increaseCount(int amount){
        count += amount;
    }

    public void setCount(int newCount){
        count = newCount;
    }

}
