package uniq_substrings_in_wraparound_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstringInWraproundString("cac"));
    }

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        for (int i = 0, len = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i - 1) + 1 == p.charAt(i) || p.charAt(i) - p.charAt(i - 1) == 25))
                len++;
            else len = 1;
            int j = p.charAt(i) - 'a';
            dp[j] = Math.max(dp[j], len);
        }
        int total = 0;
        for (int count : dp)
            total += count;
        return total;
    }
}
