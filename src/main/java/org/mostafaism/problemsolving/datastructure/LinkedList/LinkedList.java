package org.mostafaism.problemsolving.datastructure.LinkedList;

public interface LinkedList<K> {
    /**
     * Splices node onto the front of the linked list.
     * 
     * @param node the node to add to the linked list
     */
    void add(Node<K> node);

    /**
     * Removes node from the linked list.
     * 
     * @param node
     */
    void remove(Node<K> node);

    /**
     * Returns the first element with key = key if one exists, otherwise null.
     * 
     * @param key the key to search for
     * @return the first element with key = key if one exists, otherwise null
     */
    Node<K> search(K key);

    /**
     * Returns true if node is the nil node, otherwise false.
     * 
     * @param node the node to check
     * @return true if node is the nil node, otherwise false
     */
    boolean isNil(Node<K> node);
}
