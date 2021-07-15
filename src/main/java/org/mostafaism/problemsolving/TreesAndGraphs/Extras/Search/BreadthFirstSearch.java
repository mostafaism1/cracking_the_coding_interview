package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;
import org.mostafaism.problemsolving.datastructure.Queue.DefaultQueue;
import org.mostafaism.problemsolving.datastructure.Queue.Queue;

public class BreadthFirstSearch<E> implements Search<E> {

    @Override
    public Optional<GraphNode<E>> search(GraphNode<E> startNode, Predicate<GraphNode<E>> isFound) {
        if (startNode == null) {
            return Optional.empty();
        }
        GraphNode<E> result = null;
        Set<GraphNode<E>> visitedNodes = new HashSet<>();
        Queue<GraphNode<E>> queue = new DefaultQueue<>();
        // Note:
        // A node is marked as visited just before it is enqueued.
        // A node is checked when it is dequeued.
        visitedNodes.add(startNode);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            GraphNode<E> node = queue.remove();
            if (isFound.test(node)) {
                result = node;
                break;
            }
            for (GraphNode<E> adjacent : node.adjacents()) {
                if (!visitedNodes.contains(adjacent)) {
                    visitedNodes.add(adjacent);
                    queue.add(adjacent);
                }
            }
        }
        return result == null ? Optional.empty() : Optional.of(result);
    }

}
