package org.mostafaism.problemsolving.TreesAndGraphs.ValidateBst;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ValidateBst<E extends Comparable<E>> {
    @Data
    @AllArgsConstructor
    private class PartialResult {
        private boolean isBst;
        private E min;
        private E max;
    }

    /**
     * Returns true if root is a binary search tree, otherwise false.
     * 
     * @param root a binary tree; must not be null
     * @return true if root is a binary search tree, otherwise false.
     */
    public boolean validateBst(BinaryTreeNode<E> root) {
        return validateBstHelper(root).isBst();
    }

    private PartialResult validateBstHelper(BinaryTreeNode<E> node) {
        // Base case.
        if (isLeaf(node)) {
            return new PartialResult(true, node.data(), node.data());
        }

        // Recursive step.
        PartialResult leftResult;
        PartialResult rightResult;
        boolean isBst;
        E min;
        E max;
        if (node.left() != null && node.right() != null) {
            leftResult = validateBstHelper(node.left());
            rightResult = validateBstHelper(node.right());
            isBst = leftResult.isBst() && rightResult.isBst() && node.data().compareTo(leftResult.getMax()) >= 0
                    && node.data().compareTo(rightResult.getMin()) < 0;
            min = leftResult.getMin();
            max = rightResult.getMax();
        } else if (node.right() == null) {
            leftResult = validateBstHelper(node.left());
            isBst = leftResult.isBst() && node.data().compareTo(leftResult.getMax()) >= 0;
            min = leftResult.getMin();
            max = node.data();
        } else {
            rightResult = validateBstHelper(node.right());
            isBst = rightResult.isBst() && node.data().compareTo(rightResult.getMin()) < 0;
            min = node.data();
            max = rightResult.getMax();
        }
        return new PartialResult(isBst, min, max);
    }

    private boolean isLeaf(BinaryTreeNode<E> node) {
        return node.left() == null && node.right() == null;
    }
}
