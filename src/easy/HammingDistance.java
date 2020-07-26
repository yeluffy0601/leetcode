package easy;

/**
 * 461. 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistance {

    public static void main(String[] args) {
        /**
         * 输入: x = 1, y = 4
         *
         * 输出: 2
         *
         * 解释:
         * 1   (0 0 0 1)
         * 4   (0 1 0 0)
         *        ↑   ↑
         *
         * 上面的箭头指出了对应二进制位不同的位置。
         */
        int x = 1;
        int y = 4;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        HammingDistance hd = new HammingDistance();
        int result = hd.hammingDistance(x, y);
        System.out.println("result: " + result);
    }

    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            int xx = x % 2;
            int yy = y % 2;
            x = x / 2;
            y = y / 2;
            if (xx != yy) {
                result++;
            }
        }
        return result;
    }

}
