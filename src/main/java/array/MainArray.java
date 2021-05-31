package array;

import java.util.ArrayList;
import java.util.List;


public class MainArray {
    public static void dash() {
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        int[] firstArray = new int[]{ 2, 4, 0, 6 };

        int[] secondArray = new int[]{ 2, 1, 0, 1 };

        int[] thirdArray = new int[]{ 0, 8, 0, 8, 2, 0, 1, 8 };

        List<int []> joinedArray = new ArrayList<>();

        joinedArray.add(firstArray);
        joinedArray.add(secondArray);
        joinedArray.add(thirdArray);

        System.out.println("The number of array: " + joinedArray.size());

        System.out.println("The number of first array: " + firstArray.length);

        /*
        * Print all the element of array with the comma as separator and end with the dot.
        */

        List<Integer> flattenArray = new ArrayList<>();
        for (int[] arr: joinedArray) {
            for (int arrElement : arr) {
                flattenArray.add(arrElement);
            }
        }

        System.out.println("The list element of array by FOR: ");
        for (int i = 0; i < flattenArray.size(); i++) {
            System.out.print(flattenArray.get(i));
            if (i == flattenArray.size() - 1) {
                System.out.println(". ");
            } else {
                System.out.print(", ");
            }
        }

        System.out.println("C1: The list element of array by FOREACH: ");
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

        System.out.println("C2: The list element of array by FOREACH: ");
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

    }

}
