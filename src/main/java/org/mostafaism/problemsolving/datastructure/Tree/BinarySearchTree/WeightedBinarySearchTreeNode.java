package org.mostafaism.problemsolving.datastructure.Tree.BinarySearchTree;

import java.util.Random;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeightedBinarySearchTreeNode<E extends Comparable<E>> implements BinarySearchTreeNode<E> {
    E data;
    BinarySearchTreeNode<E> left;
    BinarySearchTreeNode<E> right;

    @Override
    public E getData() {
        return data;
    }

    @Override
    public BinarySearchTreeNode<E> getLeft() {
        return left;
    }

    @Override
    public BinarySearchTreeNode<E> getRight() {
        return right;
    }

    @Override
    public int getWeight() {
        return 1 + left.getWeight() + right.getWeight();
    }

    @Override
    public boolean isLeaf() {
        return left.isEmpty() && right.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void insert(E value) {
        // Base cases.
        if (left.isEmpty() && value.compareTo(data) <= 0) {
            left = BinarySearchTreeNode.singleton(value);
            return;
        } else if (right.isEmpty() && value.compareTo(data) > 0) {
            right = BinarySearchTreeNode.singleton(value);
            return;
        }
        // Recursive step.
        if (value.compareTo(data) < 0) {
            left.insert(value);
        } else {
            right.insert(value);
        }
    }

    @Override
    public BinarySearchTreeNode<E> find(E value) {
        // Base case.
        if (data == value) {
            return this;
        }
        // Recursive step.
        return value.compareTo(data) < 0 ? left.find(value) : right.find(value);
    }

    @Override
    public BinarySearchTreeNode<E> delete(BinarySearchTreeNode<E> node) {
        // Base cases.
        if (node.equals(this)) {
            return isLeaf() ? BinarySearchTreeNode.empty()
                    : left.isEmpty() ? right : right.isEmpty() ? left : promoteRightSubtreeSmallestNode();
        }
        // Recursive step.
        return deleteFromChildren(node);
    }

    private WeightedBinarySearchTreeNode<E> promoteRightSubtreeSmallestNode() {
        BinarySearchTreeNode<E> smallestRightNode = getMinimalNode(right);
        data = smallestRightNode.getData();
        right = right.delete(smallestRightNode);
        return this;
    }

    /**
     * Returns the node with the smallest value in the tree whose root is specified
     * node.
     * 
     * @param node a node
     * @return the node with the smallest value in the tree whose root is specified
     *         node
     */
    private BinarySearchTreeNode<E> getMinimalNode(BinarySearchTreeNode<E> node) {
        return node.getLeft().isEmpty() ? node : getMinimalNode(node.getLeft());
    }

    private BinarySearchTreeNode<E> deleteFromChildren(BinarySearchTreeNode<E> node) {
        left = node.getData().compareTo(data) < 0 ? left.delete(node) : left;
        right = node.getData().compareTo(data) > 0 ? right.delete(node) : right;
        return this;
    }

    @Override
    public BinarySearchTreeNode<E> getRandomNode() {
        var randomNumber = new Random().nextInt(getWeight());
        return randomNumber == 0 ? this
                : randomNumber <= left.getWeight() ? left.getRandomNode() : right.getRandomNode();
    }
}
