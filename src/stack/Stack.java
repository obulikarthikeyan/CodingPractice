package stack;

import linkedlist.Node;

public class Stack {
    Node top;
    int capacity = 10;
    int size = 0;

    Object pop() {
        if(top != null) {
            Object item = top.getData();
            top = top.getNext();
            size--;
            return item;
        }
        return null;
    }

    void push(Object item) {
        Node node = new Node((int) item);
        node.setNext(top);
        top = node;
        size++;
    }

    Object peek() {
        if (top != null)
        {
            return top.getData();
        }
        return null;
    }

    boolean isEmpty() {
        return top == null;
    }

    public static void printStack(Stack stack) {
        Node.printLinkedList(stack.top);
    }

    public boolean isFull() {
        return size >= capacity;
    }
}
