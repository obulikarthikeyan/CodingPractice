package leetcode;

public class MedianOf2SortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total%2 == 0){
            return (findKth(total/2+1, nums1, nums2, 0, 0) + findKth(total/2, nums1, nums2, 0, 0))/2.0;
        }else{
            return findKth(total/2+1, nums1, nums2, 0, 0);
        }
    }

    public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
        if(s1 == nums1.length)
            return nums2[s2 + k - 1];

        if(s2 == nums2.length)
            return nums1[s1 + k - 1];

        if(k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int m1 = s1 + k/2 - 1;
        int m2 = s2 + k/2 - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if(mid1 < mid2){
            return findKth(k-k/2, nums1, nums2, m1+1, s2);
        }else{
            return findKth(k-k/2, nums1, nums2, s1, m2+1);
        }
    }

    /**
     * This function returns median of ar1[] and ar2[]. Assumptions in this
     * function: Both ar1[] and ar2[] are sorted arrays Both have n elements
     */
    public static double getMedianMethod2(int ar1[], int ar2[], int start1,
                                       int end1, int start2, int end2) {
        int n = end1 - start1 + 1;
        if (n != end2 - start2 + 1)
            return -1;
        /* return -1 for invalid input */
        if (n <= 0)
            return -1;
        if (n == 1)
            return (ar1[start1] + ar2[start2]) / 2.0;
        if (n == 2)
            return (Math.max(ar1[start1], ar2[start2]) + Math.min(ar1[end1],
                    ar2[end2])) / 2.0;

        double m1 = median(ar1, start1, end1); /* get the median of the first array */
        double m2 = median(ar2, start2, end2);
        /*
           * get the median of the second
           * array
        */

        if (m1 == m2)
            return m1;
        if (m1 < m2) {
            if (n % 2 == 0) {
                return getMedianMethod2(ar1, ar2, start1 + n / 2 - 1, end1,
                        start2, start2 + n / 2);
            } else
                return getMedianMethod2(ar1, ar2, start1 + n / 2, end1, start2,
                        start2 + n / 2);
        } else {
            if (n % 2 == 0) {
                return getMedianMethod2(ar1, ar2, start1, start1 + n / 2,
                        start2 + n / 2 - 1, end2);
            } else
                return getMedianMethod2(ar1, ar2, start1, start1 + n / 2,
                        start2 + n / 2, end2);
        }

    }

    public static double median(int[] a, int start, int end) {
        int n = start + end + 1;
        if(n % 2 == 0) {
            return (a[n/2] + a[n/2 - 1])/2.0;
        } else {
            return a[n/2];
        }
    }

    public static double findMedianSortedArrays2(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth2(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth2(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth2(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    public static int findKth2(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = (aEnd - aStart) / 2; //aLen * k / (aLen + bLen); // a's middle count
//        int aMid = aLen * k / (aLen + bLen); // a's middle count
//        int bMid = (bEnd - bStart) / 2; //k - aMid - 1; // b's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth2(A, B, k, aStart, aEnd, bStart, bEnd);
    }

    public static void main(String ...args) {
        int[] x = {2, 3, 6, 7, 9};
        int[] y = {1, 4, 8, 10, 11};

        //double median = findMedianSortedArrays(x, y);
        double median = findMedianSortedArrays2(x, y);
        //double median = getMedianMethod2(x, y, 0, x.length-1, 0, y.length-1);
        System.out.println("Median = " + median);
    }
}
