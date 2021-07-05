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
        // Maintain the shape property by adding at the end.
        tree.add(item);
        // Fix the heap property by bubbling up.
        bubbleUp();
    }

    @Override
    public E extractMin() {
        if (tree.size() == 0) {
            return null;
        }
        // Maintain the shape property by swapping the root with the last element.
        E min = extractRoot();
        // Fix the heap property by bubbling down.
        bubbleDown();
        return min;
    }

    // Helper methods.

    private void bubbleUp() {
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

    private void bubbleDown() {
        int itemIndex = 0;
        while (itemIndex < tree.size() - 1) {
            int minChildIndex = getMinChildIndex(itemIndex);
            if (minChildIndex == -1 || !isSmaller(minChildIndex, itemIndex)) {
                break;
            }
            swap(itemIndex, minChildIndex);
            itemIndex = minChildIndex;
        }
    }

    private int getMinChildIndex(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        if (leftChildIndex > tree.size() - 1) {
            return -1;
        }
        if (rightChildIndex > tree.size() - 1) {
            return leftChildIndex;
        }
        return isSmaller(leftChildIndex, rightChildIndex) ? leftChildIndex : rightChildIndex;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private E extractRoot() {
        E min = tree.get(0);
        tree.set(0, tree.get(tree.size() - 1));
        tree.remove(tree.size() - 1);
        return min;
    }

    private boolean isRoot(int index) {
        return index == 0;
    }

    private boolean isSmaller(int index1, int index2) {
        return tree.get(index1).compareTo(tree.get(index2)) < 0;
    }

    private void swap(int index1, int index2) {
        E temp = tree.get(index2);
        tree.set(index2, tree.get(index1));
        tree.set(index1, temp);
    }

}
