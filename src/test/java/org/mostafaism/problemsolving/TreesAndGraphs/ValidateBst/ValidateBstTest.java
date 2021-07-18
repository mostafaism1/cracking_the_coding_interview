package org.mostafaism.problemsolving.TreesAndGraphs.ValidateBst;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class ValidateBstTest {
    /*
     * Testing strategy for {@code boolean validateBst(BinaryTreeNode<E> root)}
     * 
     * Cover the cross product of these partitions:
     * 
     * Partition on tree height: 0, > 0
     * 
     * Partition on tree is degenerate: true, false
     * 
     * Partition on tree is perfect: true, false
     * 
     * Partition on tree is BST: true, false
     */

    private ValidateBst<Integer> validateBst;
    private BinaryTreeNode<Integer> root;

    @BeforeEach
    void setup() {
        validateBst = new ValidateBst<>();
    }

    // Covers: height = 0, degenerate = false, perfect = true, BST = true.
    @Test
    void givenABinaryTreeOfHeightZero_thenShouldReturnTrue() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        boolean actual = validateBst.validateBst(root);

        // Then.
        then(actual).isTrue();
    }

    // Covers height = 1, degenerate = false, perfect = true, BST = false.
    @Test
    void givenAPerfectAndNonBinarySearchBinaryTreeOfHeightOne_thenShouldReturnFalse() {
        // Given.
        var node2 = new BinaryTreeNode<>(2, null, null);
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node2, node1);

        // When.
        boolean actual = validateBst.validateBst(root);

        // Then.
        then(actual).isFalse();
    }

    // Covers height = 1, degenerate = false, perfect = true, BST = true.
    @Test
    void givenAPerfectAndBinarySearchBinaryTreeOfHeightOne_thenShouldReturnTrue() {
        // Given.
        var node2 = new BinaryTreeNode<>(2, null, null);
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        boolean actual = validateBst.validateBst(root);

        // Then.
        then(actual).isFalse();
    }

    // Covers height = 1, degenerate = true, perfect = false, BST = false.
    @Test
    void givenADegenerateAndNonBinarySearchBinaryTreeOfHeightOne_thenShouldReturnFalse() {
        // Given.
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, null);

        // When.
        boolean actual = validateBst.validateBst(root);

        // Then.
        then(actual).isFalse();
    }

    // Covers height = 1, degenerate = true, perfect = false, BST = true.
    @Test
    void givenADegenerateAndBinarySearchBinaryTreeOfHeightOne_thenShouldReturnTrue() {
        // Given.
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, null, node1);

        // When.
        boolean actual = validateBst.validateBst(root);

        // Then.
        then(actual).isTrue();
    }
}
