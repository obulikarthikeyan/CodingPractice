package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

public class InetegerSubsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int n : nums) {

            List<List<Integer>> subsets = result.stream().map(ArrayList::new).collect(Collectors.toList());

            for (List<Integer> subset : subsets) {
                subset.add(n);
            }

            List<Integer> single = new ArrayList<>();
            single.add(n);
            subsets.add(single);

            result.addAll(subsets);
        }
        result.add(Collections.emptyList());
        return result;
    }

    public static List<List<Integer>> subsetsCool(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums == null || nums.length == 0){
            return res;
        }

        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, 0);

        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> li, int[] nums, int idx){
        //if(li.size() <= nums.length){
            res.add(new ArrayList<Integer>(li));
        //}

        System.out.println(idx);
        for(int i = idx; i < nums.length; i++){
            li.add(nums[i]);
            helper(res, li, nums, i+1);
            li.remove(li.size()-1);
        }
    }

    public static void main(String ...args) {
        int[] nums = {1, 2, 5};
        System.out.println("Input:\n\n" + Arrays.toString(nums));
        List<List<Integer>> result = subsets(nums);
        System.out.println("\n\nOutput:\n\n" + result.toString());
        result = subsetsCool(nums);
        System.out.println("\n\nOutput:\n\n" + result.toString());
    }
}
