package org.mostafaism.problemsolving.TreesAndGraphs.RouteBetweenNodes;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Graph.Graph;
import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public class RouteBetweenNodesTest {
    /*
     * Testing strategy for {@code boolean routeBetweenNodes(Graph<E> graph,
     * GraphNode<E> source, GraphNode<E> destination)}
     * 
     * Cover the subdomains of these partitions:
     * 
     * Partition on graph.nodes().size(): 2, > 2
     * 
     * Partition on source.adjacents().size(): 0, > 0
     * 
     * Partition on destination.adjacents().size(): 0, > 0
     * 
     * Partition on RouteBetweenNodes.routeBetweenNodesTest(graph, source,
     * destination): True, false
     * 
     */

    private RouteBetweenNodes<Integer> routeBetweenNodes;
    private Graph<Integer> graph;
    private GraphNode<Integer> source;
    private GraphNode<Integer> destination;
    private GraphNode<Integer> extraNode;
    int value = 0;

    @BeforeEach
    void setup() {
        routeBetweenNodes = new RouteBetweenNodes<>();
    }

    /*
     * Covers: graph.nodes().size() = 2, source.adjacents().size() = 0,
     * destination.adjacents().size() = 0, routeBetweenNodesTest() is false
     */
    @Test
    void givenAGraphOfSizeTwoAndNoPathFromSourceToDestination_thenWillReturnFalse() {
        // Given.
        source = new GraphNode<>(value);
        destination = new GraphNode<>(value);
        graph = new Graph<>(List.of(source, destination));

        // When.
        boolean actual = routeBetweenNodes.routeBetweenNodes(graph, source, destination);

        // Then.
        then(actual).isFalse();
    }

    /*
     * Covers: graph.nodes().size() > 2, source.adjacents().size() > 0,
     * destination.adjacents().size() > 0, routeBetweenNodesTest() is true
     */
    @Test
    void givenAGraphOfSizeThreeAndAPathFromSourceToDestination_thenWillReturnTrue() {
        // Given.
        extraNode = new GraphNode<>(value);
        destination = new GraphNode<>(value, Set.of(extraNode));
        source = new GraphNode<>(value, Set.of(destination, extraNode));
        graph = new Graph<>(List.of(source, destination));

        // When.
        boolean actual = routeBetweenNodes.routeBetweenNodes(graph, source, destination);

        // Then.
        then(actual).isTrue();
    }

}
