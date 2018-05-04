package longest_substr_with_at_least_k_repeating_chars;
public class Solution {
    public int longestSubstring(String s, int k) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;
        for (int i = 0; i < f.length; i++)
            if (f[i] > 0 && f[i] < k) {
                String[] parts = s.split(String.valueOf(i + 'a'));
                int max = 0;
                for (String part : parts)
                    max = Math.max(longestSubstring(part, k), max);
                return max;
            }
        return s.length();
    }
}
