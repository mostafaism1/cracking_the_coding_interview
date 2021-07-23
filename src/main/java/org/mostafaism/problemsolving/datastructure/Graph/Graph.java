package org.mostafaism.problemsolving.datastructure.Graph;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;

/**
 * An adjacency list representation of a graph data structure.
 */
@AllArgsConstructor
public class Graph<E> {
    private Set<GraphNode<E>> nodes;

    public Graph() {
        this(new HashSet<>());
    }

    public void addNode(GraphNode<E> graphNode) {
        nodes.add(graphNode);
    }

    public void removeNode(GraphNode<E> graphNode) {
        nodes.remove(graphNode);
    }

    public Set<GraphNode<E>> getNodes() {
        // Create a defensive copy.
        return new HashSet<>(nodes);
    }

}
