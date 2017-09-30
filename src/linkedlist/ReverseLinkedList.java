package linkedlist;

import java.util.Stack;

/**
 *
 */

public class ReverseLinkedList {

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

    public static Node reverseIteratively(Node head) {
        if(head == null) {
            return null;
        }

        Node n1 = head;
        Node n2 = head.getNext();
        head.setNext(null);

        while(n2 != null) {
            Node p = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = p;
        }
        return n1;
    }

    //T: O(N) S: O(1)
    public static Node reverseRecursively(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node secondHead = head.getNext();
        head.setNext(null);

        Node rest = reverseRecursively(secondHead);
        secondHead.setNext(head);

        return rest;
    }

    //T: O(N) S: O(N)
    public static Node reverseUsingStack(Node head) {
        Stack<Node> stack = new Stack<>();
        Node n1 = head;
        while (n1 != null) {
            stack.push(n1);
            n1 = n1.getNext();
        }

        head = stack.pop();
        Node n2 = head;
        while (!stack.isEmpty()) {
            n1 = stack.pop();
            n2.setNext(n1);
            n2 = n1;
        }
        n2.setNext(null);
        return head;
    }

    public static void main(String ...args) {
        Node head = setUp();
        System.out.println("Input:");
        Node.printLinkedList(head);
        Node reversedHead = reverseIteratively(head);
        System.out.println("\nOutput Iterative:");
        Node.printLinkedList(reversedHead);
        System.out.println("\nOutput Recursive:");
        head = setUp();
        reversedHead = reverseRecursively(head);
        Node.printLinkedList(reversedHead);
        head = setUp();
        System.out.println("\nOutput Stack:");
        reversedHead = reverseUsingStack(head);
        Node.printLinkedList(reversedHead);
    }
}
