package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        /**
         * 给定 nums = [2, 7, 11, 15], target = 9
         *
         * 因为 nums[0] + nums[1] = 2 + 7 = 9
         * 所以返回 [0, 1]
         */
        int[] nums = {2, 7, 11, 5};
        int target = 9;
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(nums, target);
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("target: " + target);
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
