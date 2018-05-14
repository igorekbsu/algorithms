package range_sum_query_immutable;
public class Solution {
    class NumArray {
        final int[] cs;

        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++)
                nums[i] += nums[i - 1];
            cs = nums;
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return cs[j];
            else return cs[j] - cs[i];
        }
    }
}
