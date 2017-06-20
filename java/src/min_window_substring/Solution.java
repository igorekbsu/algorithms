package min_window_substring;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }
        int start = 0, end = 0, counter = t.length(), minStart = 0, minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            Integer endCount = m.getOrDefault(s.charAt(end), 0);
            if (endCount > 0)
                counter--;
            m.put(s.charAt(end), endCount - 1);
            end++;
            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                m.put(s.charAt(start), m.getOrDefault(s.charAt(start), 0) + 1);
                if (m.get(s.charAt(start)) > 0)
                    counter++;
                start++;
            }
        }
        if (minLen != Integer.MAX_VALUE)
            return s.substring(minStart, minStart + minLen);
        return "";
    }
}