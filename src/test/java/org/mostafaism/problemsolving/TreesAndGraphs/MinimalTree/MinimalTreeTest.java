package org.mostafaism.problemsolving.TreesAndGraphs.MinimalTree;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.TreesAndGraphs.Extras.Traversal.InOrderTraversal;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;;

public class MinimalTreeTest {
    /*
     * Testing strategy for {@code BinaryTreeNode<Integer> minimalTree(int[]
     * numbers)}
     * 
     * Cover the subdomains of these partitions:
     * 
     * Partition on numbers.length: 0, !0
     * 
     * Partition on numbers.length: 1, !1
     * 
     * Partition on numbers.length: 2, !2
     * 
     * Partition on numbers.length: 3, !3
     */

    private MinimalTree minimalTree;
    private int[] numbers;
    private InOrderTraversal<Integer> inOrderTraversal;
    private List<Integer> actual;

    @BeforeEach
    void setup() {
        minimalTree = new MinimalTree();
        inOrderTraversal = new InOrderTraversal<>();
    }

    /*
     * Covers: numbers.length = 0, numbers.length != 1, numbers.length != 2,
     * numbers.length != 3
     */
    @Test
    void givenAnArrayOfLengthZero_thenShouldReturnNull() {
        // Given.
        numbers = new int[0];

        // When.
        BinaryTreeNode<Integer> actual = minimalTree.minimalTree(numbers);

        // Then.
        then(actual).isNull();
    }

    /*
     * Covers: numbers.length != 0, numbers.length = 1, numbers.length != 2,
     * numbers.length != 3
     */
    @Test
    void givenAnArrayOfLengthOne_thenShouldReturnAValidABinaryTree() {
        // Given.
        numbers = new int[1];
        numbers[0] = 0;

        // When.
        BinaryTreeNode<Integer> root = minimalTree.minimalTree(numbers);
        actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual).isEqualTo(Arrays.asList(numbers));
    }

    /*
     * Covers: numbers.length != 0, numbers.length != 1, numbers.length = 2,
     * numbers.length != 3
     */
    @Test
    void givenAnArrayOfLengthTwo_thenShouldReturnAValidABinaryTree() {
        // Given.
        numbers = new int[2];
        numbers[0] = 0;
        numbers[1] = 1;

        // When.
        BinaryTreeNode<Integer> root = minimalTree.minimalTree(numbers);
        actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual).isEqualTo(Arrays.asList(numbers));
    }

    /*
     * Covers: numbers.length != 0, numbers.length != 1, numbers.length != 2,
     * numbers.length = 3
     */
    @Test
    void givenAnArrayOfLengthThree_thenShouldReturnAValidABinaryTree() {
        // Given.
        numbers = new int[3];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;

        // When.
        BinaryTreeNode<Integer> root = minimalTree.minimalTree(numbers);
        actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual).isEqualTo(Arrays.asList(numbers));
    }
}
