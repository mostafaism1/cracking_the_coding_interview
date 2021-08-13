package org.mostafaism.problemsolving.datastructure.Tree.BinarySearchTree;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeNodeTest {
    /*
     * Testing strategy for {@code BinarySearchTreeNode<E extends Comparable<E>>}
     * 
     * Cover the sub-domains of these partitions:
     * 
     * Partition on isEmpty(): true, false
     * 
     * Partition on isLeaf(): true, false
     * 
     * Partition on left.isEmpty(): true, false
     * 
     * Partition on right.isEmpty(): true, false
     */

    private BinarySearchTreeNode<Integer> bstNode;

    // Covers: isEmpty() = true, isLeaf = false, left.isEmpty() = true,
    // right.isEmpty() = true.
    @Test
    void given_an_empty_node_then_data_should_throw_UnsupportedOperationException() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When, then.
        thenThrownBy(() -> bstNode.getData()).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void given_an_empty_node_then_weight_should_be_zero() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When.
        int weight = bstNode.getWeight();

        // Then.
        then(weight).isZero();
    }

    @Test
    void given_an_empty_node_then_left_should_be_empty() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When.
        var left = bstNode.getLeft();

        // Then.
        then(left.isEmpty()).isTrue();
    }

    @Test
    void given_an_empty_node_then_right_should_be_empty() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When.
        var right = bstNode.getRight();

        // Then.
        then(right.isEmpty()).isTrue();
    }

    @Test
    void given_an_empty_node_then_randomNode_should_be_empty() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When.
        var randomNode = bstNode.getRandomNode();

        // Then.
        then(randomNode.isEmpty()).isTrue();
    }

    @Test
    void given_an_empty_node_then_isLeaf_should_be_false() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When.
        boolean isLeaf = bstNode.isLeaf();

        // Then.
        then(isLeaf).isFalse();
    }

    @Test
    void given_an_empty_node_then_insert_should_throw_UnsupportedOperationException() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When, then.
        thenThrownBy(() -> bstNode.insert(0)).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void given_an_empty_node_then_delete_should_return_an_empty_node() {
        // Given.
        bstNode = BinarySearchTreeNode.empty();

        // When.
        var actual = bstNode.delete(BinarySearchTreeNode.singleton(0));

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    // Covers: isEmpty() = false, isLeaf = true, left.isEmpty() = true,
    // right.isEmpty() = true.
    @Test
    void given_a_singleton_node_then_weight_should_be_one() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        int weight = bstNode.getWeight();

        // Then.
        then(weight).isOne();
    }

    @Test
    void given_a_singleton_node_then_isEmpty_should_be_false() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        boolean isEmpty = bstNode.isEmpty();

        // Then.
        then(isEmpty).isFalse();
    }

    @Test
    void given_a_singleton_node_then_isLeaf_should_be_true() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        boolean isLeaf = bstNode.isLeaf();

        // Then.
        then(isLeaf).isTrue();
    }

    @Test
    void given_a_singleton_node_then_should_insert_smaller_node_on_the_left() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(1);

        // When.
        bstNode.insert(0);

        // Then.
        then(bstNode.getLeft().isEmpty()).isFalse();
        then(bstNode.getLeft().getData()).isEqualTo(0);
    }

    @Test
    void given_a_singleton_node_then_should_insert_an_equal_node_on_the_left() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        bstNode.insert(0);

        // Then.
        then(bstNode.getLeft().isEmpty()).isFalse();
        then(bstNode.getLeft().getData()).isEqualTo(0);
    }

    @Test
    void given_a_singleton_node_then_should_insert_a_larger_node_on_the_right() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        bstNode.insert(1);

        // Then.
        then(bstNode.getRight().isEmpty()).isFalse();
        then(bstNode.getRight().getData()).isEqualTo(1);
    }

    @Test
    void given_a_singleton_node_then_should_find_a_node_with_an_equal_value() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        var actual = bstNode.find(0);

        // Then.
        then(actual).isEqualTo(bstNode);
    }

    @Test
    void given_a_singleton_node_then_should_not_find_a_node_with_a_different_value() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        var actual = bstNode.find(1);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void given_a_singleton_node_when_deleting_a_node_not_contained_in_the_tree_then_the_tree_should_remain_unchanged() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        bstNode.delete(BinarySearchTreeNode.singleton(1));

        // Then.
        then(bstNode.getData()).isEqualTo(0);
        then(bstNode.getLeft().isEmpty()).isTrue();
        then(bstNode.getRight().isEmpty()).isTrue();
        then(bstNode.getWeight()).isOne();
    }

    @Test
    void given_a_singleton_node_when_deleting_the_root_then_should_return_an_empty_node() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        var actual = bstNode.delete(bstNode);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void given_a_singleton_node_then_getRandomNode_should_return_this_node() {
        // Given.
        bstNode = BinarySearchTreeNode.singleton(0);

        // When.
        var randomNode = bstNode.getRandomNode();

        // Then.
        then(randomNode).isEqualTo(bstNode);
    }

    // Covers: isEmpty() = false, isLeaf = false, left.isEmpty() = false,
    // right.isEmpty() = false.
    @Test
    void given_a_perfect_tree_of_height_one_then_weight_should_be_three() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        int weight = bstNode.getWeight();

        // Then.
        then(weight).isEqualTo(3);
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_isEmpty_should_be_false() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        boolean isEmpty = bstNode.isEmpty();

        // Then.
        then(isEmpty).isFalse();
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_isLeaf_should_be_false() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        boolean isLeaf = bstNode.isLeaf();

        // Then.
        then(isLeaf).isFalse();
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_should_insert_smaller_node_on_the_extreme_left() {
        // Given.
        var left = BinarySearchTreeNode.singleton(1);
        var right = BinarySearchTreeNode.singleton(3);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(2, left, right);

        // When.
        bstNode.insert(0);

        // Then.
        then(bstNode.getLeft().getLeft().isEmpty()).isFalse();
        then(bstNode.getLeft().getLeft().getData()).isEqualTo(0);
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_should_insert_a_value_equal_to_the_smallest_value_on_the_extreme_left() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        bstNode.insert(0);

        // Then.
        then(bstNode.getLeft().getLeft().isEmpty()).isFalse();
        then(bstNode.getLeft().getLeft().getData()).isEqualTo(0);
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_should_insert_a_larger_node_on_the_right() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        bstNode.insert(3);

        // Then.
        then(bstNode.getRight().getRight().isEmpty()).isFalse();
        then(bstNode.getRight().getRight().getData()).isEqualTo(3);
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_should_find_a_node_with_value_equal_to_the_left_node_value() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        var actual = bstNode.find(0);

        // Then.
        then(actual).isEqualTo(left);
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_should_not_find_a_node_with_a_value_not_contained_in_the_tree() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        var actual = bstNode.find(4);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void given_a_perfect_tree_of_height_one_when_deleting_a_node_not_contained_in_the_tree_then_the_tree_should_remain_unchanged() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        bstNode.delete(BinarySearchTreeNode.singleton(1));

        // Then.
        then(bstNode.getData()).isEqualTo(1);
        then(bstNode.getWeight()).isEqualTo(3);
        then(bstNode.getLeft().isEmpty()).isFalse();
        then(bstNode.getLeft().getData()).isEqualTo(0);
        then(bstNode.getRight().isEmpty()).isFalse();
        then(bstNode.getRight().getData()).isEqualTo(2);
    }

    @Test
    void given_a_perfect_tree_of_height_one_when_deleting_the_root_then_should_restructure_the_tree() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        var actual = bstNode.delete(bstNode);

        // Then.
        then(actual.getWeight()).isEqualTo(2);
        then(actual.find(0).isEmpty()).isFalse();
        then(actual.find(2).isEmpty()).isFalse();
        then(isBst(actual)).isTrue();
    }

    @Test
    void given_a_perfect_tree_of_height_one_then_getRandomNode_should_return_a_node_in_the_tree() {
        // Given.
        var left = BinarySearchTreeNode.singleton(0);
        var right = BinarySearchTreeNode.singleton(2);
        bstNode = new WeightedBinarySearchTreeNode<Integer>(1, left, right);

        // When.
        var randomNode = bstNode.getRandomNode();

        // Then.
        then(randomNode.isEmpty()).isFalse();
    }

    private <E extends Comparable<E>> boolean isBst(BinarySearchTreeNode<E> node) {
        // Base case.
        if (node.isEmpty() || node.isLeaf()) {
            return true;
        }
        // Recurisve step.
        boolean result = true;
        if (!node.getLeft().isEmpty()) {
            result &= node.getData().compareTo(node.getLeft().getData()) >= 0;
        }
        if (!node.getRight().isEmpty()) {
            result &= node.getData().compareTo(node.getRight().getData()) < 0;
        }
        result &= isBst(node.getLeft());
        result &= isBst(node.getRight());
        return result;
    }

}
