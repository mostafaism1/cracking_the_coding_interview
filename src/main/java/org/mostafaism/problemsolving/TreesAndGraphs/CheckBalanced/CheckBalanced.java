package org.mostafaism.problemsolving.TreesAndGraphs.CheckBalanced;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class CheckBalanced {
    /**
     * Returns true if root is balanced , otherwise false. A balanced binary tree is
     * defined to be a tree such that the heights of the two sub-trees of any node
     * never differ by more than one.
     * 
     * @param root a binary tree
     * @return true if root is balanced , otherwise false.
     */
    public boolean checkBalanced(BinaryTreeNode<?> root) {
        return checkBalancedHelper(root).isBalanced();
    }

    private static record partialResult(boolean isBalanced, int maximalHeight) {
    }

    private partialResult checkBalancedHelper(BinaryTreeNode<?> node) {
        // Base case.
        if (node == null) {
            return new partialResult(true, 0);
        }

        // Recursive step.
        partialResult left = checkBalancedHelper(node.left());
        partialResult right = checkBalancedHelper(node.right());
        return new partialResult(
                left.isBalanced() && right.isBalanced() && Math.abs(left.maximalHeight() - right.maximalHeight()) <= 1,
                1 + Math.max(left.maximalHeight(), right.maximalHeight()));
    }
}
