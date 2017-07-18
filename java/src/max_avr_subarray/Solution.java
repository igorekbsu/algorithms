package max_avr_subarray;
public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 12, -5, -6, 50, 3};
        System.out.println(new Solution().findMaxAverage(a, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++)
            maxSum += nums[i];
        for (int i = k, sum = maxSum; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }                                                           
}

