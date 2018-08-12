package super_egg_drop;
public class Solution {
    public static void main(String[] args) {
        for (int n = 2; n <= 20; n++) {
            System.out.println("n=" + n);
            for (int k = 1; k <= n; k++)
                System.out.print(new Solution().superEggDrop(k, n) + ",");
            System.out.println();
        }
    }

    public int superEggDrop(int k, int n) {
        int dp[][] = new int[n + 1][k + 1], m = 0;
        while (dp[m][k] < n) {
            m++;
            for (int i = 1; i <= k; i++)
                dp[m][i] = dp[m - 1][i - 1] + dp[m - 1][i] + 1;
        }
        return m;
    }
}
