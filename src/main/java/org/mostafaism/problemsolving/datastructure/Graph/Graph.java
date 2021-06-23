package org.mostafaism.problemsolving.datastructure.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * An adjacency list representation of a graph data structure.
 */
public record Graph<E> (List<GraphNode<E>> nodes) {

    public Graph() {
        this(new ArrayList<>());
    }

}
