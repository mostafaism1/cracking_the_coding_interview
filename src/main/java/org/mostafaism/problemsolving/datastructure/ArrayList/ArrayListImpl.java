package org.mostafaism.problemsolving.datastructure.ArrayList;

import java.util.Arrays;

public class ArrayListImpl<E> implements org.mostafaism.problemsolving.datastructure.ArrayList.ArrayList<E> {
    private static final int INITIAL_CAPACITY = 2;
    private static final int MULTIPLY_FACTOR = 2;

    private Object[] elements;
    private int count;

    public ArrayListImpl(int initialCapacity) {
        elements = new Object[initialCapacity];
        count = 0;
    }

    public ArrayListImpl() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public void push(E element) {
        if (count == elements.length) {
            increaseCapacity();
        }

        elements[count++] = element;
    }

    @Override
    public void set(int index, E value) {
        if (index >= count) {
            throw new IndexOutOfBoundsException();
        }

        elements[index] = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= count) {
            throw new IndexOutOfBoundsException();
        }

        return (E) elements[index];
    }

    private void increaseCapacity() {
        int newLength = elements.length * MULTIPLY_FACTOR;
        Object[] newArray = Arrays.copyOf(elements, newLength);
        elements = newArray;
    }
}
