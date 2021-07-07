package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Traversal;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class InOrderTraversalTest {

    private InOrderTraversal<Integer> inOrderTraversal;

    @BeforeEach
    void setup() {
        inOrderTraversal = new InOrderTraversal<>();
    }

    @Test
    void shouldReturnEmptyList_givenANullRoot() {
        // Given.
        BinaryTreeNode<Integer> root = null;

        // When.
        List<Integer> actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual.size()).isZero();
    }

    @Test
    void shouldReturnTheRoot_givenATreeWithOneNode() {
        // Given.
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(0, null, null);
        Integer expected = 0;

        // When.
        List<Integer> actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual.size()).isOne();
        then(actual.get(0)).isEqualTo(expected);
    }

    @Test
    void shouldReturnTheNodesInProperOrder_givenATreeWithTwoNodes() {
        // Given.
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<>(0, null, null), null);
        Integer expected0 = 0;
        Integer expected1 = 1;

        // When.
        List<Integer> actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(actual.get(0)).isEqualTo(expected0);
        then(actual.get(1)).isEqualTo(expected1);
    }

    @Test
    void shouldReturnTheNodesInProperOrder_givenAPerfectTreeWithThreeNodes() {
        // Given.
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(2, null, null));
        Integer expected0 = 0;
        Integer expected1 = 1;
        Integer expected2 = 2;

        // When.
        List<Integer> actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.get(0)).isEqualTo(expected0);
        then(actual.get(1)).isEqualTo(expected1);
        then(actual.get(2)).isEqualTo(expected2);
    }

    @Test
    void shouldReturnTheNodesInProperOrder_givenADegenerateTreeWithThreeNodes() {
        // Given.
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(2,
                new BinaryTreeNode<>(1, new BinaryTreeNode<>(0, null, null), null), null);
        Integer expected0 = 0;
        Integer expected1 = 1;
        Integer expected2 = 2;

        // When.
        List<Integer> actual = inOrderTraversal.inOrderTraversal(root);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.get(0)).isEqualTo(expected0);
        then(actual.get(1)).isEqualTo(expected1);
        then(actual.get(2)).isEqualTo(expected2);
    }

}
