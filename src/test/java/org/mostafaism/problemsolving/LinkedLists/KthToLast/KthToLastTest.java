package org.mostafaism.problemsolving.LinkedLists.KthToLast;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class KthToLastTest {

    private KthToLast<Integer> kthToLast;
    private LinkedList<Integer> list;

    private Integer key1;
    private Integer key2;
    private Integer key3;
    private Node<Integer> node1;
    private Node<Integer> node2;
    private Node<Integer> node3;

    @BeforeEach
    void setup() {
        kthToLast = new KthToLast<>();
        list = new DoublyLinkedList<>();
        key1 = 1;
        key2 = 2;
        key3 = 3;
        node1 = new Node<>(key1);
        node2 = new Node<>(key2);
        node3 = new Node<>(key3);
    }

    @Test
    void it_should_return_nil_when_list_is_empty() {
        // given
        int k = 0;

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void it_should_return_nil_when_k_is_equals_list_size() {
        // given
        int k = 1;
        list.add(node1);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void it_should_return_nil_when_k_is_greater_than_list_size() {
        // given
        int k = 2;
        list.add(node1);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void it_should_return_tail_node_when_k_is_0_and_list_size_is_1() {
        // given
        int k = 0;
        list.add(node1);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(actual).isEqualTo(node1);
    }

    @Test
    void it_should_return_tail_node_when_k_is_0_and_list_size_is_2() {
        // given
        int k = 0;
        list.add(node1);
        list.add(node2);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(actual).isEqualTo(node1);
    }

    @Test
    void it_should_return_head_node_when_k_is_1_and_list_size_is_2() {
        // given
        int k = 1;
        list.add(node1);
        list.add(node2);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(actual).isEqualTo(node2);
    }

    @Test
    void it_should_return_tail_node_when_k_is_0_and_list_size_is_3() {
        // given
        int k = 0;
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(actual).isEqualTo(node1);
    }

    @Test
    void it_should_return_1st_to_last_node_when_k_is_1_and_list_size_is_3() {
        // given
        int k = 1;
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(actual).isEqualTo(node2);
    }

    @Test
    void it_should_return_head_node_when_k_is_2_and_list_size_is_3() {
        // given
        int k = 2;
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        Node<Integer> actual = kthToLast.kthToLast(list, k);

        // then
        then(actual).isEqualTo(node3);
    }

}
