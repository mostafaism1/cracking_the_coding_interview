package org.mostafaism.problemsolving.StacksAndQueues.SetOfStacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.mostafaism.problemsolving.datastructure.Stack.DefaultStack;
import org.mostafaism.problemsolving.datastructure.Stack.Stack;

public class DefaultSetOfStacks<E> implements SetOfStacks<E> {

    private final int maxSize;
    private List<Stack<E>> stacks;
    private int count;

    public DefaultSetOfStacks(int maxSize) {
        this.maxSize = maxSize;
        stacks = new ArrayList<>();
        count = maxSize;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (count == 1) {
            var element = stacks.get(stacks.size() - 1).pop();
            removeLastStack();
            return element;
        }
        count--;
        return stacks.get(stacks.size() - 1).pop();
    }

    @Override
    public void push(E item) {
        if (count == maxSize) {
            stacks.add(new DefaultStack<>());
            count = 0;
        }
        stacks.get(stacks.size() - 1).push(item);
        count++;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stacks.get(stacks.size() - 1).peek();
    }

    @Override
    public boolean isEmpty() {
        return stacks.size() == 0;
    }

    @Override
    public E popAt(int index) {
        if (!checkValidIndex(index)) {
            throw new IllegalArgumentException();
        }
        if (!isLastStackIndex(index)) {
            var element = stacks.get(index).pop();
            rollOverStacksAbove(index);
            return element;
        }
        return pop();
    }

    private Stack<E> reverseStack(Stack<E> stack) {
        Stack<E> reverse = new DefaultStack<>();
        while (!stack.isEmpty()) {
            reverse.push(stack.pop());
        }
        return reverse;
    }

    private void rollOverStacksAbove(int index) {
        for (int i = index; i < stacks.size() - 1; i++) {
            rollOver(stacks.get(i), stacks.get(i + 1));
        }
        if (stacks.get(stacks.size() - 1).isEmpty()) {
            removeLastStack();
        }
    }

    /**
     * Shifts the bottom element of stack2 on top of stack1, and shifts the rest of
     * stack2 elements down by 1 on their stack.
     * 
     * @param stack1
     * @param stack2
     */
    private void rollOver(Stack<E> stack1, Stack<E> stack2) {
        if (stack2.isEmpty()) {
            return;
        }
        Stack<E> reverseStack2 = reverseStack(stack2);
        stack1.push(reverseStack2.pop());
        while (!reverseStack2.isEmpty()) {
            stack2.push(reverseStack2.pop());
        }
    }

    private void removeLastStack() {
        stacks.remove(stacks.size() - 1);
        count = maxSize;
    }

    private boolean isLastStackIndex(int index) {
        return index == stacks.size() - 1;
    }

    private boolean checkValidIndex(int index) {
        return index < stacks.size() && index >= 0;
    }

}
