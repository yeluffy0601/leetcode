package easy;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
 */
public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        MaximumProductOfTwoElementsInAnArray mpoteiaa = new MaximumProductOfTwoElementsInAnArray();
        /**
         * 输入：nums = [3,4,5,2]
         * 输出：12
         * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
         */
        int[] nums1 = {3, 4, 5, 2};
        int result1 = mpoteiaa.maxProduct(nums1);
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("result1: " + result1);

        /**
         * 输入：nums = [1,5,4,5]
         * 输出：16
         * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
         */
        int[] nums2 = {1, 5, 4, 5};
        int result2 = mpoteiaa.maxProduct(nums2);
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("result2: " + result2);

        /**
         * 输入：nums = [3,7]
         * 输出：12
         */
        int[] nums3 = {3, 7};
        int result3 = mpoteiaa.maxProduct(nums3);
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("result3: " + result3);
    }

    public int maxProduct(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= a) {
                b = a;
                a = nums[i];
                continue;
            }
            if (nums[i] >= b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }

}
