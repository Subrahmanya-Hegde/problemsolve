package com.hegde.practice.helper;

/**
 * Double linked list node
 */
public class DoubleLinkedList<T> {

    public T val;
    public DoubleLinkedList next;
    public DoubleLinkedList prev;

    public DoubleLinkedList(T value){
        this.val = value;

    }

    DoubleLinkedList(T val, DoubleLinkedList next, DoubleLinkedList prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
