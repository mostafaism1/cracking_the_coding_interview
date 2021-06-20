package org.mostafaism.problemsolving.datastructure.Queue;

import java.util.NoSuchElementException;

public class DefaultQueue<E> implements Queue<E> {

    private static class QueueNode<E> {
        private E data;
        private QueueNode<E> next;

        public QueueNode(E data) {
            this.data = data;
        }
    }

    private QueueNode<E> first;
    private QueueNode<E> last;

    @Override
    public void add(E item) {
        var node = new QueueNode<>(item);
        if (last == null) {
            last = node;
            first = last;
        } else {
            last.next = node;
            last = node;
        }
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        var data = first.data;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

}
