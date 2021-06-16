package org.mostafaism.problemsolving.datastructure.LinkedList;

public class Node<K> {

    public K key;
    public Node<K> next;
    public Node<K> previous;

    public Node(K key, Node<K> next, Node<K> previous) {
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    public Node(K key) {
        this.key = key;
        this.next = null;
        this.previous = null;
    }

    public Node() {
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Node getNilNode() {
        Node nil = new Node();
        nil.next = nil;
        nil.previous = nil;
        return nil;
    }

}
