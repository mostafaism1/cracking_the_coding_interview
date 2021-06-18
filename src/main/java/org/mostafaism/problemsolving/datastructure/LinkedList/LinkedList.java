package org.mostafaism.problemsolving.datastructure.LinkedList;

public interface LinkedList<K> {
    /**
     * Splices node onto the front of the linked list.
     * 
     * @param node the node to add to the linked list.
     */
    void add(Node<K> node);

    /**
     * Removes node from the linked list.
     * 
     * @param node a node.
     */
    void remove(Node<K> node);

    /**
     * Returns the first element with key = key if one exists, otherwise null.
     * 
     * @param key the key to search for.
     * @return the first element with key = key if one exists, otherwise null.
     */
    Node<K> search(K key);

    /**
     * Returns true if node is the nil node, otherwise false.
     * 
     * @param node the node to check.
     * @return true if node is the nil node, otherwise false.
     */
    boolean isNil(Node<K> node);

    /**
     * Returns the number of nodes from this node to the tail node, including the
     * current node.
     * 
     * @return the number of nodes from this node to the tail node, including the
     *         current node.
     */
    int size();

    /**
     * Returns the head node of this list.
     * 
     * @return the head node of this list.
     */
    Node<K> getHead();

    /**
     * Returns the nil node.
     * 
     * @return the nil node.
     */
    Node<K> getNil();

    /**
     * Returns true if node belongs to this list, otherwise false.
     * 
     * @param node a node.
     * @return true if node belongs to this list, otherwise false.
     */
    boolean contains(Node<K> node);
}
