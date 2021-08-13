package org.mostafaism.problemsolving.TreesAndGraphs.PathsWithSum;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class PathsWithSum {
    public int pathsWithSum(BinaryTreeNode<Integer> root, int sum) {
        // Base cases.
        if (root == null) {
            return 0;
        } else if (root.isLeaf()) {
            if (root.data() == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        // Recursive step.
        return pathsWithSum(root.left(), sum) + pathsWithSum(root.right(), sum)
                + pathsWithSum(root.left(), sum - root.data()) + pathsWithSum(root.right(), sum - root.data())
                + (root.data() == sum ? 1 : 0);
    }
}
