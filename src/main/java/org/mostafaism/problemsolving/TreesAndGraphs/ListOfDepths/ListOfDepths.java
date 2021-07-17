package org.mostafaism.problemsolving.TreesAndGraphs.ListOfDepths;

import java.util.ArrayList;
import java.util.List;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class ListOfDepths<E> {
    /**
     * Returns the nodes at each depth.
     *
     * @param root the root of a binary tree; must not be null
     * @return the nodes at each depth.
     */
    public List<List<BinaryTreeNode<E>>> listOfDepths(BinaryTreeNode<E> root) {
        List<List<BinaryTreeNode<E>>> result = new ArrayList<>();
        listOfDepthsHelper(root, 0, result);
        return result;
    }

    private void listOfDepthsHelper(BinaryTreeNode<E> node, int depth, List<List<BinaryTreeNode<E>>> partialResult) {
        // Base case.
        if (node == null) {
            return;
        }

        // Recursive step.
        addNodeToDepthList(node, depth, partialResult);
        listOfDepthsHelper(node.left(), depth + 1, partialResult);
        listOfDepthsHelper(node.right(), depth + 1, partialResult);
    }

    private void addNodeToDepthList(BinaryTreeNode<E> node, int depth, List<List<BinaryTreeNode<E>>> partialResult) {
        if (partialResult.size() == depth) {
            partialResult.add(new ArrayList<>());
        }
        List<BinaryTreeNode<E>> depthNodes = partialResult.get(depth);
        depthNodes.add(node);
        partialResult.set(depth, depthNodes);
    }
}
