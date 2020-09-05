package array;

import bank.Account;
import bank.AccountHistory;
import bank.ProcessServices;
import utils.StringFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static array.MainInteger.dash;
import static java.util.Comparator.comparing;
import static utils.StringFormat.*;

public class MainObject_Advance {
    public static void main(String[] args) {

        // Tạo các tài khoản
        Account accountHN = new Account(246, "Hanh", "Nguyen", Account.Period.Month);
        Account accountNH = new Account(211, "Nhat", "Nguyen", Account.Period.Month);
        Account accountTPM = new Account(111, "Trang PM", "Nguyen", Account.Period.Week);
        Account accountTD = new Account(222, "Thao", "Do", Account.Period.Week);
        Account accountCC = new Account(999, "Huong", "Cao", Account.Period.Year);
        Account accountDB = new Account(333, "Bùi", "Dũng", Account.Period.Quarter);

        // Tạo các lịch sử giao dịch cho từng tài khoản và set cho các tài khoản đó
        List<AccountHistory> accountHistoriesHN = new ArrayList<>();
        accountHistoriesHN.add(new AccountHistory(1900, AccountHistory.Type.in));
        accountHistoriesHN.add(new AccountHistory(3000, AccountHistory.Type.transferIn, accountNH.getAccountId()));
        accountHistoriesHN.add(new AccountHistory(40, AccountHistory.Type.transferIn, accountDB.getAccountId()));
        accountHistoriesHN.add(new AccountHistory(16, AccountHistory.Type.in));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesHN.add(new AccountHistory(24, AccountHistory.Type.in));
        accountHistoriesHN.add(new AccountHistory(11, AccountHistory.Type.out));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHN.setHistories(accountHistoriesHN);

        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<AccountHistory> accountHistoriesNH = new ArrayList<>();
        accountHistoriesNH.add(new AccountHistory(5, AccountHistory.Type.out));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesNH.add(new AccountHistory(69, AccountHistory.Type.transferOut, accountHN.getAccountId()));
        accountNH.setHistories(accountHistoriesNH);

        List<AccountHistory> accountHistoriesCC = new ArrayList<>();
        accountHistoriesCC.add(new AccountHistory(58, AccountHistory.Type.in));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesCC.add(new AccountHistory(14, AccountHistory.Type.out));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesCC.add(new AccountHistory(30, AccountHistory.Type.transferIn, accountDB.getAccountId()));
        accountHistoriesCC.add(new AccountHistory(45, AccountHistory.Type.out));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesCC.add(new AccountHistory(1700, AccountHistory.Type.in));
        accountCC.setHistories(accountHistoriesCC);

        List<AccountHistory> accountHistoriesDB = new ArrayList<>();
        accountHistoriesDB.add(new AccountHistory(5, AccountHistory.Type.in));
        accountHistoriesDB.add(new AccountHistory(10, AccountHistory.Type.out));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesDB.add(new AccountHistory(30, AccountHistory.Type.transferOut, accountCC.getAccountId()));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesDB.add(new AccountHistory(40, AccountHistory.Type.transferOut, accountHN.getAccountId()));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountHistoriesDB.add(new AccountHistory(300, AccountHistory.Type.in));
        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDB.setHistories(accountHistoriesDB);

        // Tạo 1 danh sách tài khoản và thêm các tài khoản đã tạo vào
        List<Account> listAccount = new ArrayList<>();
        listAccount.add(accountHN);
        listAccount.add(accountNH);
        listAccount.add(accountTPM);
        listAccount.add(accountTD);
        listAccount.add(accountCC);
        listAccount.add(accountDB);

        // Tạo 1 đối tượng xử lý tài khoản và truyền danh sách tài khoản vào constructor parameters
        ProcessServices processServices = new ProcessServices(listAccount);

        // * Câu 1: Xuất ra màn hình số lượng tài khoản đang có trong hệ thống
        System.out.println("Câu 1: Số luong tai khoản = " + listAccount.size());
        printSeparatedLine(60, "~");

        //Câu 2: Xuất ra màn hình DANH SÁCH chỉ có HỌ và TÊN của các tài
        System.out.println("Câu 2: ");
        for (int i = 0; i < listAccount.size(); i++) {
            String fullName = listAccount.get(i).getFullName();
            System.out.println(+i + 1 + "/ " + "Full Name: " + fullName);
        }
        printSeparatedLine(60, "~");

        //* Câu 3: Xuất ra màn hình SỐ LƯỢNG tài khoản đang chọn kì hạn là tuần, tháng, quý
        int periodWeek = 0;
        for (Account element : listAccount) {
            if (element.getPeriod() != Account.Period.Year) {
                periodWeek++;
            }
        }
        System.out.println("Câu 3: SỐ LƯỢNG tài khoản đang chọn kì hạn là tuần, tháng, quý = " + periodWeek);
        printSeparatedLine(60, "~");

        //* Câu 4: Xuất ra màn hình SỐ LƯỢNG tài khoản đang chọn kì hạn là tháng mà có họ là "Nguyen"
        List<Account> cau4 = listAccount.stream().filter(account -> account.getPeriod() == Account.Period.Month
                && account.getLastName() == "Nguyen").collect(Collectors.toList());
        System.out.println("Câu 4: SỐ LƯỢNG tài khoản đang chọn kì hạn là tháng mà có họ là Nguyen = " + cau4.size());
        printSeparatedLine(60, "~");

        //* Câu 5: Xuất ra màn hình DANH SÁCH chỉ có HỌ và TÊN các tài khoản có TÊN dài 4 chữ cái ("Hanh" -> 4, "Huong" -> 5)
        List<Account> cau5 = listAccount.stream().filter(account -> account.getFirstName().length() == 4).collect(Collectors.toList());
        System.out.println("Câu 5: HỌ và TÊN các tài khoản có TÊN dài 4 chữ cái: ");
        int number = 1;
        for (Account element : cau5) {
            String fullNameCau5 = element.getFullName();
            System.out.println(number + "/ " + fullNameCau5);
            number++;
        }
        printSeparatedLine(60, "~");


        //* Câu 6: Xuất ra màn hình DANH SÁCH TẤT CẢ tài khoản đang có trong hệ thống (bao thông tin tài khoản và cả thông tin lịch sử giao dịch)
        System.out.println("Câu 6: ");
        for (Account element : listAccount) {
            showInfo(element);
        }
        printSeparatedLine(60, "~");

        //* Câu 7: Xuất ra màn hình SỐ LƯỢNG tài khoản đang có trong hệ thống mà chưa thực hiện bất kì giao dịch nào
        int noOfNoTransactionAcc = 0;
        for (Account element : listAccount) {
            if (element.getHistories().size() == 0) {
                noOfNoTransactionAcc++;
            }
        }
        System.out.println("Câu 7: SỐ LƯỢNG tài khoản đang có trong hệ thống mà chưa thực hiện bất kì giao dịch nào = " + noOfNoTransactionAcc);
        printSeparatedLine(60, "~");

        //* Câu 8: Xuất ra màn hình thông tin tài khoản có nhiều giao dịch nhất
        Collections.sort(listAccount, comparing(Account::getNumberOfHistory).reversed());
        Account cau8a = listAccount.get(0);

        System.out.println("Câu 8a: tài khoản có nhiều giao dịch nhất: ");
        showInfo(cau8a);


        int numberOfTransaction = 0;
        Account cau8 = new Account();
        for (Account element : listAccount) {
            if (element.getHistories().size() > numberOfTransaction) {
                numberOfTransaction = element.getHistories().size();
                cau8 = element;
            }

        }
        System.out.println("Câu 8: tài khoản có nhiều giao dịch nhất: ");
        showInfo(cau8);

        printSeparatedLine(60, "~");

        //Câu 9: Xuất ra màn hình thông tin tài khoản có nhiều giao dịch nhận tiền vào nhất
        System.out.println("Câu 9: tài khoản có nhiều giao dịch nhận tiền vào nhất: ");
        Collections.sort(listAccount, comparing(Account::getTotalTransferIn).reversed());
        Account cau9 = listAccount.get(0);
        showInfo(cau9, AccountHistory.Type.transferIn);

        printSeparatedLine(60, "~");

        // Câu 10
        System.out.println("Câu 10: ");
        Collections.sort(listAccount, comparing(Account::getNumberOfHistory).reversed());
        Account cau10 = listAccount.get(0);
        cau10.setCurrentBalance(cau10.reCalculateBalance());
        System.out.println("Tổng tiền tài khoản có nhiều giao dịch nhất = " + cau10.getCurrentBalance());

        printSeparatedLine(60, "~");

        // Câu 11
        System.out.println("Câu 11: ");
        for (Account element : listAccount) {
            element.setCurrentBalance(element.reCalculateBalance());
            showInfoBasic(element);
        }
        printSeparatedLine(60, "~");

        // Câu 12
        System.out.println("Câu 12: ");
        for (Account element : listAccount) {
            showInfo(element, element.getHistories());
        }
        printSeparatedLine(60, "~");

        // Câu 13
        System.out.println("Câu 13: ");
        int numberOfTotalTransactions = 0;
        for (Account element : listAccount) {
            numberOfTotalTransactions += element.getHistories().size();
        }
        System.out.println("Tổng số giao dịch của hệ thống là: " + numberOfTotalTransactions);
        printSeparatedLine(60, "~");

        // Câu 14:
        System.out.println("Câu 14: ");
        List<AccountHistory> typeInList = new ArrayList<>();
        for (Account element : listAccount) {
            List<AccountHistory> listAccountHistory = element.getAccountByType(AccountHistory.Type.in);
            for (AccountHistory accountHistory : listAccountHistory) {
                accountHistory.fullName = element.getFullName();
                typeInList.add(accountHistory);
            }
        }
        Collections.sort(typeInList, comparing(AccountHistory::getCreatedDate).reversed());
        for (AccountHistory element : typeInList) {
            element.showInfoWithoutType();
        }
        printSeparatedLine(60, "~");

        // Câu 15:
        System.out.println("Câu 15: ");
        long totalInBalance = 0;
        for (AccountHistory element : typeInList) {
            totalInBalance += element.getBalance();
        }
        System.out.println("TỔNG số tiền đã được NẠP VÀO hệ thống = " + totalInBalance);
        printSeparatedLine(60, "~");

        // Câu 16:
        System.out.println("Câu 16: ");
        long totalOutBalance = 0;
        for (Account element : listAccount) {
            List<AccountHistory> cau16 = element.getAccountByType(AccountHistory.Type.out);
            for (AccountHistory balance : cau16) {
                totalOutBalance += balance.getBalance();
            }

        }
        System.out.println("TỔNG số tiền đã được RÚT RA khỏi hệ thống = " + totalOutBalance);
        printSeparatedLine(60, "~");

        //   Câu 17:
        System.out.println("Câu 17: ");
        List<AccountHistory> topMaxBalance = new ArrayList<>();
        for (Account element : listAccount) {
            for (AccountHistory history : element.getHistories()) {
                if (history.getType() == AccountHistory.Type.transferIn) {
                    history.fullName = element.getNameById(listAccount, history.getDestinationAccountId());
                } else {
                    history.fullName = element.getFullName();
                }
                topMaxBalance.add(history);
            }
        }
        Collections.sort(topMaxBalance, comparing(AccountHistory::getBalance).reversed());
        topMaxBalance = getListHistoryByNumber(topMaxBalance, 3);
        for (AccountHistory element : topMaxBalance) {
            element.showInfoWithoutType();
        }
        printSeparatedLine(60, "~");

        //   Câu 18:
        System.out.println("Câu 18: ");
        List<AccountHistory> topMinBalance = new ArrayList<>();
        for (Account element : listAccount) {
            List<AccountHistory> typeIn = element.getAccountByType(AccountHistory.Type.in);
            for (AccountHistory history : typeIn) {
                if (history.getType() == AccountHistory.Type.transferIn) {
                    history.fullName = element.getNameById(listAccount, history.getDestinationAccountId());
                } else {
                    history.fullName = element.getFullName();
                }
            }
            topMinBalance.addAll(typeIn);
        }
        Collections.sort(topMinBalance, comparing(AccountHistory::getBalance));
        topMinBalance = getListHistoryByNumber(topMinBalance, 3);
        for (AccountHistory history : topMinBalance) {
            history.showInfoWithoutType();
        }
        printSeparatedLine(60, "~");

        // Câu 19:
        System.out.println("Câu 19: ");
        List<Account> abc = getListElementByNumber(listAccount, 5);
        System.out.println(abc);
        System.out.println(listAccount);
        printSeparatedLine(60, "~");

        //  Câu 20:
        System.out.println("Câu 20: ");
        for (Account account : listAccount) {
            List<AccountHistory> accountHistoryList = account.getHistories();
            Collections.sort(account.getHistories(), comparing(AccountHistory::getBalance).reversed());
            System.out.println("Họ tên: " + account.getFullName());
            if (accountHistoryList.size() > 0) {
                accountHistoryList.get(0).showInfo();
            } else {
                System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");
            }
        }
        //======================================================================
        for (Account account : listAccount) {
            List<AccountHistory> accountHistoryList = account.getHistories();
            Collections.sort(account.getHistories(), comparing(AccountHistory::getBalance).reversed());
            account.getHistories().get(0).showInfo();
            if (account.getHistories().size() == 0) {
                System.out.println("Họ tên: " + account.getFullName());
                System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");
            } else {
                System.out.println("Họ tên: " + account.getFullName());
                System.out.println("Giao dịch lớn nhất:");
                System.out.println("Ngày tạo: " + formatDate(account.getHistories().get(0).getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
                System.out.println("Số tiền: " + formatCurrency(account.getHistories().get(0).getBalance()));
                System.out.println("Loại giao dịch: " + account.getHistories().get(0).translatedType());
            }
            if (listAccount.indexOf(account) == listAccount.size() - 1) {
                printSeparatedLine(50, "=");
            } else {
                dash();
            }
        }
        printSeparatedLine(60, "~");


        //  Câu 21:
        System.out.println("Câu 21: ");
        List<Account> periodByWeek = new ArrayList<>();
        List<Account> periodByMonth = new ArrayList<>();
        List<Account> periodByQuarter = new ArrayList<>();
        List<Account> periodByYear = new ArrayList<>();
        for (Account account : listAccount) {
            switch (account.getPeriod()) {
                case Week:
                    periodByWeek.add(account);
                    break;
                case Month:
                    periodByMonth.add(account);
                    break;
                case Quarter:
                    periodByQuarter.add(account);
                    break;
                case Year:
                    periodByYear.add(account);
                    break;
            }
        }
        System.out.println("Thống kê số lượng tài khoản theo loại kì hạn: ");
        System.out.println("Tuần: \t" + periodByWeek.size() + " tài khoản");
        System.out.println("Tháng: \t" + periodByMonth.size() + " tài khoản");
        System.out.println("Quý: \t" + periodByQuarter.size() + " tài khoản");
        System.out.println("Năm: \t" + periodByYear.size() + " tài khoản");
        printSeparatedLine(60, "~");

        // Câu 22:
        System.out.println("Câu 22: ");
        int noOfAccByWeek = 0;
        int noOfAccByMonth = 0;
        int noOfAccByQuarter = 0;
        int noOfAccByYear = 0;

        for (Account account : listAccount) {
            if (account.getHistories().size() != 0) {
                switch (account.getPeriod()) {
                    case Week:
                        noOfAccByWeek++;
                        break;
                    case Month:
                        noOfAccByMonth++;
                        break;
                    case Quarter:
                        noOfAccByQuarter++;
                        break;
                    case Year:
                        noOfAccByYear++;
                        break;
                }
            }
        }
        System.out.println("Thống kê số lượng giao dịch đã thực hiện theo loại kì hạn: ");
        System.out.println("Tuần: \t" + noOfAccByWeek + " tài khoản");
        System.out.println("Tháng: \t" + noOfAccByMonth + " tài khoản");
        System.out.println("Quý: \t" + noOfAccByQuarter + " tài khoản");
        System.out.println("Năm: \t" + noOfAccByYear + " tài khoản");
        printSeparatedLine(60, "~");

        //  Câu 23:
        System.out.println("Câu 23:  ");
        for (Account account : periodByWeek) {
            System.out.println("Thống kê số lượng giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Tuần: ");
            account.summarizeNumberOfTransaction(periodByWeek);
            System.out.println("Thống kê số lượng giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Tháng: ");
            account.summarizeNumberOfTransaction(periodByMonth);
            System.out.println("Thống kê số lượng giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Quý: ");
            account.summarizeNumberOfTransaction(periodByQuarter);
            System.out.println("Thống kê số lượng giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Năm: ");
            account.summarizeNumberOfTransaction(periodByYear);
            break;
        }
        printSeparatedLine(60, "~");

        //  Câu 24:
        System.out.println("Câu 24:");
        for (Account account : periodByWeek) {
            System.out.println("Thống kê số lượng tiền của giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Tuần: ");
            account.summarizeNumberOfTransactionByBalance(periodByWeek);
            System.out.println("Thống kê số lượng tiền của giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Tháng: ");
            account.summarizeNumberOfTransactionByBalance(periodByMonth);
            System.out.println("Thống kê số lượng tiền của giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Quý: ");
            account.summarizeNumberOfTransactionByBalance(periodByQuarter);
            System.out.println("Thống kê số lượng tiền của giao dịch đã thực hiện theo từng loại giao dịch có kì hạn Năm: ");
            account.summarizeNumberOfTransactionByBalance(periodByYear);
            break;
        }
        printSeparatedLine(60, "~");

        //  Câu 25:
        System.out.println("Câu 25:");
        List<Account> listTransferOutBalance = new ArrayList<>();
//        List<AccountHistory> listTransferOut = new ArrayList<>();
        for (Account account : listAccount) {
            List<AccountHistory> listTransferOut = account.getAccountByType(AccountHistory.Type.transferOut);
            long totalBalance = 0;
            for (AccountHistory history : listTransferOut) {
                totalBalance += history.getBalance();
                account.setTotalBalance(totalBalance);

            }
            listTransferOutBalance.add(account);
        }
        Collections.sort(listTransferOutBalance, comparing(Account::getTotalBalance).reversed());
        listTransferOutBalance.get(0).showInfo();
        System.out.println(listTransferOutBalance.get(0).getTotalBalance());


        Account accountTemp = null;
        long totalBalanceTransferOutTemp = 0;
        for (Account account : listAccount) {
            long totalBalanceTransferOut = account.getTotalBalanceByType(AccountHistory.Type.transferOut);
            if (totalBalanceTransferOut > totalBalanceTransferOutTemp) {
                accountTemp = account;
                totalBalanceTransferOutTemp = totalBalanceTransferOut;
            }
        }
        accountTemp.showInfo();
        System.out.println(totalBalanceTransferOutTemp);
    }


    //<editor-fold desc="Private functions">

    private static List<Account> getListElementByNumber(List<Account> listAccount, int numberOfGetting) {
        if (numberOfGetting > listAccount.size()) {
            return listAccount;
        } else {
            List<Account> listElementByNumber = new ArrayList<>();
            for (int i = 0; i < numberOfGetting; i++) {
                listElementByNumber.add(listAccount.get(i));
            }
            return listElementByNumber;
        }
    }

    private static List<AccountHistory> getListHistoryByNumber(List<AccountHistory> listAccount, int numberOfGetting) {
        if (numberOfGetting > listAccount.size()) {
            return listAccount;
        } else {
            List<AccountHistory> listHistoryByNumber = new ArrayList<>();
            for (int i = 0; i < numberOfGetting; i++) {
                listHistoryByNumber.add(listAccount.get(i));
            }
            return listHistoryByNumber;
        }
    }

    private static void showInfoBasic(Account account) {
        printSeparatedLine(50, "=");
        System.out.println("Họ tên: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Ngày tạo: " + formatDate(account.getCreatedDate()));
        System.out.println("Số tiền: " + formatCurrency(account.getCurrentBalance()));
        System.out.println("Loại kỳ hạn: " + account.getPeriod());
    }

    private static void showInfoWithTop1Balance(List<Account> account) {
        printSeparatedLine(50, "=");
        for (Account element : account) {
            if (element.getHistories().size() == 0) {
                System.out.println("Họ tên: " + element.getFullName());
                System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");

            } else {
                System.out.println("Họ tên: " + element.getFullName());
                System.out.println("Giao dịch lớn nhất:");
                System.out.println("Ngày tạo: " + formatDate(element.getHistories().get(0).getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
                System.out.println("Số tiền: " + formatCurrency(element.getHistories().get(0).getBalance()));
                System.out.println("Loại giao dịch: " + element.getHistories().get(0).translatedType());
            }
            if (account.indexOf(element) == account.size() - 1) {
                printSeparatedLine(50, "=");
            } else {
                dash();
            }
        }
    }

    public static void showInfoWithHighestBalance(List<AccountHistory> history) {
        for (AccountHistory element : history) {
            if (history.size() == 0) {
                System.out.println("Họ tên: " + element.fullName);
                System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");
            } else {
                System.out.println("Họ Tên: " + element.fullName);
                System.out.println("Giao dịch lớn nhất:: ");
                System.out.println("- Ngày tạo: " + formatDate(element.getCreatedDate()));
                System.out.println("- Số tiền: " + formatCurrency(element.getBalance()));
                System.out.println("- Loại giao dịch: " + element.translatedType());
                StringFormat.printSeparatedLine();
            }
        }
    }


    private static void showInfo(Account account, AccountHistory.Type type) {
        List<AccountHistory> listAccountHistory = account.getHistories().stream().filter(transferIn ->
                transferIn.getType() == type).collect(Collectors.toList());
        showInfo(account, listAccountHistory);
    }

    private static void showInfoAndTopBalance(List<Account> account, int numberOfTopHistories) {
        printSeparatedLine(50, "=");
        if (numberOfTopHistories == 0) {
            System.out.println("Invalid Number Of Top History");
            return;
        }
        for (Account element : account) {
            if (element.getHistories().size() == 0) {
                System.out.println("Họ tên: " + element.getFullName());
                System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");
                dash();
            } else {
                System.out.println("Họ tên: " + element.getFullName());
                for (int i = 0; i < numberOfTopHistories; i++) {
                    if (i < element.getHistories().size()) {
                        System.out.println("Giao dịch lớn " + (i + 1) + ":");
                        System.out.println("Ngày tạo: " + formatDate(element.getHistories().get(i).getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
                        System.out.println("Số tiền: " + formatCurrency(element.getHistories().get(i).getBalance()));
                        System.out.println("Loại giao dịch: " + element.getHistories().get(i).translatedType());
                        if (account.indexOf(element) < account.size() - 1) {
                            dash();
                        } else {
                            printSeparatedLine(50, "=");
                        }
                    } else {
                        break;
                    }

                }
            }
        }
    }


    private static void showInfo(Account account) {
        showInfo(account, account.getHistories());
    }

    private static void showInfo(Account account, List<AccountHistory> listAccountHistory) {
        printSeparatedLine(50, "=");
        System.out.println("Ho ten: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Ngay tao: " + formatDate(account.getCreatedDate()));
        System.out.println("Số tiền: " + formatCurrency(account.getCurrentBalance()));
        System.out.println("Loại kỳ hạn: " + account.getPeriod());
        System.out.println("Lịch sử giao dịch: ");
        if (account.getHistories().size() == 0) {
            System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");
            return;
        }
        printSeparatedLine(50, "*");
        for (AccountHistory history : listAccountHistory) {
            System.out.println("Ngày tạo: " + formatDate(history.getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
            System.out.println("Số tiền: " + formatCurrency(history.getBalance()));
            System.out.println("Loại giao dịch: " + history.translatedType());
            if (history.getType() == AccountHistory.Type.transferIn) {
                System.out.println("Người gửi: " + history.getDestinationAccountId());
            }
            if (history.getType() == AccountHistory.Type.transferOut) {
                System.out.println("Người nhận: " + history.getSourceAccountId());
            }
            if (listAccountHistory.indexOf(history) < listAccountHistory.size() - 1) {
                dash();
            }

        }
    }
    //</editor-fold>
}


/*
 * Câu 1: Xuất ra màn hình số lượng tài khoản đang có trong hệ thống
 *
 * Câu 2: Xuất ra màn hình DANH SÁCH chỉ có HỌ và TÊN của các tài khoản
 *
 * Câu 3: Xuất ra màn hình SỐ LƯỢNG tài khoản đang chọn kì hạn là tuần, tháng, quý
 *
 * Câu 4: Xuất ra màn hình SỐ LƯỢNG tài khoản đang chọn kì hạn là tháng mà có họ là "Nguyen"
 *
 * Câu 5: Xuất ra màn hình DANH SÁCH chỉ có HỌ và TÊN các tài khoản có TÊN dài 4 chữ cái ("Hanh" -> 4, "Huong" -> 5)
 *
 * Câu 6: Xuất ra màn hình DANH SÁCH TẤT CẢ tài khoản đang có trong hệ thống (bao thông tin tài khoản và cả thông tin lịch sử giao dịch)
 * ===============================================
 * Họ tên:
 * Ngày tạo: ngày/tháng/năm
 * Số tiền:
 * Loại kỳ hạn:
 * Lịch sử giao dịch:
 * -----------------------------------------------
 * Ngày tạo: ngày-tháng-năm giờ:phút:giây
 * Số tiền:
 * Loại giao dịch:
 * -----------------------------------------------
 * Ngày tạo: ngày-tháng-năm giờ:phút:giây
 * Số tiền:
 * Loại giao dịch:
 * ===============================================
 * Họ tên:
 * Ngày tạo: ngày/tháng/năm
 * Số tiền:
 * Loại kỳ hạn:
 * Lịch sử giao dịch:
 * Tài khoản chưa thực hiện bất kì giao dịch nào
 * ===============================================
 *
 * Câu 7: Xuất ra màn hình SỐ LƯỢNG tài khoản đang có trong hệ thống mà chưa thực hiện bất kì giao dịch nào
 *
 * Câu 8: Xuất ra màn hình thông tin tài khoản có nhiều giao dịch nhất
 * ===============================================
 * Họ tên:
 * Ngày tạo: ngày/tháng/năm
 * Số tiền:
 * Loại kỳ hạn:
 * Lịch sử giao dịch:
 * -----------------------------------------------
 * Ngày tạo: ngày-tháng-năm giờ:phút:giây
 * Số tiền:
 * Loại giao dịch:
 * -----------------------------------------------
 * Ngày tạo: ngày-tháng-năm giờ:phút:giây
 * Số tiền:
 * Loại giao dịch:
 * ===============================================
 *
 * Câu 9: Xuất ra màn hình thông tin tài khoản có nhiều giao dịch nhận tiền vào nhất
 * LƯU Ý: ở phần thông tin giao dịch chỉ in ra những thông tin về giao dịch nhận tiền thôi nhé
 * ===============================================
 * Họ tên:
 * Ngày tạo: ngày/tháng/năm
 * Số tiền:
 * Loại kỳ hạn:
 * Lịch sử giao dịch:
 * -----------------------------------------------
 * Ngày tạo: ngày-tháng-năm giờ:phút:giây
 * Số tiền:
 * Loại giao dịch:
 * -----------------------------------------------
 * Ngày tạo: ngày-tháng-năm giờ:phút:giây
 * Số tiền:
 * Loại giao dịch:
 * ===============================================
 *
 *  Câu 10: Bởi 1 thao tác sai, nhân viên IT đã làm sai số về số tiền hiện có của tài khoản có nhiều giao dịch nhất.
 *  Vui lòng giúp nhân viên tội nghiệp này tính lại số tiền của tài khoản đó dựa trên các lịch sử giao dịch đã có và
 *  xuất ra màn hình số tiền đó
 *  *Biết số tiền lúc đầu của mọi tài khoản là $100
 *
 *  Câu 11: Lại là 1 thao tác sai lần, kì này nhân viên là mất hết sồ tiền của tất cả tài khoản luôn.
 *  Vui lòng giúp phục hồi số tiền hiện có cho tất cả tài khoản đang có. Và gán lại cho danh sách đó.
 *  Sau đó in tất cả ra màn hình.
 *  *Biết số tiền lúc đầu của mọi tài khoản là $100
 *
 *  Câu 12: Hiển thị thông tin các tài khoản và lịch sử giao dịch của tài khoản đó theo mẫu dưới đây
 *   Lưu ý: các dấu ngăn cách giữa cách tài khoản và lịch sử giao dịch nên đc hiển thị đúng chính xác theo ví dụ
 *   Ví dụ:
 *   ===============================================
 *   Họ tên: Hanh Nguyen
 *   Ngày tạo: 24-06-2020
 *   Số tiền: $150
 *   Loại kỳ hạn: Tháng
 *   Lịch sử giao dịch:
 *   ************************************************
 *   Ngày tạo: 25-06-2020 16:16:16
 *   Số tiền: $50
 *   Loại giao dịch: Nạp tiền
 *   -----------------------------------------------
 *   Ngày tạo: 25-06-2020 16:16:10
 *   Số tiền: $50
 *   Loại giao dịch: Nhận tiền
 *   Người gửi: Nhat Nguyen
 *   -----------------------------------------------
 *   Ngày tạo: 25-06-2020 16:16:01
 *   Số tiền: $10
 *   Loại giao dịch: Chuyển tiền
 *   Người nhận: Huong Cao
 *   ================================================
 *   Họ tên: Trang PM Nguyen
 *   Ngày tạo: 24-06-2020
 *   Số tiền: $100
 *   Loại kỳ hạn: Năm
 *   Lịch sử giao dịch: Tài khoản chưa thực hiện giao dịch
 *   ================================================
 *   ... (còn lại)
 *
 *   Câu 13: Xuất ra màn hình TỔNG số lượng các giao dịch đã được thực hiện của tất cả các tài khoản
 *   VD: Hệ thống có 2 tài khoản thôi
 *   - Tài khoản Hạnh Nguyễn: 10 giao dịch (dựa vào lịch sử giao dịch)
 *   - Tài khoản Nhật Nguyễn: 7 giao dịch (dựa vào lịch sử giao dịch)
 *   -> Tổng số giao dịch của cả hệ thống là 17
 *
 *   Câu 14: Xuất ra màn hình tất cả các thông tin giao dịch là loại là  NẠP TIỀN (in) của tất cả các tài khoản đang có
 *   và sắp xếp theo thứ tự ngày giao dịch giảm dần (latest -> oldest) theo mẫu dưới đây
 *   -----------------------------------------------
 *   Ngày tạo: 26-06-2020 10:58:10
 *   Số tiền: $50
 *   Người nạp: Hanh Nguyen
 *  -----------------------------------------------
 *   Ngày tạo: 25-06-2020 16:16:10
 *   Số tiền: $50
 *   Người nạp: Hanh Nguyen
 *  -----------------------------------------------
 *   Ngày tạo: 24-06-2020 16:00:10
 *   Số tiền: $50
 *   Người nạp: Trang PM Nguyen
 *  -----------------------------------------------
 *
 *   Câu 15: Xuất ra màn hình TỔNG số tiền đã được NẠP VÀO hệ thống
 *
 *   Câu 16: Xuất ra màn hình TỔNG số tiền đã được RÚT RA khỏi hệ thống
 *
 *   Câu 17: Xuất ra màn hình TOP 3 giao dịch có số tiền LỚN nhất trong hệ thống (không phân biệt loại giao dịch)
 *   Ví dụ:
 *  -----------------------------------------------
 *   Ngày tạo: 26-06-2020 10:58:10
 *   Số tiền: $10000
 *   Người tạo: Hanh Nguyen
 *  -----------------------------------------------
 *   Ngày tạo: 25-06-2020 16:16:10
 *   Số tiền: $4999
 *   Người nạp: Hanh Nguyen
 *  -----------------------------------------------
 *   Ngày tạo: 24-06-2020 16:00:10
 *   Số tiền: $3000
 *   Người nạp: Trang PM Nguyen
 *  -----------------------------------------------
 *
 *   Câu 18: Xuất ra màn hình TOP 3 giao dịch có số tiền NHỎ nhất trong hệ thống (chỉ tính giao dịch nạp tiền)
 *   Ví dụ:
 *   -----------------------------------------------
 *   Ngày tạo: 26-06-2020 10:58:10
 *   Số tiền: $10
 *   Người tạo: Hanh Nguyen
 *   -----------------------------------------------
 *   Ngày tạo: 25-06-2020 16:16:10
 *   Số tiền: $23
 *   Người nạp: Hanh Nguyen
 *   -----------------------------------------------
 *   Ngày tạo: 24-06-2020 16:00:10
 *   Số tiền: $40
 *   Người nạp: Trang PM Nguyen
 *  -----------------------------------------------
 *
 *   Câu 19: Viết 1 hàm (function) dùng để lấy số lượng phần tử (element) cần thiết trong 1 mảng cho trước (array)
 *   Ví dụ phần khai báo hàm, phần cần viết là phần thân hàm
 *   private List<Account> getListElementByNumber(List<Account> listAccount, int numberOfGetting) {
 *       //todo: implement the logic to get elements
 *       //notes: check the condition before as comparing numberOfGetting with the size of list etc
 *   }
 *
 *   Câu 20: Xuất ra màn hình danh sách các tài khoản và giao dịch có số tiền lớn nhất đc thực hiện bởi tài khoản đó
 *   Ví dụ:
 *   ===============================================
 *   Họ tên: Hanh Nguyen
 *   Giao dịch lớn nhất:
 *       Ngày tạo: 25-06-2020 16:16:16
 *       Số tiền: $9000
 *       Loại giao dịch: Nạp tiền
 *   -----------------------------------------------
 *   Họ tên: Nhat Nguyen
 *   Giao dịch lớn nhất:
 *       Ngày tạo: 25-06-2020 14:24:24
 *       Số tiền: $900
 *       Loại giao dịch: Rút tiền
 *   ================================================
 *   ...
 *
 *  Câu 21: Thống kê số lượng tài khoản theo loại kì hạn.
 *  Ví dụ:
 *  Tuần: ? (? là số lượng tài khoản đang chọn kì hạn là Tuần)
 *  Tháng: ?
 *  Quý: ?
 *  Năm: ?
 *
 *  Câu 22: Thống kê số lượng giao dịch đã thực hiện theo loại kì hạn mà tài khoản đã chọn.
 *  Ví dụ:
 *  Tuần: ? (? là số lượng tài khoản giao dịch đã thực hiện có loại kì hạn là Tuần)
 *  Tháng: ?
 *  Quý: ?
 *  Năm: ?
 *
 *  Câu 23: Thống kê số lượng giao dịch đã thực hiện theo từng loại giao dịch và theo từng loại kì hạn mà tài khoản đã chọn.
 *  Ví dụ:
 *  Tuần:
 *      + Nạp tiền: ? (? là số giao dịch loại nạp tiền mà đã đc thực hiện của tài khoản mà chọn loại kì hạn là tuần)
 *      + Rút tiền: ?
 *      + Chuyển tiền: ?
 *      + Nhận tiền: ?
 *  Tháng:
 *      +...
 *  Quý:
 *      +...
 *  Năm:
 *      +...
 *
 *  Câu 24: Thống kê số lượng tiền của giao dịch đã thực hiện theo từng loại giao dịch và theo từng loại kì hạn mà tài khoản đã chọn.
 *  Ví dụ:
 *  Tuần:
 *      + Nạp tiền: ? (? là số tiền đã được nạp của tài khoản mà chọn loại kì hạn là tuần)
 *      + Rút tiền: ?
 *      + Chuyển tiền: ?
 *      + Nhận tiền: ?
 *  Tháng:
 *  Quý:
 *  Năm:
 *
 *  Câu 25: Tìm tài khoản đã thực hiện chuyển tiền nhiều nhất.
 */


