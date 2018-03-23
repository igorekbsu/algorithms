package delete_and_earn;
public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        for (int num : nums)
            values[num] += num;
        int[] dp = new int[values.length + 1];
        dp[1] = values[0];
        for (int i = 1; i < values.length; i++)
            dp[i + 1] = Math.max(values[i] + dp[i - 1], dp[i]);
        return dp[values.length];
    }
}
