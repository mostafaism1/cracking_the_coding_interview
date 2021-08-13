package org.mostafaism.problemsolving.datastructure.Tree.BinarySearchTree;

public interface BinarySearchTreeNode<E extends Comparable<E>> {
    public static <E extends Comparable<E>> BinarySearchTreeNode<E> empty() {
        return EmptyBinarySearchTreeNode.getInstance();
    }

    public static <E extends Comparable<E>> BinarySearchTreeNode<E> singleton(E value) {
        return new WeightedBinarySearchTreeNode<>(value, empty(), empty());
    }

    /**
     * Returns the data inside this node.
     * 
     * @return the data inside this node
     * @throws UnsupportedOperationException if isEmpty()
     */
    E getData();

    /**
     * Returns the left child if !isEmpty(), otherwise an empty node.
     * 
     * @return the left child if !isEmpty(), otherwise an empty node
     */
    BinarySearchTreeNode<E> getLeft();

    /**
     * Returns the right child if !isEmpty(), otherwise an empty node.
     * 
     * @return the right child if !isEmpty(), otherwise an empty node
     */
    BinarySearchTreeNode<E> getRight();

    /**
     * Returns the weight of this node, which is the number of nodes contained in
     * the tree whose root is this node.
     * 
     * @return the weight of this node, which is the number of nodes contained in
     *         the tree whose root is this node
     */
    int getWeight();

    /**
     * Returns true if this node is a leaf node, otherwise false.
     * 
     * @return true if this node is a leaf node, otherwise false
     */
    boolean isLeaf();

    /**
     * Returns true if this node is an empty node, otherwise false.
     *
     * @return true if this node is an empty node, otherwise false
     */
    boolean isEmpty();

    /**
     * Inserts a node with the specified value at the proper position in the tree
     * whose root is this node such that the tree remains a binary search tree after
     * the insertion.
     * 
     * @param value a value to insert
     * @throws UnsupportedOperationException if isEmpty()
     */
    void insert(E value);

    /**
     * Returns a node with the specified value if it exists, otherwise an empty
     * node.
     * 
     * @param value a value to search for in this tree
     * @return a node with the specified value if it exists, otherwise an empty node
     */
    BinarySearchTreeNode<E> find(E value);

    /**
     * Returns the new tree after deleting the specified node, and re-structures the
     * tree such that the tree remains a binary search tree.
     * 
     * @param node a node
     */
    BinarySearchTreeNode<E> delete(BinarySearchTreeNode<E> node);

    /**
     * Returns a random node contained in this tree. All nodes are equally likely to
     * be returned.
     * 
     * @return a random node contained in this tree. All nodes are equally likely to
     *         be returned
     */
    BinarySearchTreeNode<E> getRandomNode();
}
