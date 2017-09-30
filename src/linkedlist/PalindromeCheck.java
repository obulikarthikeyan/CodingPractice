package linkedlist;

import java.util.Stack;

public class PalindromeCheck {

    Node left;

    static class Result {
        boolean isPalindrome;
        Node node;

        public Result(Node node, boolean isPalindrome) {
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }

    private static Node setUpOdd() {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(40);
        Node node4 = new Node(40);
        Node node5 = new Node(40);
        Node node6 = new Node(20);
        Node node7 = new Node(10);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(null);
        return node1;
    }

    private static Node setUpEven() {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(30);
        Node node5 = new Node(20);
        Node node6 = new Node(10);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);
        return node1;
    }

    /**
     * Push the 1st half to a stack using slowRunner, fastRunner approach
     * Now the stack consists of 1st half of linkedlist in reverse order
     * Compare rest of the linkedlist with the elements popped from the stack
     *
     * @param head
     * @return
     */
    private static boolean isPalindromeUsingIteration(Node head) {
        Node slow = head;
        Node fast = head;


        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.getNext() != null) {
            stack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if(fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            int n = stack.pop();
            if (slow.getData() != n) {
                return false;
            }
            slow = slow.getNext();
        }

        return true;
    }

    private static PalindromeCheck.Result isPalindromeUsingRecursion(Node head, int length) {
        if(head == null || length == 0) {
            return new PalindromeCheck.Result(head, true);
        } else if(length == 1) {
            return  new PalindromeCheck.Result(head.getNext(), true);
        } else if(length == 2) {
            return new PalindromeCheck.Result(head.getNext().getNext(), head.getData() == head.getNext().getData());
        }

        PalindromeCheck.Result result = isPalindromeUsingRecursion(head.getNext(), length - 2);

        if(!result.isPalindrome || result.node == null) {
            return result;
        } else {
            result.isPalindrome = head.getData() == result.node.getData();
            result.node = result.node.getNext();
            return result;
        }
    }

    public static boolean isPalindrome(Node head) {
        if(head == null ){
            return true;
        }

        Node tempOriginal = new Node(head.getData());
        Node original = tempOriginal;
        tempOriginal.setNext(null);
        Node temp = head.getNext();
        while (temp != null) {
            tempOriginal.setNext(new Node(temp.getData()));
            tempOriginal = tempOriginal.getNext();
            temp = temp.getNext();
        }

        Node reversedHead = reverse(head);
        while(original != null && reversedHead != null) {
            if(original.getData() != reversedHead.getData()) {
                return false;
            }
            original = original.getNext();
            reversedHead = reversedHead.getNext();
        }
        return true;
    }

    public static Node reverse(Node head) {
        Node n1 = head;
        Node n2 = head.getNext();
        head.setNext(null);

        while(n2 != null) {
            Node p = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = p;
        }
        return n1;
    }

    public boolean recursionHelper(Node right) {
        if(right == null) {
            return true;
        }

        boolean isPalindrome = recursionHelper(right.getNext());

        if (!isPalindrome) {
            return false;
        }

        isPalindrome = left.getData() == right.getData();
        left = left.getNext();
        return isPalindrome;
    }

    public boolean isPalindromeRecursionSimple(Node head) {
        left = head;
        Node right = head;
        return recursionHelper(right);
    }

    public static boolean isPalindromeHalfReverse(Node head) {
        if(head == null || head.getNext() == null) {
            return true;
        }

        Node mid = getMid(head).getNext();
        Node reversedHead = reverse(mid);

        while (head != null && reversedHead != null) {
            if(head.getData() != reversedHead.getData()) {
                return false;
            }
            head = head.getNext();
            reversedHead = reversedHead.getNext();
        }
        return true;
    }

    private static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.getNext();

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static void main(String ...args) {
        System.out.println("Initial LinkedList (Odd)");
        Node oddHead = setUpOdd();
        Node.printLinkedList(oddHead);

        System.out.println("\nInitial LinkedList (Even)");
        Node evenHead = setUpEven();
        Node.printLinkedList(evenHead);

        System.out.println("\nIs Odd LinkedList Palindrome (Using Iteration) = " + isPalindromeUsingIteration(oddHead));
        System.out.println("\nIs Even LinkedList Palindrome (Using Iteration) = " + isPalindromeUsingIteration(evenHead));

        System.out.println("\nIs Odd LinkedList Palindrome (Using Recursion) = " + isPalindromeUsingRecursion(oddHead, 7).isPalindrome);
        System.out.println("\nIs Even LinkedList Palindrome (Using Recursion) = " + isPalindromeUsingRecursion(evenHead ,6).isPalindrome);

        //System.out.println("\nIs Odd LinkedList Palindrome (Using Recursion) = " + isPalindrome(oddHead));
        //System.out.println("\nIs Even LinkedList Palindrome (Using Recursion) = " + isPalindrome(evenHead));

        PalindromeCheck palindromeCheck = new PalindromeCheck();
        System.out.println("\nIs Odd LinkedList Palindrome (Using Recursion Simple) = " + palindromeCheck.isPalindromeRecursionSimple(oddHead));
        System.out.println("\nIs Even LinkedList Palindrome (Using Recursion Simple) = " + palindromeCheck.isPalindromeRecursionSimple(evenHead));

        oddHead = setUpOdd();
        evenHead = setUpEven();
        System.out.println("\nIs Odd LinkedList Palindrome (Using Half Reverse) = " + isPalindromeHalfReverse(oddHead));
        System.out.println("\nIs Even LinkedList Palindrome (Using Half Reverse) = " + isPalindromeHalfReverse(evenHead));
    }
}
