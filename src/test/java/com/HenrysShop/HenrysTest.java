package com.HenrysShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HenrysTest {
    @Test
    public void checkStockPopulation1() {
        //test case for integers
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("bread", "loaf", 0.80));
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("apple", "single", 0.10));
        int expectedValue = 4;
        int actualValue = stock.size();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkForBread2() {
        //test case for string

        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("bread", "loaf", 0.80));
        String expectedValue = "bread";
        String actualValue = stock.get(0).getName();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkForBreadinStock3() {
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("bread", "loaf", 0.80));
        stock.add(new StockItems("apple", "single", 0.10));
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals("bread")) {
                String expectedValue = "bread";
                String actualValue = stock.get(i).getName();
                Assertions.assertEquals(expectedValue, actualValue);
            }
        }

    }

    @Test
    public void checksoupPrice4() {
        StockItems soup = new StockItems("soup", "tin", 0.65);
        double expectedValue = 0.65;
        double actualValue = soup.getPrice();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void checkItemsAddedtoBasket5(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("bread", "loaf", 0.80));
        stock.add(new StockItems("apple", "single", 0.10));

        stock.get(0).increaseCount(2);
        stock.get(1).increaseCount(1);
        stock.get(3).increaseCount(1);

        int expectedValue = 4;
        int expectedIndividualValue = 1;
        int actualValue = 0;

        for (int i = 0; i < stock.size(); i++){
            actualValue += stock.get(i).getCount();
        }

        boolean result = (expectedValue == actualValue) && (expectedIndividualValue == stock.get(1).getCount());

        assert result;

    }

    @Test
    public void checkTotalPrice6(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("bread", "loaf", 0.80));
        stock.add(new StockItems("apple", "single", 0.10));

        stock.get(0).increaseCount(2);
        stock.get(1).increaseCount(1);
        stock.get(3).increaseCount(1);

        double expectedValue = 2.70;
        double actualValue = 0;

        for (int i = 0; i < stock.size(); i++){
            actualValue += stock.get(i).getCount() * stock.get(i).getPrice();
        }

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void checkTotalPricewithDiscount7(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("bread", "loaf", 0.80));

        stock.get(0).increaseCount(2);
        stock.get(1).increaseCount(1);

        String expectedValue = "1.70";
        double total = 0;

        total -= DiscountPrice.BreadDiscount(stock);

        for (int i = 0; i < stock.size(); i++){
            total += stock.get(i).getCount() * stock.get(i).getPrice();
        }

        DecimalFormat f = new DecimalFormat("##.00");
        String actualValue = f.format(total);

        Assertions.assertEquals(expectedValue, actualValue);

    }
    @Test
    public void test1FortotalPrice8(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("bread", "loaf", 0.80));

        stock.get(0).increaseCount(3);
        stock.get(1).increaseCount(2);

        String expectedValue = "3.15";
        double total = 0;

        total -= DiscountPrice.totalDiscount(stock, 0);

        for (int i = 0; i < stock.size(); i++){
            total += stock.get(i).getCount() * stock.get(i).getPrice();
        }

        DecimalFormat f = new DecimalFormat("##.00");
        String actualValue = f.format(total);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void test2FortotalPrice9(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("apple", "single", 0.10));

        stock.get(0).increaseCount(1);
        stock.get(1).increaseCount(6);

        String expectedValue = "1.90";
        double total = 0;

        total -= DiscountPrice.totalDiscount(stock, 0);

        for (int i = 0; i < stock.size(); i++){
            total += stock.get(i).getCount() * stock.get(i).getPrice();
        }

        DecimalFormat f = new DecimalFormat("##.00");
        String actualValue = f.format(total);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void test3FortotalPrice10(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("milk", "bottle", 1.30));
        stock.add(new StockItems("apple", "single", 0.10));

        stock.get(0).increaseCount(1);
        stock.get(1).increaseCount(6);

        String expectedValue = "1.84";
        double total = 0;

        total -= DiscountPrice.totalDiscount(stock, 5);

        for (int i = 0; i < stock.size(); i++){
            total += stock.get(i).getCount() * stock.get(i).getPrice();
        }

        DecimalFormat f = new DecimalFormat("##.00");
        String actualValue = f.format(total);

        Assertions.assertEquals(expectedValue, actualValue);

    }
    @Test
    public void test4FortotalPrice11(){
        ArrayList<StockItems> stock = new ArrayList<>();
        stock.add(new StockItems("soup", "tin", 0.65));
        stock.add(new StockItems("bread", "loaf", 0.80));
        stock.add(new StockItems("apple", "single", 0.10));

        stock.get(0).increaseCount(2);
        stock.get(1).increaseCount(1);
        stock.get(2).increaseCount(3);

        String expectedValue = "1.97";
        double total = 0;

        total -= DiscountPrice.totalDiscount(stock, 5);

        for (int i = 0; i < stock.size(); i++){
            total += stock.get(i).getCount() * stock.get(i).getPrice();
        }

        DecimalFormat f = new DecimalFormat("##.00");
        String actualValue = f.format(total);

        Assertions.assertEquals(expectedValue, actualValue);

    }

    //total price with discount - days is included.
}
