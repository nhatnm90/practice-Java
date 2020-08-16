package bank;

import java.time.temporal.WeekFields;
import java.util.Calendar;

public class Main {
    private static Object Month;

    public static void main(String[] args){
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 49);

        Account acc12 = new Account(246, "Hanh", "Nguyen", startDate, endDate, 50000, Account.Period.Month);
        acc12.calculateCurrentBalance();

        acc12.addMoney(10000);
        acc12.addMoney(20000);
        acc12.subMoney(5000);
        acc12.showInfo();

    }



}
