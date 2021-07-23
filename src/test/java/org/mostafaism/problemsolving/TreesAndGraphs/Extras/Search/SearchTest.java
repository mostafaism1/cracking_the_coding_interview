package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public abstract class SearchTest {

    protected Search<Integer> search;
    private Predicate<GraphNode<Integer>> isFound;
    private GraphNode<Integer> startNode;
    private GraphNode<Integer> adjacentNode;
    private GraphNode<Integer> adjacentNode0;
    private GraphNode<Integer> adjacentNode1;
    private Integer value;
    private Integer value0;
    private Integer value1;
    private Integer value2;
    private Integer otherValue;

    @Test
    void givenANullStartNode_whenSearching_thenWillReturnAnEmptyOptional() {
        // Given.
        startNode = null;
        isFound = n -> n.getData() == 0;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void givenAStartNodeWithNoAdjacents_whenSearchingForANodeWithADifferentValueThanTheStartingNode_thenWillReturnAnEmptyOptional() {
        // Given.
        value = 0;
        otherValue = 1;
        startNode = new GraphNode<Integer>(value);
        isFound = n -> n.getData() == otherValue;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void givenAStartNodeWithNoAdjacents_whenSearchingForANodeWithTheSameValueAsTheStartingNode_thenWillReturnAnOptionalOfTheStartNode() {
        // Given.
        value = 0;
        startNode = new GraphNode<Integer>(value);
        isFound = n -> n.getData() == value;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isPresent()).isTrue();
        then(actual.get()).isEqualTo(startNode);
    }

    @Test
    void givenAStartNodeWithOneAdjacent_whenSearchingForANodeWithADifferentValueThanBothNodes_thenWillReturnAnEmptyOptional() {
        // Given.
        value = 0;
        otherValue = 1;
        startNode = new GraphNode<Integer>(value);
        isFound = n -> n.getData() == otherValue;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void givenAStartNodeWithOneAdjacent_whenSearchingForANodeWithTheSameValueAsTheStartingNode_thenWillReturnAnOptionalOfTheStartNode() {
        // Given.
        value0 = 0;
        value1 = 1;
        adjacentNode = new GraphNode<Integer>(value1);
        startNode = new GraphNode<Integer>(value0, Set.of(adjacentNode));
        isFound = n -> n.getData() == value0;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isPresent()).isTrue();
        then(actual.get()).isEqualTo(startNode);
    }

    @Test
    void givenAStartNodeWithOneAdjacent_whenSearchingForANodeWithTheSameValueAsTheAdjacentNode_thenWillReturnAnOptionalOfTheAdjacentNode() {
        // Given.
        value0 = 0;
        value1 = 1;
        adjacentNode = new GraphNode<Integer>(value1);
        startNode = new GraphNode<Integer>(value0, Set.of(adjacentNode));
        isFound = n -> n.getData() == value1;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isPresent()).isTrue();
        then(actual.get()).isEqualTo(adjacentNode);
    }

    @Test
    void givenAStartNodeWithTwoAdjacents_whenSearchingForANodeWithTheSameValueAsTheSecondAdjacentNode_thenWillReturnAnOptionalOfTheSecondAdjacentNode() {
        // Given.
        value0 = 0;
        value1 = 1;
        value2 = 2;
        adjacentNode0 = new GraphNode<Integer>(value1);
        adjacentNode1 = new GraphNode<Integer>(value2);
        startNode = new GraphNode<Integer>(value0, Set.of(adjacentNode0, adjacentNode1));
        isFound = n -> n.getData() == value2;

        // When.
        Optional<GraphNode<Integer>> actual = search.search(startNode, isFound);

        // Then.
        then(actual.isPresent()).isTrue();
        then(actual.get()).isEqualTo(adjacentNode1);
    }

}
