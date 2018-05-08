package find_k_th_smallest_pair_distance;
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int len2 = 1_000_000, dp[] = new int[len2];
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                dp[Math.abs(nums[i] - nums[j])]++;
        for (int i = 0, sum = 0; i < len2; i++) {
            sum += dp[i];
            if (sum >= k) return i;
        }
        return 0;
    }
}
