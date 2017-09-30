package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Frequently Used cache eviction implementation.
 * If the page is not available in memory, evicts a page with minimum frequency count and adds the requested page to memory. 
 * If multiple pages have same frequency count, evict the one that was added first (FIFO)
 * 
 * The following implementation guarantees get and put operations in the LFU Cache to be in O(1) amortized.
 * Uses 2 HashMaps, Doubly Linked List and a LinkedHashSet
 * 
 * The idea is use 1 HashMap for storing key and value, another to store key and the node.
 * Use a LinkedHashSet to store the keys of same frequency count in the order in which they were added to the memory.
 *
 */
public class LFUCache {
    
    private int capacity;
    private LFUNode head = null;
    private Map<Integer, Integer> valueHash;
    private Map<Integer, LFUNode> nodeHash;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }
    
    public int get(int key) {
        if(valueHash.containsKey(key)) {
            increaseCount(key);
            return valueHash.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if(valueHash.size() < capacity) {
                valueHash.put(key, value);
            } else {
                removeOld();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new LFUNode(0);
            head.keys.add(key);
        } else if (head.count > 0){
            LFUNode node = new LFUNode(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);
    }

    private void removeOld() {
        if(head == null) return;
        int oldKey = 0;
        for(int i : head.keys) {
            oldKey = i;
            break;
        }
        head.keys.remove(oldKey);
        if (head.keys.size() == 0) remove(head);
        valueHash.remove(oldKey);
        nodeHash.remove(oldKey);
    }

    private void increaseCount(int key) {
        LFUNode node = nodeHash.get(key);
        node.keys.remove(key);

        if(node.next == null) {
            node.next = new LFUNode(node.count + 1);
            node.next.keys.add(key);
            node.next.prev = node;
        } else if (node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            LFUNode temp = new LFUNode(node.count + 1);
            temp.keys.add(key);
            temp.next = node.next;
            temp.prev = node;
            node.next.prev = temp;
            node.next = temp;
        }

        nodeHash.put(key, node.next);
        if(node.keys.size() == 0) {
            remove(node);
        }
    }

    private void remove(LFUNode node) {
        if(node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public static void main(String ...args) {
        LFUCache lfuCache = new LFUCache(5);
        lfuCache.put(1, 10);
        lfuCache.put(2, 20);
        lfuCache.put(3, 30);
        lfuCache.put(4, 40);
        lfuCache.put(5, 50);

        System.out.println("Get 1 = " + lfuCache.get(1));
        System.out.println("Put 6, 60");
        lfuCache.put(6, 60);
        System.out.println("Get 2 = " + lfuCache.get(2));
        System.out.println(lfuCache.valueHash);
    }
}
