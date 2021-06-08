package org.mostafaism.problemsolving.datastructure.HashTable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListArrayHashTable<K, V> implements HashTable<K, V> {

    private static final int CAPACITY = 32;

    private List<List<Node<K, V>>> hashTable;
    private int capacity;

    public LinkedListArrayHashTable(int capacity) {
        initializeHashTable(capacity);
        this.capacity = capacity;
    }

    private void initializeHashTable(int capacity) {
        hashTable = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            hashTable.add(new ArrayList<Node<K, V>>());
        }
    }

    public LinkedListArrayHashTable() {
        this(CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        List<Node<K, V>> values = removeNode(key, hashTable.get(index));
        Node<K, V> node = new Node<>(key, value);
        values.add(node);
        hashTable.set(index, values);
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return hashTable.get(index).stream().filter(node -> node.getKey() == key).map(node -> node.getValue()).findAny()
                .orElseThrow(() -> new IllegalArgumentException("Non existant key"));
    }

    @Override
    public boolean contains(K key) {
        int index = getIndex(key);
        return hashTable.get(index).stream().anyMatch(node -> node.getKey() == key);
    }

    private int getIndex(K key) {
        return key.hashCode() % capacity;
    }

    private List<Node<K, V>> removeNode(K key, List<Node<K, V>> list) {
        return list.stream().filter(n -> n.getKey() != key).collect(Collectors.toList());
    }

}
