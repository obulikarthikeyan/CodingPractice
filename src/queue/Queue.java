package queue;

import linkedlist.Node;

public class Queue {
    Node first, last;

    void enqueue(Object item) {
        if(last == null) {
            last = new Node((int) item);
            first = last;
        } else{
            last.setNext(new Node((int) item));
            last = last.getNext();
        }
    }

    Object dequeue() {
        if (first != null) {
            Object item = first.getData();
            first = first.getNext();
            return item;
        }
        return null;
    }
}
