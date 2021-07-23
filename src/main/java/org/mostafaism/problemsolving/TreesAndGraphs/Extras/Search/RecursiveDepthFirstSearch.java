package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public class RecursiveDepthFirstSearch<E> implements Search<E> {

    @Override
    public Optional<GraphNode<E>> search(GraphNode<E> startNode, Predicate<GraphNode<E>> isFound) {
        Set<GraphNode<E>> visitedNodes = new HashSet<>();
        GraphNode<E> result = searchHelper(startNode, isFound, visitedNodes);
        return result == null ? Optional.empty() : Optional.of(result);
    }

    private GraphNode<E> searchHelper(GraphNode<E> root, Predicate<GraphNode<E>> isFound,
            Set<GraphNode<E>> visitedNodes) {
        // Base case.
        if (root == null) {
            return null;
        }
        if (isFound.test(root)) {
            return root;
        }
        // Recursive step.
        GraphNode<E> result = null;
        visitedNodes.add(root);
        for (GraphNode<E> node : root.getAdjacents()) {
            if (!visitedNodes.contains(node)) {
                result = searchHelper(node, isFound, visitedNodes);
                if (result != null) {
                    break;
                }
            }
        }
        return result;
    }

}
