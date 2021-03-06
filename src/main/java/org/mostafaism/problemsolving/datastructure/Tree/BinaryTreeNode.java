package org.mostafaism.problemsolving.datastructure.Tree;

public record BinaryTreeNode<E> (E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {

    public boolean isLeaf() {
        return left == null && right == null;
    }

}
