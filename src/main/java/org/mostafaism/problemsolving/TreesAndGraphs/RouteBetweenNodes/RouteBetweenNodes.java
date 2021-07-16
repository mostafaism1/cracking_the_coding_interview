package org.mostafaism.problemsolving.TreesAndGraphs.RouteBetweenNodes;

import java.util.Optional;
import java.util.function.Predicate;

import org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search.BreadthFirstSearch;
import org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search.Search;
import org.mostafaism.problemsolving.datastructure.Graph.Graph;
import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public class RouteBetweenNodes<E> {
    /**
     * Returns true if a path exists from the source node to the destination node in
     * the graph, otherwise false.
     * 
     * @param graph       a graph
     * @param source      a node; must belong to the graph
     * @param destination a node; must belong to the graph
     * @return true if a path exists from the source node to the destination node in
     *         the graph, otherwise false.
     */
    public boolean routeBetweenNodes(Graph<E> graph, GraphNode<E> source, GraphNode<E> destination) {
        Search<E> search = new BreadthFirstSearch<>();
        Predicate<GraphNode<E>> isFound = n -> n == destination;
        Optional<GraphNode<E>> searchResult = search.search(source, isFound);
        return searchResult.isPresent() ? true : false;
    }
}
