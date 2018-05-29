package partition_to_k_equal_sum_subsets;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartitionKSubsets(new int[]{5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}, 15));
    }

    public boolean canPartitionKSubsets(int[] a, int k) {
        int sum = IntStream.of(a).sum();
        return k != 0 && sum % k == 0 && canPartition(0, a, new boolean[a.length], k, 0, sum / k);
    }

    boolean canPartition(int start, int[] a, boolean[] seen, int k, int sum, int target) {
        if (k == 1) return true;
        if (sum == target)
            return canPartition(0, a, seen, k - 1, 0, target);
        for (int i = start; i < a.length; i++)
            if (!seen[i]) {
                seen[i] = true;
                if (canPartition(i + 1, a, seen, k, sum + a[i], target))
                    return true;
                seen[i] = false;
            }
        return false;
    }
}
