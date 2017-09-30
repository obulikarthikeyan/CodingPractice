package linkedlist;

public class Node {

    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public static void printLinkedList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.println(n.getData());
            n = n.getNext();
        }
    }
}
