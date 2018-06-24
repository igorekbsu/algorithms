package longest_substr_without_repeating_chars;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("c"));
    }

    public int lengthOfLongestSubstring(String s) {
        int idx[] = new int[256], max = 0, count[] = new int[256];
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            count[c]++;
            if (count[c] > 1) {
                for (; start <= idx[c]; start++)
                    count[s.charAt(start)]--;
            }
            idx[c] = end;
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
