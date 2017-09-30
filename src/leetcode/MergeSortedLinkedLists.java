package leetcode;

import linkedlist.Node;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeSortedLinkedLists {

    private static Node setUp1() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(10);
        Node node4 = new Node(12);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
        return node1;
    }

    private static Node setUp2() {
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(8);
        Node node5 = new Node(15);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        return node1;
    }

    public static Node mergeSortedLists(Node n1, Node n2) {
        if(n1 == null) {
            return n2;
        }

        if(n2 == null) {
            return n1;
        }

        Node head = new Node(0);
        Node p = head;
        Node p1 = n1;
        Node p2 = n2;
        while (p1 != null && p2 != null) {
            if(p1.getData() < p2.getData()) {
                p.setNext(p1);
                p1 = p1.getNext();
            } else {
                p.setNext(p2);
                p2 = p2.getNext();
            }
            p = p.getNext();
        }

        if(p1 == null) {
            p.setNext(p2);
        }

        if(p2 == null) {
            p.setNext(p1);
        }

        return head.getNext();
    }

    public static void main(String ...args) {
        System.out.println("List 1");
        Node head1 = setUp1();
        Node.printLinkedList(head1);
        Node head2 = setUp2();
        System.out.println("\n List 2");
        Node.printLinkedList(head2);
        Node head3 = mergeSortedLists(head1, head2);
        System.out.println("\nMerged List");
        Node.printLinkedList(head3);
    }
}
