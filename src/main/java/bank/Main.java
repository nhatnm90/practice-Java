package bank;

import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    private static Object Month;

    public static void main(String[] args){

        Account customer1 = new Account(246, "Hanh", "Nguyen", Account.Period.Month);
        Account customer2 = new Account(211, "Nhat", "Nguyen", Account.Period.Year);
        Account customer3 = new Account(111, "Trang PM", "Nguyen", Account.Period.Week);
        Account customer4 = new Account(222, "Thao", "Do", Account.Period.Week);

//        customer2.addMoney(100000, AccountHistory.Type.in);
//        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
//        try {
//            Thread.sleep(3 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        customer2.addMoney(148000);
//        // Cho ngủ 3s để thấy đc thời điểm giao dịch khác nhau
//        try {
//            Thread.sleep(3 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        customer2.subMoney(5000);
//
//        customer2.showInfo();
//        customer1.showInfo();





        List<Account> accounts = new ArrayList<>();
        accounts.add(customer1);
        accounts.add(customer2);
        accounts.add(customer3);
        accounts.add(customer4);
        ProcessServices services = new ProcessServices(accounts);

        services.Transfer(211, 246, 50000);
        services.Transfer(246,211, 100000);
        services.Transfer(246,211, 20000);
        customer1.showInfo();
        customer2.showInfo();


//        customer3.showInfo();
//        customer4.showInfo();
        /*
         *
         * 1. Viết hoặc tùy chỉnh lại phương thức showInfo để in ra thông tin khách hàng sau khi thực hiện những giao dịch trên theo những yêu cầu sau
         * - In tất cả thông tin khách hàng
         * - In lịch sử giao dịch theo format sau:
         *   + nếu chưa có bất kì giao dịch nào: -> "Khách hàng chưa có giao dịch"
         *   + nếu đã có giao dịch:
         *       - sắp xếp lịch sử giao dịch theo ngày tháng theo thứ tự mới trước cũ sau
         *       - format theo cấu trúc sau:
         * 			- Số tài khoản: 211
         *			- Tên + Họ: Nhat Nguyen
         *			- Số tiền trong tài khoản: 293000
         *			- Ngày tạo tài khoản: 16-08-2020
         *			- Lịch sử giao dịch:
         *			-------------------------------
         *			+ Ngày giao dịch: 16-08-2020 05:11:33
         *			+ Số tiền: 5000
         *			+ Loại giao dịch: Rút tiền
         *			-------------------------------
         *			+ Ngày giao dịch: 16-08-2020 05:11:18
         *			+ Số tiền: 148000
         *			+ Loại giao dịch: Nạp tiền
         *			-------------------------------
         *			+ Ngày giao dịch: 16-08-2020 05:11:03
         *			+ Số tiền: 100000
         *			+ Loại giao dịch: Nạp tiền
         *
         * 2. Viết phương thức chuyển tiền giữa 2 khách hàng theo những yêu cầu sau
         *  - nhận vào id của người chuyển, người nhận và số tiền chuyển
         *  - kiểm tra thông tin nhận gửi, số dư khả dụng, tài khoản ngân hàng tồn tại hay ko
         *  - ghi lại lịch sử giao dịch cho cả 2 đối tượng
         *      + nhận tiền: Type = transferIn
         *      + chuyển tiền: Type = transferOut
         *  vd: void transfer (long sourceAccountId, long destinationAccountId, long balance)
         *  customer1 chuyển tiền cho customer2 (tùy chọn cách gọi phương thức chuyển tiền ...)
         *
         * 3. Viết hoặc tùy chỉnh lại phương thức showInfo để in ra thông tin khách hàng sau khi thực hiện những giao dịch chuyển tiền giữa 2 khách hàng trên
         *
         * 4. Nếu là phương thức chuyển tiền qua lại giữa 2 khách hàng, ở phần lịch sử giao dịch hiển thị thêm thông tin như sau:
         *  - nếu giao dịch chuyển tiền (transferOut): hiển thị thông tin người nhận
         *          -------------------------------
         *			+ Ngày giao dịch: 16-08-2020 05:11:03
         *			+ Số tiền: 100000
         *			+ Loại giao dịch: chuyển tiền đi
         *          + Người nhận: Trang PM
         *  - nếu giao dịch nhận tiền (transferIn): hiển thị thông tin người chuyển
         *          -------------------------------
         *			+ Ngày giao dịch : 16-08-2020 05:11:03
         *			+ Số tiền: 100000
         *			+ Loại giao dịch: nhận tiền
         *          + Người chuyển: Trang PM
         *
         * 5. Viết lại phương thức tìm account theo accountId theo cách khác.
         * */

    }



}
