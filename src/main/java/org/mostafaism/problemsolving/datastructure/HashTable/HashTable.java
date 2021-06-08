package org.mostafaism.problemsolving.datastructure.HashTable;

public interface HashTable<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean contains(K key);
}
