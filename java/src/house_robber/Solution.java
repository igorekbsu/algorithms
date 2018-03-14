package house_robber;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{0}));
    }

    public int rob(int[] a) {
        if (a.length == 0) return 0;
        int[] dp = new int[a.length + 1];
        dp[1] = a[0];
        for (int i = 1; i < a.length; i++)
            dp[i + 1] = Math.max(a[i] + dp[i - 1], dp[i]);
        return dp[a.length];
    }
}
