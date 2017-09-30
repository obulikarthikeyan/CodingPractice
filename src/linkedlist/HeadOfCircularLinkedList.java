package linkedlist;

public class HeadOfCircularLinkedList {
    private static Node setUp() {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        Node node6 = new Node(60);
        Node node7 = new Node(70);
        Node node8 = new Node(80);
        Node node9 = new Node(90);
        Node node10 = new Node(100);
        Node node11 = new Node(110);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(node11);
        //node11.setNext(null);
        node11.setNext(node4);
        return node1;
    }

    /**
     * 1. slowRunner 1 step at a time and fastRunner 2 steps at a time.
     * 2. Identify collision point
     * 3. Move slowRunner to LinkedList head and keep fastRunner at collision point
     * 4. Move slowRunner and fastRunner 1 step at a time
     * 5. Return collision point
     *
     * @param head
     * @return
     */

    private static Node getHeadOfCircularLinkedList(Node head) {
        Node slowRunner = head;
        Node fastRunner = head;

        do {
            if(fastRunner == null || fastRunner.getNext() == null) {
                return null;
            }
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
        } while (slowRunner.getData() != fastRunner.getData());


        slowRunner = head;
        while (slowRunner.getData() != fastRunner.getData()) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext();
        }

        return slowRunner;
    }

    public static void main(String ...args) {
        Node head = setUp();
        System.out.println("Initial LinkedList");
        Node headOfLoop = getHeadOfCircularLinkedList(head);
        if(headOfLoop == null) {
            System.out.println("is Not a Circular Linked List");
            Node.printLinkedList(head);
        } else {
            System.out.println("is a Circular Linked List");
            Node n1 = head;
            while (n1.getData() != headOfLoop.getNext().getData()) {
                System.out.println(n1.getData());
                n1 = n1.getNext();
            }
            while (n1.getData() != headOfLoop.getData()) {
                System.out.println(n1.getData());
                n1 = n1.getNext();
            }
            System.out.println("\nLoop found at " + headOfLoop.getData());
        }
    }
}
