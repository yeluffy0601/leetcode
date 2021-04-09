package easy;

/**
 * 263. 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class UglyNumber {

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：n = 6
         * 输出：true
         * 解释：6 = 2 × 3
         *
         * 示例 2：
         *
         * 输入：n = 8
         * 输出：true
         * 解释：8 = 2 × 2 × 2
         *
         * 示例 3：
         *
         * 输入：n = 14
         * 输出：false
         * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
         *
         * 示例 4：
         *
         * 输入：n = 1
         * 输出：true
         * 解释：1 通常被视为丑数。
         */
        UglyNumber un = new UglyNumber();
        System.out.println(un.isUgly(6));
        System.out.println(un.isUgly(8));
        System.out.println(un.isUgly(14));
        System.out.println(un.isUgly(1));
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0) {
            return isUgly(n / 2);
        }
        if (n % 3 == 0) {
            return isUgly(n / 3);
        }
        if (n % 5 == 0) {
            return isUgly(n / 5);
        }
        return false;
    }

}
