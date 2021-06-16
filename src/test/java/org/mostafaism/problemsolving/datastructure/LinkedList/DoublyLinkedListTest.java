package org.mostafaism.problemsolving.datastructure.LinkedList;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void it_should_add_node_to_empty_list() {
        // given
        Integer key = 1;
        Node<Integer> node = new Node<>(key);

        // when
        list.add(node);
        Node<Integer> actual = list.search(key);

        // then
        then(actual).isEqualTo(node);
    }

    @Test
    void it_should_add_node_to_a_list_of_size_1() {
        // given
        Integer key1 = 1;
        Node<Integer> node1 = new Node<>(key1);
        list.add(node1);
        Integer key2 = 2;
        Node<Integer> node2 = new Node<>(key2);

        // when
        list.add(node2);
        Node<Integer> actual = list.search(key2);

        // then
        then(actual).isEqualTo(node2);
    }

    @Test
    void it_should_remove_node_from_a_list_of_size_1() {
        // given
        Integer key = 1;
        Node<Integer> node = new Node<>(key);
        list.add(node);

        // when
        list.remove(node);
        boolean actual = list.isNil(list.search(key));

        // then
        then(actual).isTrue();
    }

    @Test
    void it_should_remove_node_from_a_list_of_size_2() {
        // given
        Integer key1 = 1;
        Node<Integer> node1 = new Node<>(key1);
        list.add(node1);
        Integer key2 = 2;
        Node<Integer> node2 = new Node<>(key2);
        list.add(node2);

        // when
        list.remove(node1);
        boolean actual = list.isNil(list.search(key1));

        // then
        then(actual).isTrue();
    }

}
