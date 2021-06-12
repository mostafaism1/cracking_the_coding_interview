package org.mostafaism.problemsolving.ArraysAndStrings.RotateMatrix;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RotateMatrixTest {

    private RotateMatrix rotateMatrix;

    @BeforeEach
    void setup() {
        rotateMatrix = new RotateMatrix();
    }

    @Test
    void it_should_not_do_anything_when_matrix_empty() {
        // given
        int[][] matrix = {};
        int[][] expected = {};

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_not_do_anything_when_matrix_is_1_by_1() {
        // given
        int[][] matrix = { { 1 } };
        int[][] expected = { { 1 } };

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_rotate_when_matrix_is_2_by_2() {
        // given
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int[][] expected = { { 3, 1 }, { 4, 2 } };

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_rotate_when_matrix_is_3_by_3() {
        // given
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_rotate_when_matrix_is_4_by_4() {
        // given
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[][] expected = { { 13, 9, 5, 1 }, { 14, 10, 6, 2 }, { 15, 11, 7, 3 }, { 16, 12, 8, 4 } };

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_rotate_when_matrix_is_5_by_5() {
        // given
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        int[][] expected = { { 21, 16, 11, 6, 1 }, { 22, 17, 12, 7, 2 }, { 23, 18, 13, 8, 3 }, { 24, 19, 14, 9, 4 },
                { 25, 20, 15, 10, 5 } };

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_rotate_when_matrix_is_6_by_6() {
        // given
        int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 }, { 31, 32, 33, 34, 35, 36 } };
        int[][] expected = { { 31, 25, 19, 13, 7, 1 }, { 32, 26, 20, 14, 8, 2 }, { 33, 27, 21, 15, 9, 3 },
                { 34, 28, 22, 16, 10, 4 }, { 35, 29, 23, 17, 11, 5 }, { 36, 30, 24, 18, 12, 6 } };

        // when
        rotateMatrix.rotateMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

}
