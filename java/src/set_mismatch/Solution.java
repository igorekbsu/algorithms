package set_mismatch;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{2, 2})));
    }

    public int[] findErrorNums(int[] nums) {
        int dup = -1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] < 0)
                dup = j + 1;
            else {
                nums[j] *= -1;
                sum += Math.abs(nums[i]);
            }
        }
        return new int[]{dup, (1 + nums.length) * nums.length / 2 - sum};
    }
}
