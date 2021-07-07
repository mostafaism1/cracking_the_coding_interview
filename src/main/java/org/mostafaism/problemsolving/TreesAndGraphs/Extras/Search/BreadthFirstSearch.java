package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;
import org.mostafaism.problemsolving.datastructure.Queue.DefaultQueue;
import org.mostafaism.problemsolving.datastructure.Queue.Queue;

public class BreadthFirstSearch<E> implements Search<E> {

    @Override
    public Optional<GraphNode<E>> search(GraphNode<E> startNode, E value) {
        if (startNode == null) {
            return Optional.empty();
        }
        GraphNode<E> result = null;
        Set<GraphNode<E>> visitedNodes = new HashSet<>();
        Queue<GraphNode<E>> queue = new DefaultQueue<>();
        visitedNodes.add(startNode);
        queue.add(startNode);
        while (!queue.isEmpty()) {
            GraphNode<E> node = queue.remove();
            if (node.data() == value) {
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
