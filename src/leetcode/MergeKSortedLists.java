package leetcode;

import linkedlist.Node;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class MergeKSortedLists {

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

    private static Node setUp3() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(9);
        Node node4 = new Node(11);
        Node node5 = new Node(13);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        return node1;
    }

    public static Node sortAndMerge(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node result;
        if(l1.getData() <= l2.getData()) {
            result = l1;
            result.setNext(sortAndMerge(l1.getNext(), l2));
        } else {
            result = l2;
            result.setNext(sortAndMerge(l1, l2.getNext()));
        }
        return result;
    }

    public static Node mergeKSortedLists(Node[] nodes) {
        int last = nodes.length - 1;
        while (last != 0) {
            int i = 0;
            int j = last;
            while (i < j) {
                nodes[i] = sortAndMerge(nodes[i], nodes[j]);
                i++;
                j--;

                if(i >= j) {
                    last = j;
                }
            }
        }
        return nodes[0];
    }

    public static void main(String ...args) {
        Node l1 = setUp1();
        System.out.println("List 1");
        Node.printLinkedList(l1);
        Node l2 = setUp2();
        System.out.println("\nList 2");
        Node.printLinkedList(l1);
        Node l3 = setUp3();
        System.out.println("\nList 3");
        Node.printLinkedList(l1);

        Node[] nodes = {l1, l2, l3};
        Node result = mergeKSortedLists(nodes);
        System.out.println("\nSorted List");
        Node.printLinkedList(result);
    }
}
