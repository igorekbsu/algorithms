package three_sum_smaller;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumSmaller(new int[]{-1, 1, -1, -1}, -1));
    }

    public int threeSumSmaller(int[] nums, int target) {
        int n = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    n += right - left;
                    left++;
                } else right--;
            }
        }
        return n;
    }
}