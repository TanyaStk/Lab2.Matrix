package com.project1;

import static com.project1.Main.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @org.junit.jupiter.api.Test
    void testSortingWithRandomNumbers() {
        int[][] actualMatrix = new int[][]{{4, 9, 1}, {5, 10, 0}, {2, 7, 9}, {5, 3, 2}};
        sortMatrixByNonDecreasingSums(actualMatrix);
        int[][] expectedMatrix = new int[][]{{5, 3, 2}, {4, 9, 1}, {5, 10, 0}, {2, 7, 9}};
        for (int i = 0; i < actualMatrix.length; i++) {
            for (int j = 0; j < actualMatrix[i].length; j++) {
                assertEquals(actualMatrix[i][j], expectedMatrix[i][j]);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void testSortingWithEqualLines() {
        int[][] actualMatrix = new int[][]{{0, 0, 0}, {5, 10, 0}, {0, 0, 0}};
        sortMatrixByNonDecreasingSums(actualMatrix);
        int[][] expectedMatrix = new int[][]{{0, 0, 0}, {0, 0, 0}, {5, 10, 0}};
        for (int i = 0; i < actualMatrix.length; i++) {
            for (int j = 0; j < actualMatrix[i].length; j++) {
                assertEquals(actualMatrix[i][j], expectedMatrix[i][j]);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void testCountSumOfElementsInLine() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int expected = 15;
        int actual = countSumOfElementsInLine(array);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testSwapMatrixLines() {
        int[][] actualMatrix = new int[][]{{1, 1, 1}, {1, 1, 1}, {0, 0, 0}, {2, 2, 2}};
        swapMatrixLines(actualMatrix, 0, 2);
        int[][] expectedMatrix = new int[][]{{0, 0, 0}, {1, 1, 1}, {1, 1, 1}, {2, 2, 2}};
        for (int i = 0; i < actualMatrix.length; i++) {
            for (int j = 0; j < actualMatrix[i].length; j++) {
                assertEquals(actualMatrix[i][j], expectedMatrix[i][j]);
            }
        }
    }
}
