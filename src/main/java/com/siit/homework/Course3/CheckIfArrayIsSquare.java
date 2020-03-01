package com.siit.homework.Course3;

import java.util.Arrays;

public class CheckIfArrayIsSquare {
// Check if array is square.
    public static void main(String[] args) {
        int[][] array1 = {
                {4, 4, 3},
                {5, 7, 4},
                {7, 8, 9}
        };

        int[][] array2 = {
                {4},
                {5, 7, 4},
                {7, 8}
        };

        boolean responseForFirstArray = isSquare(array1);
        boolean responseForSecondArray = isSquare(array2);
        System.out.println("Array1 " + Arrays.deepToString(array1) + " square result: " + responseForFirstArray);
        System.out.println("Array2 " + Arrays.deepToString(array2) + " square result: " + responseForSecondArray);
    }

    public static boolean isSquare(int[][] array) {
        for (int[] value : array) {
            if (value.length != array.length) {
                return false;
            }
        }
        return true;
    }
}
