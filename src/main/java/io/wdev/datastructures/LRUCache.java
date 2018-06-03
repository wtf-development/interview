package io.wdev.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * The class provides methods to design a non synchronized LRU Cache.
 *
 * @author WTF Development
 */
public class LRUCache<K, V> {

    private int capacity;
    private Map<K, Node<K, V>> data;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
    }

    public V get(K key) {
        if (!this.data.containsKey(key)) {
            return null;
        }

        Node<K, V> node = this.data.get(key);
        return node.val;
    }

    public void put(K key, V val) {
        if (data.containsKey(key)) {
            Node<K, V> node = data.get(key);
            node.val = val;
            remove(node);
            putToHead(node);
        } else {
            Node<K, V> node = new Node<K, V>(key, val);
            if (this.data.size() < capacity) {
                putToHead(node);
            } else {
                this.data.remove(this.tail.key);
                remove(this.tail);
                putToHead(node);
            }
            this.data.put(key, node);
        }
    }

    public V evict(K key) {
        if (!this.data.containsKey(key)) {
            return null;
        }
        Node<K, V> node = this.data.get(key);
        remove(node);
        putToHead(node);
        return node.val;
    }

    @SuppressWarnings("unchecked")
    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
    }

    @SuppressWarnings("unchecked")
    private void putToHead(Node node){
        node.next = this.head;
        node.prev = null;

        if(this.head != null) {
            this.head.prev = node;
        }

        this.head = node;

        if(this.tail == null) {
            this.tail = this.head;
        }
    }

    private final class Node<K, V> {
        private K key;
        private V val;
        private Node<K,V> next;
        private Node<K,V> prev;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

}
