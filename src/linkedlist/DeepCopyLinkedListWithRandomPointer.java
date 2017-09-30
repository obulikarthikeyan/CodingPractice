package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */

public class DeepCopyLinkedListWithRandomPointer {

    Node head;

    static class Node {
        int data;//Node data
        Node next, random;//Next and random reference

        //Node constructor
        public Node(int data)
        {
            this.data = data;
            this.next = this.random = null;
        }
    }

    public void push(int data)  {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    public DeepCopyLinkedListWithRandomPointer(Node head) {
        this.head = head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null)
        {
            Node random = temp.random;
            int randomData = (random != null)? random.data: -1;
            System.out.println("Data = " + temp.data +
                    ", Random data = "+ randomData);
            temp = temp.next;
        }
    }

    //T: O(N) S: O(N) Using HashMap
    public static Node copyUsingHashMap(Node head) {
        if(head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node copyHead = new Node(head.data);

        Node p = head;
        Node q = copyHead;
        map.put(head, copyHead);

        p = p.next;
        while (p != null) {
            Node r = new Node(p.data);
            map.put(p, r);
            q.next = r;
            p = p.next;
            q = q.next;
        }

        p = head;
        q = copyHead;

        while (p != null) {
            if(p.random != null) {
                q.random = map.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return copyHead;
    }

    //T: O(N) S: O(1)
    public static Node copy(Node head) {
        if(head == null) {
            return null;
        }

        Node p = head;

        while (p != null) {
            Node copy = new Node(p.data);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        Node copyNode = head.next;
        while (p != null) {
            Node temp = p.next;
            p.next = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
            p = p.next;
        }
        return copyNode;
    }


    public static void main(String ...args) {
        Node node = new Node(5);
        DeepCopyLinkedListWithRandomPointer list = new DeepCopyLinkedListWithRandomPointer(node);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        // Making a clone of the original linked list.
        Node copyHead = copyUsingHashMap(list.head);

        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        print(list.head);
        System.out.println("\nCloned linked list");
        print(copyHead);

        // Making a clone of the original linked list.
        copyHead = copy(list.head);

        //Print the original and cloned linked list.
        System.out.println("\nOriginal linked list");
        print(list.head);
        System.out.println("\nCloned linked list");
        print(copyHead);

    }

}
