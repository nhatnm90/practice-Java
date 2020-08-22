package array;

import bank.Account;
import bank.AccountHistory;
import utils.StringFormat;

import static java.util.Comparator.comparing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainObject_Answer {
    public static void main(String[] args){
        List<AccountHistory> listAccountHistory = new ArrayList<>();
        AccountHistory history1 = new AccountHistory(10, AccountHistory.Type.in);
        listAccountHistory.add(history1);
        listAccountHistory.add(new AccountHistory(5, AccountHistory.Type.out));
        listAccountHistory.add(new AccountHistory(3, AccountHistory.Type.transferIn));
        listAccountHistory.add(new AccountHistory(1, AccountHistory.Type.transferOut));
        AccountHistory history2 = new AccountHistory(10, AccountHistory.Type.in);
        listAccountHistory.add(history2);

//        System.out.println(listAccountHistory);

        // Nó được sử dụng để lấy phần tự tại chỉ số index tương ứng
        // LƯU Ý: index của mảng LUÔN LUÔN được tính từ 0 -> phần tử ĐẦU TIÊN có index = 0
        // ObjectType get(int index)
        // Ex: AccountHistory minBalance = listAccountHistory.get(0);

        // Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
        // boolean add(Object o)
        // Viết tắt
        // Ex: listAccountHistory.add(new AccountHistory(3, AccountHistory.Type.transferIn));
        // Viết tường minh
        AccountHistory newAccountHistory = new AccountHistory(246, AccountHistory.Type.in);
        listAccountHistory.add(newAccountHistory);

        // Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
        // void add(int index, Object element)
        // Ex:
        // Thêm phần tử vào vị trí thứ 0
        listAccountHistory.add(0, new AccountHistory(100, AccountHistory.Type.transferOut));

        // Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách, theo thứ tự chúng được trả về bởi bộ lặp iterator.
        // boolean addAll(Collection c)
        // Tạo 1 danh sách các phần tử mới
        ArrayList<AccountHistory> newListAccountHistory = new ArrayList<>();
        newListAccountHistory.add(new AccountHistory(111, AccountHistory.Type.out));
        newListAccountHistory.add(new AccountHistory(222, AccountHistory.Type.out));

        // Nối 2 danh sách account history lại
        listAccountHistory.addAll(newListAccountHistory);

        // Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách, bắt đầu từ vị trí index.
        // boolean addAll(int index, Collection c)
        // Tương tự như trên nhưng có thể chọn vị trí muốn thêm vào
        // nếu thêm vào mà ko chỉ vị trí thì MẶC ĐỊNH thêm vào CUỐI MẢNG

        // Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
        // void removeAll(Collection c)
        ArrayList<AccountHistory> needToRemoveListAccountHistory = new ArrayList<>();
        AccountHistory needToRemoveAccountHistory = new AccountHistory(111, AccountHistory.Type.out);
        needToRemoveListAccountHistory.add(needToRemoveAccountHistory);
        listAccountHistory.removeAll(needToRemoveListAccountHistory);

        // Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
        // void clear()
//        listAccountHistory.clear();

        // Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
        // boolean contains(element)
        boolean isNewAccountHistoryExisted = listAccountHistory.contains(newAccountHistory);
        System.out.println("newAccountHistory " + (isNewAccountHistoryExisted ? "có" : "không") + " tồn tại trong mảng");

        boolean isNeedToRemoveAccountHistoryExisted = listAccountHistory.contains(needToRemoveAccountHistory);
        System.out.println("needToRemoveAccountHistory " + (isNeedToRemoveAccountHistoryExisted ? "có" : "không") + " tồn tại trong mảng");

        // Function tìm phần tử (element) theo thuộc tính có trong phần tử đó (element)
        // TODO: 8/19/2020
        // a. Tìm những history có loại là transferIn (return array có thế empty, 1 hoặc nhiều phần tử)

        // b. Tìm histories balance > 10 (return array có thế empty, 1 hoặc nhiều phần tử)

        // c. Tìm history có balance nhỏ nhất (return 1 element duy nhất)

        // CÂU C:

        // CÁCH GIẢI 1:
        // 1. Sắp xếp mảng theo chiều tăng gần
        // 2. Lấy phần tử đầu tiên sau khi sắp xếp


        // 1. SẮP XẾP: thuật toán để sắp xếp
        // Sắp xếp tăng dần (Ascending)
        // Cách 1:
        // Collections.sort(listAccountHistory, comparing(AccountHistory::getBalance));

        // Cách 2:
//        Collections.sort(listAccountHistory, (AccountHistory a1, AccountHistory a2) -> (int) (a1.getBalance() - a2.getBalance()));
//        for (AccountHistory accountHistory : listAccountHistory) {
//            showInfo(accountHistory);
//        }

        // Sắp xếp giảm dần (Descending)
        // Cách 1:
        // Collections.sort(listAccountHistory, comparing(AccountHistory::getBalance).reversed());

        // Cách 2:
        // Collections.sort(listAccountHistory, (AccountHistory a1, AccountHistory a2) -> (int) (a2.getBalance() - a1.getBalance()));
//        for (AccountHistory accountHistory : listAccountHistory) {
//            showInfo(accountHistory);
//        }

        // 2. LẤY PHẦN TỬ ĐẦU TIÊN: sau khi sắp xếp có thể lấy phần tử đầu tiên, là giá trị lớn nhất hay nhỏ nhất tùy theo cách sắp xếp
//        AccountHistory minBalanceAccountHistory = listAccountHistory.get(0);
//        showInfo(minBalanceAccountHistory);

        // CÁCH GIẢI 2:
        // Loop qua các phần tử trong mảng
        // Tạo 1 biến tạm giữ giá trị nhỏ nhất là giá trị đầu tiên
        // So sánh từ giá trị đc loop qua
        // - nếu giá trị hiện tại nhỏ hơn giá trị ở biến tạm, GÁN NÓ LẠI CHO BIẾN TẠM
        // - nếu giá trị hiện tại lớn hơn giá trị ở biến tạm, BỎ QUA
        // Sau khi loop qua hết phần tử của mảng thì giá trị trong biến tạm là giá trị nhỏ nhất

        // Gán giá trị minBalance là giá trị đầu tiên của mảng
        AccountHistory minBalance = listAccountHistory.get(0);
        for (int i = 1; i < listAccountHistory.size(); i++) {
            // lấy từng phần tử theo index hiện tại, chỉ lấy từ index i = 1 do đã gán giá trị đầu tiên cho biến tạm
            // nếu ko có giá trị nào so sánh nhỏ hơn thì xem như phần tử đầu tiên là nhỏ nhất
            // nếu có giá trị nhỏ hơn, biến tạm sẽ bị gán lại
            AccountHistory currentAccountHistory = listAccountHistory.get(i);
            // Nếu thỏa nhỏ hơn -> GÁN LẠI
            if (currentAccountHistory.getBalance() < minBalance.getBalance()) {
                minBalance = currentAccountHistory;
            }
            // Nếu không thỏa -> ĐI TIẾP
        }
        showInfo(minBalance);
    }

    private static void showInfo(AccountHistory accountHistory) {
        System.out.println("Số tiền: " + accountHistory.getBalance());
        System.out.println("Loại giao dịch: " + accountHistory.getType());
        System.out.println("Ngày giao dịch: " + StringFormat.formatDate(accountHistory.getCreatedDate(), "dd-MM-yyyy hh:mm:ss"));
        System.out.println("-------------------------------------------");
    }

    private static void printArray(List<Integer> array) {
        for (int element: array) {
            System.out.println(element);
        }
    }

}
