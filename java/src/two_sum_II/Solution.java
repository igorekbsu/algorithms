package two_sum_II;
public class Solution {
    public int[] twoSum(int[] a, int t) {
        for (int i = 0, j = a.length - 1; i < j; ) {
            int s = a[i] + a[j];
            if (s == t)
                return new int[]{i + 1, j + 1};
            else if (s < t) i++;
            else j--;
        }
        return null;
    }
}
