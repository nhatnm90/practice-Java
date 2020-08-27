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
        accountHistoriesHN.add(new AccountHistory(69, AccountHistory.Type.transferIn, accountNH.getAccountId()));
        accountHistoriesHN.add(new AccountHistory(40, AccountHistory.Type.transferIn, accountDB.getAccountId()));
        accountHistoriesHN.add(new AccountHistory(16, AccountHistory.Type.in));
        accountHistoriesHN.add(new AccountHistory(24, AccountHistory.Type.in));
        accountHistoriesHN.add(new AccountHistory(11, AccountHistory.Type.out));
        accountHN.setHistories(accountHistoriesHN);

        List<AccountHistory> accountHistoriesNH = new ArrayList<>();
        accountHistoriesNH.add(new AccountHistory(5, AccountHistory.Type.out));
        accountHistoriesNH.add(new AccountHistory(69, AccountHistory.Type.transferOut, accountHN.getAccountId()));
        accountNH.setHistories(accountHistoriesNH);

        List<AccountHistory> accountHistoriesCC = new ArrayList<>();
        accountHistoriesCC.add(new AccountHistory(58, AccountHistory.Type.in));
        accountHistoriesCC.add(new AccountHistory(14, AccountHistory.Type.out));
        accountHistoriesCC.add(new AccountHistory(30, AccountHistory.Type.transferIn, accountDB.getAccountId()));
        accountHistoriesCC.add(new AccountHistory(45, AccountHistory.Type.out));
        accountHistoriesCC.add(new AccountHistory(1700, AccountHistory.Type.in));
        accountCC.setHistories(accountHistoriesCC);

        List<AccountHistory> accountHistoriesDB = new ArrayList<>();
        accountHistoriesDB.add(new AccountHistory(50, AccountHistory.Type.in));
        accountHistoriesDB.add(new AccountHistory(10, AccountHistory.Type.out));
        accountHistoriesDB.add(new AccountHistory(30, AccountHistory.Type.transferOut, accountCC.getAccountId()));
        accountHistoriesDB.add(new AccountHistory(40, AccountHistory.Type.transferOut, accountHN.getAccountId()));
        accountHistoriesDB.add(new AccountHistory(300, AccountHistory.Type.in));
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
            String fullName = listAccount.get(i).getFirstName() + " " + listAccount.get(i).getLastName();
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
            String fullNameCau5 = element.getFirstName() + " " + element.getLastName();
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
        for (Account element: listAccount){
            element.setCurrentBalance(element.reCalculateBalance());
            showInfoBasic(element);
        }
    }


    private static void showInfoBasic(Account account) {
        printSeparatedLine(50, "=");
        System.out.println("Ho ten: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Ngay tao: " + formatDate(account.getCreatedDate()));
        System.out.println("Số tiền: " + formatCurrency(account.getCurrentBalance()));
        System.out.println("Loại kỳ hạn: " + account.getPeriod());
    }

    private static void showInfo(Account account){
     //   printSeparatedLine(50, "=");
        System.out.println("Ho ten: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Ngay tao: " + formatDate(account.getCreatedDate()));
        System.out.println("Số tiền: " + formatCurrency(account.getCurrentBalance()));
        System.out.println("Loại kỳ hạn: " + account.getPeriod());
        System.out.println("Lịch sử giao dịch: ");
        if (account.getHistories().size() == 0) {
            System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");

        }
        for (AccountHistory history : account.getHistories()) {
            dash();
            System.out.println("Ngày tạo: " + formatDate(history.getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
            System.out.println("Số tiền: " + formatCurrency(history.getBalance()));
            System.out.println("Loại giao dịch: " + history.translatedType());
        }
        printSeparatedLine(50, "=");
    }
    private static void showInfo(Account account, AccountHistory.Type type){
     //   printSeparatedLine(50, "=");
        System.out.println("Ho ten: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Ngay tao: " + formatDate(account.getCreatedDate()));
        System.out.println("Số tiền: " + formatCurrency(account.getCurrentBalance()));
        System.out.println("Loại kỳ hạn: " + account.getPeriod());
        System.out.println("Lịch sử giao dịch: ");
        if (account.getHistories().size() == 0) {
            System.out.println("Tài khoản chưa thực hiện bất kì giao dịch nào");

        }
        List<AccountHistory> transferInList = account.getHistories().stream().filter(transferIn ->
                transferIn.getType() == type).collect(Collectors.toList());
        for (AccountHistory history : transferInList) {
            // if (history.getType() == type) {
            dash();
            System.out.println("Ngày tạo: " + formatDate(history.getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
            System.out.println("Số tiền: " + formatCurrency(history.getBalance()));
            System.out.println("Loại giao dịch: " + history.translatedType());
            // }
        }
        printSeparatedLine(50, "=");
    }
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
*  Câu 12+: Hoàn thành phương thức chuyển tiền trong class ProcessServices
*/


