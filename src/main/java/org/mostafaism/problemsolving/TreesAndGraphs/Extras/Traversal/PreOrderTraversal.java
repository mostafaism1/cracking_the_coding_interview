package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class PreOrderTraversal<E> {

    public List<E> preOrderTraversal(BinaryTreeNode<E> root) {
        // Base case.
        if (root == null) {
            return Collections.emptyList();
        }

        // Recursive step.
        List<E> left = preOrderTraversal(root.left());
        List<E> right = preOrderTraversal(root.right());
        List<E> result = new ArrayList<>();
        result.add(root.data());
        result.addAll(left);
        result.addAll(right);
        return result;
    }

}
