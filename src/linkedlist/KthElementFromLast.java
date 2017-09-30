package linkedlist;

import java.util.Scanner;

public class KthElementFromLast {

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

    public static class IntegerWrapper {
        int value = 0;
    }

    private static Node findKthElementFromLastUsingRecursion(Node head, int k, IntegerWrapper integerWrapper) {
        if(head == null) {
            return null;
        }

        Node node = findKthElementFromLastUsingRecursion(head.getNext(), k, integerWrapper);
        integerWrapper.value = integerWrapper.value + 1;
        if (integerWrapper.value == k) {
            return head;
        }

        return node;
    }

    private static Node findKthElementFromLastUsingIteration(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        int count = 0;
        while(p2 != null) {
            if(count == k) {
                break;
            }
            count++;
            p2 = p2.getNext();
        }

        if (p2 == null) {
            return null;
        }

        while(p2 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;
    }

    public static void main(String ...args) {
        System.out.println("Given LinkedList");
        Node head = setUp();
        Node.printLinkedList(head);

        System.out.println("\nEnter k");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Node kthNode = findKthElementFromLastUsingRecursion(head, k, new KthElementFromLast.IntegerWrapper());

        if(kthNode != null) {
            System.out.println("\nKth Element using recursion = " + kthNode.getData());
        } else {
            System.out.println("\nElement doesn't exist");
        }

        head = setUp();
        kthNode = findKthElementFromLastUsingIteration(head, k);

        if(kthNode != null) {
            System.out.println("\nKth Element using Iteration = " + kthNode.getData());
        } else {
            System.out.println("\nElement doesn't exist");
        }

    }
}
