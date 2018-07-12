package count_different_palindromic_subsequences;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String S) {
        TreeSet[] chars = new TreeSet[26];
        int len = S.length();
        for (int i = 0; i < 26; i++) chars[i] = new TreeSet<Integer>();
        for (int i = 0; i < len; ++i) {
            int c = S.charAt(i) - 'a';
            chars[c].add(i);
        }
        int[][] dp = new int[len + 1][len + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return count(chars, dp, 0, len);
    }

    int count(TreeSet<Integer>[] chars, int[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] > -1) return dp[start][end];
        long count = 0;
        for (int i = 0; i < 26; i++) {
            Integer newStart = chars[i].ceiling(start);
            Integer newEnd = chars[i].lower(end);
            if (newStart == null || newStart >= end)
                continue;
            count++;
            if (newStart != newEnd) count++;
            count += count(chars, dp, newStart + 1, newEnd);
        }
        dp[start][end] = (int) (count % MOD);
        return dp[start][end];
    }
}
