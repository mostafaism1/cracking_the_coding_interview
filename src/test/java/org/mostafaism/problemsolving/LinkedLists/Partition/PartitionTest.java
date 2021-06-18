package org.mostafaism.problemsolving.LinkedLists.Partition;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mostafaism.problemsolving.datastructure.LinkedList.DoublyLinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.LinkedList;
import org.mostafaism.problemsolving.datastructure.LinkedList.Node;

public class PartitionTest {

    private Partition<Integer> partition;
    private LinkedList<Integer> list;
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
    private int partitionValue;

    @BeforeEach
    void setup() {
        partition = new Partition<>();
        list = new DoublyLinkedList<>();
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
    void it_should_do_nothing_when_list_is_empty() {
        // given
        partitionValue = 1;

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isZero();
    }

    @Test
    void it_should_do_nothing_when_list_size_is_1_and_partition_value_is_equal_to_the_element() {
        // given
        partitionValue = 1;
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isOne();
        then(list.contains(node1)).isTrue();
    }

    @Test
    void it_should_do_nothing_when_list_size_is_1_and_partition_value_is_less_than_the_element() {
        // given
        partitionValue = 0;
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isOne();
        then(list.contains(node1)).isTrue();
    }

    @Test
    void it_should_do_nothing_when_list_size_is_1_and_partition_value_is_greater_than_the_element() {
        // given
        partitionValue = 2;
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isOne();
        then(list.contains(node1)).isTrue();
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_2_and_partition_value_is_greater_than_all_element() {
        // given
        partitionValue = 3;
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(2);
        then(list.contains(node1)).isTrue();
        then(list.contains(node2)).isTrue();
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_2_and_partition_value_is_less_than_all_element() {
        // given
        partitionValue = 0;
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(2);
        then(list.contains(node1)).isTrue();
        then(list.contains(node2)).isTrue();
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_2_and_partition_value_is_less_than_or_equal_all_element() {
        // given
        partitionValue = 1;
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(2);
        then(list.contains(node1)).isTrue();
        then(list.contains(node2)).isTrue();
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_2_and_partition_value_is_greater_than_or_equal_all_element() {
        // given
        partitionValue = 2;
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(2);
        then(list.contains(node1)).isTrue();
        then(list.contains(node2)).isTrue();
    }

    @Test
    void it_should_partition_when_list_size_is_2_and_not_partitioned() {
        // given
        partitionValue = 2;
        list.add(node1);
        list.add(node3);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(2);
        then(list.indexOf(node1)).isEqualTo(0);
        then(list.indexOf(node3)).isEqualTo(1);
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_3_and_partitioned() {
        // given
        partitionValue = 2;
        list.add(node3);
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(3);
        then(list.indexOf(node1)).isEqualTo(0);
        then(list.indexOf(node2)).isBetween(1, 2);
        then(list.indexOf(node3)).isBetween(1, 2);
    }

    @Test
    void it_should_partition_when_list_size_is_3_and_not_partitioned() {
        // given
        partitionValue = 2;
        list.add(node1);
        list.add(node2);
        list.add(node3);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(3);
        then(list.indexOf(node1)).isEqualTo(0);
        then(list.indexOf(node2)).isBetween(1, 2);
        then(list.indexOf(node3)).isBetween(1, 2);
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_4_and_partitioned() {
        // given
        partitionValue = 2;
        list.add(node4);
        list.add(node3);
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(4);
        then(list.indexOf(node1)).isEqualTo(0);
        then(list.indexOf(node2)).isBetween(1, 3);
        then(list.indexOf(node3)).isBetween(1, 3);
        then(list.indexOf(node4)).isBetween(1, 3);
    }

    @Test
    void it_should_partition_when_list_size_is_4_and_not_partitioned() {
        // given
        partitionValue = 2;
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(4);
        then(list.indexOf(node1)).isEqualTo(0);
        then(list.indexOf(node2)).isBetween(1, 3);
        then(list.indexOf(node3)).isBetween(1, 3);
        then(list.indexOf(node4)).isBetween(1, 3);
    }

    @Test
    void it_should_leave_the_list_partitioned_when_list_size_is_5_and_partitioned() {
        // given
        partitionValue = 3;
        list.add(node5);
        list.add(node4);
        list.add(node3);
        list.add(node2);
        list.add(node1);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(5);
        then(list.indexOf(node1)).isBetween(0, 1);
        then(list.indexOf(node2)).isBetween(0, 1);
        then(list.indexOf(node3)).isBetween(2, 4);
        then(list.indexOf(node4)).isBetween(2, 4);
        then(list.indexOf(node5)).isBetween(2, 4);
    }

    @Test
    void it_should_partition_when_list_size_is_5_and_not_partitioned() {
        // given
        partitionValue = 3;
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        // when
        partition.partition(list, partitionValue);

        // then
        then(list.size()).isEqualTo(5);
        then(list.indexOf(node1)).isBetween(0, 1);
        then(list.indexOf(node2)).isBetween(0, 1);
        then(list.indexOf(node3)).isBetween(2, 4);
        then(list.indexOf(node4)).isBetween(2, 4);
        then(list.indexOf(node5)).isBetween(2, 4);
    }

}
