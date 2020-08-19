package array;

import bank.Account;
import bank.AccountHistory;

import java.util.ArrayList;
import java.util.List;

public class MainObject {
    public static void main(String[] args){
        List<AccountHistory> listAccountHistory = new ArrayList<>();
        AccountHistory history1 = new AccountHistory(10, AccountHistory.Type.in);
        listAccountHistory.add(history1);
        listAccountHistory.add(new AccountHistory(5, AccountHistory.Type.out));
        listAccountHistory.add(new AccountHistory(2, AccountHistory.Type.transferIn));
        AccountHistory history2 = new AccountHistory(10, AccountHistory.Type.in);
        listAccountHistory.add(history2);

        System.out.println(listAccountHistory);

        // Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
        // boolean add(Object o)
        // TODO: 8/19/2020 using this function to practice array

        // Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
        // void add(int index, Object element)
        // Ex:
        // Thêm phần tử vào vị trí thứ 0
        listAccountHistory.add(0, new AccountHistory(100, AccountHistory.Type.transferOut));

        // Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách, theo thứ tự chúng được trả về bởi bộ lặp iterator.
        // boolean addAll(Collection c)
        // TODO: 8/19/2020

        // Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách, bắt đầu từ vị trí index.
        // boolean addAll(int index, Collection c)
        // TODO: 8/19/2020

        // Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
        // void removeAll(Collection c)
        // TODO: 8/19/2020

        // Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
        // void clear()
        // TODO: 8/19/2020

        // Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
        // boolean contains(element)
        // TODO: 8/19/2020

        // Function tìm phần tử (element) theo thuộc tính có trong phần tử đó (element)
        // TODO: 8/19/2020
        // a. Tìm những history có loại là transferIn (return array có thế empty, 1 hoặc nhiều phần tử)

        // b. Tìm histories balance > 10 (return array có thế empty, 1 hoặc nhiều phần tử)

        // c. Tìm history có balance nhỏ nhất (return 1 element duy nhất)

    }

    private static void printArray(List<Integer> array) {
        for (int element: array) {
            System.out.println(element);
        }
    }

}
