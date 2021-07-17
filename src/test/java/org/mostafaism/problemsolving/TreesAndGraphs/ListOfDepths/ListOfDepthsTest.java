package org.mostafaism.problemsolving.TreesAndGraphs.ListOfDepths;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class ListOfDepthsTest {
    /*
     * Testing strategy for {@code List<List<BinaryTreeNode<E>>>
     * listOfDepths(BinaryTreeNode<E> root)}
     * 
     * Cover the cross product of these partitions:
     * 
     * Partition on tree depth: 1, > 1
     * 
     * Partition on tree is degenerate: true, false
     * 
     * Partition on tree is perfect: true, false
     */

    private ListOfDepths<Integer> listOfDepths;
    BinaryTreeNode<Integer> root;
    private List<List<BinaryTreeNode<Integer>>> expected;

    @BeforeEach
    void setup() {
        listOfDepths = new ListOfDepths<>();
    }

    /*
     * Covers: depth = 1, degenerate = false, perfect = true
     */
    @Test
    void givenATreeOfDepthOne_thenShouldReturnAValidListOfDepths() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);
        expected = List.of(List.of(root));

        // When.
        var actual = listOfDepths.listOfDepths(root);

        // Then.
        then(actual.size()).isEqualTo(1);
        then(new HashSet<>(actual.get(0))).isEqualTo(new HashSet<>(expected.get(0)));
    }

    /*
     * Covers: depth > 1, degenerate = false, perfect = false
     */
    @Test
    void givenANonDegenerateAndNonPerfectTreeOfDepthThree_thenShouldReturnAValidListOfDepths() {
        // Given.
        var node4 = new BinaryTreeNode<Integer>(4, null, null);
        var node3 = new BinaryTreeNode<Integer>(3, null, null);
        var node2 = new BinaryTreeNode<Integer>(2, null, node4);
        var node1 = new BinaryTreeNode<Integer>(1, node3, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);
        expected = List.of(List.of(root), List.of(node1, node2), List.of(node3, node4));

        // When.
        List<List<BinaryTreeNode<Integer>>> actual = listOfDepths.listOfDepths(root);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(new HashSet<>(actual.get(0))).isEqualTo(new HashSet<>(expected.get(0)));
        then(new HashSet<>(actual.get(1))).isEqualTo(new HashSet<>(expected.get(1)));
        then(new HashSet<>(actual.get(2))).isEqualTo(new HashSet<>(expected.get(2)));
    }

    /*
     * Covers: depth > 1, degenerate = false, perfect = true
     */
    @Test
    void givenAPerfectTreeOfDepthTwo_thenShouldReturnAValidListOfDepths() {
        // Given.
        var node1 = new BinaryTreeNode<Integer>(1, null, null);
        var node2 = new BinaryTreeNode<Integer>(2, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);
        expected = List.of(List.of(root), List.of(node1, node2));

        // When.
        List<List<BinaryTreeNode<Integer>>> actual = listOfDepths.listOfDepths(root);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(new HashSet<>(actual.get(0))).isEqualTo(new HashSet<>(expected.get(0)));
        then(new HashSet<>(actual.get(1))).isEqualTo(new HashSet<>(expected.get(1)));
    }

    /*
     * Covers: depth > 1, degenerate = false, perfect = true
     */
    @Test
    void givenAPerfectTreeOfDepthThree_thenShouldReturnAValidListOfDepths() {
        // Given.
        var node6 = new BinaryTreeNode<Integer>(6, null, null);
        var node5 = new BinaryTreeNode<Integer>(5, null, null);
        var node4 = new BinaryTreeNode<Integer>(4, null, null);
        var node3 = new BinaryTreeNode<Integer>(3, null, null);
        var node2 = new BinaryTreeNode<Integer>(2, node5, node6);
        var node1 = new BinaryTreeNode<Integer>(1, node3, node4);
        root = new BinaryTreeNode<Integer>(0, node1, node2);
        expected = List.of(List.of(root), List.of(node1, node2), List.of(node3, node4, node5, node6));

        // When.
        List<List<BinaryTreeNode<Integer>>> actual = listOfDepths.listOfDepths(root);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(new HashSet<>(actual.get(0))).isEqualTo(new HashSet<>(expected.get(0)));
        then(new HashSet<>(actual.get(1))).isEqualTo(new HashSet<>(expected.get(1)));
        then(new HashSet<>(actual.get(2))).isEqualTo(new HashSet<>(expected.get(2)));
    }

    /*
     * Covers: depth > 1, degenerate = true, perfect = false
     */
    @Test
    void givenADegenerateTreeOfDepthTwo_thenShouldReturnAValidListOfDepths() {
        // Given.
        var node1 = new BinaryTreeNode<Integer>(1, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, null);
        expected = List.of(List.of(root), List.of(node1));

        // When.
        List<List<BinaryTreeNode<Integer>>> actual = listOfDepths.listOfDepths(root);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(new HashSet<>(actual.get(0))).isEqualTo(new HashSet<>(expected.get(0)));
        then(new HashSet<>(actual.get(1))).isEqualTo(new HashSet<>(expected.get(1)));
    }
}
