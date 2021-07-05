package org.mostafaism.problemsolving.datastructure.Heap;

import java.util.ArrayList;
import java.util.List;

public class DefaultMinHeap<E extends Comparable<E>> implements MinHeap<E> {

    private List<E> tree;

    public DefaultMinHeap() {
        this.tree = new ArrayList<>();
    }

    @Override
    public void insert(E item) {
        // Maintain the shape property.
        tree.add(item);
        // Fix the heap property by bubbling up.
        int itemIndex = tree.size() - 1;
        while (!isRoot(itemIndex)) {
            int parentIndex = getParentIndex(itemIndex);
            if (!isSmaller(itemIndex, parentIndex)) {
                break;
            }
            swap(itemIndex, parentIndex);
            itemIndex = parentIndex;
        }
    }

    @Override
    public E extractMin() {
        if (tree.size() == 0) {
            return null;
        }
        // Maintain the shape property.
        E min = extractRoot();
        // Fix the heap property by bubbling down.
        int elementIndex = 0;
        while (elementIndex < tree.size() - 1) {
            int minChildIndex = getMinChildIndex(elementIndex);
            if (minChildIndex == -1 || !isSmaller(minChildIndex, elementIndex)) {
                break;
            }
            swap(elementIndex, minChildIndex);
            elementIndex = minChildIndex;
        }
        return min;
    }

    // Helper methods.

    private int getMinChildIndex(int elementIndex) {
        int leftChildIndex = getLeftChildIndex(elementIndex);
        int rightChildIndex = getRightChildIndex(elementIndex);
        if (leftChildIndex > tree.size() - 1) {
            return -1;
        }
        if (rightChildIndex > tree.size() - 1) {
            return leftChildIndex;
        }
        return isSmaller(leftChildIndex, rightChildIndex) ? leftChildIndex : rightChildIndex;
    }

    private int getParentIndex(int itemIndex) {
        return (itemIndex - 1) / 2;
    }

    private boolean isRoot(int index) {
        return index == 0;
    }

    private boolean isSmaller(int itemIndex, int parentIndex) {
        return tree.get(itemIndex).compareTo(tree.get(parentIndex)) < 0;
    }

    private void swap(int index1, int index2) {
        E temp = tree.get(index2);
        tree.set(index2, tree.get(index1));
        tree.set(index1, temp);
    }

    private int getRightChildIndex(int elementIndex) {
        return 2 * elementIndex + 2;
    }

    private int getLeftChildIndex(int elementIndex) {
        return 2 * elementIndex + 1;
    }

    private E extractRoot() {
        E min = tree.get(0);
        tree.set(0, tree.get(tree.size() - 1));
        tree.remove(tree.size() - 1);
        return min;
    }

}
