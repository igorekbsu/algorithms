package strange_printer;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strangePrinter("tbgtgb"));
    }

    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return print(s.toCharArray(), 0, s.length() - 1, dp);
    }

    int print(char[] a, int lo, int hi, int[][] dp) {
        if (lo > hi) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi];
        int r = print(a, lo + 1, hi, dp) + 1;
        for (int i = lo + 1; i <= hi; i++)
            if (a[lo] == a[i])
                r = Math.min(r, print(a, lo, i - 1, dp) + print(a, i + 1, hi, dp));
        dp[lo][hi] = r;
        return dp[lo][hi];
    }
}
