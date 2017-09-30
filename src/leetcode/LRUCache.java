package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * LRUCache cache = new LRUCache( 2 );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 *
 * We use two data structures to implement an LRU Cache.
 * Queue which is implemented using a doubly linked list.
 * The maximum size of the queue will be equal to the total number of frames available (cache size).
 * The most recently used pages will be near front end and least recently pages will be near rear end
 *
 * A Hash with page number as key and address of the corresponding queue node as value
 * When a page is referenced, the required page may be in the memory.
 * If it is in the memory, we need to detach the node of the list and bring it to the front of the queue
 * If the required page is not in the memory, we bring that in memory.
 * In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.
 *
 * Note: Initially no page is in the memory.
 */

public class LRUCache {
    int capacity;
    Map<Integer, CacheNode> map = new HashMap<>();

    CacheNode head = null;
    CacheNode tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            CacheNode node = map.get(key);
            int value = node.value;
            remove(node);
            setHead(node);
            return value;
        }
        return -1;
    }

    private void setHead(CacheNode node) {
        node.next = head;
        node.prev= null;

        if(head != null) {
            head.prev = node;
        }

        head = node;

        if(tail == null) {
            tail = head;
        }
    }

    private void remove(CacheNode node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            CacheNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            CacheNode newNode = new CacheNode(key, value);
            if(map.size() >= capacity) {
                remove(tail);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }



}
