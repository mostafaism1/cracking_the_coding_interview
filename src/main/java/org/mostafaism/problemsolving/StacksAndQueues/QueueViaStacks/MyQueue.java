package org.mostafaism.problemsolving.StacksAndQueues.QueueViaStacks;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.mostafaism.problemsolving.datastructure.Queue.Queue;
import org.mostafaism.problemsolving.datastructure.Stack.DefaultStack;
import org.mostafaism.problemsolving.datastructure.Stack.Stack;

public class MyQueue<E> implements Queue<E> {

    private Stack<E> stack;

    public MyQueue() {
        stack = new DefaultStack<>();
    }

    @Override
    public void add(E item) {
        Stack<E> temp = new DefaultStack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(item);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    @Override
    public E remove() {
        try {
            return stack.pop();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E peek() {
        try {
            return stack.peek();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
