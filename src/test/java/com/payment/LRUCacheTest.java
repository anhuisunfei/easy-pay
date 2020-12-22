package com.payment;

import java.util.HashMap;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/22 17:34
 */
public class LRUCacheTest {
}

class LRUCache<K, V> {
    private int currentSize; // 当前大小
    private int capacity; // 总容量
    private HashMap<K, Node> caches; // 所有的节点
    private Node first; // 头结点
    private Node last; // 尾节点

    public LRUCache(int size) {
        currentSize = 0;
        this.capacity = size;
        caches = new HashMap<K, Node>(size);
    }


    public void put(K key, V value) {
        Node node = caches.get(key);
        if (node == null) {
            if (caches.size() >= capacity) {
                caches.remove(last.key);
                removeLast();
            }
            node = new Node(key, value);
        }
        node.value = value;
        moveToHead(node);
        caches.put(key, node);
    }

    private void moveToHead(Node node) {
        if (first == node) {
            return;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node == last) {
            last = last.prev;
        }

        if (first == null || last == null) {
            first = last = node;
            return;
        }

        node.next = first;
        first.prev = node;
        first = node;
        first.prev = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.prev;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }
}

class Node {
    Object key;
    Object value;

    Node prev;
    Node next;

    Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
