package move_zeroes;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {0, 0, 1, };
        s.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (n != 0) nums[i++] = n;
        for (; i < nums.length; nums[i++]=0);
    }
}