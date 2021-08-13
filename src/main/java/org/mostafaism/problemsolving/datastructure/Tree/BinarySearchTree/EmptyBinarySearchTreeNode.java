package org.mostafaism.problemsolving.datastructure.Tree.BinarySearchTree;

public class EmptyBinarySearchTreeNode<E extends Comparable<E>> implements BinarySearchTreeNode<E> {
    @SuppressWarnings("rawtypes")
    private static final EmptyBinarySearchTreeNode INSTANCE = new EmptyBinarySearchTreeNode<>();

    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> EmptyBinarySearchTreeNode<E> getInstance() {
        return (EmptyBinarySearchTreeNode<E>) INSTANCE;
    }

    private EmptyBinarySearchTreeNode() {
    }

    @Override
    public E getData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public BinarySearchTreeNode<E> getLeft() {
        return getInstance();
    }

    @Override
    public BinarySearchTreeNode<E> getRight() {
        return getInstance();
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void insert(E value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BinarySearchTreeNode<E> find(E value) {
        return getInstance();
    }

    @Override
    public BinarySearchTreeNode<E> delete(BinarySearchTreeNode<E> node) {
        return getInstance();
    }

    @Override
    public BinarySearchTreeNode<E> getRandomNode() {
        return getInstance();
    }
}
