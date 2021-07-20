package org.mostafaism.problemsolving.TreesAndGraphs.Successor;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class Successor {
    /**
     * Returns the successor of the specified node or null if the specified node has
     * no right child.
     * 
     * A successor is defined to be the node that comes after the specified node in
     * an in-order traversal.
     * 
     * @param <E>  the nodes datatype
     * @param node a binary search tree node; must not be null
     * @return the successor of the specified node or null if the specified node has
     *         no right child.
     */
    public <E> BinaryTreeNode<E> successor(BinaryTreeNode<E> node) {
        if (node.right() == null) {
            return null;
        }
        return getLeftMostNode(node.right());
    }

    private <E> BinaryTreeNode<E> getLeftMostNode(BinaryTreeNode<E> node) {
        // Base case.
        if (node.left() == null) {
            return node;
        }

        // Recursive step.
        return getLeftMostNode(node.left());
    }
}
