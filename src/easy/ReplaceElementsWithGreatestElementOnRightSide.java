package easy;

import java.util.Arrays;

/**
 * 1299. 将每个元素替换为右侧最大元素
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        /**
         * 输入：arr = [17,18,5,4,6,1]
         * 输出：[18,6,6,6,1,-1]
         */
        ReplaceElementsWithGreatestElementOnRightSide rewgeors = new ReplaceElementsWithGreatestElementOnRightSide();
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] result = rewgeors.replaceElements(arr);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("result: " + Arrays.toString(result));
    }

    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            result[i] = max;
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return result;
    }

}
