package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumArray {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int rem = target - nums[i];
            if(map.containsKey(rem)) {
                result[0] = i;
                result[1] = map.get(rem);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    
    public static void main(String ...args) {
        System.out.println("starTime = " + System.currentTimeMillis());
        int[] array = {5, 3, 2, 4};
        int[] result = twoSum(array, 6);
        System.out.println("\nresult = [" + result[0] + "," + result[1] + "]");
        System.out.println("\nendTime = " + System.currentTimeMillis());
    }
}
