package org.mostafaism.problemsolving.datastructure.Queue;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public abstract class QueueTest {

    protected Queue<Integer> queue;

    @Test
    void givenEmptyQueue_whenRemove_thenThrowException() {
        // given

        // when, then
        thenThrownBy(() -> queue.remove()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenEmptyQueue_whenPeek_thenThrowException() {
        // given

        // when, then
        thenThrownBy(() -> queue.peek()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void givenQueueOfSizeOne_whenRemove_thenReturnFirstElementAndRemoveIt() {
        // given
        queue.add(1);

        // when
        Integer actual = queue.remove();

        // then
        then(actual).isEqualTo(1);
        then(queue.isEmpty()).isTrue();
    }

    @Test
    void givenQueueOfSizeOne_whenPeek_thenReturnFirstElementButDoNotRemoveIt() {
        // given
        queue.add(1);

        // when
        Integer actual = queue.peek();

        // then
        then(actual).isEqualTo(1);
        then(queue.isEmpty()).isFalse();
    }

    @Test
    void givenQueueOfSizeTwo_whenRemove_thenReturnTopElementAndRemoveIt() {
        // given
        queue.add(1);
        queue.add(2);

        // when
        Integer actual1 = queue.remove();
        Integer actual2 = queue.remove();

        // then
        then(actual1).isEqualTo(1);
        then(actual2).isEqualTo(2);
        then(queue.isEmpty()).isTrue();
    }

    @Test
    void givenQueueOfSizeTwo_whenPeek_thenReturnTopElementButDoNotRemoveIt() {
        // given
        queue.add(1);
        queue.add(2);

        // when
        Integer actual1 = queue.peek();
        queue.remove();
        Integer actual2 = queue.peek();

        // then
        then(actual1).isEqualTo(1);
        then(actual2).isEqualTo(2);
        then(queue.isEmpty()).isFalse();
    }

}
