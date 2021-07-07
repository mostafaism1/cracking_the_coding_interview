package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class PostOrderTraversal<E> {

    public List<E> postOrderTraversal(BinaryTreeNode<E> root) {
        // Base case.
        if (root == null) {
            return Collections.emptyList();
        }

        // Recursive step.
        List<E> left = postOrderTraversal(root.left());
        List<E> right = postOrderTraversal(root.right());
        List<E> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(right);
        result.add(root.data());
        return result;
    }

}
