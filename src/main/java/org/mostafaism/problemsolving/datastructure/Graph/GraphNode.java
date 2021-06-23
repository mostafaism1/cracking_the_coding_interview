package org.mostafaism.problemsolving.datastructure.Graph;

import java.util.ArrayList;
import java.util.List;

public record GraphNode<E> (E data, List<GraphNode<E>> adjacents) {

    public GraphNode(E data) {
        this(data, new ArrayList<>());
    }

}
