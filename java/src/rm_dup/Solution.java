package rm_dup;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = nums.length == 0 ? 0 : 1;
        for (int n : nums)
            if (n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}