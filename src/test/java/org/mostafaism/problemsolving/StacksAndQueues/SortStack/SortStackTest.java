package org.mostafaism.problemsolving.StacksAndQueues.SortStack;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Stack.Stack;

public class SortStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new SortStack<>();
    }

    @Test
    void givenEmptyStack_whenPop_shouldThrowException() {
        // given

        // when, then
        thenThrownBy(() -> stack.pop()).isInstanceOf(EmptyStackException.class);
    }

    @Test
    void givenStackOfSizeOne_whenPop_shouldReturnTopElementAndRemoveIt() {
        // given
        stack.push(1);

        // when
        Integer actual = stack.pop();

        // then
        then(actual).isEqualTo(1);
        then(stack.isEmpty()).isTrue();
    }

    @Test
    void givenStackOfSizeTwo_whenPop_shouldReturnSmallerElementAndRemoveIt() {
        // given
        stack.push(1);
        stack.push(2);

        // when
        Integer actual1 = stack.pop();
        Integer actual2 = stack.pop();

        // then
        then(actual1).isEqualTo(1);
        then(actual2).isEqualTo(2);
        then(stack.isEmpty()).isTrue();
    }

    @Test
    void givenEmptyStack_whenPeek_shouldThrowException() {
        // given

        // when, then
        thenThrownBy(() -> stack.peek()).isInstanceOf(EmptyStackException.class);
    }

    @Test
    void givenStackOfSizeOne_whenPeek_shouldReturnTopElementAndNotMutateTheStack() {
        // given
        stack.push(1);

        // when
        Integer actual = stack.peek();

        // then
        then(actual).isEqualTo(1);
        then(stack.isEmpty()).isFalse();
    }

    @Test
    void givenStackOfSizeTwo_whenPeek_shouldReturnSmallerElementAndNotMutateTheStack() {
        // given
        stack.push(1);
        stack.push(2);

        // when
        Integer actual1 = stack.peek();
        stack.pop();
        Integer actual2 = stack.peek();

        // then
        then(actual1).isEqualTo(1);
        then(actual2).isEqualTo(2);
        then(stack.isEmpty()).isFalse();
    }
}
