package utils;
import bank.AccountHistory;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringFormat {

    public static String formatDate(Calendar date) {
        return generateDate(date, new SimpleDateFormat("dd-MM-yyyy"));
    }

    public static String formatDate(Calendar date, String pattern) {
        return generateDate(date, new SimpleDateFormat(pattern));
    }

    private static String generateDate(Calendar date, SimpleDateFormat format) {
        return format.format(date.getTime());
    }

    public static void dash(){
        System.out.println("----------------------------------------");
    }

    public static void dash(int length) {
        // TODO: 8/22/2020 add logic to print dash line with the length
    }

    public static void printSeparatedLine() {
        print(50, "-");
    }


    public static void printSeparatedLine(int length, String separatedChar) {
        print(length, separatedChar);
    }

    private static void print(int length, String separatedChar) {
        StringBuilder separatedLine = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            separatedLine.append(separatedChar);
        }
        System.out.println(separatedLine);
    }

    public static String formatCurrency(long amount) {
        return format(amount, new Locale("en", "US"));
    }

    public static String formatCurrency(double amount, String language, String country) {
        return format(amount, new Locale(language, country));
    }

    private static String format(double amount, Locale local) {
        return NumberFormat.getCurrencyInstance(local).format(amount);
    }
}



