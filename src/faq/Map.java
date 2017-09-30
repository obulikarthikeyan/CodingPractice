package faq;

import java.util.ArrayList;

/**
 * HashTable implementation
 *
 * http://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
 */

public class Map<K, V> {

    private ArrayList<HashNode<K, V>> buckets;

    private int numBuckets;
    private int size;

    public Map() {
        buckets = new ArrayList<>();
        size = 0;
        numBuckets = 10;

        for(int i=0; i<numBuckets; i++) {
            buckets.add(null);
        }
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        int index = hash % numBuckets;
        return index;
    }

    public V get(K key) {
        int index = getBucketIndex(key);

        HashNode<K, V> head = buckets.get(index);

        while (head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);

        HashNode<K, V> head = buckets.get(index);
        HashNode<K, V> prev = null;

        while (head != null) {

            if(head.key.equals(key)) {
                break;
            }

            prev = head;
            head = head.next;
        }

        if(head == null) {
            return null;
        }

        size--;
        if(prev != null) {
            prev.next = head.next;
        } else {
            buckets.set(index, head.next);
        }

        return head.value;
    }

    public void add(K key, V value) {
        int index = getBucketIndex(key);

        HashNode<K, V> head = buckets.get(index);
        HashNode<K, V> t = head;

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }

            head = head.next;
        }

        size++;
        HashNode<K, V> node = new HashNode<K, V>(key, value);
        node.next = t;
        buckets.set(index, node);

        if((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> tempBuckets = buckets;
            buckets = new ArrayList<>();
            size = 0;
            numBuckets = 2 * numBuckets;
            for (int i=0; i<numBuckets; i++) {
                buckets.add(null);
            }

            for(HashNode<K, V> headNode : tempBuckets) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Map<String, Integer>map = new Map<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.getSize());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.getSize());
        System.out.println(map.remove("er"));
        System.out.println(map.getSize());
        System.out.println(map.remove("hi"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
        System.out.println(map.remove("coder"));
        System.out.println(map.getSize());
        System.out.println(map.isEmpty());
    }
}
