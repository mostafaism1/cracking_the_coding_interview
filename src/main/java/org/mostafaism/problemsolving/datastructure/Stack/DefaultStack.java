package org.mostafaism.problemsolving.datastructure.Stack;

import java.util.EmptyStackException;

public class DefaultStack<E> implements Stack<E> {

    private static class StackNode<E> {
        private E data;
        private StackNode<E> next;

        public StackNode(E data) {
            this.data = data;
        }
    }

    private StackNode<E> top;

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public void push(E item) {
        var node = new StackNode<E>(item);
        node.next = top;
        top = node;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
