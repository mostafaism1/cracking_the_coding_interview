package org.mostafaism.problemsolving.TreesAndGraphs.PathsWithSum;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class PathsWithSumTest {
    /*
     * Testing strategy for {@code int pathsWithSum(BinaryTreeNode<Integer> root,
     * int sum)}
     * 
     * Cover the sub-domains of these partitions:
     * 
     * Partition on root is: null, not null
     * 
     * Partition on root.height: null, 0, 1, > 1
     * 
     * Partition on tree is degenerate: null, false, true
     */

    private PathsWithSum pathsWithSum;
    private BinaryTreeNode<Integer> root;

    @BeforeEach
    void setup() {
        pathsWithSum = new PathsWithSum();
    }

    // Covers: root = null, root.height = null, degenerate = null.
    @Test
    void given_an_empty_node_then_should_return_zero() {
        // Given.
        root = null;

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 0);

        // Then.
        then(paths).isZero();
    }

    // Covers: root != null, root.height = 0, degenerate = false.
    @Test
    void given_an_single_node_tree_and_a_sum_value_not_equal_to_the_root_value_then_should_return_zero() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 1);

        // Then.
        then(paths).isZero();
    }

    @Test
    void given_an_single_node_tree_and_a_sum_value_equal_to_the_root_value_then_should_return_one() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 0);

        // Then.
        then(paths).isOne();
    }

    // Covers: root != null, root.height = 1, degenerate = false.
    @Test
    void given_a_perfect_tree_of_height_one_and_a_sum_value_with_no_corresponding_path_then_should_return_zero() {
        // Given.
        var left = new BinaryTreeNode<Integer>(-1, null, null);
        var right = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(1, left, right);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 3);

        // Then.
        then(paths).isZero();
    }

    @Test
    void given_a_perfect_tree_of_height_one_and_a_sum_value_with_one_corresponding_path_then_should_return_one() {
        // Given.
        var left = new BinaryTreeNode<Integer>(-1, null, null);
        var right = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(1, left, right);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 3);

        // Then.
        then(paths).isZero();
    }

    @Test
    void given_a_perfect_tree_of_height_one_and_a_sum_value_with_two_corresponding_paths_then_should_return_two() {
        // Given.
        var left = new BinaryTreeNode<Integer>(1, null, null);
        var right = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(-1, left, right);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 0);

        // Then.
        then(paths).isEqualTo(2);
    }

    @Test
    void given_a_perfect_tree_of_height_one_and_a_sum_value_with_three_corresponding_paths_then_should_return_three() {
        // Given.
        var left = new BinaryTreeNode<Integer>(0, null, null);
        var right = new BinaryTreeNode<Integer>(0, null, null);
        root = new BinaryTreeNode<Integer>(1, left, right);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 1);

        // Then.
        then(paths).isEqualTo(3);
    }

    // Covers: root != null, root.height = 1, degenerate = true.
    @Test
    void given_a_degenerate_tree_of_height_one_and_a_sum_value_with_no_corresponding_paths_then_should_return_zero() {
        // Given.
        var left = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, left, null);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 2);

        // Then.
        then(paths).isZero();
    }

    @Test
    void given_a_degenerate_tree_of_height_one_and_a_sum_value_with_one_corresponding_paths_then_should_return_one() {
        // Given.
        var left = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, left, null);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 0);

        // Then.
        then(paths).isOne();
    }

    @Test
    void given_a_degenerate_tree_of_height_one_and_a_sum_value_with_two_corresponding_paths_then_should_return_two() {
        // Given.
        var left = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, left, null);

        // When.
        int paths = pathsWithSum.pathsWithSum(root, 1);

        // Then.
        then(paths).isEqualTo(2);
    }
}