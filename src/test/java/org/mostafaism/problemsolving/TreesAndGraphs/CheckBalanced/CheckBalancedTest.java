package org.mostafaism.problemsolving.TreesAndGraphs.CheckBalanced;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class CheckBalancedTest {
    /*
     * Testing strategy for {@code boolean checkBalanced(BinaryTreeNode<?> root)}
     * 
     * Cover the cross product of these partitions:
     * 
     * Partition on tree height: 0, > 0
     * 
     * Partition on tree is degenerate: true, false
     * 
     * Partition on tree is perfect: true, false
     * 
     * Partition on tree is balanced: true, false
     */

    private CheckBalanced checkBalanced;
    BinaryTreeNode<Integer> root;

    @BeforeEach
    void setup() {
        checkBalanced = new CheckBalanced();
    }

    /*
     * Covers: height = 0, degenerate = false, perfect = true, balanced = true
     */
    @Test
    void givenATreeOfHeightZero_thenShouldReturnTrue() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        boolean actual = checkBalanced.checkBalanced(root);

        // Then.
        then(actual).isTrue();
    }

    /*
     * Covers: height > 0, degenerate = false, perfect = true, balanced = true
     */
    @Test
    void givenAPerfectTreeOfHeightOne_thenShouldReturnTrue() {
        // Given.
        var node2 = new BinaryTreeNode<>(2, null, null);
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        boolean actual = checkBalanced.checkBalanced(root);

        // Then.
        then(actual).isTrue();
    }

    /*
     * Covers: height > 0, degenerate = true, perfect = false, balanced = true
     */
    @Test
    void givenADegenerateTreeOfHeightOne_thenShouldReturnTrue() {
        // Given.
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, null);

        // When.
        boolean actual = checkBalanced.checkBalanced(root);

        // Then.
        then(actual).isTrue();
    }

    /*
     * Covers: height > 0, degenerate = true, perfect = false, balanced = false
     */
    @Test
    void givenADegenerateTreeOfHeightTwo_thenShouldReturnFalse() {
        // Given.
        var node2 = new BinaryTreeNode<>(2, null, null);
        var node1 = new BinaryTreeNode<>(1, node2, null);
        root = new BinaryTreeNode<Integer>(0, node1, null);

        // When.
        boolean actual = checkBalanced.checkBalanced(root);

        // Then.
        then(actual).isFalse();
    }

    /*
     * Covers: height > 0, degenerate = false, perfect = false, balanced = false
     */
    @Test
    void givenANonDegenerateAndNonPerfectAndUnBalancedTreeOfHeightTwo_thenShouldReturnFalse() {
        // Given.
        var node3 = new BinaryTreeNode<>(3, null, null);
        var node2 = new BinaryTreeNode<>(2, null, null);
        var node1 = new BinaryTreeNode<>(1, node2, node3);
        root = new BinaryTreeNode<Integer>(0, node1, null);

        // When.
        boolean actual = checkBalanced.checkBalanced(root);

        // Then.
        then(actual).isFalse();
    }

    /*
     * Covers: height > 0, degenerate = false, perfect = false, balanced = true
     */
    @Test
    void givenANonDegenerateAndNonPerfectAndBalancedTreeOfHeightTwo_thenShouldReturnTrue() {
        // Given.
        var node3 = new BinaryTreeNode<>(3, null, null);
        var node2 = new BinaryTreeNode<>(2, null, node3);
        var node1 = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        boolean actual = checkBalanced.checkBalanced(root);

        // Then.
        then(actual).isTrue();
    }
}
