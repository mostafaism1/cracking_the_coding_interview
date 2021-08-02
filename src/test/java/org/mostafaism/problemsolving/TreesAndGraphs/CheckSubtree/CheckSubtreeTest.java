package org.mostafaism.problemsolving.TreesAndGraphs.CheckSubtree;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class CheckSubtreeTest {
    /*
     * Testing strategy for {@code boolean checkSubtree(BinaryTreeNode<E> root1,
     * BinaryTreeNode<E> root2)}
     * 
     * Cover the cross product of these partitions:
     * 
     * Partition on root1.height: null, 0, 1, > 1
     * 
     * Partition on root2 intersect root1: null, root1, root1.left, root2.right,
     * some node in root1.left subtree, some node in root1.right subtree
     * 
     */

    private CheckSubtree<Integer> checkSubtree;
    private BinaryTreeNode<Integer> root1;
    private BinaryTreeNode<Integer> root2;

    @BeforeEach
    void setup() {
        checkSubtree = new CheckSubtree<>();
    }

    // Covers: root1.height = null, root2 intersect root1 = root1.
    @Test
    void given_root1_is_null_and_root2_is_null_then_should_return_true() {
        // Given.
        root1 = null;
        root2 = null;

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height = null, root2 intersect root1 = root1.
    @Test
    void given_root1_is_null_and_root2_is_not_null_then_should_return_false() {
        // Given.
        root1 = null;
        root2 = new BinaryTreeNode<>(0, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isFalse();
    }

    // Covers: root1.height = 0, root2 intersect root1 = null.
    @Test
    void given_root1_height_is_zero_and_root2_intersect_root1_is_null_then_should_return_false() {
        // Given.
        root1 = new BinaryTreeNode<>(0, null, null);
        root2 = new BinaryTreeNode<>(1, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isFalse();
    }

    // Covers: root1.height = 0, root2 intersect root1 = root1.
    @Test
    void given_root1_height_is_zero_and_root2_intersect_root1_is_root1_then_should_return_true() {
        // Given.
        root1 = new BinaryTreeNode<>(0, null, null);
        root2 = new BinaryTreeNode<>(0, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height = 1, root2 intersect root1 = null.
    @Test
    void given_root1_height_is_one_and_root2_intersect_root1_is_null_then_should_return_false() {
        // Given.
        var root1Left = new BinaryTreeNode<>(1, null, null);
        var root1Right = new BinaryTreeNode<>(2, null, null);
        root1 = new BinaryTreeNode<>(0, root1Left, root1Right);
        root2 = new BinaryTreeNode<>(0, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isFalse();
    }

    // Covers: root1.height = 1, root2 intersect root1 = root1.
    @Test
    void given_root1_height_is_one_and_root2_intersect_root1_is_root1_then_should_return_true() {
        // Given.
        var root1Left = new BinaryTreeNode<>(1, null, null);
        var root1Right = new BinaryTreeNode<>(2, null, null);
        root1 = new BinaryTreeNode<>(0, root1Left, root1Right);
        var root2Left = new BinaryTreeNode<>(1, null, null);
        var root2Right = new BinaryTreeNode<>(2, null, null);
        root2 = new BinaryTreeNode<>(0, root2Left, root2Right);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height = 1, root2 intersect root1 = root1.left.
    @Test
    void given_root1_height_is_one_and_root2_intersect_root1_is_root1_left_child_then_should_return_true() {
        // Given.
        var root1Left = new BinaryTreeNode<>(1, null, null);
        var root1Right = new BinaryTreeNode<>(2, null, null);
        root1 = new BinaryTreeNode<>(0, root1Left, root1Right);
        root2 = new BinaryTreeNode<>(1, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height = 1, root2 intersect root1 = root1.right.
    @Test
    void given_root1_height_is_one_and_root2_intersect_root1_is_root1_right_child_then_should_return_true() {
        // Given.
        var root1Left = new BinaryTreeNode<>(1, null, null);
        var root1Right = new BinaryTreeNode<>(2, null, null);
        root1 = new BinaryTreeNode<>(0, root1Left, root1Right);
        root2 = new BinaryTreeNode<>(2, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height > 1, root2 intersect root1 = null.
    @Test
    void given_root1_height_is_two_and_root2_intersect_root1_is_null_then_should_return_false() {
        // Given.
        var root1LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root1LeftRight = new BinaryTreeNode<>(1, null, null);
        var root1RightLeft = new BinaryTreeNode<>(2, null, null);
        var root1RightRight = new BinaryTreeNode<>(3, null, null);
        var root1Left = new BinaryTreeNode<>(4, root1LeftLeft, root1LeftRight);
        var root1Right = new BinaryTreeNode<>(5, root1RightLeft, root1RightRight);
        root1 = new BinaryTreeNode<>(6, root1Left, root1Right);
        var root2Left = new BinaryTreeNode<>(4, null, null);
        var root2Right = new BinaryTreeNode<>(5, null, null);
        root2 = new BinaryTreeNode<Integer>(6, root2Left, root2Right);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isFalse();
    }

    // Covers: root1.height > 1, root2 intersect root1 = root1.
    @Test
    void given_root1_height_is_two_and_root2_intersect_root1_is_root1_then_should_return_true() {
        // Given.
        var root1LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root1LeftRight = new BinaryTreeNode<>(1, null, null);
        var root1RightLeft = new BinaryTreeNode<>(2, null, null);
        var root1RightRight = new BinaryTreeNode<>(3, null, null);
        var root1Left = new BinaryTreeNode<>(4, root1LeftLeft, root1LeftRight);
        var root1Right = new BinaryTreeNode<>(5, root1RightLeft, root1RightRight);
        root1 = new BinaryTreeNode<Integer>(6, root1Left, root1Right);
        var root2LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root2LeftRight = new BinaryTreeNode<>(1, null, null);
        var root2RightLeft = new BinaryTreeNode<>(2, null, null);
        var root2RightRight = new BinaryTreeNode<>(3, null, null);
        var root2Left = new BinaryTreeNode<>(4, root2LeftLeft, root2LeftRight);
        var root2Right = new BinaryTreeNode<>(5, root2RightLeft, root2RightRight);
        root2 = new BinaryTreeNode<Integer>(6, root2Left, root2Right);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height > 1, root2 intersect root1 = root1.left.
    @Test
    void given_root1_height_is_two_and_root2_intersect_root1_is_root1_left_child_then_should_return_true() {
        // Given.
        var root1LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root1LeftRight = new BinaryTreeNode<>(1, null, null);
        var root1RightLeft = new BinaryTreeNode<>(2, null, null);
        var root1RightRight = new BinaryTreeNode<>(3, null, null);
        var root1Left = new BinaryTreeNode<>(4, root1LeftLeft, root1LeftRight);
        var root1Right = new BinaryTreeNode<>(5, root1RightLeft, root1RightRight);
        root1 = new BinaryTreeNode<Integer>(6, root1Left, root1Right);
        var root2Left = new BinaryTreeNode<>(0, null, null);
        var root2Right = new BinaryTreeNode<>(1, null, null);
        root2 = new BinaryTreeNode<Integer>(4, root2Left, root2Right);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height > 1, root2 intersect root1 = root1.right.
    @Test
    void given_root1_height_is_two_and_root2_intersect_root1_is_root1_right_child_then_should_return_true() {
        // Given.
        var root1LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root1LeftRight = new BinaryTreeNode<>(1, null, null);
        var root1RightLeft = new BinaryTreeNode<>(2, null, null);
        var root1RightRight = new BinaryTreeNode<>(3, null, null);
        var root1Left = new BinaryTreeNode<>(4, root1LeftLeft, root1LeftRight);
        var root1Right = new BinaryTreeNode<>(5, root1RightLeft, root1RightRight);
        root1 = new BinaryTreeNode<Integer>(6, root1Left, root1Right);
        var root2Left = new BinaryTreeNode<>(2, null, null);
        var root2Right = new BinaryTreeNode<>(3, null, null);
        root2 = new BinaryTreeNode<Integer>(5, root2Left, root2Right);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height > 1, root2 intersect root1 = some node in root1.left
    // subtree.
    @Test
    void given_root1_height_is_two_and_root2_intersect_root1_is_some_node_in_root1_left_child_subtree_then_should_return_true() {
        // Given.
        var root1LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root1LeftRight = new BinaryTreeNode<>(1, null, null);
        var root1RightLeft = new BinaryTreeNode<>(2, null, null);
        var root1RightRight = new BinaryTreeNode<>(3, null, null);
        var root1Left = new BinaryTreeNode<>(4, root1LeftLeft, root1LeftRight);
        var root1Right = new BinaryTreeNode<>(5, root1RightLeft, root1RightRight);
        root1 = new BinaryTreeNode<Integer>(6, root1Left, root1Right);
        root2 = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }

    // Covers: root1.height > 1, root2 intersect root1 = some node in root1.right
    // subtree.
    @Test
    void given_root1_height_is_two_and_root2_intersect_root1_is_some_node_in_root1_right_child_subtree_then_should_return_true() {
        // Given.
        var root1LeftLeft = new BinaryTreeNode<>(0, null, null);
        var root1LeftRight = new BinaryTreeNode<>(1, null, null);
        var root1RightLeft = new BinaryTreeNode<>(2, null, null);
        var root1RightRight = new BinaryTreeNode<>(3, null, null);
        var root1Left = new BinaryTreeNode<>(4, root1LeftLeft, root1LeftRight);
        var root1Right = new BinaryTreeNode<>(5, root1RightLeft, root1RightRight);
        root1 = new BinaryTreeNode<Integer>(6, root1Left, root1Right);
        root2 = new BinaryTreeNode<Integer>(3, null, null);

        // When.
        boolean actual = checkSubtree.checkSubtree(root1, root2);

        // Then.
        then(actual).isTrue();
    }
}
