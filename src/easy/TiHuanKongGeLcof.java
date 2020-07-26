package easy;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class TiHuanKongGeLcof {

    public static void main(String[] args) {
        /**
         * 输入：s = "We are happy."
         * 输出："We%20are%20happy."
         */
        TiHuanKongGeLcof thkgl = new TiHuanKongGeLcof();
        String s = "We are happy.";
        System.out.println("s: " + s);
        String result = thkgl.replaceSpace(s);
        System.out.println("result: " + result);
    }

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == ' ') {
                result.append("%20");
            } else {
                result.append(tmp);
            }
        }
        return result.toString();
    }

}
