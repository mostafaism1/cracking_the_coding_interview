package org.mostafaism.problemsolving.StacksAndQueues.SetOfStacks;

import org.mostafaism.problemsolving.datastructure.Stack.Stack;

public interface SetOfStacks<E> extends Stack<E> {
    /**
     * Returns the popped element at the specified index.
     * 
     * @param index an index
     * @return the popped element at the specified index.
     * @throws IllegalArgumentException if index is less than zero or greater than
     *                                  the numbers of stacks -1.
     */
    E popAt(int index);
}
