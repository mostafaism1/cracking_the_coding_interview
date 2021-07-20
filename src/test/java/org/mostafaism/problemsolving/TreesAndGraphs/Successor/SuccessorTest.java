package org.mostafaism.problemsolving.TreesAndGraphs.Successor;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class SuccessorTest {
    /*
     * Testing strategy for {@code <E> BinaryTreeNode<E> successor(BinaryTreeNode<E>
     * node)}
     * 
     * Cover the sub-domains of these partitions:
     * 
     * Partition on left sub-tree height: null, 0, > 0
     * 
     * Partition on right sub-tree height: null, 0, > 0
     * 
     * Partition on tree is degenerate: true, false
     * 
     * Partition on tree is perfect: true, false
     */

    private Successor successor;
    private BinaryTreeNode<Integer> root;

    @BeforeEach
    void setup() {
        successor = new Successor();
    }

    @Test
    void givenATreeOfHeightZero_thenShouldReturnNull() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        BinaryTreeNode<Integer> actual = successor.successor(root);

        // Then.
        then(actual).isNull();
        ;
    }

    // Covers: left sub-tree is null, right sub-tree height > 0, degenerate = true,
    // perfect = false.
    @Test
    void givenARightDegenerateTreeOfHeightOne_thenShouldReturnTheRightNode() {
        // Given.
        var right = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, null, right);

        // When.
        BinaryTreeNode<Integer> actual = successor.successor(root);

        // Then.
        then(actual).isEqualTo(right);
    }

    // Covers: left sub-tree height > 0, right sub-tree is null, degenerate = true,
    // perfect = false.
    @Test
    void givenALeftDegenerateTreeOfHeightOne_thenShouldReturnNull() {
        // Given.
        var left = new BinaryTreeNode<>(0, null, null);
        root = new BinaryTreeNode<Integer>(1, left, null);

        // When.
        BinaryTreeNode<Integer> actual = successor.successor(root);

        // Then.
        then(actual).isNull();
    }

    // Covers: left sub-tree height > 0, right sub-tree height > 0, degenerate =
    // false, perfect = true.
    @Test
    void givenAPerfectTreeOfHeightOne_thenShouldReturnTheRightNode() {
        // Given.
        var left = new BinaryTreeNode<>(0, null, null);
        var right = new BinaryTreeNode<>(2, null, null);
        root = new BinaryTreeNode<Integer>(1, left, right);

        // When.
        BinaryTreeNode<Integer> actual = successor.successor(root);

        // Then.
        then(actual).isEqualTo(right);
    }

    // Covers: left sub-tree height > 0, right sub-tree > 0, degenerate = false,
    // perfect = false.
    @Test
    void givenATreeWithALeftSubtreeOfHeightZeroAndRightSubtreeOfHeightOne_thenShouldReturnTheRightLeftNode() {
        // Given.
        var rightRight = new BinaryTreeNode<>(4, null, null);
        var rightLeft = new BinaryTreeNode<>(2, null, null);
        var right = new BinaryTreeNode<>(3, rightLeft, rightRight);
        var left = new BinaryTreeNode<>(0, null, null);
        root = new BinaryTreeNode<Integer>(1, left, right);

        // When.
        BinaryTreeNode<Integer> actual = successor.successor(root);

        // Then.
        then(actual).isEqualTo(rightLeft);
    }

    // Covers: left sub-tree height is null, right sub-tree height is null,
    // degenerate = false, perfect = true.
    @Test
    void givenATreeWithALeftSubtreeOfHeightOneAndRightSubtreeOfHeightZero_thenShouldReturnTheRightNode() {
        // Given.
        var leftLeft = new BinaryTreeNode<>(0, null, null);
        var leftRight = new BinaryTreeNode<>(2, null, null);
        var left = new BinaryTreeNode<>(1, leftLeft, leftRight);
        var right = new BinaryTreeNode<>(4, null, null);
        root = new BinaryTreeNode<Integer>(3, left, right);

        // When.
        BinaryTreeNode<Integer> actual = successor.successor(root);

        // Then.
        then(actual).isEqualTo(right);
    }
}
