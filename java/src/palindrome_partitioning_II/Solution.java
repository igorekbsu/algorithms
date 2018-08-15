package palindrome_partitioning_II;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aab"));
    }

    public int minCut(String s) {
        char[] a = s.toCharArray();
        int[] dp = new int[a.length + 1];
        dp[0] = -1;
        for (int i = 0; i < a.length; i++)
            dp[i + 1] = i;
        for (int i = 0; i < a.length; i++) {
            expand(a, i, i + 1, dp);
            expand(a, i, i, dp);
        }
        return dp[a.length];
    }

    void expand(char[] a, int lo, int hi, int[] dp) {
        while (lo >= 0 && hi < a.length && a[lo] == a[hi]) {
            dp[hi + 1] = Math.min(dp[hi + 1], dp[lo] + 1);
            lo--; hi++;
        }
    }
}
