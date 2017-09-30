package linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                    c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionOfTwoLinkedList {

    /**
     * Alternate Approach
     * T: O(N+M) S: O(1)
     *
     * Maintain two pointers pA and pB initialized at the head of A and B, respectively.
     * Then let them both traverse through the lists, one node at a time.When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
     * If at any point pA meets pB, then pA/pB is the intersection node.
     * To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'.
     * Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does.
     * By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
     * If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.
     */

    //T: O(N+M) S: O(1)
    public static Node getIntersectingNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;
        Node nodeA = headA;
        Node nodeB = headB;
        while (nodeA != null) {
            nodeA = nodeA.getNext();
            lenA++;
        }

        while (nodeB != null) {
            nodeB = nodeB.getNext();
            lenB++;
        }

        nodeA = headA;
        nodeB = headB;

        if(lenA > lenB) {
            nodeA = fastForward(nodeA, lenA - lenB);
        } else {
            nodeB = fastForward(nodeB, lenB - lenA);
        }

        while (nodeA !=  nodeB) {
            nodeA = nodeA.getNext();
            nodeB = nodeB.getNext();
        }

        return nodeA;
    }

    public static Node fastForward(Node node, int n) {
        for(int i = 1; i <= n; i++) {
            node = node.getNext();
        }
        return node;
    }

    private static Node setUp1() {
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

    private static Node setUp2() {
        Node node = new Node(5);
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(null);
        return node;
    }

    public static void main(String ...args) {
        Node headA = setUp1();
        Node headB = setUp2();
        headB.getNext().getNext().setNext(headA.getNext());
        Node node = getIntersectingNode(headA, headB);
        System.out.println(node != null? node.getData() : null);
    }
}
