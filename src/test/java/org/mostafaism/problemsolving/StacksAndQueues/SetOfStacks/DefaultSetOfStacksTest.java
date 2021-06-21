package org.mostafaism.problemsolving.StacksAndQueues.SetOfStacks;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.Stack.StackTest;

public class DefaultSetOfStacksTest extends StackTest {

    private int maxSize = 2;
    private SetOfStacks<Integer> setOfStacks;

    @BeforeEach
    void setup() {
        stack = new DefaultSetOfStacks<>(maxSize);
        setOfStacks = new DefaultSetOfStacks<>(maxSize);
    }

    @Test
    void givenEmptyStack_WhenPopAt_ThenThrowException() {
        // given

        // when, then
        thenThrownBy(() -> setOfStacks.popAt(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenStackOfSizeOne_WhenPopAtZero_ThenPop() {
        // given
        setOfStacks.push(1);

        // when
        Integer actual = setOfStacks.popAt(0);

        // then
        then(actual).isOne();
    }

    @Test
    void givenStackOfSizeOne_WhenPopAtOne_ThenThrowException() {
        // given
        setOfStacks.push(1);

        // when, then
        thenThrownBy(() -> setOfStacks.popAt(1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenStackOfSizeOne_WhenPopAtNegativeOne_ThenThrowException() {
        // given
        setOfStacks.push(1);

        // when, then
        thenThrownBy(() -> setOfStacks.popAt(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenStackOfSizeTwo_WhenPopAtZero_ThenPopTopElement() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);

        // when
        Integer actual = setOfStacks.popAt(0);

        // then
        then(actual).isEqualTo(2);
    }

    @Test
    void givenStackOfSizeThree_WhenPopAtOne_ThenPopTopElement() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        // when
        Integer actual = setOfStacks.popAt(1);

        // then
        then(actual).isEqualTo(3);
    }

    @Test
    void givenStackOfSizeThree_WhenPopAtZero_ThenPopInnerStackAndRollOver() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        // when
        Integer actual1 = setOfStacks.popAt(0);
        Integer actual2 = setOfStacks.popAt(0);
        Integer actual3 = setOfStacks.popAt(0);

        // then
        then(actual1).isEqualTo(2);
        then(actual2).isEqualTo(3);
        then(actual3).isEqualTo(1);
        then(setOfStacks.isEmpty()).isTrue();
    }

    @Test
    void givenStackOfSizeFour_WhenPopAtOne_ThenPopTopElement() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);

        // when
        Integer actual = setOfStacks.popAt(1);

        // then
        then(actual).isEqualTo(4);
    }

    @Test
    void givenStackOfSizeFour_WhenPopAtZero_ThenPopInnerStackAndRollOver() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);

        // when
        Integer actual1 = setOfStacks.popAt(0);
        Integer actual2 = setOfStacks.popAt(0);
        Integer actual3 = setOfStacks.popAt(0);
        Integer actual4 = setOfStacks.popAt(0);

        // then
        then(actual1).isEqualTo(2);
        then(actual2).isEqualTo(3);
        then(actual3).isEqualTo(4);
        then(actual4).isEqualTo(1);
        then(setOfStacks.isEmpty()).isTrue();
    }

    @Test
    void givenStackOfSizeFive_WhenPopAtTwo_ThenPopTopElement() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        // when
        Integer actual = setOfStacks.popAt(2);

        // then
        then(actual).isEqualTo(5);
    }

    @Test
    void givenStackOfSizeFive_WhenPopAtOne_ThenPopInnerStackAndRollOver() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        // when
        Integer actual1 = setOfStacks.popAt(1);
        Integer actual2 = setOfStacks.popAt(1);
        Integer actual3 = setOfStacks.popAt(1);
        Integer actual4 = setOfStacks.popAt(0);
        Integer actual5 = setOfStacks.popAt(0);

        // then
        then(actual1).isEqualTo(4);
        then(actual2).isEqualTo(5);
        then(actual3).isEqualTo(3);
        then(actual4).isEqualTo(2);
        then(actual5).isEqualTo(1);
        then(setOfStacks.isEmpty()).isTrue();
    }

    @Test
    void givenStackOfSizeFive_WhenPopAtZero_ThenPopInnerStackAndRollOver() {
        // given
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        // when
        Integer actual1 = setOfStacks.popAt(0);
        Integer actual2 = setOfStacks.popAt(0);
        Integer actual3 = setOfStacks.popAt(0);
        Integer actual4 = setOfStacks.popAt(0);
        Integer actual5 = setOfStacks.popAt(0);

        // then
        then(actual1).isEqualTo(2);
        then(actual2).isEqualTo(3);
        then(actual3).isEqualTo(4);
        then(actual4).isEqualTo(5);
        then(actual5).isEqualTo(1);
        then(setOfStacks.isEmpty()).isTrue();
    }

}
