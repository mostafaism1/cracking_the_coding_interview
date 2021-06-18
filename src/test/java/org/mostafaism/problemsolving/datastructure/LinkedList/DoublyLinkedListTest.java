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

    @Test
    void size_should_return_0_when_list_is_empty() {
        // given

        // when
        int actual = list.size();

        // then
        then(actual).isZero();
    }

    @Test
    void size_should_return_1_when_list_has_1_element() {
        // given
        Integer key = 1;
        Node<Integer> node = new Node<>(key);

        // when
        list.add(node);
        int actual = list.size();

        // then
        then(actual).isOne();
    }

    @Test
    void size_should_return_2_when_list_has_2_element() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);

        // when
        list.add(node1);
        list.add(node2);
        int actual = list.size();

        // then
        then(actual).isEqualTo(2);
    }

    @Test
    void size_should_return_3_when_list_has_3_element() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Integer key3 = 3;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        Node<Integer> node3 = new Node<>(key3);

        // when
        list.add(node1);
        list.add(node2);
        list.add(node3);
        int actual = list.size();

        // then
        then(actual).isEqualTo(3);
    }

    /**
     * 
     * 
     */

    @Test
    void getHead_should_return_nil_node_when_list_is_empty() {
        // given

        // when
        boolean actual = list.isNil(list.getHead());

        // then
        then(actual).isTrue();
    }

    @Test
    void getHead_should_return_last_node_added_when_list_has_1_element() {
        // given
        Integer key = 1;
        Node<Integer> node = new Node<>(key);

        // when
        list.add(node);
        Node<Integer> actual = list.getHead();

        // then
        then(actual).isEqualTo(node);
    }

    @Test
    void getHead_should_return_last_node_added_when_list_has_2_element() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);

        // when
        list.add(node1);
        list.add(node2);
        Node<Integer> actual = list.getHead();

        // then
        then(actual).isEqualTo(node2);
    }

    @Test
    void getHead_should_return_last_node_added_when_list_has_3_element() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Integer key3 = 3;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        Node<Integer> node3 = new Node<>(key3);

        // when
        list.add(node1);
        list.add(node2);
        list.add(node3);
        Node<Integer> actual = list.getHead();

        // then
        then(actual).isEqualTo(node3);
    }

    @Test
    void get_nil_should_return_nil_node_when_list_size_is_0() {
        // given

        // when
        Node<Integer> actual = list.getNil();

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void get_nil_should_return_nil_node_when_list_size_is_1() {
        // given
        Integer key = 1;
        Node<Integer> node = new Node<>(key);
        list.add(node);

        // when
        Node<Integer> actual = list.getNil();

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void get_nil_should_return_nil_node_when_list_size_is_2() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        list.add(node1);
        list.add(node2);

        // when
        Node<Integer> actual = list.getNil();

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void get_nil_should_return_nil_node_when_list_size_is_3() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Integer key3 = 3;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        Node<Integer> node3 = new Node<>(key3);
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        Node<Integer> actual = list.getNil();

        // then
        then(list.isNil(actual)).isTrue();
    }

    @Test
    void contains_should_return_false_when_list_is_empty() {
        // given
        Integer key1 = 1;
        Node<Integer> node1 = new Node<>(key1);

        // when
        boolean actual = list.contains(node1);

        // then
        then(actual).isFalse();
    }

    @Test
    void contains_should_return_false_when_node_does_not_belong_to_list_and_list_size_is_1() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        list.add(node1);

        // when
        boolean actual = list.contains(node2);

        // then
        then(actual).isFalse();
    }

    @Test
    void contains_should_return_true_when_node_belongs_to_list_and_list_size_is_1() {
        // given
        Integer key1 = 1;
        Node<Integer> node1 = new Node<>(key1);
        list.add(node1);

        // when
        boolean actual = list.contains(node1);

        // then
        then(actual).isTrue();
    }

    @Test
    void contains_should_return_false_when_node_does_not_belongs_to_list_and_list_size_is_2() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Integer key3 = 3;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        Node<Integer> node3 = new Node<>(key3);
        list.add(node1);
        list.add(node2);

        // when
        boolean actual = list.contains(node3);

        // then
        then(actual).isFalse();
    }

    @Test
    void contains_should_return_true_when_node_belongs_to_list_and_list_size_is_2() {
        // given
        Integer key1 = 1;
        Integer key2 = 2;
        Node<Integer> node1 = new Node<>(key1);
        Node<Integer> node2 = new Node<>(key2);
        list.add(node1);
        list.add(node2);

        // when
        boolean actual = list.contains(node2);

        // then
        then(actual).isTrue();
    }

}
