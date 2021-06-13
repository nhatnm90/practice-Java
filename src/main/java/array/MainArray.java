package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainArray {
    public static void dash() {
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        int[] firstArray = new int[]{ 2, 4, 0, 6 };

        int[] secondArray = new int[]{ 2, 1, 0, 1 };

        int[] thirdArray = new int[]{ 0, 8, 0, 8, 2, 0, 1, 8 };

        ArrayList<int []> joinedArray = new ArrayList<>();

        joinedArray.add(firstArray);
        joinedArray.add(secondArray);
        joinedArray.add(thirdArray);

        // Example - xem phần này trước như là bài học trước khi bắt đầu làm bài tập ha e
        /* START: COMMENT OUT TO DO THE EXERCISES: you can un-comment this quote to run the example code (from START to END)

        System.out.println("The number of array: " + joinedArray.size());

        System.out.println("The number of first array: " + firstArray.length);

        // PRACTICE: Print all the element of array with the comma as separator and end with the dot.

        System.out.println();

        System.out.println("C1: The list element of array by flattening a complex array to a simple array: ");

        // Instead of looping through the array of array, we can flat it to a simple array
        // array = [[a, b, c], [d, e, f]];
        // ->
        // flattenArray = [a, b, c, d, e, f];

        List<Integer> flattenArray = new ArrayList<>();
        for (int[] arr: joinedArray) {
            for (int arrElement : arr) {
                flattenArray.add(arrElement);
            }
        }

        // using FOR to check the last index of array and add the suitable signal (comma or dor)

        for (int i = 0; i < flattenArray.size(); i++) {
            System.out.print(flattenArray.get(i));
            if (i == flattenArray.size() - 1) {
                System.out.println(". ");
            } else {
                System.out.print(", ");
            }
        }

        // using FOREACH need to create a variable to detect the last element instead of using index of FOR
        int index = 0;
        for (int element: flattenArray) {
            System.out.print(element);
            if (index == flattenArray.size() - 1) {
                System.out.println(". ");
            } else {
                System.out.print(", ");
            }
            index += 1;
        }

        System.out.println();


        // Looping through the Array of array, within each time, looping through the array to print the element
        // Using 2 variables due to using 2 loop:
        // - 1 variable to detect last array in array of array (countArray)
        // - 1 variable to detect last element in last array and print the dot to end (countElement)


        System.out.println("C2: The list element of array by looping double array ");
        int countArray = 0;
        for (int[] arr: joinedArray) {
            int countElement = 0;
            for (int arrElement : arr) {
                if (countArray == joinedArray.size() - 1 && countElement == arr.length - 1) {
                    System.out.println(arrElement + ". ");
                    break;
                } else {
                    System.out.print(arrElement + ", ");
                }
                countElement += 1;
            }
            countArray += 1;
        }

        System.out.println();

        System.out.println("C3: The list element of array by looping double array and add the | at the end of each array");
        int countArray1 = 0;
        for (int[] arr: joinedArray) {
            int countElement = 0;
            for (int arrElement : arr) {
                if (countElement == arr.length - 1) {
                    if (countArray1 == joinedArray.size() - 1) {
                        System.out.println(arrElement + ". ");
                    } else {
                        System.out.print(arrElement + " | ");
                    }
                } else {
                    System.out.print(arrElement + ", ");
                }
                countElement += 1;
            }
            countArray1 += 1;
        }

        *** END: COMMENT OUT TO DO THE EXERCISES */

        // Lưu ý trước khi vào bài
        /*
        * Trước khi học mình cần làm rõ trước khái niệm Array và ArrayList trước ha e, xem mấy cái article này đễ rõ hơn à e:
        * https://viettuts.vn/java-collection/su-khac-nhau-giua-array-voi-arraylist
        * https://www.geeksforgeeks.org/array-vs-arraylist-in-java/
        *
        * int[] -> Array: perfomance nhanh nhưng rắc rối hơn, ít method support và khó thao tác
        * ArrayList<Integer> -> ArrayList: perfomance ko cao nhưng có nhiều method hỗ trợ, dễ dùng
        * nên mình thống nhất từ giờ về sau cần thao tác gì mình cứ chuyển hết về ArrayList rồi làm sẽ dễ hơn e ha
        */

        // Các mảng cho trước dùng để giải bài tập
        // Mảng số nguyên chứa 4 phần tử đều là số nguyên
        // firstArray = [2, 4, 0, 6 ];
        ArrayList<Integer> firstArrayList = new ArrayList<>();
        firstArrayList.add(2);
        firstArrayList.add(4);
        firstArrayList.add(0);
        firstArrayList.add(6);

        // secondArray = [2, 1, 0, 1 ];
        ArrayList<Integer> secondArrayList = new ArrayList<>();
        secondArrayList.add(2);
        secondArrayList.add(1);
        secondArrayList.add(0);
        secondArrayList.add(1);

        //thirdArrayList =  [0, 8, 0, 8, 2, 0, 1, 8 ];
        ArrayList<Integer> thirdArrayList = new ArrayList<>();
        thirdArrayList.add(0);
        thirdArrayList.add(8);
        thirdArrayList.add(0);
        thirdArrayList.add(8);
        thirdArrayList.add(2);
        thirdArrayList.add(0);
        thirdArrayList.add(1);
        thirdArrayList.add(8);

        // Mảng chứa các mảng số nguyên
        // joinedArrayList = [ [2, 4, 0, 6 ],  [2, 1, 0, 1 ], [0, 8, 0, 8, 2, 0, 1, 8 ] ]
        ArrayList<ArrayList<Integer>> joinedArrayList = new ArrayList<>();
        joinedArrayList.add(firstArrayList);
        joinedArrayList.add(secondArrayList);
        joinedArrayList.add(thirdArrayList);

        // Có 2 cách tạo 1 đối tượng là mảng kiểu số nguyên là:

        // Cách 1:
        // ArrayList<Integer> newArrayListName = new ArrayList<Integer>();

        // Cách 2:
        // ArrayList<Integer> newArrayListName = new ArrayList<>();
        // Mình có thể để trống phần sau do phần đầu đã định nghĩa kiểu dữ liệu rồi

        // Tạo ra 1 mảng mới chứa tất cả các phần tử đều là số nguyên từ cái mảng bự lúc đầu đã cho (mảng bự lúc đầu là 1 mảng chứa các mảng số nguyên)
        // joinedArrayList = [ [2, 4, 0, 6 ],  [2, 1, 0, 1 ], [0, 8, 0, 8, 2, 0, 1, 8 ] ]
        // Sau khi chạy xong câu lệnh bên dưới mảng mới vừa tạo sẽ để thao tác hơn do chỉ còn các số nguyên thôi, mảng chứa màng giờ chỉ còn chứa số nguyên
        // flattenedArray = [2, 4, 0, 6 , 2, 1, 0, 1, 0, 8, 0, 8, 2, 0, 1, 8]
        ArrayList<Integer> flattenedArray = new ArrayList<>();
        for (List<Integer> arr: joinedArrayList) {
            for (int arrElement : arr) {
                flattenedArray.add(arrElement);
            }
        }

        // Có 1 cách khác để tạo mảng chứa toàn số nguyên đơn giản hơn cách bên trên,
        // thay vì phải dùng 2 for mình dùng phương thức addAll mà mảng hỗ trợ để tạo ra mảng mới chỉ chứa toàn số nguyên nhanh hơn
        ArrayList<Integer> flattenedArray_1 = new ArrayList<>();
        flattenedArray_1.addAll(firstArrayList);
        flattenedArray_1.addAll(secondArrayList);
        flattenedArray_1.addAll(thirdArrayList);

        // E nhớ lưu ý nếu bị issue:
        // 1 xem kĩ lại cheatsheet
        // 2 debug thử
        // 3 google xem ra không
        // 4 e cứ hỏi a nha

        // QUESTIONS:
        /*
        PRACTICE:
        Hope you have time to take care on this practice at weekend...
        Please take a look on the cheat sheet before doing them... I can not do something difference...

        Within the array as below:
        joinedArray = [
            [2, 4, 0, 6],
            [2, 1, 0, 1 ],
            [0, 8, 0, 8, 2, 0, 1, 8]
        ];

        1. Print the array by the ascending sort
        Ex:
            int[] newArray = [9, 1, 7, 2, 3];
            -> int[] result = [1, 2, 3, 7, 9];

        2. Print the array without duplicate element and by descending sort
        Ex:
            int[] newArray = [1, 7, 9, 1, 7, 2, 3, 4, 2];
            -> int[] result = [9, 7, 4, 3, 2, 1];

        From this question please using the input array as the result of question 2
        3. Get the total of the array of practice 2
        Ex:
            int[] newArray = [1, 2, 3];
            -> result = 6;

        4. Add any number at the end of the array and print the array out
        Ex:
            int[] newArray = [1, 7, 9, 1, 7];
            -> int[] result =  [1, 7, 9, 1, 7, 246];

        5. Add any number at the beginning of the array and print the array out
        Ex:
            int[] newArray = [1, 7, 9, 1, 7];
            -> int[] result =  [246, 1, 7, 9, 1, 7];

        6. Create a new int[] array with 3 elements that divisible by 13 and add the this array to the middle index of the current array

        Ex:
            int[] newArray = [13, 39, 52];
            int[] currentArray = [0, 1, 2, 3, 4, 5, 6, 7];
            int[] expectedResult = [0, 1, 2, 3, 13, 39, 53, 4, 5, 6, 7];


        7. From the list of practice 1, create an array of array with each child array has 2 element with ascending sort
        Ex:
            int[] array = [0, 1, 2, 4, 5, 8, 9, 10]
            -> resultArray = [[0, 1], [2, 4], [5, 8], [9, 10]]
        */

        // Hi vọng là e đã giải được phần nào bài tập rồi à e, nếu có chỗ nào chưa rõ e chịu khó xem thử phần này e nha
        // ANSWERS:

        // 1
        // dùng phương thức clone() để tạo 1 đối đượng mới từ arrayList đã cho ở đề bài để không làm thay đổi mảng đã cho ban đầu
        System.out.println("Câu 1: ");
        ArrayList<Integer> cau1 = (ArrayList<Integer>) flattenedArray_1.clone();
        Collections.sort(cau1);
        printArray(cau1);
        System.out.println();

        // 2
        ArrayList<Integer> cau2 = (ArrayList<Integer>) flattenedArray_1.clone();
        // tạo 1 mảng rỗng để chứa những phần tử không trùng nhau,
        // loop qua mảng đã cho kiểm tra phần tử nếu chưa tồn tại trong mảng thì thêm vào mảng kết quả, nếu có rồi thì bỏ qua
        System.out.println("Câu 2: ");
        ArrayList<Integer> uniqueArrayList = new ArrayList<>();
        for (int i: cau2) {
            if (uniqueArrayList.contains(i) == false) {
                uniqueArrayList.add(i);
            }
        }
        // sắp xếp mảng kết quả theo thứ tự giảm dần
        Collections.sort(uniqueArrayList, Collections.reverseOrder());
        printArray(uniqueArrayList);
        System.out.println();

        // 3
        System.out.println("Câu 3: ");
        int sum = 0;
        ArrayList<Integer> cau3 = (ArrayList<Integer>) uniqueArrayList.clone();
        for (int i: cau3) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println();

        // 4
        System.out.println("Câu 4: ");
        ArrayList<Integer> cau4 = (ArrayList<Integer>) uniqueArrayList.clone();
        cau4.add(2406);
        printArray(cau4);
        System.out.println();

        // 5
        System.out.println("Câu 5: ");
        ArrayList<Integer> cau5 = (ArrayList<Integer>) uniqueArrayList.clone();
        cau5.add(0, 2406);
        printArray(cau5);
        System.out.println();

        // 6
        System.out.println("Câu 6: ");
        ArrayList<Integer> cau6 = (ArrayList<Integer>) uniqueArrayList.clone();
        ArrayList<Integer> divided13 = new ArrayList<>();
        for (int i = 13; i < 100; i+= 13) {
            divided13.add(i);
            if (divided13.size() == 3) {
                break;
            }
        }
        int middleIndex = cau6.size() / 2;
        cau6.addAll(middleIndex, divided13);
        printArray(cau6);
        System.out.println();

        // 7
        System.out.println("Câu 7: ");
        ArrayList<Integer> cau7 = (ArrayList<Integer>) flattenedArray_1.clone();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < cau7.size(); i++) {
            tempArray.add(cau7.get(i));
            if (tempArray.size() == 2 || i == cau7.size() - 1) {
                result.add((ArrayList<Integer>) tempArray.clone());
                tempArray.clear();
            }
        }
        System.out.print("[");
        for (ArrayList<Integer> childArray :result) {
            System.out.print(" [");
            for (int i = 0; i < childArray.size(); i++) {
                System.out.print(childArray.get(i));
                if (i != childArray.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("] ");
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printArray(ArrayList<Integer> arrayList) {
        for (int i: arrayList) {
            System.out.print(i  + " ");
        }
        System.out.println();
    }

}
