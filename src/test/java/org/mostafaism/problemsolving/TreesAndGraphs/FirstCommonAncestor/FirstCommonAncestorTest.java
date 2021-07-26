package org.mostafaism.problemsolving.TreesAndGraphs.FirstCommonAncestor;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class FirstCommonAncestorTest {
    /*
     * Testing strategy for {@code <E> BinaryTreeNode<E>
     * firstCommonAncestor(BinaryTreeNode<E> root, BinaryTreeNode<E> node1,
     * BinaryTreeNode<E> node2)}
     * 
     * Cover the sub-domains of these partitions:
     * 
     * Partition on root is: null, not null
     * 
     * Partition on node1 is: null, not null
     * 
     * Partition on node2 is: null, not null
     * 
     * Partition on tree height: null, 0, 1, 2, > 2
     * 
     * Partition on node1 position: null, leaf, internal, root
     * 
     * Partition on node2 position: null, leaf, internal, root
     * 
     * Partition on tree is degenerate: false, true
     */

    private FirstCommonAncestor firstCommonAncestor;
    private BinaryTreeNode<Integer> root;
    private BinaryTreeNode<Integer> node1;
    private BinaryTreeNode<Integer> node2;

    @BeforeEach
    void setup() {
        firstCommonAncestor = new FirstCommonAncestor();
    }

    // Covers: root is null, node1 is null, node2 is null, tree height is null,
    // node1 position is null, node2 position is null, tree is degenerate = false.
    @Test
    void givenANullRootAndANullFirstNodeAndANullSecondNode_thenShouldReturnNull() {
        // Given.
        root = null;
        node1 = null;
        node2 = null;

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isNull();
    }

    // Covers: root is not null, node1 is null, node2 is null, tree height = 0,
    // node1 position is null, node2 position is null, tree is degenerate = false.
    @Test
    void givenANonNullRootAndANullFirstNodeAndANullSecondNode_thenShouldReturnNull() {
        // Given.
        root = new BinaryTreeNode<Integer>(0, null, null);
        node1 = null;
        node2 = null;

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isNull();
    }

    // Covers: root is null, node1 is null, node2 is not null, tree height = 0,
    // node1 position is null, node2 position is null, tree is degenerate = false.
    @Test
    void givenANullRootAndANullFirstNodeAndANonNullSecondNode_thenShouldReturnNull() {
        // Given.
        root = null;
        node1 = null;
        node2 = new BinaryTreeNode<Integer>(0, null, null);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isNull();
    }

    // Covers: root is null, node1 is not null, node2 is null, tree height = 0,
    // node1 position is null, node2 position is null, tree is degenerate = false.
    @Test
    void givenANullRootAndANonNullFirstNodeAndANullSecondNode_thenShouldReturnNull() {
        // Given.
        root = null;
        node1 = new BinaryTreeNode<Integer>(0, null, null);
        node2 = null;

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isNull();
    }

    // Covers: root is not null, node1 is null, node2 is not null, tree height = 1,
    // node1 position is null, node2 position is leaf, tree is degenerate = true.
    @Test
    void givenADegenerateTreeOfHeightOneAndANullFirstNodeAndANonNullSecondNode_thenShouldReturnNull() {
        // Given.
        node1 = null;
        node2 = new BinaryTreeNode<Integer>(0, null, null);
        root = new BinaryTreeNode<Integer>(0, node2, null);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isNull();
    }

    // Covers: root is not null, node1 is not null, node2 is null, tree height = 1,
    // node1 position is leaf, node2 position is null, tree is degenerate = true.
    @Test
    void givenADegenerateTreeOfHeightOneAndANonNullFirstNodeAndANullSecondNode_thenShouldReturnNull() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, null, null);
        node2 = null;
        root = new BinaryTreeNode<Integer>(0, null, node1);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isNull();
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 1, node1 position is leaf, node2 position is leaf, tree is degenerate =
    // false.
    @Test
    void givenANonDegenerateTreeOfHeightOne_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, null, null);
        node2 = new BinaryTreeNode<Integer>(0, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is leaf, node2 position is internal, tree is degenerate =
    // true.
    @Test
    void givenADegenerateTreeOfHeightTwoAndNode1IsLeaf_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, null, null);
        node2 = new BinaryTreeNode<Integer>(0, node1, null);
        root = new BinaryTreeNode<Integer>(0, node2, null);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(node2);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is internal, node2 position is leaf, tree is degenerate =
    // true.
    @Test
    void givenADegenerateTreeOfHeightTwoAndNode2IsLeaf_thenShouldReturnAValidAncestor() {
        // Given.
        node2 = new BinaryTreeNode<Integer>(0, null, null);
        node1 = new BinaryTreeNode<Integer>(0, null, node2);
        root = new BinaryTreeNode<Integer>(0, null, node1);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(node1);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is leaf, node2 position is internal, tree is degenerate =
    // false.
    @Test
    void givenANonDegenerateTreeOfHeightTwoAndNode1IsLeafAndNode2IsInternal_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, null, null);
        node2 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is internal, node2 position is leaf, tree is degenerate =
    // false
    @Test
    void givenANonDegenerateTreeOfHeightTwoAndNode1IsInternalAndNode2IsLeaf_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        node2 = new BinaryTreeNode<Integer>(0, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is internal, node2 position is internal, tree is degenerate
    // = false.
    @Test
    void givenANonDegenerateTreeOfHeightTwoAndNode1IsInternalAndNode2IsInternal_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        node2 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        root = new BinaryTreeNode<Integer>(0, node1, node2);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 1, node1 position is leaf, node2 position is root, tree is degenerate = true.
    @Test
    void givenADegenerateTreeOfHeightOneAndNode1IsLeafAndNode2IsRoot_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, null, null);
        root = new BinaryTreeNode<Integer>(0, node1, null);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, root);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 1, node1 position is root, node2 position is leaf, tree is degenerate = true.
    @Test
    void givenADegenerateTreeOfHeightOneAndNode1IsRootAndNode2IsLeaf_thenShouldReturnAValidAncestor() {
        // Given.
        node2 = new BinaryTreeNode<Integer>(0, null, null);
        root = new BinaryTreeNode<Integer>(0, null, node2);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, root, node2);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is internal, node2 position is root, tree is degenerate =
    // false.
    @Test
    void givenANonDegenerateTreeOfHeightTwoAndNode1IsInternalAndNode2Isroot_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        root = new BinaryTreeNode<Integer>(0, node1,
                new BinaryTreeNode<>(0, new BinaryTreeNode<>(0, null, null), new BinaryTreeNode<>(0, null, null)));

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, root);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height =
    // 2, node1 position is root, node2 position is internal, tree is degenerate =
    // false.
    @Test
    void givenANonDegenerateTreeOfHeightTwoAndNode1IsRootAndNode2IsInternal_thenShouldReturnAValidAncestor() {
        // Given.
        node2 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        root = new BinaryTreeNode<Integer>(0,
                new BinaryTreeNode<>(0, new BinaryTreeNode<>(0, null, null), new BinaryTreeNode<>(0, null, null)),
                node2);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, root, node2);

        // Then.
        then(actual).isEqualTo(root);
    }

    // Covers: root is not null, node1 is not null, node2 is not null, tree height >
    // 2, node1 position is internal, node2 position is internal, tree is degenerate
    // = false.
    @Test
    void givenANonDegenerateTreeOfHeightThreeAndNode1IsInternalAndNode2IsInternal_thenShouldReturnAValidAncestor() {
        // Given.
        node1 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        node2 = new BinaryTreeNode<Integer>(0, new BinaryTreeNode<>(0, null, null),
                new BinaryTreeNode<>(0, null, null));
        var left = new BinaryTreeNode<>(0, node1, node2);
        var right = new BinaryTreeNode<>(0, new BinaryTreeNode<>(0, null, null), new BinaryTreeNode<>(0, null, null));
        root = new BinaryTreeNode<Integer>(0, left, right);

        // When.
        BinaryTreeNode<Integer> actual = firstCommonAncestor.firstCommonAncestor(root, node1, node2);

        // Then.
        then(actual).isEqualTo(left);
    }

}
