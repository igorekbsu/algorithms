package longest_substring_without_repeating_chars;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> p = new HashMap<>();
        int max = 0, prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (p.containsKey(s.charAt(i))) {
                max = Math.max(max, i - prev);
                prev = Math.max(prev, p.get(s.charAt(i)) + 1);
            }
            p.put(s.charAt(i), i);
        }
        return Math.max(max, s.length() - prev);
    }
}
