package faq;

/**
 * HashTable implementation
 *
 * http://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
 */

public class HashNode<K, V> {

    K key;
    V value;

    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
