package org.mostafaism.problemsolving.TreesAndGraphs.MinimalTree;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class MinimalTree {
    /**
     * Returns a minimal height binary search tree representation for the numbers
     * array, or null if numbers.length = 0.
     * 
     * @param numbers an array of integers; must not be null; must contain unique
     *                numbers; must be sorted in an increasing order
     * @return a minimal height binary search tree representation for the numbers
     *         array, or null if numbers.length = 0.
     */
    public BinaryTreeNode<Integer> minimalTree(int[] numbers) {
        return minimalTreeHelper(numbers, 0, numbers.length - 1);
    }

    private BinaryTreeNode<Integer> minimalTreeHelper(int[] numbers, int low, int high) {
        // Base case.
        if (low > high) {
            return null;
        }

        // Recursive step.
        var mid = ((low + high) / 2);
        var left = minimalTreeHelper(numbers, low, mid - 1);
        var right = minimalTreeHelper(numbers, mid + 1, high);
        return new BinaryTreeNode<Integer>(numbers[mid], left, right);
    }
}
