package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums, return all unique triplets whose sum is 0
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 */

public class ThreeSumArray {

    /*public static List<List<Integer>> threeSumUsingHashMap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int zeros = 0;

        for(int i : nums) {
            if (i != 0)
                break;
            zeros++;
        }

        if(zeros >= 3) {
            result.add(Arrays.asList(0,0,0));
            //return result;
        }

        for(int i=0; i<nums.length-1; i++) {
            for(int j= i+1; j<nums.length; j++) {
                int rems = -(nums[i] + nums[j]);
                if (map.containsKey(rems)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(rems);
                    result.add(triplet);
                } else {
                    System.out.println("nums[i] = " + nums[i] + " nums[j] = " + nums[j] + " rems = " + rems);
                    map.put(nums[j], nums[i]);
                }
            }
        }
        return result;
    }*/

    public static List<List<Integer>> threeSumUsingHashMap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if (i==0 || nums[i] > nums[i-1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int t = nums[i] + nums[j] + nums[k];
                    if (t == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        result.add(triplet);
                        j++;
                        k--;

                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j<k && nums[k] == nums[k+1]) {
                            k--;
                        }
                    } else if (t < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String ...args) {
        //int[] nums = {0, 1, 1, -2, -1, -1, 2};
        int[] nums = {-1, 0, 1, 1, 2, 0, 0, 0, -1, -4};
        List<List<Integer>> threeSum = threeSumUsingHashMap(nums);
        String resultStr = threeSum.stream()
                .map(i -> i.stream().map(Object::toString)
                          .collect(Collectors.joining(", "))
                ).collect(Collectors.joining("\n"));
        System.out.println("Three Sum Triplets: \n" + resultStr);
    }
}
