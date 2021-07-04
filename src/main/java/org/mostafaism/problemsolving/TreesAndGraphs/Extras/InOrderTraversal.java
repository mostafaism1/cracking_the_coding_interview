package org.mostafaism.problemsolving.TreesAndGraphs.Extras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class InOrderTraversal<E> {

    public List<E> inOrderTraversal(BinaryTreeNode<E> root) {
        // Base case.
        if (root == null) {
            return Collections.emptyList();
        }

        // Recursive step.        
        List<E> left = inOrderTraversal(root.left());
        List<E> right = inOrderTraversal(root.right());
        List<E> result = new ArrayList<>();
        result.addAll(left);
        result.add(root.data());
        result.addAll(right);
        return result;
    }

}
