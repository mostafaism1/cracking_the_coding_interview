package org.mostafaism.problemsolving.StacksAndQueues.SortStack;

import org.mostafaism.problemsolving.datastructure.Stack.DefaultStack;
import org.mostafaism.problemsolving.datastructure.Stack.Stack;

public class SortStack<E extends Comparable<E>> implements Stack<E> {

    private Stack<E> sortedStack;

    public SortStack() {
        this.sortedStack = new DefaultStack<>();
    }

    @Override
    public E pop() {
        return sortedStack.pop();
    }

    @Override
    public void push(E item) {
        Stack<E> temp = new DefaultStack<>();
        while (!sortedStack.isEmpty()) {
            if (item.compareTo(sortedStack.peek()) <= 0) {
                break;
            }
            temp.push(sortedStack.pop());
        }
        sortedStack.push(item);
        while (!temp.isEmpty()) {
            sortedStack.push(temp.pop());
        }
    }

    @Override
    public E peek() {
        return sortedStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return sortedStack.isEmpty();
    }

}
