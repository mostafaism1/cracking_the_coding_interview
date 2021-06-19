package org.mostafaism.problemsolving.LinkedLists.Intersection;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class IntersectionTest {

    private Intersection<Integer> intersection;
    private Node<Integer> head1;
    private Node<Integer> head2;
    Node<Integer> node0;
    Node<Integer> node1;
    Node<Integer> node2;
    Node<Integer> node3;

    @BeforeEach
    void setup() {
        intersection = new Intersection<>();
        head1 = null;
        head2 = null;
        node0 = new Node<>(0);
        node1 = new Node<>(1);
        node2 = new Node<>(2);
        node3 = new Node<>(3);
    }

    @Test
    void it_should_return_null_when_both_lists_are_empty() {
        // given

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_null_when_first_list_is_empty() {
        // given
        head2 = node0;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_null_when_second_list_is_empty() {
        // given
        head1 = node0;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_null_when_both_lists_size_is_1_and_no_intersection() {
        // given
        head1 = node0;
        head2 = node1;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_intersecting_node_when_both_lists_size_is_1_and_intersect() {
        // given
        head1 = node0;
        head2 = node0;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isEqualTo(node0);
    }

    @Test
    void it_should_return_null_when_first_list_size_is_1_and_second_list_size_is_2_and_no_intersection() {
        // given
        head1 = node0;
        head2 = node1;
        node1.next = node2;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_intersecting_node_when_first_list_size_is_1_and_second_list_size_is_2_and_intersect() {
        // given
        head1 = node0;
        head2 = node1;
        node1.next = node0;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isEqualTo(node0);
    }

    @Test
    void it_should_return_null_when_first_list_size_is_2_and_second_list_size_is_1_and_no_intersection() {
        // given
        head1 = node0;
        node0.next = node1;
        head2 = node2;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_intersecting_node_when_first_list_size_is_2_and_second_list_size_is_1_and_intersect() {
        // given
        head1 = node1;
        node1.next = node0;
        head2 = node0;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isEqualTo(node0);
    }

    @Test
    void it_should_return_null_when_first_list_size_is_2_and_second_list_size_is_2_and_no_intersection() {
        // given
        head1 = node0;
        node0.next = node1;
        head2 = node2;
        node2.next = node3;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isNull();
    }

    @Test
    void it_should_return_intersecting_node_when_first_list_size_is_2_and_second_list_size_is_2_and_intersect_at_last_node() {
        // given
        head1 = node1;
        node1.next = node0;
        head2 = node2;
        node2.next = node0;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isEqualTo(node0);
    }

    @Test
    void it_should_return_intersecting_node_when_first_list_size_is_2_and_second_list_size_is_2_and_intersect_at_first_node() {
        // given
        head1 = node0;
        head2 = node0;
        node0.next = node1;

        // when
        Node<Integer> actual = intersection.intersection(head1, head2);

        // then
        then(actual).isEqualTo(node0);
    }

}
