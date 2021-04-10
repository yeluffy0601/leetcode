package normal;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：s = "babad"
         * 输出："bab"
         * 解释："aba" 同样是符合题意的答案。
         *
         * 示例 2：
         *
         * 输入：s = "cbbd"
         * 输出："bb"
         *
         * 示例 3：
         *
         * 输入：s = "a"
         * 输出："a"
         *
         * 示例 4：
         *
         * 输入：s = "ac"
         * 输出："a"
         *
         * 示例 5：
         *
         * 输入：s = "aa"
         * 输出："aa"
         *
         * 示例 6：
         *
         * 输入：s = "aaaaaa"
         * 输出："aaaaaa"
         */
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("babad"));
        System.out.println(lps.longestPalindrome("cbbd"));
        System.out.println(lps.longestPalindrome("a"));
        System.out.println(lps.longestPalindrome("ac"));
        System.out.println(lps.longestPalindrome("aa"));
        System.out.println(lps.longestPalindrome("aaaaaa"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String result = "";
        String temp;
        for (int i = 0; i < s.length(); i++) {
            int c = i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1) ? 1 : 0;
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    temp = s.substring(i - j, i + j + 1);
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                    continue;
                }
                break;
            }
            for (int j = 0; i - j >= 0 && i + j + c < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j + c)) {
                    temp = s.substring(i - j, i + j + c + 1);
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                    continue;
                }
                break;
            }
        }
        return result;
    }

}
