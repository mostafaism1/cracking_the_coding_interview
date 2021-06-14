package org.mostafaism.problemsolving.ArraysAndStrings.ZeroMatrix;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public void zeroMatrix(int[][] matrix) {
        Set<Integer> zeroRows = getRowsWithAZeroElement(matrix);
        Set<Integer> zeroColumns = getColumnsWithAZeroElement(matrix);
        zeroEntireRows(matrix, zeroRows);
        zeroEntireColumns(matrix, zeroColumns);
    }

    private Set<Integer> getRowsWithAZeroElement(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    continue;
                }
            }
        }
        return zeroRows;
    }

    private Set<Integer> getColumnsWithAZeroElement(int[][] matrix) {
        Set<Integer> zeroColumns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroColumns.add(j);
                    continue;
                }
            }
        }
        return zeroColumns;
    }

    private void zeroEntireRows(int[][] matrix, Set<Integer> zeroRows) {
        for (Integer row : zeroRows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }

    private void zeroEntireColumns(int[][] matrix, Set<Integer> zeroColumns) {
        for (Integer column : zeroColumns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

}
