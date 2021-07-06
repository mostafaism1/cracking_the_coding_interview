package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public class RecursiveDepthFirstSearch<E> implements Search<E> {

    @Override
    public Optional<GraphNode<E>> search(GraphNode<E> startNode, E value) {
        Set<GraphNode<E>> visitedNodes = new HashSet<>();
        GraphNode<E> result = searchHelper(startNode, value, visitedNodes);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    private GraphNode<E> searchHelper(GraphNode<E> root, E value, Set<GraphNode<E>> visitedNodes) {
        // Base case.
        if (root == null) {
            return null;
        }
        if (root.data() == value) {
            return root;
        }
        // Recursive step.
        GraphNode<E> result = null;
        visitedNodes.add(root);
        for (GraphNode<E> node : root.adjacents()) {
            if (!visitedNodes.contains(node)) {
                result = searchHelper(node, value, visitedNodes);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

}
