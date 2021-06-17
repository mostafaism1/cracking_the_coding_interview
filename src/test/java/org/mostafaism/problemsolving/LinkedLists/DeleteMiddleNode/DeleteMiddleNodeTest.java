package org.mostafaism.problemsolving.LinkedLists.DeleteMiddleNode;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class DeleteMiddleNodeTest {

    private DeleteMiddleNode<Integer> deleteMiddleNode;
    private LinkedList<Integer> list;
    private LinkedList<Integer> expected;
    private Integer key1;
    private Integer key2;
    private Integer key3;
    private Integer key4;
    private Integer key5;
    private Node<Integer> node1;
    private Node<Integer> node2;
    private Node<Integer> node3;
    private Node<Integer> node4;
    private Node<Integer> node5;

    @BeforeEach
    void setup() {
        deleteMiddleNode = new DeleteMiddleNode<>();
        list = new DoublyLinkedList<>();
        expected = new DoublyLinkedList<>();
        key1 = 1;
        key2 = 2;
        key3 = 3;
        key4 = 4;
        key5 = 5;
        node1 = new Node<>(key1);
        node2 = new Node<>(key2);
        node3 = new Node<>(key3);
        node4 = new Node<>(key4);
        node5 = new Node<>(key5);
    }

    @Test
    void it_should_delete_middle_node_when_given_the_middle_node_and_list_size_is_3() {
        // given
        list.add(node1);
        list.add(node2);
        list.add(node3);
        expected.add(node1);
        expected.add(node3);

        // when
        deleteMiddleNode.deleteMiddleNode(node2);

        // then
        then(list).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_delete_the_second_node_when_given_the_second_node_and_list_size_is_4() {
        // given
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        expected.add(node1);
        expected.add(node3);
        expected.add(node4);

        // when
        deleteMiddleNode.deleteMiddleNode(node2);

        // then
        then(list).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_delete_the_third_node_when_given_the_third_node_and_list_size_is_4() {
        // given
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        expected.add(node1);
        expected.add(node2);
        expected.add(node4);

        // when
        deleteMiddleNode.deleteMiddleNode(node3);

        // then
        then(list).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_delete_the_second_node_when_given_the_second_node_and_list_size_is_5() {
        // given
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        expected.add(node1);
        expected.add(node3);
        expected.add(node4);
        expected.add(node5);

        // when
        deleteMiddleNode.deleteMiddleNode(node2);

        // then
        then(list).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_delete_the_third_node_when_given_the_third_node_and_list_size_is_5() {
        // given
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        expected.add(node1);
        expected.add(node2);
        expected.add(node4);
        expected.add(node5);

        // when
        deleteMiddleNode.deleteMiddleNode(node3);

        // then
        then(list).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void it_should_delete_the_fourth_node_when_given_the_fourth_node_and_list_size_is_5() {
        // given
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        expected.add(node1);
        expected.add(node2);
        expected.add(node3);
        expected.add(node5);

        // when
        deleteMiddleNode.deleteMiddleNode(node3);

        // then
        then(list).usingRecursiveComparison().isEqualTo(expected);
    }

}
