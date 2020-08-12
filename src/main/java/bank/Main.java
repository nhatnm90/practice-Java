package bank;

import java.util.Calendar;

import static bank.AccountTemp.Period.Month;
import static bank.AccountTemp.Period.Week;

public class Main {
    public static void main(String[] args){

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 67);

        AccountTemp acc = new AccountTemp(246, "Hanh", "Nguyen", startDate, endDate, 50000, Month);

        System.out.println(acc.generateNumberOfExpiredDate());


    }

}
