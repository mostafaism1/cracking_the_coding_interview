package org.mostafaism.problemsolving.TreesAndGraphs.Extras.Search;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public class RecursiveDepthFirstSearchTest {

    private DepthFirstSearch<Integer> depthFirstSearch;
    GraphNode<Integer> startNode;
    GraphNode<Integer> adjacentNode;
    GraphNode<Integer> adjacentNode0;
    GraphNode<Integer> adjacentNode1;
    Integer value;
    Integer value0;
    Integer value1;
    Integer value2;
    Integer otherValue;

    @BeforeEach
    void setup() {
        depthFirstSearch = new RecursiveDepthFirstSearch<>();
    }

    @Test
    void givenANullStartNode_whenSearching_thenWillReturnAnEmptyOptional() {
        // Given.
        startNode = null;

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, 0);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void givenAStartNodeWithNoAdjacents_whenSearchingForANodeWithADifferentValueThanTheStartingNode_thenWillReturnAnEmptyOptional() {
        // Given.
        value = 0;
        otherValue = 1;
        startNode = new GraphNode<Integer>(value);

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, otherValue);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void givenAStartNodeWithNoAdjacents_whenSearchingForANodeWithTheSameValueAsTheStartingNode_thenWillReturnAnOptionalOfTheStartNode() {
        // Given.
        value = 0;
        startNode = new GraphNode<Integer>(value);

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, value);

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

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, otherValue);

        // Then.
        then(actual.isEmpty()).isTrue();
    }

    @Test
    void givenAStartNodeWithOneAdjacent_whenSearchingForANodeWithTheSameValueAsTheStartingNode_thenWillReturnAnOptionalOfTheStartNode() {
        // Given.
        value0 = 0;
        value1 = 1;
        adjacentNode = new GraphNode<Integer>(value1);
        startNode = new GraphNode<Integer>(value0, List.of(adjacentNode));

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, value0);

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
        startNode = new GraphNode<Integer>(value0, List.of(adjacentNode));

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, value1);

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
        startNode = new GraphNode<Integer>(value0, List.of(adjacentNode0, adjacentNode1));

        // When.
        Optional<GraphNode<Integer>> actual = depthFirstSearch.search(startNode, value2);

        // Then.
        then(actual.isPresent()).isTrue();
        then(actual.get()).isEqualTo(adjacentNode1);
    }

}
