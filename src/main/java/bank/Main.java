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


//        Account account1 = new Account(124, "Hanh", "Nguyen");
//        account1.showInfo();
//
//        account1.addMoney(200000);
//        System.out.println(account1.getCurrentBalance());
//        account1.subMoney(200000);
//        System.out.println(account1.getCurrentBalance());
//
//        Account acc2 = new Account(Account.Period.Week);
//        System.out.println(acc2.getRate());
//
//        acc2.recalculatedBalance();
//        System.out.println(acc2.getCurrentBalance());

        
    }



}
