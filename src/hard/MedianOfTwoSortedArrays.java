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
        int[] nums3 = {1, 2};
        System.out.println("nums3: " + Arrays.toString(nums3));
        int[] nums4 = {3, 4};
        System.out.println("nums4: " + Arrays.toString(nums4));
        double result2 = motsa.findMedianSortedArrays(nums3, nums4);
        System.out.println("result2: " + result2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int x = totalLength / 2;
        int y = totalLength % 2 == 0 ? x - 1 : -1;
        int tempX = 0;
        int tempY = 0;
        int temp;
        int i = 0;
        int j = 0;
        for (int z = 0; z < totalLength; z++) {
            if (i >= nums1.length) {
                temp = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                temp = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                temp = nums1[i];
                i++;
            } else {
                temp = nums2[j];
                j++;
            }
            if (z == y) {
                tempY = temp;
                continue;
            }
            if (z == x) {
                tempX = temp;
                break;
            }
        }
        return y >= 0 ? (tempX + tempY) / 2.0 : tempX;
    }

}
