package split_array_with_equal_sum;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean splitArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
        for (int j = 3; j < nums.length - 1; j++) {
            Set<Integer> sums = new HashSet<>();
            for (int i = 1; i < j - 1; i++)
                if (sum[i] == sum[j - 1] - sum[i])
                    sums.add(sum[i]);
            for (int k = j + 1; k < nums.length - 1; k++)
                if (sum[k] - sum[j + 1] == sum[nums.length] - sum[k + 1] && sums.contains(sum[k] - sum[j + 1]))
                    return true;
        }
        return false;
    }
}
