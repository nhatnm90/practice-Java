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
        * PRACTICE: Print all the element of array with the comma as separator and end with the dot.
        */

        System.out.println();

        System.out.println("C1: The list element of array by flattening a complex array to a simple array: ");

        /*
        Instead of looping through the array of array, we can flat it to a simple array
        array = [[a, b, c], [d, e, f]];
        ->
        flattenArray = [a, b, c, d, e, f];
        */

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

        /*
        Looping through the Array of array, within each time, looping through the array to print the element
        Using 2 variables due to using 2 loop:
        - 1 variable to detect last array in array of array (countArray)
        - 1 variable to detect last element in last array and print the dot to end (countElement)
        */

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

    }

}
