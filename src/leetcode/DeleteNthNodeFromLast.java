package leetcode;

import linkedlist.Node;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class DeleteNthNodeFromLast {

    private static Node setUp() {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        return node1;
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node p1 = head;
        Node p2 = head;

        if(head == null || n <= 0) {
            return head;
        }

        int count = 0;
        while (p2 != null) {
            if(count == n) {
                break;
            }
            count++;
            p2 = p2.getNext();
        }

        if(p2 == null) {
            return head.getNext();
        }

        while (p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        p1.setNext(p1.getNext().getNext());

        return head;
    }

    public static void main(String ...args) {
        System.out.println("Initial List");
        Node head = setUp();
        Node.printLinkedList(head);
        int n = 2;
        Node node = removeNthFromEnd(head, 10);
        System.out.println("\nList after deletion of n = " + n + "th element from last");
        Node.printLinkedList(node);
    }
}
