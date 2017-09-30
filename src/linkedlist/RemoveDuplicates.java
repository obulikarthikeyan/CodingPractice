package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    private static Node setUp() {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(20);
        Node node5 = new Node(10);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        return node1;
    }

    private static Node removeDuplicateWithBuffer(Node head) {
        Node n = head;
        Node prev = null;
        Map<Integer, Node> nodeHashMap = new HashMap<>();

        while (n != null) {
            if(nodeHashMap.containsKey(n.getData())) {
                prev.setNext(n.getNext());
            } else {
                nodeHashMap.put(n.getData(), n);
                prev = n;
            }
            n = n.getNext();
        }
        return head;
    }

    public static void main(String ...args) {
        System.out.println("Given LinkedList");
        Node head = setUp();
        Node.printLinkedList(head);

        System.out.println("\nProcessed LinkedList (with Buffer)");
        Node newHead = removeDuplicateWithBuffer(head);
        Node.printLinkedList(newHead);

        System.out.println("\nProcessed LinkedList (no buffer)");
        head = setUp();
        newHead = removeDuplicateWithoutBuffer(head);
        Node.printLinkedList(newHead);
    }

    private static Node removeDuplicateWithoutBuffer(Node head) {
        Node current = head;

        if(head == null) {
            return head;
        }

        while (current != null) {
            Node runner = current;

            while (runner.getNext() != null) {
                if(runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
        return head;
    }
}
