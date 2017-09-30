package trees;

/**
 * A Binary Heap is a Binary Tree with following properties.
 * 1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.
 *
 * 2) A Binary Heap is either Min Heap or Max Heap.
 * In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree.
 * Max Binary Heap is similar to Min Heap.
 *
 * A Binary heap is typically represented as an array.
 *
 * Examples of Min Heap:
 *
 *              10                     10
 *           /      \               /      \
 *         20       100           15        30
 *         /                      /  \     /  \
 *       30                     40    50 100   40
 */
public class MinHeap {

    int size;
    int capacity;
    int[] heap;

    public MinHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public int parent(int i) { return (i-1)/2; }

    public int left(int i) { return 2*i + 1; }

    public int right(int i) { return 2*i + 2; }

    public int getMin() { if(isEmpty()) throw new IllegalStateException(); return heap[0]; }

    public boolean isEmpty() { return size == 0; }

    public boolean isFull() { return size == capacity; }

    public void swap(int l, int r) {
        int temp = heap[l];
        heap[l] = heap[r];
        heap[r] = temp;
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int key = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown(0);
        return key;
    }

    public void insert(int key) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        heap[size] = key;
        size++;

        int i = size-1;
        heapifyUp(i);
    }

    public void heapifyUp(int i) {
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void decreaseKey(int i, int newKey) {
        if(i > size) {
            System.out.println("Index not found");
            throw new IllegalStateException();
        }
        heap[i] = newKey;
        heapifyUp(i);
    }

    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public void heapifyDown(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if(l < size && heap[l] < heap[i]) {
            smallest = l;
        }

        if(r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }

        if(smallest != i) {
            swap(smallest, i);
            heapifyDown(smallest);
        }
    }

    public static void main(String ...args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(40);
        heap.insert(20);
        heap.insert(-19);
        heap.insert(39);
        heap.insert(100);

        System.out.println("Min = " + heap.extractMin());
        System.out.println("Min = " + heap.extractMin());
        System.out.println("DecreaseKey for 3 to 0");
        heap.decreaseKey(2, 0);
        System.out.println("Min = " + heap.getMin());

    }


}
