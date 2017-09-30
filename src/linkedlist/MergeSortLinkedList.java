package linkedlist;

/**
 * Sort a given LinkedList using merge sort
 */
public class MergeSortLinkedList {

    public static Node merge(Node left, Node right) {
        Node result = null;
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        if(left.getData() <= right.getData()) {
            result = left;
            result.setNext(merge(left.getNext(), right));
        } else {
            result = right;
            result.setNext(merge(left, right.getNext()));
        }
        return result;
    }

    public static Node sort(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }

        Node midNode = getMiddleNode(head);

        Node rightHead = midNode.getNext();

        midNode.setNext(null);

        Node left = sort(head);
        Node right = sort(rightHead);

        return merge(left, right);
    }

    private static Node getMiddleNode(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private static Node setUp() {
        Node node1 = new Node(10);
        Node node2 = new Node(30);
        Node node3 = new Node(20);
        Node node4 = new Node(70);
        Node node5 = new Node(40);
        Node node6 = new Node(10);
        Node node7 = new Node(0);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(null);
        return node1;
    }

    public static void main(String ...args) {
        Node head = setUp();

        System.out.println("Input:");
        Node.printLinkedList(head);

        Node sortedHead = sort(head);
        System.out.println("\nOutput:");
        Node.printLinkedList(sortedHead);
    }

}
