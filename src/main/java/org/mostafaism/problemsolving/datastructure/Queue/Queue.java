package org.mostafaism.problemsolving.datastructure.Queue;

import java.util.NoSuchElementException;

public interface Queue<E> {
    /**
     * Adds the item to the queue.
     * 
     * @param item an item.
     */
    void add(E item);

    /**
     * Returns the element at the front of the queue and removes it.
     * 
     * @return the element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    E remove();

    /**
     * Returns the element at the front of the queue.
     * 
     * @return the element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    E peek();

    /**
     * Returns true if the queue is empty, otherwise false.
     * 
     * @return true if the queue is empty, otherwise false.
     */

    boolean isEmpty();
}
