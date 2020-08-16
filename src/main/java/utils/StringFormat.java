package utils;
import bank.AccountHistory;

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
}



