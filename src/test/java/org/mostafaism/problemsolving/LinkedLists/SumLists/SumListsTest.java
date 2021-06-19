package org.mostafaism.problemsolving.LinkedLists.SumLists;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class SumListsTest {

    private SumLists sumLists;
    private LinkedList<Integer> listA;
    private LinkedList<Integer> listB;
    private LinkedList<Integer> expected;

    Node<Integer> nodeA0;
    Node<Integer> nodeA1;
    Node<Integer> nodeA2;
    Node<Integer> nodeA3;
    Node<Integer> nodeA4;
    Node<Integer> nodeA5;
    Node<Integer> nodeA6;
    Node<Integer> nodeA7;
    Node<Integer> nodeA8;
    Node<Integer> nodeA9;

    Node<Integer> nodeB0;
    Node<Integer> nodeB1;
    Node<Integer> nodeB2;
    Node<Integer> nodeB3;
    Node<Integer> nodeB4;
    Node<Integer> nodeB5;
    Node<Integer> nodeB6;
    Node<Integer> nodeB7;
    Node<Integer> nodeB8;
    Node<Integer> nodeB9;

    Node<Integer> nodeE0;
    Node<Integer> nodeE1;
    Node<Integer> nodeE2;
    Node<Integer> nodeE3;
    Node<Integer> nodeE4;
    Node<Integer> nodeE5;
    Node<Integer> nodeE6;
    Node<Integer> nodeE7;
    Node<Integer> nodeE8;
    Node<Integer> nodeE9;

    @BeforeEach
    void setup() {
        sumLists = new SumLists();
        listA = new DoublyLinkedList<>();
        listB = new DoublyLinkedList<>();
        expected = new DoublyLinkedList<>();

        nodeA0 = new Node<>(0);
        nodeA1 = new Node<>(1);
        nodeA2 = new Node<>(2);
        nodeA3 = new Node<>(3);
        nodeA4 = new Node<>(4);
        nodeA5 = new Node<>(5);
        nodeA6 = new Node<>(6);
        nodeA7 = new Node<>(7);
        nodeA8 = new Node<>(8);
        nodeA9 = new Node<>(9);

        nodeB0 = new Node<>(0);
        nodeB1 = new Node<>(1);
        nodeB2 = new Node<>(2);
        nodeB3 = new Node<>(3);
        nodeB4 = new Node<>(4);
        nodeB5 = new Node<>(5);
        nodeB6 = new Node<>(6);
        nodeB7 = new Node<>(7);
        nodeB8 = new Node<>(8);
        nodeB9 = new Node<>(9);

        nodeE0 = new Node<>(0);
        nodeE1 = new Node<>(1);
        nodeE2 = new Node<>(2);
        nodeE3 = new Node<>(3);
        nodeE4 = new Node<>(4);
        nodeE5 = new Node<>(5);
        nodeE6 = new Node<>(6);
        nodeE7 = new Node<>(7);
        nodeE8 = new Node<>(8);
        nodeE9 = new Node<>(9);
    }

    @Test
    void it_should_return_empty_list_when_the_input_lists_are_empty() {
        // given

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_first_list_when_the_second_input_list_is_empty() {
        // given
        listA.add(nodeA0);
        expected.add(nodeE0);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_second_list_when_the_first_input_list_is_empty() {
        // given
        listB.add(nodeB0);
        expected.add(nodeE0);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_both_input_lists_size_is_1_and_the_sum_produces_no_carry() {
        // given
        listA.add(nodeA1);
        listB.add(nodeB2);
        expected.add(nodeE3);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_both_input_lists_size_is_1_and_the_sum_produces_a_carry() {
        // given
        listA.add(nodeA5);
        listB.add(nodeB5);
        expected.add(nodeE0);
        expected.add(nodeE1);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_1_and_the_second_list_size_is_2_and_the_sum_produces_no_carry() {
        // given
        listA.add(nodeA3);
        listB.add(nodeB4);
        listB.add(nodeB5);
        expected.add(nodeE7);
        expected.add(nodeE5);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_1_and_the_second_list_size_is_2_and_the_sum_produces_a_single_carry() {
        // given
        listA.add(nodeA9);
        listB.add(nodeB8);
        listB.add(nodeB5);
        expected.add(nodeE7);
        expected.add(nodeE6);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_1_and_the_second_list_size_is_2_and_the_sum_produces_2_carries() {
        // given
        listA.add(nodeA9);
        listB.add(nodeB8);
        listB.add(nodeB9);
        expected.add(nodeE7);
        expected.add(nodeE0);
        expected.add(nodeE1);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_2_and_the_second_list_size_is_1_and_the_sum_produces_no_carry() {
        // given
        listA.add(nodeA1);
        listA.add(nodeA2);
        listB.add(nodeB4);
        expected.add(nodeE5);
        expected.add(nodeE2);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_2_and_the_second_list_size_is_1_and_the_sum_produces_a_single_carry() {
        // given
        listA.add(nodeA9);
        listA.add(nodeA8);
        listB.add(nodeB5);
        expected.add(nodeE4);
        expected.add(nodeE9);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_2_and_the_second_list_size_is_1_and_the_sum_produces_2_carries() {
        // given
        listA.add(nodeA8);
        listA.add(nodeA9);
        listB.add(nodeB5);
        expected.add(nodeE3);
        expected.add(nodeE0);
        expected.add(nodeE1);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_2_and_the_second_list_size_is_2_and_the_sum_produces_no_carry() {
        // given
        listA.add(nodeA2);
        listA.add(nodeA3);
        listB.add(nodeB4);
        listB.add(nodeB5);
        expected.add(nodeE6);
        expected.add(nodeE8);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_2_and_the_second_list_size_is_2_and_the_sum_produces_one_carry() {
        // given
        listA.add(nodeA9);
        listA.add(nodeA3);
        listB.add(nodeB9);
        listB.add(nodeB5);
        expected.add(nodeE8);
        expected.add(nodeE9);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_the_first_list_size_is_2_and_the_second_list_size_is_2_and_the_sum_produces_two_carries() {
        // given
        listA.add(nodeA9);
        listA.add(nodeA8);
        listB.add(nodeB9);
        listB.add(nodeB8);
        expected.add(nodeE8);
        expected.add(nodeE7);
        expected.add(nodeE1);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_return_sum_list_when_both_input_lists_size_is_3_and_the_sum_produces_3_carries() {
        // given
        listA.add(nodeA7);
        listA.add(nodeA8);
        listA.add(nodeA9);
        listB.add(nodeB7);
        listB.add(nodeB8);
        listB.add(nodeB9);
        expected.add(nodeE4);
        expected.add(nodeE7);
        expected.add(nodeE9);
        expected.add(nodeE1);

        // when
        var sum = sumLists.sumLists(listA, listB);

        // then
        then(sum).usingRecursiveComparison().isEqualTo(expected);
    }

}
