package org.mostafaism.problemsolving.TreesAndGraphs.BstSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.mostafaism.problemsolving.datastructure.Tree.BinaryTreeNode;

public class BstSequences {
    /**
     * Returns a set of all possible lists that could have generated the specified
     * binary tree if the lists were to be traversed in order.
     * 
     * @param <E>  the nodes datatype
     * @param root a binary tree
     * @return a set of all possible lists that could have generated the specified
     *         binary tree if the lists were to be traversed in order.
     */
    public <E> Set<List<E>> bstSequences(BinaryTreeNode<E> root) {
        // Base cases.
        if (root == null) {
            return Set.of();
        }
        if (root.isLeaf()) {
            return Set.of(List.of(root.data()));
        }

        // Recursive step.
        Set<List<E>> leftResult = bstSequences(root.left());
        Set<List<E>> rightResult = bstSequences(root.right());
        Set<List<E>> interleavedChildrenResults = interleaveOuterCollections(leftResult, rightResult);
        UnaryOperator<List<E>> prependRootValue = list -> {
            List<E> result = new ArrayList<>();
            result.add(root.data());
            result.addAll(list);
            return result;
        };
        return interleavedChildrenResults.stream().map(prependRootValue).collect(Collectors.toSet());
    }

    private <E> Set<List<E>> interleaveOuterCollections(Set<List<E>> outerCollection1, Set<List<E>> outerCollection2) {
        if (outerCollection1.isEmpty()) {
            return outerCollection2;
        }
        if (outerCollection2.isEmpty()) {
            return outerCollection1;
        }
        Set<List<E>> result = new HashSet<>();
        for (List<E> list1 : outerCollection1) {
            for (List<E> list2 : outerCollection2) {
                result.addAll(interleaveInnerCollections(list1, list2));
            }
        }
        return result;
    }

    private <E> Set<List<E>> interleaveInnerCollections(List<E> list1, List<E> list2) {
        // Base cases.
        if (list1.isEmpty()) {
            return Set.of(list2);
        }
        if (list2.isEmpty()) {
            return Set.of(list1);
        }

        // Recursive step.
        Set<List<E>> result = new HashSet<>();
        for (int i = 0; i <= list1.size(); i++) {
            List<E> prefix = new ArrayList<>();
            prefix.addAll(list1.subList(0, i));
            prefix.add(list2.get(0));
            UnaryOperator<List<E>> prependPrefix = list -> {
                List<E> resultList = new ArrayList<>();
                resultList.addAll(prefix);
                resultList.addAll(list);
                return resultList;
            };
            List<E> nextList1 = list1.subList(i, list1.size());
            List<E> nextList2 = list2.subList(1, list2.size());
            result.addAll(interleaveInnerCollections(nextList1, nextList2).stream().map(prependPrefix)
                    .collect(Collectors.toSet()));
        }
        return result;
    }

}
