package linkedlist;

public class AddTwoNumbersRepresentedAsLinkedList {

    private static Node setUp1() {
        Node node1 = new Node(8);
        Node node2 = new Node(5);
        node1.setNext(node2);
        node2.setNext(null);
        return node1;
    }

    private static Node setUp2() {
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);
        return node1;
    }

    private static Node addTwoNumsWithDigitsReversedAsListsUsingRecursion(Node l1, Node l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(carry);
        int value = carry;
        if(l1 != null) {
            value += l1.getData();
            l1 = l1.getNext();
        }

        if(l2 != null) {
            value += l2.getData();
            l2 = l2.getNext();
        }

        result.setData(value % 10);

        Node sum = addTwoNumsWithDigitsReversedAsListsUsingRecursion(l1, l2, (value / 10));

        result.setNext(sum);
        return result;
    }

    public static Node additionOfTwoNumbersUsingIteration(Node l1, Node l2) {
        Node sum = new Node(0);
        Node d = sum;

        int value = 0;
        while (l1 != null || l2 != null) {
            value /= 10;

            if(l1 != null) {
                value += l1.getData();
                l1 = l1.getNext();
            }

            if(l2 != null) {
                value += l2.getData();
                l2 = l2.getNext();
            }

            d.setNext(new Node(value % 10));
            d = d.getNext();
        }

        if(value / 10 == 1) {
            d.setNext(new Node(1));
        }
        return sum.getNext();
    }

    public static void main(String ...args) {

        System.out.println("Adding List 1");
        Node l1 = setUp1();
        Node.printLinkedList(l1);
        System.out.println("\nWith List 2");
        Node l2 = setUp2();
        Node.printLinkedList(l2);

        Node sum = addTwoNumsWithDigitsReversedAsListsUsingRecursion(l1, l2, 0);

        System.out.println("\nResulting Sum (Using Recursion)");
        Node.printLinkedList(sum);

        System.out.println("\nResulting Sum (Using Iteration)");
        Node.printLinkedList(additionOfTwoNumbersUsingIteration(l1, l2));
    }
}
