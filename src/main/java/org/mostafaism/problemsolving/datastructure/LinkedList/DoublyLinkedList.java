package org.mostafaism.problemsolving.datastructure.LinkedList;

@SuppressWarnings({ "unchecked" })
public class DoublyLinkedList<K> implements LinkedList<K> {

    private Node<K> nil;

    public DoublyLinkedList() {
        nil = Node.getNilNode();
    }

    @Override
    public void add(Node<K> node) {
        node.next = getHead();
        getHead().previous = node;
        node.previous = nil;
        nil.next = node;
    }

    @Override
    public void remove(Node<K> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    @Override
    public Node<K> search(K key) {
        Node<K> n = getHead();
        while (!isNil(n) && n.key != key) {
            n = n.next;
        }
        return n;
    }

    @Override
    public boolean isNil(Node<K> node) {
        return node == nil;
    }

    @Override
    public int size() {
        int result = 0;
        Node<K> n = getHead();
        while (!isNil(n)) {
            n = n.next;
            result++;
        }
        return result;
    }

    @Override
    public Node<K> getHead() {
        return nil.next;
    }

    @Override
    public Node<K> getNil() {
        return nil;
    }

    @Override
    public boolean contains(Node<K> node) {
        Node<K> runner = getHead();
        while (!isNil(runner) && runner != node) {
            runner = runner.next;
        }
        return isNil(runner) ? false : true;
    }

    @Override
    public int indexOf(Node<K> node) {
        int result = 0;
        Node<K> runner = getHead();
        while (!isNil(runner) && runner != node) {
            result++;
            runner = runner.next;
        }
        return isNil(runner) ? -1 : result;
    }
}
