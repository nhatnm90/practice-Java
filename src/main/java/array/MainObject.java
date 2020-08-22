package array;

import bank.AccountHistory;
import utils.StringFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static array.MainInteger.dash;

public class MainObject {
    public static void main(String[] args) {

        List<AccountHistory> listAccountHistory = new ArrayList<>();
        AccountHistory history1 = new AccountHistory(10, AccountHistory.Type.in);
        listAccountHistory.add(history1);
        listAccountHistory.add(new AccountHistory(5, AccountHistory.Type.out));
        listAccountHistory.add(new AccountHistory(2, AccountHistory.Type.transferIn));
        AccountHistory history2 = new AccountHistory(10, AccountHistory.Type.in);
        listAccountHistory.add(history2);

        System.out.println(listAccountHistory);
        System.out.println("history1: " + history1);
        System.out.println("history2: " + history2);
        printArray(listAccountHistory);
        dash();


//        // Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
//        // boolean add(Object o)
//        // TODO: 8/19/2020 using this function to practice array
//        System.out.println(listAccountHistory);
//        AccountHistory history3 = new AccountHistory(2, AccountHistory.Type.transferOut);
//        listAccountHistory.add(history3);
//        System.out.println("boolean add: " + listAccountHistory);
//        dash();
//
//        // Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
//        // void add(int index, Object element)
//        // Ex:
//        // Thêm phần tử vào vị trí thứ 0
//        listAccountHistory.add(0, new AccountHistory(100, AccountHistory.Type.transferOut));
//
//        // Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách, theo thứ tự chúng được trả về bởi bộ lặp iterator.
//        // boolean addAll(Collection c)
//        // TODO: 8/19/2020
//        System.out.println(listAccountHistory);
//        List<AccountHistory> listCollectionC = new ArrayList<>();
//        listCollectionC.add(new AccountHistory(12, AccountHistory.Type.in));
//        listCollectionC.add(new AccountHistory(13, AccountHistory.Type.out));
//        listAccountHistory.addAll(listCollectionC);
//        System.out.println(listCollectionC);
//
//        System.out.println("boolean addAll 1: " + listAccountHistory);
//        dash();
//
//        // Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách, bắt đầu từ vị trí index.
//        // boolean addAll(int index, Collection c)
//        // TODO: 8/19/2020
//        System.out.println(listAccountHistory);
//        System.out.println(listCollectionC);
//        listAccountHistory.addAll(2,listCollectionC);
//        System.out.println("boolean addAll 2: " + listAccountHistory);
//        dash();
//
//        // Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
//        // void removeAll(Collection c)
//        // TODO: 8/19/2020
//        System.out.println(listAccountHistory);
//        System.out.println(listCollectionC);
//        listAccountHistory.removeAll(listCollectionC);
//        System.out.println("removeAll: " + listAccountHistory);
//        dash();
//
//
//        // Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
//        // void clear()
//        // TODO: 8/19/2020
//        List<AccountHistory> clearList = new ArrayList<>();
//        clearList.add(new AccountHistory(22, AccountHistory.Type.in));
//        clearList.add(new AccountHistory(23, AccountHistory.Type.in));
//        System.out.println(clearList);
//        clearList.clear();
//        System.out.println("void clear: " + clearList);
//        dash();
//
//        // Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
//        // boolean contains(element)
//        // TODO: 8/19/2020
//        List<AccountHistory> containsList = new ArrayList<>();
//        containsList.add(history1);;
//        boolean history = containsList.contains(history1);
//        System.out.println("history contain =  " + history);
//        boolean historyA = containsList.contains(history3);
//        System.out.println("historyA contain =  " + historyA);

        // Function tìm phần tử (element) theo thuộc tính có trong phần tử đó (element)
        // TODO: 8/19/2020
//        System.out.println("h1 = " + history1.getHistoryId());

        // Câu a:
        // chỉ trả về type là transferIn
        // này trả về 1 list nè, để vầy ko đc
        System.out.println("Câu a: ");
        List<AccountHistory> cauA = MainObject.findElements(listAccountHistory);
        // cái biến cauA lúc này đang có kiểu dữ liệu là 1 danh sách các accountHistory nên mình loop qua nó đc
        // loop qua để hiển thị các giá trị của danh sách account history trong cau a có type là transferIn
        for (AccountHistory accountHistory: cauA) {
            System.out.println("- Ngày giao dịch: " + StringFormat.formatDate(accountHistory.getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
            System.out.println("- Số tiền: " + accountHistory.getBalance());
            System.out.println("- Loại giao dịch: " + accountHistory.translatedType());
        }

        System.out.println("Câu a1: ");
        // trả về type mình tuyền vào, ở trường hợp này là những account history có kiểu là in
        List<AccountHistory> cauA1 = MainObject.findElements(listAccountHistory, AccountHistory.Type.in);
        // loop qua để hiển thị các giá trị của danh sách account history trong cau a có type là in
        for (AccountHistory accountHistory: cauA1) {
            System.out.println("- Ngày giao dịch: " + StringFormat.formatDate(accountHistory.getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
            System.out.println("- Số tiền: " + accountHistory.getBalance());
            System.out.println("- Loại giao dịch: " + accountHistory.translatedType());
        }
        System.out.println(listAccountHistory);
        System.out.println("Câu b: ");
        List<AccountHistory> cauB = MainObject.findElementBalanceValue(listAccountHistory);
        System.out.println("- Giao dịch có balance > 10: " + cauB);

        System.out.println(listAccountHistory);
        System.out.println("Câu c: ");
        List<AccountHistory> cauC = MainObject.findElementBalanceMinValue(listAccountHistory);
        System.out.println("-câu C: " + cauC.get(0));


        // chỗ này sau khi lấy đc cái danh sách mình phải in nó ra theo từng properties á,
        // cái Class Account history chưa có hàm showInfo
    }

        // a. Tìm những history có loại là transferIn (return array có thế empty, 1 hoặc nhiều phần tử)
        // câu này mình phải tìm đc cái danh sách account history với loại là transferIn
        // E muốn a demo tử luôn ko e?

        // b. Tìm histories balance > 10 (return array có thế empty, 1 hoặc nhiều phần tử)



        // c. Tìm history có balance nhỏ nhất (return 1 element duy nhất)

    // viết nó ở ngoài á e, đừng viết trong cái hàm main, hàm main chỉ dùng để mình gọi hàm dó thôi e
    // Ủa cái này mình đang xài xong cái AccountHistory thôi mà e, đâu liên quan gì account đâu hen, chỉ practice trên
    // AccountHistory trước cho quen với mảng thôi à
    // Này là function trả về accounthistory khi truyền vào cái danh sách account history và id tương ứng nè e
    private AccountHistory findElementById (List<AccountHistory> listAccountHistory, UUID historyId){
       // for (kiểu dữ liệu của element : tên của element : danh sách element)
        for(AccountHistory accountHistory : listAccountHistory) {
            if(accountHistory.getHistoryId().equals(historyId)) {
                return accountHistory;
            }
        }
        return null;
    }

    // Câu a: Tìm danh sách account history với kiểu là transferIn
    private static List<AccountHistory> findElements (List<AccountHistory> listAccountHistory){
        // for (kiểu dữ liệu của element : tên của element : danh sách element)
        List<AccountHistory> result = new ArrayList<>();
        for(AccountHistory accountHistory : listAccountHistory) {
            if(accountHistory.getType().equals(AccountHistory.Type.transferIn)) {
                result.add(accountHistory);
            }
        }
        return result;
    }

    // mở rộng ra thì mình nên làm thế này cho nó linh động
    private static List<AccountHistory> findElements (List<AccountHistory> listAccountHistory, AccountHistory.Type type){
        // for (kiểu dữ liệu của element : tên của element : danh sách element)
        List<AccountHistory> result = new ArrayList<>();
        for(AccountHistory accountHistory : listAccountHistory) {
            if(accountHistory.getType().equals(type)) {
                result.add(accountHistory);
            }
        }
        return result;
    }

    // b. Tìm histories balance > 10 (return array có thế empty, 1 hoặc nhiều phần tử)
    private static List<AccountHistory>  findElementBalanceValue(List<AccountHistory> listAccountHistory){
        List<AccountHistory> result = new ArrayList<>();
        for(AccountHistory accountBalance : listAccountHistory){
            if(accountBalance.getBalance() > 10){
                result.add(accountBalance);
            }
        }
        return result;
    }


    // c. Tìm history có balance nhỏ nhất (return 1 element duy nhất)
    private static List<AccountHistory> findElementBalanceMinValue(List<AccountHistory> listAccountHistory){
        ArrayList result = new ArrayList();
        for(AccountHistory accountBalance : listAccountHistory){
            //List<AccountHistory> minArray = new ArrayList<>();
            long minValue = accountBalance.getBalance();
            result.add(minValue);
        }
        Collections.sort(result);
        return result;
    }

    // Câu này mình có thể làm theo 2 cách.
    // Cách 1 là mình loop qua cái mảng đó, tạo 1 cái biến để lưu giá trị đang nhỏ nhất
    // mình chạy qua mỗi lần sẽ so sánh cái hiện tại với cái giá trị đó,
    // nếu nhỏ hơn thì mình gán lại giá trị nhỏ nhất cho cái biến lưu giá trị tạm

//    private static List<AccountHistory> findElementBalanceMinValue1(List<AccountHistory> listAccountHistory) {
        // Mình chỉ cần tìm phần tử nhỏ nhất nêm mình ko cần khai báo 1 cái mảng result à e
        // Khai báo 1 cái biến chứa giá trị nhỏ nhất
//        for(AccountHistory accountBalance : listAccountHistory){
//            //List<AccountHistory> minArray = new ArrayList<>();
//            long minValue = accountBalance.getBalance();
//            result.add(minValue);
//        }
//        Collections.sort(result);
//        return result;
//    }

        private static void printArray (List <AccountHistory> array) {
            for (AccountHistory element : array) {
                System.out.println(element);
            }
        }

    }

