package array;

import java.util.ArrayList;
import java.util.List;


public class MainInteger {
    public static void dash() {
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 10; i += 2) {
            listInt.add(i);
        }

        System.out.println(listInt);

        System.out.println(listInt.remove(2));

        System.out.println(listInt);

        System.out.println(listInt.indexOf(100) >= 0 ? listInt.get(100) : -1);

        System.out.println(listInt.remove(listInt.get(100)));

        System.out.println(listInt);
//        printArray(listInt);
//
//        // Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
//        // boolean add(Object o)
//        // TODO: 8/19/2020 using this function to practice array
//        System.out.println(listInt);
//        listInt.add(2);
//        System.out.println("boolean add: " + listInt);
//        dash();
//
//
//        // Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
//        // void add(int index, Object element)
//        // TODO: 8/19/2020
//        System.out.println(listInt);
//        listInt.add(1, 24);
//        System.out.println("void add: " + listInt);
//        dash();
//
//        // Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách, theo thứ tự chúng được trả về bởi bộ lặp iterator.
//        // boolean addAll(Collection c)
//        // TODO: 8/19/2020
//        System.out.println(listInt);
//        List<Integer> listCollectionC = new ArrayList<>();
//        for (int i = 20; i <= 30; i += 3) {
//            listCollectionC.add(i);
//        }
//        listInt.addAll(listCollectionC);
//        System.out.println("boolean addAll 1: " + listInt);
//        dash();
//
//        // Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách, bắt đầu từ vị trí index.
//        // boolean addAll(int index, Collection c)
//        // TODO: 8/19/2020
//        System.out.println(listInt);
//        listInt.addAll(0, listCollectionC);
//        System.out.println("boolean addAll 2: " + listInt);
//        dash();
//
//        // Nó được sử dụng để xóa những phần tử không thuộc collection c ra khỏi danh sách.
//        // void retainAll(Collection c)
//        System.out.println(listInt);
//        listInt.retainAll(listCollectionC);
//        System.out.println("void retainAll: " + listInt);
//        dash();
//
//        // Ex:
//        // khởi tạo listRetain
//        ArrayList<Integer> listRetain = new ArrayList<>();
//        listRetain.add(26);
//        // xóa những phần tử KHÔNG thuộc listRetain khỏi listInt
//        System.out.println("List Integer old: " + listInt);
//        System.out.println("List Retain: " + listRetain);
//        listInt.retainAll(listRetain);
//        System.out.println("List Integer: " + listInt);
//        dash();
//
//        // Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
//        // void removeAll(Collection c)
//        // TODO: 8/19/2020
//        System.out.println("List Retain : " + listRetain);
//        System.out.println("List Collection C old: " + listCollectionC);
//        listCollectionC.removeAll(listRetain);
//        System.out.println("void removeAll: " + listCollectionC);
//        dash();
//
//        // Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện đầu tiên của phần tử được chỉ định, hoặc -1 nếu danh sách không chứa phần tử này.
//        // int indexOf(Object o)
//        //Ex:
//        int indexOfNumber6 = listInt.indexOf(6);
//        System.out.println(indexOfNumber6);
//        dash();
//        for (int i = 40; i <= 60; i += 2) {
//            listInt.add(i);
//        }
//        System.out.println("List Int: " + listInt);
//        int indexOfNo44 = listInt.indexOf(44);
//        System.out.println("Index of number 44: " + indexOfNo44);
//        dash();
//
//
//        // Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
//        // void clear()
//        // TODO: 8/19/2020
//        System.out.println("List Retain old: " + listRetain);
//        listRetain.clear();
//        System.out.println("void clear list Retain: " + listRetain);
//        dash();
//
//        // Nó được sử dụng để cắt dung lượng của thể hiện ArrayList này là kích thước danh sách hiện tại.
//        // void trimToSize()
//        // TODO: 8/19/2020
//        ArrayList<Integer> listNew = new ArrayList<>();
//        for (int i = 50; i <= 55; i++) {
//            listNew.add(i);
//        }
//        listNew.add(11);
//        System.out.println("List new: " + listNew);
//        listNew.trimToSize();
//        System.out.println("void trimToSize: " );
//        for (int number : listNew) {
//            System.out.println("element = " + number);
//        }
//        dash();
//
//        // Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
//        // boolean contains(element)
//        // TODO: 8/19/2020
//        System.out.println("List new: " + listNew);
//        boolean number;
//        number = listNew.contains(11);
//        System.out.println("boolean contains 11: " + number);
//        number = listNew.contains(56);
//        System.out.println("boolean contains 56: " + number);
//        dash();

    }

    private static void printArray(List<Integer> array) {
        for (int element : array) {
            System.out.println(element);
        }
    }

}
