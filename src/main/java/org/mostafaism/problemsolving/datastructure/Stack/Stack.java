package org.mostafaism.problemsolving.datastructure.Stack;

import java.util.EmptyStackException;

public interface Stack<E> {
    /**
     * Returns the element at the front of the stack and removes it.
     * 
     * @return the last element pushed.
     * @throws EmptyStackException if the stack is empty.
     */
    E pop();

    /**
     * Adds the specified item to the top of the stack.
     * 
     * @param item an item.
     */
    void push(E item);

    /**
     * Returns the element at the top of the stack.
     * 
     * @return the element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    E peek();

    /**
     * Returns true if the stack is empty, otherwise false.
     * 
     * @return true if the stack is empty, otherwise false.
     */
    boolean isEmpty();
}
