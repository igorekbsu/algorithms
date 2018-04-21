package longest_substr_without_repeating_chars;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int maxLen = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.containsKey(c))
                j = Math.max(j, m.get(c) + 1);
            m.put(c, i);
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}
