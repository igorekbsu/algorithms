package first_missing_positive;
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }
}
