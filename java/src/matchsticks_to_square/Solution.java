package matchsticks_to_square;
import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0 || nums.length < 4) return false;
        Arrays.sort(nums);
        return can(nums, new int[4], sum / 4, nums.length - 1);
    }

    boolean can(int[] a, int[] s, int w, int i) {
        if (i == -1)
            return s[0] == w && s[1] == w && s[2] == w;
        for (int j = 0; j < 4; j++)
            if (s[j] + a[i] <= w) {
                s[j] += a[i];
                if (can(a, s, w, i - 1)) return true;
                s[j] -= a[i];
            }
        return false;
    }
}
