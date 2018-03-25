package pattern_132;
public class Solution {
    public boolean find132pattern(int[] nums) {
        int a = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (a < nums[i])
                for (int j = i + 1; j < nums.length; j++)
                    if (a < nums[j] && nums[i] > nums[j])
                        return true;
            a = Math.min(a, nums[i]);

        }
        return false;
    }
}
