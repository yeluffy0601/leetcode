package hard;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        /**
         * nums1 = [1, 3]
         * nums2 = [2]
         *
         * 则中位数是 2.0
         */
        int[] nums1 = {1, 3};
        System.out.println("nums1: " + Arrays.toString(nums1));
        int[] nums2 = {2};
        System.out.println("nums2: " + Arrays.toString(nums2));
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        double result1 = motsa.findMedianSortedArrays(nums1, nums2);
        System.out.println("result1: " + result1);

        /**
         * nums1 = [1, 2]
         * nums2 = [3, 4]
         *
         * 则中位数是 (2 + 3)/2 = 2.5
         */
        int[] nums3 = {1, 3};
        System.out.println("nums3: " + Arrays.toString(nums3));
        int[] nums4 = {2};
        System.out.println("nums4: " + Arrays.toString(nums4));
        double result2 = motsa.findMedianSortedArrays(nums3, nums4);
        System.out.println("result2: " + result2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TODO: 2020/7/19
        return 0;
    }

}
