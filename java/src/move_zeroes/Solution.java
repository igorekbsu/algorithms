package move_zeroes;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {0, 0, 1,};
        s.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (n != 0) nums[i++] = n;
        for (; i < nums.length; nums[i++] = 0) ;
    }

    public void moveZeroes1(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[s];
                nums[s] = nums[i];
                nums[i] = t;
                s++;
            }
        }
    }
}