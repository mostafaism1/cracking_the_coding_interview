package org.mostafaism.problemsolving.LinkedLists.RemoveDups;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class RemoveDupsTest {

    private RemoveDups removeDups;
    private LinkedList<Integer> list;

    @BeforeEach
    void setup() {
        removeDups = new RemoveDups();
        list = new DoublyLinkedList<>();
    }

    @Test
    void it_should_not_modify_when_list_is_empty() {
        // given

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isZero();
    }

    @Test
    void it_should_not_modify_when_list_size_is_1() {
        // given
        Integer value = 1;
        Node<Integer> node = new Node<>(value);
        list.add(node);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isOne();
    }

    @Test
    void it_should_not_modify_when_list_size_is_2_and_unique() {
        // given
        Integer value1 = 1;
        Integer value2 = 2;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        list.add(node1);
        list.add(node2);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(2);
    }

    @Test
    void it_should_modify_when_list_size_is_2_and_contains_duplicate() {
        // given
        Integer value1 = 1;
        Integer value2 = 1;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        list.add(node1);
        list.add(node2);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isOne();
    }

    @Test
    void it_should_not_modify_when_list_size_is_3_and_unique() {
        // given
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(3);
    }

    @Test
    void it_should_modify_when_list_size_is_3_and_contains_1_duplicate() {
        // given
        Integer value1 = 1;
        Integer value2 = 1;
        Integer value3 = 3;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(2);
    }

    @Test
    void it_should_modify_when_list_size_is_3_and_contains_2_duplicates_of_1_value() {
        // given
        Integer value1 = 1;
        Integer value2 = 1;
        Integer value3 = 1;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isOne();
    }

    @Test
    void it_should_not_modify_when_list_size_is_4_and_unique() {
        // given
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 3;
        Integer value4 = 4;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        Node<Integer> node4 = new Node<>(value4);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(4);
    }

    @Test
    void it_should_modify_when_list_size_is_4_and_contains_1_duplicates_of_1_value() {
        // given
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 1;
        Integer value4 = 3;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        Node<Integer> node4 = new Node<>(value4);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(3);
    }

    @Test
    void it_should_modify_when_list_size_is_4_and_contains_2_duplicates_of_1_value() {
        // given
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 1;
        Integer value4 = 1;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        Node<Integer> node4 = new Node<>(value4);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(2);
    }

    @Test
    void it_should_modify_when_list_size_is_4_and_contains_2_duplicates_of_2_value() {
        // given
        Integer value1 = 1;
        Integer value2 = 2;
        Integer value3 = 1;
        Integer value4 = 2;
        Node<Integer> node1 = new Node<>(value1);
        Node<Integer> node2 = new Node<>(value2);
        Node<Integer> node3 = new Node<>(value3);
        Node<Integer> node4 = new Node<>(value4);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        // when
        removeDups.removeDups(list);

        // then
        then(list.size()).isEqualTo(2);
    }
}
