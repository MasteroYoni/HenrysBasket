package com.HenrysShop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DiscountPrice {
    public static double totalDiscount(ArrayList<StockItems> stock, int NoDBP){
        double total = 0;
        if (NoDBP >= -1 && NoDBP <= 7){
            total += BreadDiscount(stock);
        }
        Date nowdate = new Date();
        Date nextDate = getNextDate(nowdate);
        int numberofdays = (int) ((nextDate.getTime() - nowdate.getTime()) / (24 * 60 * 60 * 1000));
        numberofdays -= 1;
        if (NoDBP >= 3 && NoDBP <= numberofdays){
            total += appleDiscount(stock);
        }
        return total;
    }
    public static double BreadDiscount(ArrayList<StockItems> stock) {
        int tinCount = 0;
        int breadCount = 0;
        double total = 0;
        double breadPrice = 0;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals("soup") && stock.get(i).getUnit().equals("tin") && stock.get(i).getCount() >= 2) {
                tinCount = stock.get(i).getCount();
            }
            if (stock.get(i).getName().equals("bread") && stock.get(i).getUnit().equals("loaf")) {
                breadCount = stock.get(i).getCount();
                breadPrice = stock.get(i).getPrice();
            }
        }
        while (tinCount >= 2 && breadCount > 0) {
            total += (breadPrice / 2);
            breadCount -= 1;
            tinCount -= 2;
        }
        return total;

    }
    public static double appleDiscount(ArrayList<StockItems> stock) {
        int appleCount = 0;
        double applePrice = 0.00;
        double total = 0.00;

        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getName().equals("apple") && stock.get(i).getUnit().equals("single")) {
                appleCount = stock.get(i).getCount();
                applePrice = stock.get(i).getPrice();
            }
        }
        total += (applePrice * 0.1) * appleCount;
        return total;
    }

    private static Date getNextDate(Date nowDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, c.getMaximum(Calendar.DATE));
        return c.getTime();
    }
}
