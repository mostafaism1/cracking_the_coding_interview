package org.mostafaism.problemsolving.TreesAndGraphs.CheckSubtree;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class CheckSubtree<E> {
    /**
     * Returns true if the second tree is a subtree of the first tree, otherwise
     * false.
     * 
     * Note: Equality is is determined by comparing values not references.
     * 
     * @param root1 the first tree
     * @param root2 the second tree
     * @return true if the second tree is a subtree of the first tree, otherwise
     *         false.
     */
    public boolean checkSubtree(BinaryTreeNode<E> root1, BinaryTreeNode<E> root2) {
        // Base cases.
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null ^ root2 == null) {
            return false;
        }
        // Recursive step.
        boolean result = false;
        if (root1.data().equals(root2.data())) {
            result = checkSubtree(root1.right(), root2.right()) && checkSubtree(root1.left(), root2.left());
        }
        return result ? result : checkSubtree(root1.left(), root2) || checkSubtree(root1.right(), root2);
    }
}
