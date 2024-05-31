package com.hegde.practice.linkedlist;


import com.hegde.practice.helper.DoubleLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCacheNaive<K, V> implements Cache<K, V> {
    int capacity;
    int cacheSize = 0;
    private final Map<K, DoubleLinkedList> cache;
    private DoubleLinkedList cacheStoreHead;
    private DoubleLinkedList cacheStoreTail;

    public LRUCacheNaive(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        cacheStoreHead = new DoubleLinkedList(null);
        cacheStoreTail = new DoubleLinkedList(null);
        cacheStoreHead.next = cacheStoreTail;
        cacheStoreTail.prev = cacheStoreHead;
    }

    @Override
    public Optional<V> get(K key) {
        DoubleLinkedList cacheNode = cache.get(key);
        if (cacheNode != null) {
            moveToHead(cacheNode);
            CacheObj cacheObj = (CacheObj) cacheNode.val;
            return Optional.of((V) cacheObj.value);
        }
        return Optional.empty();
    }

    @Override
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            DoubleLinkedList cacheNode = cache.get(key);
            ((CacheObj) cacheNode.val).value = value;
            moveToHead(cacheNode);
        } else {
            if (cacheSize >= capacity) {
                removeTail();
            }
            DoubleLinkedList newNode = new DoubleLinkedList(new CacheObj(key, value));
            addAtHead(newNode);
            cache.put(key, newNode);
            cacheSize++;
        }
    }

    private void moveToHead(DoubleLinkedList node) {
        removeNode(node);
        addAtHead(node);
    }

    public void removeNode(DoubleLinkedList node) {
        if(node != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void removeTail() {
        if(cacheStoreTail.prev != cacheStoreHead) {
            DoubleLinkedList tail = cacheStoreTail.prev;
            removeNode(tail);
            cache.remove(((CacheObj) tail.val).key);
            cacheSize--;
        }
    }

    //Head and tail node will always be null. Actual values will be in between.
    public void addAtHead(DoubleLinkedList node) {
        node.next = cacheStoreHead.next;
        node.prev = cacheStoreHead;
        cacheStoreHead.next.prev = node;
        cacheStoreHead.next = node;
    }

    public void print() {
        cache.entrySet().forEach(System.out::println);
    }

    public static class CacheObj<K, V> {
        private K key;
        private V value;

        public CacheObj(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
