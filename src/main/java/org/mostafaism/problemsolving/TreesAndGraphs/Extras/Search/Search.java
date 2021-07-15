package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import java.util.Optional;
import java.util.function.Predicate;

import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public interface Search<E> {
    /**
     * Returns an Optional of a GraphNode for which the isFound predicate evaluates
     * to true if such a node exists, otherwise Optional.empty.
     * 
     * @param startNode a node from which to start searching
     * @param isFound   a predicate to test the nodes against
     * @return an Optional of a GraphNode for which the isFound predicate evaluates
     *         to true if such a node exists, otherwise Optional.empty.
     */
    Optional<GraphNode<E>> search(GraphNode<E> startNode, Predicate<GraphNode<E>> isFound);
}
