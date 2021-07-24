package org.mostafaism.problemsolving.TreesAndGraphs.BuildOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.mostafaism.problemsolving.datastructure.Graph.Graph;
import org.mostafaism.problemsolving.datastructure.Graph.GraphNode;

public class BuildOrder<E> {
    /**
     * Returns a list of the projects with the list's projects respecting the
     * dependencies, such that for any dependency, if y depends x, then x appears
     * before y in the list.
     * 
     * @param projects     a list of projects; must not be null
     * @param dependencies a list of dependencies between the projects; must not be
     *                     null; each dependency entry is interpreted as follow:
     *                     Entry.value depends on Entry.key
     * @return a list of the projects with the list's sequence respecting the
     *         dependencies, such that for any dependency, if y depends x, then x
     *         appears before y in the list.
     * @throws NoValidBuildOrderException if there is no valid build order
     */
    public List<E> buildOrder(Set<E> projects, Set<Entry<E, E>> dependencies) throws NoValidBuildOrderException {
        Graph<E> graph = generateDependencyGraph(projects, dependencies);
        checkAcyclic(graph);
        Set<GraphNode<E>> nodesWithNoIncomingEdges = getNodesWithNoIncomingEdges(graph);
        return traverseNodes(nodesWithNoIncomingEdges);
    }

    private Graph<E> generateDependencyGraph(Set<E> data, Set<Entry<E, E>> dependencies) {
        Set<GraphNode<E>> graphNodes = new HashSet<>();
        for (E datum : data) {
            GraphNode<E> graphNode = new GraphNode<>(datum);
            graphNodes.add(graphNode);
        }
        for (Entry<E, E> dependency : dependencies) {
            GraphNode<E> dependee = graphNodes.stream().filter(n -> n.getData().equals(dependency.getKey())).findAny()
                    .orElseThrow(() -> new IllegalArgumentException(
                            "A dependency contains a project that does not belong to the projects"));
            GraphNode<E> dependent = graphNodes.stream().filter(n -> n.getData().equals(dependency.getValue()))
                    .findAny().orElseThrow(() -> new IllegalArgumentException(
                            "A dependency contains a project that does not belong to the projects"));
            dependee.addAdjacent(dependent);
        }
        Graph<E> graph = new Graph<>(graphNodes);
        return graph;
    }

    private void checkAcyclic(Graph<E> graph) throws NoValidBuildOrderException {
        if (isCyclic(graph)) {
            throw new NoValidBuildOrderException();
        }
    }

    private boolean isCyclic(Graph<E> graph) {
        boolean result = false;
        Set<GraphNode<E>> visited = new HashSet<>();
        for (GraphNode<E> n : graph.getNodes()) {
            if (visited.contains(n)) {
                continue;
            }
            Set<GraphNode<E>> beingVisited = new HashSet<>();
            result |= isNodeTraversalCyclic(n, visited, beingVisited);
            if (result) {
                break;
            }
        }
        return result;
    }

    private boolean isNodeTraversalCyclic(GraphNode<E> graphNode, Set<GraphNode<E>> visited,
            Set<GraphNode<E>> beingVisited) {
        if (visited.contains(graphNode)) {
            return false;
        }

        // Base case.
        if (beingVisited.contains(graphNode)) {
            visited.add(graphNode);
            return true;
        }

        // Recursive step.
        boolean result = false;
        beingVisited.add(graphNode);
        for (GraphNode<E> n : graphNode.getAdjacents()) {
            result |= isNodeTraversalCyclic(n, visited, beingVisited);
            if (result) {
                break;
            }
        }
        beingVisited.remove(graphNode);
        visited.add(graphNode);
        return result;
    }

    private Set<GraphNode<E>> getNodesWithNoIncomingEdges(Graph<E> acyclicGraph) {
        return acyclicGraph.getNodes().stream().filter(n -> !hasAnIncomingEdges(acyclicGraph, n))
                .collect(Collectors.toSet());
    }

    private boolean hasAnIncomingEdges(Graph<E> graph, GraphNode<E> graphNode) {
        return graph.getNodes().stream().flatMap(n -> n.getAdjacents().stream()).anyMatch(graphNode::equals);
    }

    private List<E> traverseNodes(Set<GraphNode<E>> nodesWithNoIncomingEdges) {
        List<E> result = new LinkedList<>();
        Set<GraphNode<E>> visited = new HashSet<>();
        for (GraphNode<E> n : nodesWithNoIncomingEdges) {
            // Insert new traversed nodes at the front of the list, since the new
            // traversed nodes could be higher up on the same tree.
            result.addAll(0, traverseNode(n, visited));
        }
        return result;
    }

    // Traverse the node, visiting only unvisited nodes.
    private List<E> traverseNode(GraphNode<E> node, Set<GraphNode<E>> visited) {
        if (visited.contains(node)) {
            return Collections.emptyList();
        }
        visited.add(node);

        // Base case.
        if (node.isLeaf()) {
            return List.of(node.getData());
        }

        // Recursive step.
        List<E> result = new ArrayList<>();
        result.add(node.getData());
        for (GraphNode<E> child : node.getAdjacents()) {
            result.addAll(traverseNode(child, visited));
        }
        return result;
    }
}
