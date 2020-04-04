package com.siit.homework.course3;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int r1;
        int r2;
        int c1;
        int c2;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter number rows for matrix 1:");
        r1 = in.nextInt();

        System.out.println("Enter columns rows for matrix 1:");
        c1 = in.nextInt();
        System.out.println("Enter number rows for matrix 2:");
        r2 = in.nextInt();

        System.out.println("Enter columns rows of matrix 2");
        c2 = in.nextInt();
        matrixMultiplication(r1, c1, r2, c2);
    }

    public static void matrixMultiplication(
            int r1,
            int c1,
            int r2,
            int c2
    ) {
        int i;
        int j;
        int k;
        int sum;

        Scanner in = new Scanner(System.in);

        if (c1 != r2) {
            System.out.print("Multiplication does not exist ");
            return;
        }

        int[][] mat1 = new int[r1][c1];
        int[][] mat2 = new int[r2][c2];
        int[][] res = new int[r1][c2];

        System.out.println("Enter the elements of matrix1");

        for (i = 0; i < r1; i++) {

            for (j = 0; j < c1; j++)
                mat1[i][j] = in.nextInt();

        }
        System.out.println("Enter the elements of matrix2");

        for (i = 0; i < r2; i++) {

            for (j = 0; j < c2; j++)
                mat2[i][j] = in.nextInt();

        }

        System.out.println("\n\n Output matrix:");

        for (i = 0; i < r1; i++) {
            for (j = 0; j < c2; j++) {
                sum = 0;
                for (k = 0; k < r2; k++) {
                    sum += mat1[i][k] * mat2[k][j];

                }
                res[i][j] = sum;
            }
        }

        for (i = 0; i < r1; i++) {
            for (j = 0; j < c2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
