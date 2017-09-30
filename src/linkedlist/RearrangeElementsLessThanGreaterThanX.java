package linkedlist;

import java.util.Scanner;

public class RearrangeElementsLessThanGreaterThanX {

    private static Node setUp() {
        Node node1 = new Node(10);
        Node node2 = new Node(60);
        Node node3 = new Node(70);
        Node node4 = new Node(40);
        Node node5 = new Node(20);
        Node node6 = new Node(30);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);
        return node1;
    }

    private static Node reArrange(Node head, int x) {
        Node list1 = null;
        Node list2 = null;
        Node list2Head = null;

        Node node  = head;

        while (node != null) {
            if(node.getData() < x) {
                if(list1 == null) {
                    list1 = new Node(node.getData());
                    head = list1;
                } else {
                    list1.setNext(new Node(node.getData()));
                    list1 = list1.getNext();
                }
            } else {
                if(list2 == null) {
                    list2 = new Node(node.getData());
                    list2Head = list2;
                } else {
                    list2.setNext(new Node(node.getData()));
                    list2 = list2.getNext();
                }
            }
            node = node.getNext();
        }

        list1.setNext(list2Head);

        return head;
    }

    public static void main(String ...args) {
        System.out.println("Initial LinkedList");
        Node head = setUp();
        Node.printLinkedList(head);

        System.out.println("\nEnter X");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        Node newNode = reArrange(head, x);

        System.out.println("\nRearranged LinkedList");
        Node.printLinkedList(newNode);
    }
}
