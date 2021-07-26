package org.mostafaism.problemsolving.TreesAndGraphs.FirstCommonAncestor;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FirstCommonAncestor {
    /**
     * Returns the first common ancestor of 2 nodes in a binary tree if it exists,
     * otherwise null.
     * 
     * @param <E>   the nodes datatype
     * @param root  the root of the tree
     * @param node1 a node
     * @param node2 a node
     * @return the first common ancestor of 2 nodes in a binary tree if it exists,
     *         otherwise null.
     */
    public <E> BinaryTreeNode<E> firstCommonAncestor(BinaryTreeNode<E> root, BinaryTreeNode<E> node1,
            BinaryTreeNode<E> node2) {
        return firstCommonAncestorHelper(root, node1, node2).firstCommonAncestor;
    }

    @Data
    @AllArgsConstructor
    private static class PartialResult<E> {
        private boolean containsNode1;
        private boolean containsNode2;
        private BinaryTreeNode<E> firstCommonAncestor;
    }

    public <E> PartialResult<E> firstCommonAncestorHelper(BinaryTreeNode<E> root, BinaryTreeNode<E> node1,
            BinaryTreeNode<E> node2) {
        // Base case.
        if (root == null) {
            return new PartialResult<>(false, false, null);
        }

        // Recursive step.
        PartialResult<E> result;
        PartialResult<E> leftResult = firstCommonAncestorHelper(root.left(), node1, node2);
        PartialResult<E> rightResult = firstCommonAncestorHelper(root.right(), node1, node2);
        if (leftResult.firstCommonAncestor != null) {
            result = leftResult;
        } else if (rightResult.firstCommonAncestor != null) {
            result = rightResult;
        } else {
            boolean rootIsFirstCommonAncestor = isFirstCommonAncestor(root, node1, node2, leftResult, rightResult);
            result = new PartialResult<>(root == node1 || rootIsFirstCommonAncestor,
                    root == node2 || rootIsFirstCommonAncestor, rootIsFirstCommonAncestor ? root : null);
        }
        return result;
    }

    private <E> boolean isFirstCommonAncestor(BinaryTreeNode<E> node, BinaryTreeNode<E> node1, BinaryTreeNode<E> node2,
            PartialResult<E> leftResult, PartialResult<E> rightResult) {
        return ((node == node1) && (leftResult.containsNode2 || rightResult.containsNode2))
                || ((node == node2) && (leftResult.containsNode1 || rightResult.containsNode1))
                || ((leftResult.containsNode1 && rightResult.containsNode2)
                        || (leftResult.containsNode2 && rightResult.containsNode1));
    }
}
