import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        /**
         * 输入: "abcabcbb"
         * 输出: 3
         * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
         */
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        String str1 = "abcabcbb";
        System.out.println("str1: " + str1);
        int result1 = lswrc.lengthOfLongestSubstring(str1);
        System.out.println("result1: " + result1);

        /**
         * 输入: "bbbbb"
         * 输出: 1
         * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
         */
        String str2 = "bbbbb";
        System.out.println("str2: " + str2);
        int result2 = lswrc.lengthOfLongestSubstring(str2);
        System.out.println("result2: " + result2);

        /**
         * 输入: "pwwkew"
         * 输出: 3
         * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
         */
        String str3 = "pwwkew";
        System.out.println("str3: " + str3);
        int result3 = lswrc.lengthOfLongestSubstring(str3);
        System.out.println("result3: " + result3);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int start = 0;
        Map<Character, Integer> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int current = i - start + 1;
            Character character = s.charAt(i);
            Integer charAt = record.get(character);
            if (charAt != null && charAt >= start) {
                current--;
                start = charAt + 1;
            }
            record.put(character, i);
            if (current > result) {
                result = current;
            }
        }
        return result;
    }

}
