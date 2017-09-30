package linkedlist;

public class DeleteElementGivenAccessOnlyToNode {

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

    private static boolean deleteElementAt(Node node) {
        if(node == null) {
            return false;
        }

        if (node.getNext() == null) {
            node.setData(-1);
            return true;
        }

        Node next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());
        return true;
    }

    public static void main(String ...args) {
        Node head = setUp();
        System.out.println("Initial LinkedList");
        Node.printLinkedList(head);

        Node nodeToBeDeleted = head.getNext().getNext().getNext().getNext();
        int data = nodeToBeDeleted.getData();
        boolean isDeleted = deleteElementAt(nodeToBeDeleted);

        if (isDeleted) {
            System.out.println("\nElement " + data + " Deleted\n");
        } else {
            System.out.println("\nElement could not be deleted\n");
        }
        System.out.println("LinkedList after deletion");
        Node.printLinkedList(head);
    }
}
