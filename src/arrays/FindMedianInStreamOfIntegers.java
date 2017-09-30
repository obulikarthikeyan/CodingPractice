package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given that integers are read from a data stream. Find median of elements read so for in efficient way. For simplicity assume there are no duplicates. For example, let us consider the stream 5, 15, 1, 3 …
 * After reading 1st element of stream - 5 -> median - 5
 * After reading 2nd element of stream - 5, 15 -> median - 10
 * After reading 3rd element of stream - 5, 15, 1 -> median - 5
 * After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...
 *
 * Making it clear, when the input size is odd, we take the middle element of sorted data.
 * If the input size is even, we pick average of middle two elements in sorted stream.
 *
 * Note that output is effective median of integers read from the stream so far.
 * Such an algorithm is called online algorithm.
 * Any algorithm that can guarantee output of i-elements after processing i-th element, is said to be online algorithm.
 */
public class FindMedianInStreamOfIntegers {

    static List<Integer> stream = new ArrayList<>();
    static int count;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));
    /**
     * Insertion sort guarantees that after processing ith element, all i elements are in sorted order.
     * In other words, insertion sort doesn't depend on future elements, making it a perfect fit for online algorithm
     *
     * T: O(N^2) S: O(1)
     */
    public static double findMedianInIntegerStreamUsingInsertionSort(int num) {
        stream.add(num);
        count++;

        double median = 0.0;
        if(count == 1) {
            return stream.get(0);
        }

        if(count == 2) {
            return (stream.get(0) + stream.get(1)) / 2.0;
        }

        for (int i = 1; i < count; i++) {
            int j = i-1;
            int k = stream.get(i);

            while (j >= 0 && stream.get(j) > k) {
                stream.set(j+1, stream.get(j));
                j--;
            }
            stream.set(j+1, k);
        }

        median = (count % 2 == 1) ? stream.get(count/2) : (stream.get(count/2) + stream.get((count/2) - 1)) / 2.0;
        return median;
    }

    /**
     * Using Min and Max Heaps
     * Construct Max heap on left and Min heap on right
     * After processing ith element, the number of elements in both the heaps differ by ay most 1 element.
     * If no. of elements in Min and Max heaps are equal, median is the average of roots of Min and Max heaps.
     * Else, median is the root of heap that has the maximum number of elements.
     *
     * T: O(N log N)
     */
    public static double findMedianInIntegerStreamUsingMinAndMaxHeaps(int num) {
        stream.add(num);
        count++;

        if(count == 1) {
            return stream.get(0);
        }

        if(count == 2) {
            return (stream.get(0) + stream.get(1)) / 2.0;
        }

        if(maxHeap.size() == 0 || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        //balance the heaps so that both the heaps differ in size by at most 2
        PriorityQueue<Integer> largerHeap;
        PriorityQueue<Integer> smallerHeap;

        if(maxHeap.size() > minHeap.size()) {
            largerHeap = maxHeap;
            smallerHeap = minHeap;
        } else {
            largerHeap = minHeap;
            smallerHeap = maxHeap;
        }

        if(largerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(largerHeap.poll());
        }

        if(largerHeap.size() < smallerHeap.size()) {
            largerHeap = smallerHeap;
            smallerHeap = largerHeap;
        }

        if(largerHeap.size() == smallerHeap.size()) {
            return (largerHeap.peek() + smallerHeap.peek()) / 2.0;
        }
        return largerHeap.peek();
    }


    public static void main(String ...args) {
        int[] a = {4, 3, 2, 1, 7, 8};

        System.out.println("Using Insertion sort - T: O(N^2) S: O(1)");
        for (int num : a) {
            System.out.println(findMedianInIntegerStreamUsingInsertionSort(num));
        }

        stream.clear();

        System.out.println("\nUsing Min and Max Heaps - T: O(N log N) S: O(N)");
        for (int num : a) {
            System.out.println(findMedianInIntegerStreamUsingMinAndMaxHeaps(num));
        }
    }

}
