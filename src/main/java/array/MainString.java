package array;

import java.util.ArrayList;
import java.util.List;

import static array.MainInteger.dash;

public class MainString {
    public static void main(String[] args){
        List<String> listString = new ArrayList<>();
        listString.add("Banana");
        listString.add("Citrus");
        listString.add("Rambutan");
        listString.add("Durian");

        System.out.println(listString);
        printArray(listString);
        dash();

        // Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
        // boolean add(Object o)
        // TODO: 8/19/2020 using this function to practice array
        System.out.println(listString);
        listString.add("mango");
        System.out.println("boolean add:" + listString);
        dash();

        // Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
        // void add(int index, Object element)
        // TODO: 8/19/2020
        System.out.println(listString);
        listString.add(0, "papaya");
        System.out.println("void add:" + listString);
        dash();

        // Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách, theo thứ tự chúng được trả về bởi bộ lặp iterator.
        // boolean addAll(Collection c)
        // TODO: 8/19/2020
        System.out.println(listString);
        List<String> listStringNew = new ArrayList<>();
        listStringNew.add("apple");
        listStringNew.add("strawberry");
        listStringNew.add("peach");
        System.out.println(listStringNew);
        listString.addAll(listStringNew);
        System.out.println("boolean addAll 1:" + listString);
        dash();
        // Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách, bắt đầu từ vị trí index.
        // boolean addAll(int index, Collection c)
        // TODO: 8/19/2020
        System.out.println(listString);
        System.out.println(listStringNew);
        listString.addAll(2,listStringNew);
        System.out.println("boolean addAll 2:" + listString);
        dash();
        // Nó được sử dụng để xóa những phần tử không thuộc collection c ra khỏi danh sách.
        // void retainAll(Collection c)
        // TODO: 8/19/2020
        System.out.println(listString);
        System.out.println(listStringNew);
        listString.retainAll(listStringNew);
        System.out.println("retainAll:" + listString);
        dash();
        // Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
        // void removeAll(Collection c)
        // TODO: 8/19/2020
        System.out.println(listString);
        List<String> apple = new ArrayList<>();
        apple.add("apple");
        apple.add("peach");
        System.out.println(apple);
        listString.removeAll(apple);
        System.out.println("removeAll:" + listString);
        dash();
        // Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện đầu tiên của phần tử được chỉ định, hoặc -1 nếu danh sách không chứa phần tử này.
        // int indexOf(Object o)
        //Ex:
        listString.add("Durian");
        System.out.println(listString);
        int indexOfDurian = listString.indexOf("Durian");
        System.out.println("Index of Durian: " + indexOfDurian);

        int indexOfMango = listString.indexOf("Mango");
        System.out.println("Index of Mango: " + indexOfMango);
        dash();
        // Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
        // void clear()
        // TODO: 8/19/2020

        System.out.println(listStringNew);
        listStringNew.clear();
        System.out.println("clear:" + listStringNew);
        dash();
        // Nó được sử dụng để cắt dung lượng của thể hiện ArrayList này là kích thước danh sách hiện tại.
        // void trimToSize()
        // TODO: 8/19/2020
        ArrayList<String> arrString = new ArrayList<>();

        arrString.add("Banana");
        arrString.add("Citrus");
        arrString.add("Rambutan");
        arrString.add("Durian");
        System.out.println(arrString);
        arrString.trimToSize();
        System.out.println("trimToSize:" );
        for (String element: arrString){
            System.out.println("element: " + element);
        }
        dash();
        // Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
        // boolean contains(element)
        // TODO: 8/19/2020

    }

    private static void printArray(List<String> array) {
        for (String element: array) {
            System.out.println(element);
        }
    }

}
