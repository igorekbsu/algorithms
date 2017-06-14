package max_subarray_product;
public class Solution {
    int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, max = r, min = r; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            r = Math.max(r, max);
        }
        return r;
    }
}