package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import java.util.Optional;

import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public interface DepthFirstSearch<E> {
    /**
     * Returns an Optional of a GraphNode with a value equal to the specified value
     * if the value exists, otherwise Optional.empty.
     *
     * @param startNode a node from which to start searching
     * @param value     the value to search for
     * @return an Optional of a GraphNode with a value equal to the specified value
     *         if the value exists, otherwise Optional.empty
     */
    Optional<GraphNode<E>> search(GraphNode<E> startNode, E value);
}
