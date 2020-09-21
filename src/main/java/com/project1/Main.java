package com.project1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter row size: ");
            int row = scanner.nextInt();

            System.out.println("Enter column size: ");
            int column = scanner.nextInt();
            if (row == 0 || column == 0) {
                throw new Exception("Zero size");
            }
            int[][] matrix = createRandomMatrix(row, column);
            System.out.print("Original matrix:\n");
            matrixPrinting(matrix);

            sortMatrixByNonDecreasingSums(matrix);
            System.out.print("Sorted matrix:\n");
            matrixPrinting(matrix);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void matrixPrinting(int[][] matrix) {
        for (int[] line : matrix) {
            for (int elem : line) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static int[][] createRandomMatrix(int row, int column) {
        int[][] matrix = new int[row][column];
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(20);
            }
        }
        return matrix;
    }

    static void sortMatrixByNonDecreasingSums(int[][] matrix) {
        int[] arrayOfSums = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            arrayOfSums[i] = countSumOfElementsInLine(matrix[i]);
        }
        for (int i = arrayOfSums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayOfSums[j] >= arrayOfSums[j + 1]) {
                    swapMatrixLines(matrix, j, j + 1);
                    int temp = arrayOfSums[j];
                    arrayOfSums[j] = arrayOfSums[j + 1];
                    arrayOfSums[j + 1] = temp;
                }
            }
        }
    }

    static int countSumOfElementsInLine(int[] line) {
        int sum = 0;
        for (int elem : line) {
            sum += elem;
        }
        return sum;
    }

    static void swapMatrixLines(int[][] matrix,
                                int realIndex, int expectedIndex) {
        for (int i = 0; i < matrix.length - 1; i++) {
            int temp = matrix[realIndex][i];
            matrix[realIndex][i] = matrix[expectedIndex][i];
            matrix[expectedIndex][i] = temp;
        }
    }
}
