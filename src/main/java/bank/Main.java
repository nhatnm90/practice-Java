package bank;

import java.util.Calendar;

import static bank.AccountHistory.Period.Month;

public class Main {
    public static void main(String[] args){

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 67);

        AccountHistory acc = new AccountHistory(246, "Hanh", "Nguyen", startDate, endDate, 50000, Month);

        System.out.println(acc.generateNumberOfExpiredDate());


    }

}
