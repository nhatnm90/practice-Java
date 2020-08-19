package array;

import java.util.ArrayList;
import java.util.List;

public class MainInteger {
    public static void main(String[] args){
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 10; i+=2) {
            listInt.add(i);
        }

        System.out.println(listInt);
        printArray(listInt);

        // Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
        // boolean add(Object o)
        // TODO: 8/19/2020 using this function to practice array

        // Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
        // void add(int index, Object element)
        // TODO: 8/19/2020

        // Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách, theo thứ tự chúng được trả về bởi bộ lặp iterator.
        // boolean addAll(Collection c)
        // TODO: 8/19/2020

        // Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách, bắt đầu từ vị trí index.
        // boolean addAll(int index, Collection c)
        // TODO: 8/19/2020

        // Nó được sử dụng để xóa những phần tử không thuộc collection c ra khỏi danh sách.
        // void retainAll(Collection c)

        // Ex:
        // khởi tạo listRetain
        ArrayList<Integer> listRetain = new ArrayList<>();
        listRetain.add(6);
        // xóa những phần tử KHÔNG thuộc listRetain khỏi listInt
        listInt.retainAll(listRetain);
        System.out.println("List Integer: " + listInt);

        // Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
        // void removeAll(Collection c)
        // TODO: 8/19/2020

        // Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện đầu tiên của phần tử được chỉ định, hoặc -1 nếu danh sách không chứa phần tử này.
        // int indexOf(Object o)
        //Ex:
        int indexOfNumber6 = listInt.indexOf(6);
        System.out.println(indexOfNumber6);

        // Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
        // void clear()
        // TODO: 8/19/2020

        // Nó được sử dụng để cắt dung lượng của thể hiện ArrayList này là kích thước danh sách hiện tại.
        // void trimToSize()
        // TODO: 8/19/2020

        // Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
        // boolean contains(element)
        // TODO: 8/19/2020

    }

    private static void printArray(List<Integer> array) {
        for (int element: array) {
            System.out.println(element);
        }
    }

}
