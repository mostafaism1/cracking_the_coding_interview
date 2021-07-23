package org.mostafaism.problemsolving.datastructure.Graph;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GraphNode<E> {
    @Getter
    private E data;
    private Set<GraphNode<E>> adjacents;

    public GraphNode(E data) {
        this(data, new HashSet<>());
    }

    public void addAdjacent(GraphNode<E> graphNode) {
        adjacents.add(graphNode);
    }

    public void removeAdjacent(GraphNode<E> graphNode) {
        adjacents.remove(graphNode);
    }

    public Set<GraphNode<E>> getAdjacents() {
        // Create a defensive copy.
        return new HashSet<>(adjacents);
    }
}
