package org.mostafaism.problemsolving.TreesAndGraphs.BstSequences;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class BstSequencesTest {
    /*
     * Testing strategy for {@code <E> List<List<E>> BstSequences(BinaryTreeNode<E>
     * root)}
     * 
     * Cover the cross product of these partitions:
     * 
     * Partition on root is: null, not null
     * 
     * Partition on root.height: null, 0, 1, 2, > 2
     * 
     * Partition on left.height: null, 0, 1, > 1
     * 
     * Partition on right.height: null, 0, 1, > 1
     */

    private BstSequences bstSequences;
    private BinaryTreeNode<Integer> root;

    @BeforeEach
    void setup() {
        bstSequences = new BstSequences();
    }

    // Covers: root = null, root.height = null, left.height = null, right.height =
    // null.
    @Test
    void givenRootIsNull_thenShouldReturnAnEmptySet() {
        // Given.
        root = null;

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual).isEmpty();
    }

    // Covers: root != null, root.height = 0, left.height = null, right.height =
    // null.
    @Test
    void givenATreeOfHeightZero_thenShouldReturnASetOfASingleListContainingTheRoot() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.contains(List.of(root.data()))).isTrue();
    }

    // Covers: root != null, root.height = 1, left.height = null, right.height = 0.
    @Test
    void givenALeftDegenerateTreeOfHeightOne_thenShouldReturnValidSequences() {
        // Given.
        var left = new BinaryTreeNode<>(0, null, null);
        root = new BinaryTreeNode<Integer>(1, left, null);
        var expected = List.of(1, 0);

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.contains(expected)).isTrue();
    }

    // Covers: root != null, root.height = 1, left.height = 0, right.height = null.
    @Test
    void givenARightDegenerateTreeOfHeightOne_thenShouldReturnValidSequences() {
        // Given.
        var right = new BinaryTreeNode<>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, null, right);
        var expected = List.of(root.data(), right.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.contains(expected)).isTrue();
    }

    // Covers: root != null, root.height = 1, left.height = 0, right.height = 0.
    @Test
    void givenABalancedTreeOfHeightOne_thenShouldReturnValidSequences() {
        // Given.
        var left = new BinaryTreeNode<>(0, null, null);
        var right = new BinaryTreeNode<>(2, null, null);
        root = new BinaryTreeNode<Integer>(1, left, right);
        var expected1 = List.of(root.data(), left.data(), right.data());
        var expected2 = List.of(root.data(), right.data(), left.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(actual.contains(expected1)).isTrue();
        then(actual.contains(expected2)).isTrue();
    }

    // Covers: root != null, root.height = 2, left.height = 1, right.height = null.
    @Test
    void givenALeftDegenerateTreeOfHeightTwo_thenShouldReturnValidSequences() {
        // Given.
        var leftLeft = new BinaryTreeNode<>(0, null, null);
        var left = new BinaryTreeNode<>(1, leftLeft, null);
        root = new BinaryTreeNode<Integer>(2, left, null);
        var expected = List.of(root.data(), left.data(), leftLeft.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.contains(expected)).isTrue();
    }

    // Covers: root != null, root.height = 2, left.height = 1, right.height = 1.
    @Test
    void givenATreeOfHeightTwoAndLeftSubTreeOfHeight1AndRightSubTreeOfHeight1_thenShouldReturnValidSequences() {
        // Given.
        var leftLeft = new BinaryTreeNode<>(0, null, null);
        var left = new BinaryTreeNode<>(1, leftLeft, null);
        var rightRight = new BinaryTreeNode<>(4, null, null);
        var right = new BinaryTreeNode<>(3, null, rightRight);
        root = new BinaryTreeNode<Integer>(2, left, right);
        var expected1 = List.of(root.data(), left.data(), leftLeft.data(), right.data(), rightRight.data());
        var expected2 = List.of(root.data(), left.data(), right.data(), leftLeft.data(), rightRight.data());
        var expected3 = List.of(root.data(), right.data(), left.data(), leftLeft.data(), rightRight.data());
        var expected4 = List.of(root.data(), left.data(), right.data(), rightRight.data(), leftLeft.data());
        var expected5 = List.of(root.data(), right.data(), left.data(), rightRight.data(), leftLeft.data());
        var expected6 = List.of(root.data(), right.data(), rightRight.data(), left.data(), leftLeft.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isEqualTo(6);
        then(actual.contains(expected1)).isTrue();
        then(actual.contains(expected2)).isTrue();
        then(actual.contains(expected3)).isTrue();
        then(actual.contains(expected4)).isTrue();
        then(actual.contains(expected5)).isTrue();
        then(actual.contains(expected6)).isTrue();
    }

    // Covers: root != null, root.height = 2, left.height = null, right.height = 1.
    @Test
    void givenATreeOfHeightTwoAndAPerfectRightSubTree_thenShouldReturnValidSequences() {
        // Given.
        var rightLeft = new BinaryTreeNode<>(1, null, null);
        var rightRight = new BinaryTreeNode<>(3, null, null);
        var right = new BinaryTreeNode<>(2, rightLeft, rightRight);
        root = new BinaryTreeNode<Integer>(0, null, right);
        var expected1 = List.of(root.data(), right.data(), rightLeft.data(), rightRight.data());
        var expected2 = List.of(root.data(), right.data(), rightRight.data(), rightLeft.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(actual.contains(expected1)).isTrue();
        then(actual.contains(expected2)).isTrue();
    }

    // Covers: root != null, root.height > 2, left.height > 1, right.height = null.
    @Test
    void givenATreeOfHeightThreeAndANullRightSubTree_thenShouldReturnValidSequences() {
        // Given.
        var leftRightLeft = new BinaryTreeNode<>(2, null, null);
        var leftRight = new BinaryTreeNode<>(3, leftRightLeft, null);
        var left = new BinaryTreeNode<>(0, null, leftRight);
        root = new BinaryTreeNode<Integer>(1, left, null);
        var expected = List.of(root.data(), left.data(), leftRight.data(), leftRightLeft.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.contains(expected)).isTrue();
    }

    // Covers: root != null, root.height > 2, left.height > 1, right.height = 1.
    @Test
    void givenATreeOfHeightThreeAndALeftSubTreeOfHeightTwoAndARightSubTreeOfHeightOne_thenShouldReturnValidSequences() {
        // Given.
        var leftRightLeft = new BinaryTreeNode<>(1, null, null);
        var leftRight = new BinaryTreeNode<>(2, leftRightLeft, null);
        var left = new BinaryTreeNode<>(0, null, leftRight);
        var rightLeft = new BinaryTreeNode<>(4, null, null);
        var right = new BinaryTreeNode<>(5, rightLeft, null);
        root = new BinaryTreeNode<Integer>(3, left, right);
        var expected1 = List.of(root.data(), left.data(), leftRight.data(), leftRightLeft.data(), right.data(),
                rightLeft.data());
        var expected2 = List.of(root.data(), left.data(), leftRight.data(), right.data(), leftRightLeft.data(),
                rightLeft.data());
        var expected3 = List.of(root.data(), left.data(), right.data(), leftRight.data(), leftRightLeft.data(),
                rightLeft.data());
        var expected4 = List.of(root.data(), right.data(), left.data(), leftRight.data(), leftRightLeft.data(),
                rightLeft.data());
        var expected5 = List.of(root.data(), left.data(), leftRight.data(), right.data(), rightLeft.data(),
                leftRightLeft.data());
        var expected6 = List.of(root.data(), left.data(), right.data(), leftRight.data(), rightLeft.data(),
                leftRightLeft.data());
        var expected7 = List.of(root.data(), right.data(), left.data(), leftRight.data(), rightLeft.data(),
                leftRightLeft.data());
        var expected8 = List.of(root.data(), left.data(), right.data(), rightLeft.data(), leftRight.data(),
                leftRightLeft.data());
        var expected9 = List.of(root.data(), right.data(), left.data(), rightLeft.data(), leftRight.data(),
                leftRightLeft.data());
        var expected10 = List.of(root.data(), right.data(), rightLeft.data(), left.data(), leftRight.data(),
                leftRightLeft.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isEqualTo(10);
        then(actual.contains(expected1)).isTrue();
        then(actual.contains(expected2)).isTrue();
        then(actual.contains(expected3)).isTrue();
        then(actual.contains(expected4)).isTrue();
        then(actual.contains(expected5)).isTrue();
        then(actual.contains(expected6)).isTrue();
        then(actual.contains(expected7)).isTrue();
        then(actual.contains(expected8)).isTrue();
        then(actual.contains(expected9)).isTrue();
        then(actual.contains(expected10)).isTrue();
    }

    // Covers: root != null, root.height > 2, left.height > 1, right.height > 1.
    // TODO.

    // Covers: root != null, root.height > 2, left.height = null, right.height > 1.
    @Test
    void givenATreeOfHeightThreeAndANullLefttSubTree_thenShouldReturnValidSequences() {
        // Given.
        var rightRightRight = new BinaryTreeNode<>(3, null, null);
        var rightRight = new BinaryTreeNode<>(2, null, rightRightRight);
        var right = new BinaryTreeNode<>(1, null, rightRight);
        root = new BinaryTreeNode<Integer>(0, null, right);
        var expected = List.of(root.data(), right.data(), rightRight.data(), rightRightRight.data());

        // When.
        Set<List<Integer>> actual = bstSequences.bstSequences(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.contains(expected)).isTrue();
    }

}
