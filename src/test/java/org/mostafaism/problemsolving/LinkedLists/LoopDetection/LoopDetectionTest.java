package org.mostafaism.problemsolving.LinkedLists.LoopDetection;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class LoopDetectionTest {

    private LoopDetection<Integer> loopDetection;
    private Node<Integer> head;
    private Node<Integer> node0;
    private Node<Integer> node1;
    private Node<Integer> node2;

    @BeforeEach
    void setup() {
        loopDetection = new LoopDetection<>();
        node0 = new Node<>(0);
        node1 = new Node<>(1);
        node2 = new Node<>(2);
    }

    @Test
    void it_should_return_null_when_the_list_is_null() {
        // given

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_null_when_the_list_size_is_1_and_no_loop() {
        // given
        head = node0;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_head_node_when_the_list_size_is_1_and_contains_a_loop() {
        // given
        head = node0;
        node0.next = node0;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isEqualTo(head);
    }

    @Test
    void it_should_return_null_when_the_list_size_is_2_and_no_loop() {
        // given
        head = node0;
        node0.next = node1;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_head_node_when_the_list_size_is_2_and_contains_a_loop_on_the_head_node() {
        // given
        head = node0;
        node0.next = node1;
        node1.next = node0;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isEqualTo(head);
    }

    @Test
    void it_should_return_null_when_the_list_size_is_3_and_no_loop() {
        // given
        head = node0;
        node0.next = node1;
        node1.next = node2;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_head_node_when_the_list_size_is_3_and_contains_a_loop_on_the_head_node() {
        // given
        head = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node0;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isEqualTo(head);
    }

    @Test
    void it_should_return_second_node_when_the_list_size_is_3_and_contains_a_loop_on_the_second_node() {
        // given
        head = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node1;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isEqualTo(node1);
    }

    @Test
    void it_should_return_tail_node_when_the_list_size_is_3_and_contains_a_loop_on_the_tail_node() {
        // given
        head = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node2;

        // when
        var actual = loopDetection.loopDetection(head);

        // then
        then(actual).isEqualTo(node2);
    }

}
