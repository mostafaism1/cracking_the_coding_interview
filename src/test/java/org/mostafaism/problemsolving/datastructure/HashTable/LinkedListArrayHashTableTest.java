package org.mostafaism.problemsolving.datastructure.HashTable;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;

public class LinkedListArrayHashTableTest {

    @Test
    void it_should_put_one_key() {
        // given
        HashTable<Integer, Integer> hashTable = new LinkedListArrayHashTable<>();

        // when
        hashTable.put(1, 100);

        // then
        then(hashTable.contains(1)).isTrue();
        then(hashTable.get(1)).isEqualTo(100);
    }

    @Test
    void it_should_put_two_distinct_keys() {
        // given
        HashTable<Integer, Integer> hashTable = new LinkedListArrayHashTable<>();

        // when
        hashTable.put(1, 100);
        hashTable.put(2, 200);

        // then
        then(hashTable.contains(1)).isTrue();
        then(hashTable.contains(2)).isTrue();
        then(hashTable.get(1)).isEqualTo(100);
        then(hashTable.get(2)).isEqualTo(200);
    }

    @Test
    void it_should_replace_old_value_when_put_is_called_twice_with_same_key() {
        // given
        HashTable<Integer, Integer> hashTable = new LinkedListArrayHashTable<>();

        // when
        hashTable.put(1, 100);
        hashTable.put(1, 200);

        // then
        then(hashTable.contains(1)).isTrue();
        then(hashTable.get(1)).isEqualTo(200);
    }
}
