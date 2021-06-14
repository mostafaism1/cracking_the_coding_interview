package org.mostafaism.problemsolving.ArraysAndStrings.ZeroMatrix;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZeroMatrixTest {

    private ZeroMatrix zeroMatrix;

    @BeforeEach
    void setup() {
        zeroMatrix = new ZeroMatrix();
    }

    @Test
    void it_should_do_nothing_when_matrix_is_1_by_1_and_not_zero() {
        // given
        int[][] matrix = { { 1 } };
        int[][] expected = { { 1 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_do_nothing_when_matrix_is_1_by_1_and_zero() {
        // given
        int[][] matrix = { { 0 } };
        int[][] expected = { { 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_do_nothing_when_matrix_is_1_by_2_and_does_not_contain_a_zero() {
        // given
        int[][] matrix = { { 1, 2 } };
        int[][] expected = { { 1, 2 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_all_elements_when_matrix_is_1_by_2_and_contains_a_zero_at_row_1_column_2() {
        // given
        int[][] matrix = { { 1, 0 } };
        int[][] expected = { { 0, 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_all_elements_when_matrix_is_1_by_2_and_contains_a_zero_at_row_1_column_1() {
        // given
        int[][] matrix = { { 0, 1 } };
        int[][] expected = { { 0, 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_do_nothing_when_matrix_is_2_by_1_and_does_not_contain_a_zero() {
        // given
        int[][] matrix = { { 1 }, { 2 } };
        int[][] expected = { { 1 }, { 2 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_all_elements_when_matrix_is_2_by_1_and_contains_a_zero_at_row_2_column_1() {
        // given
        int[][] matrix = { { 1 }, { 0 } };
        int[][] expected = { { 0 }, { 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_all_elements_when_matrix_is_2_by_1_and_contains_a_zero_at_row_1_column_1() {
        // given
        int[][] matrix = { { 0 }, { 1 } };
        int[][] expected = { { 0 }, { 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_do_nothing_when_matrix_is_2_by_2_and_does_not_contain_a_zero() {
        // given
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int[][] expected = { { 1, 2 }, { 3, 4 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_some_elements_when_matrix_is_2_by_2_and_contains_a_zero_at_row_1_column_1() {
        // given
        int[][] matrix = { { 0, 1 }, { 2, 3 } };
        int[][] expected = { { 0, 0 }, { 0, 3 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_some_elements_when_matrix_is_2_by_2_and_contains_a_zero_at_row_1_column_2() {
        // given
        int[][] matrix = { { 1, 0 }, { 2, 3 } };
        int[][] expected = { { 0, 0 }, { 2, 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_some_elements_when_matrix_is_2_by_2_and_contains_a_zero_at_row_2_column_1() {
        // given
        int[][] matrix = { { 1, 2 }, { 0, 3 } };
        int[][] expected = { { 0, 2 }, { 0, 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

    @Test
    void it_should_zero_some_elements_when_matrix_is_2_by_2_and_contains_a_zero_at_row_2_column_2() {
        // given
        int[][] matrix = { { 1, 2 }, { 3, 0 } };
        int[][] expected = { { 1, 0 }, { 0, 0 } };

        // when
        zeroMatrix.zeroMatrix(matrix);

        // then
        then(matrix).isEqualTo(expected);
    }

}
