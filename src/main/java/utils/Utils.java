package utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utils {

    public static void Sleep(double second) {
        try {
            Thread.sleep((int)(second * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



