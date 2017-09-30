package sort;

/**
 * QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different ways.
 *
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 */

public class QuickSort {

    public static void quicksort(int[] a, int low, int high) {
        if(low < high) {
            int pivot = partition(a, low, high);
            quicksort(a, low, pivot - 1);
            quicksort(a, pivot + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        
        for(int j=low; j<=high-1; j++) {
            if(a[j] <= pivot) {
                swap(a, i++, j);
            }
        }

        swap(a, i, high);
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String ...args) {
        System.out.println("Unsorted Array");
        int[] a ={10, 7, 8, 9, 7, 1, 5};
        printArray(a);
        int n = a.length;

        quicksort(a, 0, n-1);
        System.out.println("\n Sorted Array");
        printArray(a);
    }
}
